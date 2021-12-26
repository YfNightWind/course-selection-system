package com.alexlin.utils;

public class ReturnContent {
    private boolean code;
    private String msg;
    private Object result;

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ReturnContent() {
    }

    public ReturnContent(boolean code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }
}
