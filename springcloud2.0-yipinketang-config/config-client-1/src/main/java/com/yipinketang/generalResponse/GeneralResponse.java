package com.yipinketang.generalResponse;

public class GeneralResponse {

    private Integer code;
    private String message;
    private Object date;

    public GeneralResponse() {
    }

    public GeneralResponse(Integer code, String message, Object date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}
