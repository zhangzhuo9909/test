package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 商品品牌表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 中文名称
     */
    @TableField("cname")
    private String cname;

    /**
     * 英文名称
     */
    @TableField("ename")
    private String ename;

    /**
     * 分类id
     */
    @TableField("cid")
    private Long cid;

    /**
     * 分类名称，冗余
     */
    @TableField("cat_name")
    private String catName;

    /**
     * 图标地址
     */
    @TableField("logo")
    private String logo;

    /**
     * 官网url
     */
    @TableField("url")
    private String url;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 原产地
     */
    @TableField("source")
    private String source;

    /**
     * 状态: 1 可用，0 不可用
     */
    @TableField("status")
    private boolean status;

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
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        return "Brand{" +
            "id=" + id +
            ", cname=" + cname +
            ", ename=" + ename +
            ", cid=" + cid +
            ", catName=" + catName +
            ", logo=" + logo +
            ", url=" + url +
            ", remark=" + remark +
            ", source=" + source +
            ", status=" + status +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
