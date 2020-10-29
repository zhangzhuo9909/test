package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 会员邮箱管理
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_member_email")
public class MemberEmail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 邮件唯一识别号
     */
    @TableField("sign")
    private String sign;

    /**
     * 用户账号
     */
    @TableField("login_name")
    private String loginName;

    /**
     * forget:找回密码；register:注册；product:商品价格变动；change:邮箱更换
     */
    @TableField("type")
    private String type;

    /**
     * 邮箱验证、密码丢失找回密码的url
     */
    @TableField("url")
    private String url;

    /**
     * 邮件有效开始时间
     */
    @TableField("start_time")
    private Date startTime;

    /**
     * 邮件有效结束时间
     */
    @TableField("end_time")
    private Date endTime;

    /**
     * 新的邮箱
     */
    @TableField("new_email")
    private String newEmail;

    /**
     * 链接是否失效状态。0：未失效；1：已失效。
     */
    @TableField("status")
    private Integer status;

    /**
     * 发送状态。0：发送失败；1：发送成功。
     */
    @TableField("send_status")
    private Integer sendStatus;

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
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
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
        return "MemberEmail{" +
            "id=" + id +
            ", sign=" + sign +
            ", loginName=" + loginName +
            ", type=" + type +
            ", url=" + url +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", newEmail=" + newEmail +
            ", status=" + status +
            ", sendStatus=" + sendStatus +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
