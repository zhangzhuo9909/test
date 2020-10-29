package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品详情表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_product_detail")
public class ProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，来自于商品表id
     */
    @TableId("product_id")
    private Long productId;

    /**
     * 详情html内容
     */
    @TableField("html")
    private String html;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
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
        return "ProductDetail{" +
            "productId=" + productId +
            ", html=" + html +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
