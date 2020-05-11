package com.znsd.sportsbean.http;

import com.znsd.sportsbean.live.LiveDomainList;

import java.io.Serializable;
import java.util.List;

public class HttpResponse implements Serializable {
    private Integer code;
    private LiveDomainList data;
    private String msg;

    public HttpResponse() {
    }

    public HttpResponse(Integer code, LiveDomainList data, String msg) {
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

    public LiveDomainList getData() {
        return data;
    }

    public void setData(LiveDomainList data) {
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
        return "HttpResponse{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
