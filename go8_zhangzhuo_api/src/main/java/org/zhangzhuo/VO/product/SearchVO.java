package org.zhangzhuo.VO.product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SearchVO {

    private Long id;
    private Long cid;
    private String title;
    private Integer status;
    @NotNull(message = "当前页不能为空")
    @Min(value = 1, message = "当前页最小值为1")
    private Integer index;
    @Min(value = 1, message = "每页条数最小值为1")
    private Integer size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
