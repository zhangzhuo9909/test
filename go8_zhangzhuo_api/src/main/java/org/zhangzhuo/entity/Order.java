package org.zhangzhuo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 订单主表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员id
     */
    @TableField("member_id")
    private Long memberId;

    /**
     * 1：待付款 2：待发货 3：待收货 4：待评价 5：待归档
     */
    @TableField("status")
    private Integer status;

    /**
     * 商品总金额
     */
    @TableField("ptotal")
    private BigDecimal ptotal;

    /**
     * 运费总金额
     */
    @TableField("fee")
    private BigDecimal fee;

    /**
     * 订单总金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 优惠总金额
     */
    @TableField("reduce_money")
    private BigDecimal reduceMoney;

    /**
     * 最终付款金额
     */
    @TableField("final_pay_money")
    private BigDecimal finalPayMoney;

    /**
     * 订单获赠积分
     */
    @TableField("score")
    private Integer score;

    /**
     * 备注信息
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField("gmt_modified")
    private Date gmtModified;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public BigDecimal getPtotal() {
        return ptotal;
    }

    public void setPtotal(BigDecimal ptotal) {
        this.ptotal = ptotal;
    }
    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public BigDecimal getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(BigDecimal reduceMoney) {
        this.reduceMoney = reduceMoney;
    }
    public BigDecimal getFinalPayMoney() {
        return finalPayMoney;
    }

    public void setFinalPayMoney(BigDecimal finalPayMoney) {
        this.finalPayMoney = finalPayMoney;
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
        return "Order{" +
            "id=" + id +
            ", memberId=" + memberId +
            ", status=" + status +
            ", ptotal=" + ptotal +
            ", fee=" + fee +
            ", amount=" + amount +
            ", reduceMoney=" + reduceMoney +
            ", finalPayMoney=" + finalPayMoney +
            ", score=" + score +
            ", remark=" + remark +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
