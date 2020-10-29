package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 会员基本信息表
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_member_info")
public class MemberInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 外键会员id
     */
    @TableId("id")
    private Long id;

    @TableField("nick_name")
    private String nickName;

    @TableField("true_name")
    private String trueName;

    @TableField("sex")
    private String sex;

    @TableField("birthday")
    private Date birthday;

    @TableField("card")
    private String card;

    @TableField("rank")
    private String rank;

    @TableField("score")
    private Integer score;

    @TableField("province")
    private String province;

    @TableField("city")
    private String city;

    @TableField("address")
    private String address;

    @TableField("postcode")
    private String postcode;

    @TableField("gmt_created")
    private Date gmtCreated;

    @TableField("gmt_modified")
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
            "id=" + id +
            ", nickName=" + nickName +
            ", trueName=" + trueName +
            ", sex=" + sex +
            ", birthday=" + birthday +
            ", card=" + card +
            ", rank=" + rank +
            ", score=" + score +
            ", province=" + province +
            ", city=" + city +
            ", address=" + address +
            ", postcode=" + postcode +
            ", gmtCreated=" + gmtCreated +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
