package org.zhangzhuo.pojo;

public class Product {
    private Long id;
    private int price;
    private String title;
    private String image;
    private String catalog_name;
    private String brand_cname;
    private String brand_ename;
    private String attributes;
    private String picture;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", catalog_name='" + catalog_name + '\'' +
                ", brand_cname='" + brand_cname + '\'' +
                ", brand_ename='" + brand_ename + '\'' +
                ", attributes='" + attributes + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public String getBrand_cname() {
        return brand_cname;
    }

    public void setBrand_cname(String brand_cname) {
        this.brand_cname = brand_cname;
    }

    public String getBrand_ename() {
        return brand_ename;
    }

    public void setBrand_ename(String brand_ename) {
        this.brand_ename = brand_ename;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Product() {
    }

    public Product(Long id, int price, String title, String image, String catalog_name, String brand_cname, String brand_ename, String attributes, String picture) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.image = image;
        this.catalog_name = catalog_name;
        this.brand_cname = brand_cname;
        this.brand_ename = brand_ename;
        this.attributes = attributes;
        this.picture = picture;
    }
}
