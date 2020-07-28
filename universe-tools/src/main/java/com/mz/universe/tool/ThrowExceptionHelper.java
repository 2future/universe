package com.mz.universe.tool;

import com.mz.universe.exception.CommonException;
import com.mz.universe.exception.ExceptionType;
import org.slf4j.Logger;
import org.springframework.util.Assert;

import java.util.function.Function;

/**
 * @author mz
 * @version V1.0
 * @Title ThrowExceptionHelper
 * @Package com.mz.universe.tool
 * @Description 异常日子打印工具类
 * @date 2020/7/28 9:23 上午
 */
public class ThrowExceptionHelper {

    /**
     * 记录异常信息并抛出异常 不带有异常编码
     *
     * @param logger
     * @param function
     * @param errorMsg
     */
    public static void tryCatchThrow(Logger logger, Function<Void, Void> function, String errorMsg) {
        tryCatchThrow(logger, function, errorMsg, ExceptionType.NORMAL);
    }

    /**
     * 记录异常信息并抛出异常 需要自定义异常编码 enum
     *
     * @param logger
     * @param function
     * @param errorMsg
     * @param exceptionType
     */
    public static void tryCatchThrow(Logger logger, Function<Void, Void> function, String errorMsg,
                                     ExceptionType exceptionType) {
        try {
            function.apply(null);
        } catch (Exception e) {
            Assert.notNull(logger, "logger can not be null");
            logger.error("调用方法异常", e);
            throw new CommonException(errorMsg, exceptionType);
        }
    }

    /**
     * 记录异常信息不抛出异常 不带有异常编码
     *
     * @param logger
     * @param function
     * @param errorMsg
     */
    public static void tryCatchNoThrow(Logger logger, Function<Void, Void> function, String errorMsg) {
        tryCatchNoThrow(logger, function, errorMsg, ExceptionType.NORMAL);
    }

    /**
     * 记录异常信息不抛出异常 需要自定义异常编码 enum
     *
     * @param logger
     * @param function
     * @param errorMsg
     * @param exceptionType
     */
    public static void tryCatchNoThrow(Logger logger, Function<Void, Void> function, String errorMsg,
                                       ExceptionType exceptionType) {
        try {
            function.apply(null);
        } catch (Exception e) {
            Assert.notNull(logger, "logger can not be null");
            logger.error("调用方法异常", e);
        }
    }
}