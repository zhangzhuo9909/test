package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品收藏表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_favorite")
public class Favorite implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    @TableId("id")
    private Long id;

    /**
     * 会员id
     */
    @TableField("account_id")
    private Long accountId;

    /**
     * 商品id
     */
    @TableField("product_id")
    private Long productId;

    /**
     * sku主键
     */
    @TableField("sku_id")
    private Long skuId;

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
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
        return "Favorite{" +
            "id=" + id +
            ", accountId=" + accountId +
            ", productId=" + productId +
            ", skuId=" + skuId +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
