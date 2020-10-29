package org.zhangzhuo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 会员等级
 * </p>
 *
 * @author zhangzhuo
 * @since 2020-08-12
 */
@TableName("t_member_rank")
public class MemberRank implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 级别编码R1,R2,R3,R4,R5
     */
    @TableField("code")
    private String code;

    /**
     * 普通会员，铜牌，银牌，金牌，钻石
     */
    @TableField("name")
    private String name;

    /**
     * 0-499,500-999,1000-1999
     */
    @TableField("min_score")
    private Integer minScore;

    /**
     * 2000-4000，大于4000
     */
    @TableField("max_score")
    private Integer maxScore;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

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
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }
    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
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
        return "MemberRank{" +
            "id=" + id +
            ", code=" + code +
            ", name=" + name +
            ", minScore=" + minScore +
            ", maxScore=" + maxScore +
            ", remark=" + remark +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
        "}";
    }
}
