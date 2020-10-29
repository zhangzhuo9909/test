package org.zhangzhuo.config;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private List<T> records;

    private Long total;

    public PageResult() {
    }

    public PageResult(List<T> records, Long total) {
        this.records = records;
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
