package org.zhangzhuo.config;

public class ResponseMessage {
    private int code;
    private String message;
    private Object data;

    public static ResponseMessage ok() {
        return new ResponseMessage(200,"ok",null);
    }

    public static ResponseMessage ok(Object data){
        return new ResponseMessage(200,"ok",data);
    }

    public static ResponseMessage error(){
        return new ResponseMessage(500,"error",null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public ResponseMessage(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
