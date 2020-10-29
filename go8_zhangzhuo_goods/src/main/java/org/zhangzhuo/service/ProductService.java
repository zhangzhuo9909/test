package org.zhangzhuo.service;

import org.zhangzhuo.VO.product.ProductVO;
import org.zhangzhuo.config.PageResult;
import org.zhangzhuo.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.zhangzhuo.entity.Product;

import java.util.List;


/**
 * <p>
 * 商品基本信息表（spu) 服务类
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
public interface ProductService extends IService<Product> {

    PageResult<Product> getProductBy(Product product, Long index, Long size);

    void setStatus(Product product);

    void addProduct(ProductVO productVO);

    ProductExe getProductBrandById(Long id);

    ProductDetail getProductDetailById(Long id);

    List<ProductSku> getProductSkulById(Long id);
}
