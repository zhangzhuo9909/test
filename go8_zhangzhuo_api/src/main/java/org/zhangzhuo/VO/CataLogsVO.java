package org.zhangzhuo.VO;

import java.util.ArrayList;
import java.util.List;

public class CataLogsVO {
    private long id;
    private long pid;
    private String title;
    private boolean loading;
    private boolean parent;
    private List<CataLogsVO> children = new ArrayList<>();

    @Override
    public String toString() {
        return "CataLogsVO{" +
                "id=" + id +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                ", loading=" + loading +
                ", parent=" + parent +
                ", children=" + children +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public boolean isParent() {
        return parent;
    }

    public void setParent(boolean parent) {
        this.parent = parent;
    }

    public List<CataLogsVO> getChildren() {
        return children;
    }

    public void setChildren(List<CataLogsVO> children) {
        this.children = children;
    }

    public CataLogsVO() {
    }

    public CataLogsVO(long id, long pid, String title, boolean loading, boolean parent, List<CataLogsVO> children) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.loading = loading;
        this.parent = parent;
        this.children = children;
    }
}
