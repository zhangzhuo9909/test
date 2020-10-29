package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品属性表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_attribute")
public class Attribute implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 属性名称
     */
    @TableField("name")
    private String name;

    /**
     * 1普通属性 2规格属性
     */
    @TableField("type")
    private Integer type;

    /**
     * 1 单选 2 多选 3 自定义
     */
    @TableField("input_type")
    private Integer inputType;

    /**
     * 分类id
     */
    @TableField("cid")
    private Long cid;

    /**
     * 分组id，默认0，没有分组
     */
    @TableField("gid")
    private Long gid;

    /**
     * 0 非必填 1 必填
     */
    @TableField("required")
    private Integer required;

    /**
     * 显示顺序
     */
    @TableField("show_order")
    private Integer showOrder;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }
    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }
    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }
    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
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
        return "Attribute{" +
            "id=" + id +
            ", name=" + name +
            ", type=" + type +
            ", inputType=" + inputType +
            ", cid=" + cid +
            ", gid=" + gid +
            ", required=" + required +
            ", showOrder=" + showOrder +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
