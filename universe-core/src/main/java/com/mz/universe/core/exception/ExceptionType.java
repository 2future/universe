package com.mz.universe.core.exception;

public enum ExceptionType {
    NORMAL("0000");

    ExceptionType(String code) {
        this.code = code;
    }

    private String code;
}
