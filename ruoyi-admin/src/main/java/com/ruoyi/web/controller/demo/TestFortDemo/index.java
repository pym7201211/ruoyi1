package com.ruoyi.web.controller.demo.TestFortDemo;

import java.util.Objects;

public class index {

    private String pageNum;
    private String pageSize;

    public String getPageNum() {
        return pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof index)) return false;
        index index = (index) o;
        return Objects.equals(getPageNum(), index.getPageNum()) &&
                Objects.equals(getPageSize(), index.getPageSize());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPageNum(), getPageSize());
    }

    @Override
    public String toString() {
        return "index{" +
                "pageNum='" + pageNum + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
