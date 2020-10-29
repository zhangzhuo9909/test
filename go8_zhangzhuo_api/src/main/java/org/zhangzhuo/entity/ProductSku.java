package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品sku基本信息表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_product_sku")
public class ProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品spu的id
     */
    @TableField("product_id")
    private Long productId;

    /**
     * 规格属性集，json
     */
    @TableField("attrs")
    private String attrs;

    /**
     * 规格主图
     */
    @TableField("picture")
    private String picture;

    /**
     * 平台价格，单位：分
     */
    @TableField("go8_price")
    private Integer go8Price;

    /**
     * 规格库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 创建日期
     */
    @TableField("gmt_create")
    private Date gmtCreate;

    /**
     * 修改日期
     */
    @TableField("gmt_modified")
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public Integer getGo8Price() {
        return go8Price;
    }

    public void setGo8Price(Integer go8Price) {
        this.go8Price = go8Price;
    }
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "ProductSku{" +
            "id=" + id +
            ", productId=" + productId +
            ", attrs=" + attrs +
            ", picture=" + picture +
            ", go8Price=" + go8Price +
            ", stock=" + stock +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
