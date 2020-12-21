package org.zhangzhuo.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.zhangzhuo.VO.product.ProductVO;
import org.zhangzhuo.common.service.ServiceResponse;
import org.zhangzhuo.config.PageResult;
import org.zhangzhuo.entity.Product;
import org.zhangzhuo.service.ProductService;

import java.util.*;

/**
 * <p>
 * 商品基本信息表（spu) 前端控制器
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@RestController
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 品牌表
     * 条件查询  分页
     * @param product
     * @param index
     * @param size
     * @return
     */
    @GetMapping
    public ServiceResponse getProductAdd(Product product, @RequestParam(value = "index",defaultValue = "1") Long index, @RequestParam(value = "size",defaultValue = "10") Long size){
        try {
            PageResult<Product> list = productService.getProductBy(product,index,size);
            //把数据和前台
            HashMap<String, Object> map = new HashMap<>();
            map.put("rows",list.getRecords());
            map.put("total",list.getTotal());
            return ServiceResponse.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 设置上架还是下架
     * @return
     */
    @PutMapping("/status")
    public ServiceResponse setStatus(@RequestBody Product product){
        try {
            productService.setStatus(product);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

    /**
     * 添加商品表  使用内部类
     * @param productVO
     * @return
     */
    @PostMapping
    public ServiceResponse addProduct(@RequestBody ProductVO productVO) {
        try {
            productService.addProduct (productVO);
            return ServiceResponse.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServiceResponse.error();
    }

//    /**
//     * 静态内部类 定义前台传进来的数据
//     */
//    static class productDemo{
//        private Product product;
//        private String detail;
//        private ProductSku[] skus;
//        @Override
//        public String toString() {
//            return "productDemo{" +
//                    "product=" + product +
//                    ", detail='" + detail + '\'' +
//                    ", skus=" + Arrays.toString(skus) +
//                    '}';
//        }
//
//        public Product getProduct() {
//            return product;
//        }
//
//        public void setProduct(Product product) {
//            this.product = product;
//        }
//
//        public String getDetail() {
//            return detail;
//        }
//
//        public void setDetail(String detail) {
//            this.detail = detail;
//        }
//
//        public ProductSku[] getSkus() {
//            return skus;
//        }
//
//        public void setSkus(ProductSku[] skus) {
//            this.skus = skus;
//        }
//
//    }
}
