package com.mz.universe.core.exception;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author mz
 * @version V1.0
 * @Title CommonException
 * @Package com.mz.universe.core.exception
 * @Description
 * @date 2020/7/24 5:36 下午
 */
public class CommonException extends RuntimeException {

    private String code;

    private String msg;

    private ExceptionType exceptionType;

    public CommonException(String msg, ExceptionType exceptionType) {
        super(msg);
        this.code = exceptionType.getCode();
        this.msg = StringUtils.defaultIfBlank(exceptionType.getMsg(), msg);
    }

    public CommonException(String msg) {
        super(msg);
        this.msg = msg;
    }


}