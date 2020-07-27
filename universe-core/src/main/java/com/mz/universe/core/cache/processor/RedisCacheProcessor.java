package com.mz.universe.core.cache.processor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mz.universe.core.exception.CommonException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author mz
 * @version V1.0
 * @Title CacheProcesser
 * @Package
 * @Description redis缓存处理器
 * @date 2020/7/2 7:24 下午
 */
public class RedisCacheProcessor<T> implements CacheProcessor<T> {

    /**
     * 缓存key 值
     */
    private String cacheKey;

    /**
     * 缓存过期时间
     */
    private long expireTime;

    /**
     * 缓存最大字符串 byte 大小
     */
    private long maxSize;

    /**
     * 定义redission 客户端
     */
    private RedisTemplate redisTemplate;


    public RedisCacheProcessor(String cacheKey, long expireTime, RedisTemplate redisTemplate) {
        this.cacheKey = cacheKey;
        this.expireTime = expireTime;
        this.maxSize = -1;
        this.redisTemplate = redisTemplate;
    }

    public RedisCacheProcessor(String cacheKey, long expireTime, long maxSize, RedisTemplate redisTemplate) {
        this.cacheKey = cacheKey;
        this.expireTime = expireTime;
        this.maxSize = maxSize;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void setCache(T o) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonBody = null;
        try {
            jsonBody = objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new CommonException("redis 序列化异常");
        }
        Optional.ofNullable(jsonBody).ifPresent(json->{
            if (maxSize==-1 || json.getBytes().length<maxSize) {
                redisTemplate.opsForValue().set(cacheKey, json, expireTime, TimeUnit.MILLISECONDS);
            }
        });
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    @Override
    public T getCache(String key,Class<T> clazz) {
        if ( redisTemplate.opsForValue().getOperations().hasKey(key) && redisTemplate.opsForValue().get(key)==null) {
            return (T) StringUtils.EMPTY;
        }
        String valueStr =(String) redisTemplate.opsForValue().get(key);
        if (valueStr==null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            Object o1 = objectMapper.readValue(valueStr, clazz);
            return (T) o1;
        } catch (Exception e) {
            throw new CommonException("json 解析异常");
        }
    }
}