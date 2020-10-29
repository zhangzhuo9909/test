package org.zhangzhuo.config;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private int code;

    private String msg;

    private T t;

    public static Result ok() {
        return new Result(200, "OK");
    }

    public static <T> Result ok(T t) {
        return new Result(200, "OK", t);
    }

    public static Result error() {
        return new Result(500, "ERROR");
    }

    public static <T> Result error(T t) {
        return new Result(500, "ERROR", t);
    }

    public Result(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
