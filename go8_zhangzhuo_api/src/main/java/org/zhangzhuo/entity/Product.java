package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品基本信息表（spu)
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类
     */
    @TableField("cid")
    private Long cid;

    /**
     * 品牌
     */
    @TableField("brand_id")
    private Long brandId;

    /**
     * 商品标题
     */
    @TableField("title")
    private String title;

    /**
     * 副标题
     */
    @TableField("sub_title")
    private String subTitle;

    /**
     * 商品属性集，json
     */
    @TableField("attributes")
    private String attributes;

    /**
     * 售价，单位：分
     */
    @TableField("price")
    private Integer price;

    /**
     * 平台价格，单位：分
     */
    @TableField("go8_price")
    private Integer go8Price;

    /**
     * 总库存
     */
    @TableField("stock")
    private Integer stock;

    /**
     * 1 上架 2 下架
     */
    @TableField("status")
    private Integer status;

    /**
     * 商品主图
     */
    @TableField("picture")
    private String picture;

    /**
     * 规格缩略图
     */
    @TableField("images")
    private String images;

    /**
     * 货号
     */
    @TableField("product_code")
    private String productCode;

    /**
     * 包装信息，格式：json
     */
    @TableField("package_info")
    private String packageInfo;

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

    /**
     * 创建人
     */
    @TableField("creator")
    private String creator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(String packageInfo) {
        this.packageInfo = packageInfo;
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
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", cid=" + cid +
            ", brandId=" + brandId +
            ", title=" + title +
            ", subTitle=" + subTitle +
            ", attributes=" + attributes +
            ", price=" + price +
            ", go8Price=" + go8Price +
            ", stock=" + stock +
            ", status=" + status +
            ", picture=" + picture +
            ", images=" + images +
            ", productCode=" + productCode +
            ", packageInfo=" + packageInfo +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", creator=" + creator +
        "}";
    }
}
