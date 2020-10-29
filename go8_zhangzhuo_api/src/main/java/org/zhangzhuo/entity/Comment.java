package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 会员评论表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    @TableField("product_id")
    private Long productId;

    /**
     * sku的主键
     */
    @TableField("sku_id")
    private Long skuId;

    /**
     * 会员主键
     */
    @TableField("account_id")
    private Long accountId;

    /**
     * 订单主键
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 订单明细主键
     */
    @TableField("order_detail_id")
    private Long orderDetailId;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 评论星级：1,2,3,4,5
     */
    @TableField("star")
    private Integer star;

    /**
     * 显示：1，不显示：0
     */
    @TableField("show")
    private Integer show;

    @TableField("gmt_create")
    private Date gmtCreate;

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
    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
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
        return "Comment{" +
            "id=" + id +
            ", productId=" + productId +
            ", skuId=" + skuId +
            ", accountId=" + accountId +
            ", orderId=" + orderId +
            ", orderDetailId=" + orderDetailId +
            ", content=" + content +
            ", star=" + star +
            ", show=" + show +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
