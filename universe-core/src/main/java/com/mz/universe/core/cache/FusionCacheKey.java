package com.deppon.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mz
 * @version V1.0
 * @Title FusionCacheKey
 * @Package com.deppon.cache
 * @Description 实体内部混合缓存key注解
 * @date 2020/7/1 5:49 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
public @interface FusionCacheKey {
    int index();
}
