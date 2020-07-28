package com.mz.universe.exception;

public enum ExceptionType {
    /**
     * 一般异常信息
     */
    NORMAL("0000", null),
    /**
     * 网络异常
     */
    NetWorkException("0001", "network error");


    ExceptionType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
