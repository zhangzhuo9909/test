package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 会员配送地址表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_member_address")
public class MemberAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员id
     */
    @TableField("memberId")
    private Long memberId;

    /**
     * 省份
     */
    @TableField("province")
    private String province;

    /**
     * 城市
     */
    @TableField("city")
    private String city;

    /**
     * 区
     */
    @TableField("area")
    private String area;

    /**
     * 街道
     */
    @TableField("street")
    private String street;

    /**
     * 省份城市区街道合并结果，空格隔开
     */
    @TableField("pcas")
    private String pcas;

    /**
     * 详细地址
     */
    @TableField("address")
    private String address;

    /**
     * 邮编
     */
    @TableField("zip")
    private String zip;

    /**
     * 手机
     */
    @TableField("phone")
    private String phone;

    /**
     * 电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 收货人
     */
    @TableField("person")
    private String person;

    /**
     * 是否默认。0：不是，1：是。
     */
    @TableField("is_default")
    private boolean isDefault;

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
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public String getPcas() {
        return pcas;
    }

    public void setPcas(String pcas) {
        this.pcas = pcas;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
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
        return "MemberAddress{" +
            "id=" + id +
            ", memberId=" + memberId +
            ", province=" + province +
            ", city=" + city +
            ", area=" + area +
            ", street=" + street +
            ", pcas=" + pcas +
            ", address=" + address +
            ", zip=" + zip +
            ", phone=" + phone +
            ", tel=" + tel +
            ", person=" + person +
            ", isDefault=" + isDefault +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
