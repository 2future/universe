package com.mz.universe.core.cache;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mz
 * @version V1.0
 * @Title CacheKey
 * @Package com.mz.universe.core.cache
 * @Description 服务层缓存key 注解
 * @date 2020/7/1 5:49 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
public @interface CacheKey {

}
