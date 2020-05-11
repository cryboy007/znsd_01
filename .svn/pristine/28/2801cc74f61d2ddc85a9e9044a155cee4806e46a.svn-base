package com.znsd.sportsbean.http;

import com.znsd.sportsbean.live.LiveDomain;
import com.znsd.sportsbean.live.LiveDomainList;

import java.io.Serializable;
import java.util.List;

public class HttpResponse2 implements Serializable {
    private Integer code;
    private List<LiveDomain> data;
    private String msg;

    public HttpResponse2() {
    }

    public HttpResponse2(Integer code, List<LiveDomain> data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<LiveDomain> getData() {
        return data;
    }

    public void setData(List<LiveDomain> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "HttpResponse2{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
