package com.mz.universe.core.exception;

/**
 * @author mz
 * @version V1.0
 * @Title CommonException
 * @Package com.mz.universe.core.exception
 * @Description
 * @date 2020/7/24 5:36 下午
 */
public class CommonException extends RuntimeException {

    private String msg;

    private ExceptionType exceptionType;


    public CommonException(String msg, ExceptionType exceptionType) {
        super(msg);
        this.msg = msg;
        this.exceptionType = exceptionType;
    }

    public CommonException(String msg) {
        super(msg);
        this.msg = msg;
    }


}