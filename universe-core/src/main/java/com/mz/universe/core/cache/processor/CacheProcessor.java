package com.deppon.cache.processor;

/**
 * @author mz
 * @version V1.0
 * @Title CacheProcessor
 * @Package com.common.core.cache.aop
 * @Description 缓存处理通用接口
 * @date 2020/7/2 7:35 下午
 */
public interface CacheProcessor<T> {


    /**
     * 设置缓存
     *
     * @param t
     */
    void setCache(T t);

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    T getCache(String key,Class<T> clazz);

}