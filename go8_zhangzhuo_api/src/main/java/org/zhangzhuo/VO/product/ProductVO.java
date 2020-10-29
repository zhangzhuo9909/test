package org.zhangzhuo.VO.product;


import org.zhangzhuo.entity.Product;
import org.zhangzhuo.entity.ProductSku;

public class ProductVO {
    Product product;
    String detail;
    ProductSku[] skus;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ProductSku[] getSkus() {
        return skus;
    }

    public void setSkus(ProductSku[] skus) {
        this.skus = skus;
    }
}
