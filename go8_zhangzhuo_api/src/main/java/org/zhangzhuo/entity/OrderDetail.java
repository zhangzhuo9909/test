package org.zhangzhuo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 订单明细表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单ID
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 产品ID
     */
    @TableField("product_id")
    private Long productId;

    /**
     * 图片
     */
    @TableField("image")
    private String image;

    /**
     * 产品名称
     */
    @TableField("product_title")
    private String productTitle;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 数量
     */
    @TableField("number")
    private Integer number;

    /**
     * 优惠方式
     */
    @TableField("reduce_type")
    private String reduceType;

    /**
     * 优惠金额
     */
    @TableField("redduce_money")
    private BigDecimal redduceMoney;

    /**
     * 运送方式
     */
    @TableField("ship_type")
    private String shipType;

    /**
     * 运送金额
     */
    @TableField("ship_money")
    private BigDecimal shipMoney;

    /**
     * 运费保险
     */
    @TableField("ship_insurance")
    private BigDecimal shipInsurance;

    /**
     * 积分
     */
    @TableField("score")
    private Integer score;

    /**
     * 买家留言
     */
    @TableField("remark")
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getReduceType() {
        return reduceType;
    }

    public void setReduceType(String reduceType) {
        this.reduceType = reduceType;
    }
    public BigDecimal getRedduceMoney() {
        return redduceMoney;
    }

    public void setRedduceMoney(BigDecimal redduceMoney) {
        this.redduceMoney = redduceMoney;
    }
    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }
    public BigDecimal getShipMoney() {
        return shipMoney;
    }

    public void setShipMoney(BigDecimal shipMoney) {
        this.shipMoney = shipMoney;
    }
    public BigDecimal getShipInsurance() {
        return shipInsurance;
    }

    public void setShipInsurance(BigDecimal shipInsurance) {
        this.shipInsurance = shipInsurance;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
            "id=" + id +
            ", orderId=" + orderId +
            ", productId=" + productId +
            ", image=" + image +
            ", productTitle=" + productTitle +
            ", price=" + price +
            ", number=" + number +
            ", reduceType=" + reduceType +
            ", redduceMoney=" + redduceMoney +
            ", shipType=" + shipType +
            ", shipMoney=" + shipMoney +
            ", shipInsurance=" + shipInsurance +
            ", score=" + score +
            ", remark=" + remark +
        "}";
    }
}
