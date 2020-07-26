package com.mz.universe.core.cache;

public @interface ServiceCache {


    /**
     * 过期时间 默认值 十分钟
     *
     * @return
     */
    long expire() default 600000;

    /**
     * 最大缓存直接大小
     * @return
     */
    long maxSize() default -1;

    /**
     * 缓存key 没有默认使用类名加方法名
     *
     * @return
     */
    String cacheKey() default "";

    /**
     * 缓存key类型
     * @return
     */
    KeyType keyType() default KeyType.SINGLE_CACHE_KEY;
}
