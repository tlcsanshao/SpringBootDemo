package com.sanshao.SpringBootDemo.exceptions;



public class SimpleException extends  RuntimeException{

    private int code;
    private String msg;

    public SimpleException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public SimpleException() {
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
