package org.zhangzhuo.entity;

import java.util.Date;

public class Sku {
    private Long id;

    private Long productId;

    private String attrs;

    private String picture;

    private Integer go8Price;

    private Integer stock;

    private Date gmtCreate;

    private Date gmtModified;

    @Override
    public String toString() {
        return "Sku{" +
                "id=" + id +
                ", productId=" + productId +
                ", attrs='" + attrs + '\'' +
                ", picture='" + picture + '\'' +
                ", go8Price=" + go8Price +
                ", stock=" + stock +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

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

    public Sku() {
    }

    public Sku(Long id, Long productId, String attrs, String picture, Integer go8Price, Integer stock, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.productId = productId;
        this.attrs = attrs;
        this.picture = picture;
        this.go8Price = go8Price;
        this.stock = stock;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }
}
