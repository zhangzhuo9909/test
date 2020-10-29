package org.zhangzhuo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.zhangzhuo.VO.product.ProductVO;
import org.zhangzhuo.common.util.JsonUtils;
import org.zhangzhuo.config.PageResult;
import org.zhangzhuo.entity.*;
import org.zhangzhuo.mapper.ProductMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zhangzhuo.mq.ProducterMq;
import org.zhangzhuo.entity.Product;
import org.zhangzhuo.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 商品基本信息表（spu) 服务实现类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private ProductSkuService productSkuService;
    @Autowired
    private CatalogService catalogService;

    /**
     * 分页查询数据
     * @param product
     * @param index
     * @param size
     * @return
     */
    @Override
    public PageResult<Product> getProductBy(Product product, Long index, Long size) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        Page<Product> page = new Page<>(index, size);
        //不确定代码
        List<Product> list = list();
        Long cid = product.getCid();
        if(cid != null && cid > 0 ){
            wrapper.eq("cid",cid);
        }
        String title = product.getTitle();
        if(! StringUtils.isEmpty(title)){
            wrapper.like("title",title);
        }
        Integer status = product.getStatus();
        if(status != null && status > 0){
            wrapper.eq("status",status);
        }
        page = page(page, wrapper);
        return
                new PageResult<>(page.getRecords(),page.getTotal());
    }

    /**
     * 设置上架还是下架
     */
    @Override
    public void setStatus(Product product) {
        //获取到前台传进来的 status
        Integer status = product.getStatus();
        //如果 前台传过来的status 为 1 就将它设置为 2
        if(Objects.nonNull(product) && status == 1){
            updateById(product);
        }
        //如果 前台传过来的status 为 2 就将它设置为 1
        if(Objects.nonNull(product) && status == 2){
            updateById(product);
        }
    }

    /**
     * 添加的实现类
     * @param productVO
     * @return
     */
    @Transactional
    @Override
    public void addProduct(ProductVO productVO) {
        //将数据保存到mysql数据库里面
        if (Objects.nonNull(productVO)) {
            try {
                Product product = productVO.getProduct();
                if (Objects.nonNull(product)) {
                    product.setGmtModified(new Date());
                    product.setGmtCreate(new Date());
                    save(product);
                }
                String detail = productVO.getDetail();
                if (!StringUtils.isEmpty(detail)) {
                    ProductDetail productDetail = new ProductDetail();
                    productDetail.setProductId(product.getId());
                    productDetail.setHtml(detail);
                    productDetail.setGmtCreate(new Date());
                    productDetail.setGmtModified(new Date());
                    boolean save = productDetailService.save(productDetail);
                }
                ProductSku[] skus = productVO.getSkus();
                ArrayList<ProductSku> productSkus = new ArrayList<>();
                for (int i = 0; i < skus.length; i++) {
                    ProductSku sku = skus[i];
                    sku.setProductId(product.getId());
                    sku.setGmtCreate(new Date());
                    sku.setGmtModified(new Date());
                    productSkus.add(sku);
                }
                productSkuService.saveBatch(productSkus);
                //发送消息的方式进行消息发送
                //创建索引对象
                org.zhangzhuo.pojo.Product goods = new org.zhangzhuo.pojo.Product();
                Product product1 = productVO.getProduct();

                goods.setId(product1.getId());
                goods.setPicture(product1.getPicture());
                goods.setTitle(product1.getTitle());
                goods.setPrice(product1.getPrice());

                goods.setCatalog_name(catalogService.getById(product1.getCid()).getName());

                Brand brand = brandService.getByBrandId(product1.getBrandId());
                goods.setBrand_cname(brand.getCname());
                goods.setBrand_ename(brand.getEname());

                goods.setAttributes(product1.getAttributes());

                ProducterMq mqGoods = new ProducterMq();
                //发送消息
                mqGoods.sendMessage("goods_group","goods_topic","goods_tag", JsonUtils.objectToJson(goods).getBytes());
                System.out.println("发送消息");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ProductExe getProductBrandById(Long id) {
        ProductExe productExe = new ProductExe();
        Product product = getById(id);
        BeanUtils.copyProperties(product,productExe);
        Brand brand = brandService.getById(product.getBrandId());
        productExe.setBrand(brand);
        return productExe;
    }

    @Override
    public ProductDetail getProductDetailById(Long id) {
        ProductDetail productDetail = productDetailService.getById(id);
        System.out.println("-------------------->>>>>>."+productDetail);
        return productDetail;
    }

    @Override
    public List<ProductSku> getProductSkulById(Long id) {
        QueryWrapper<ProductSku> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        List<ProductSku> skuList = baseMapper.getProductSkulById(wrapper);
        return skuList;
    }


}
