package com.yanzhen.util;

import com.yanzhen.model.TypeInfo;

import java.util.List;

public class JsonObject {
    private int code;
    private List data;
    private long total;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
