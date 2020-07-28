package com.mz.universe.exception;

/**
 * @author mz
 * @version V1.0
 * @Title UseJavassistException
 * @Package com.mz.universe.exception
 * @Description javassist异常
 * @date 2020/7/28 1:22 下午
 */
public class UseJavassistException extends RuntimeException {

    private Exception exception;

    public UseJavassistException(Exception exception) {
        super(exception);
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "UseJavassistException{" +
                ", exception=" + exception +
                '}';
    }
}