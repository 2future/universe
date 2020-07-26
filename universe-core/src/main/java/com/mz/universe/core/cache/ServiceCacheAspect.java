package com.mz.universe.core.cache;

import com.mz.universe.core.cache.processor.CacheProcessor;
import com.mz.universe.core.cache.processor.RedisCacheProcessor;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author mz
 * @version V1.0
 * @Title ServiceCacheAspect
 * @Package com.mz.universe.core.cache
 * @Description
 * @date 2020/7/24 5:23 下午
 */
@Aspect
public class ServiceCacheAspect {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    private static final String cachePrefix = "cache";
    private static final String fusionKeyPrefix = "fusion.key";
    private static final String cacheSplit = "-";


    @Around("@annotation(ServiceCache)")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取目标类
        Class<?> targetClazz = joinPoint.getTarget().getClass();
        //获取执行的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取此方法的参数列表
        Class<?>[] par = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        //获取到实际执行的方法
        Method objMethod = targetClazz.getMethod(methodName, par);
        //获取到缓存注解
        ServiceCache serviceCache = objMethod.getAnnotation(ServiceCache.class);
        //获取注解 缓存key值
        String cacheKey = serviceCache.cacheKey();
        //初始化缓存key全路径名
        StringBuilder strAppend = new StringBuilder(cachePrefix).append(cacheSplit);
        strAppend.append(targetClazz.getName()).append(cacheSplit).
                append(StringUtils.defaultIfBlank(cacheKey, objMethod.getName()));
        if (par != null) {
            Object[] args = joinPoint.getArgs();
            Parameter[] parameters = objMethod.getParameters();
            //遍历入参
            for (int paramIndex = 0; paramIndex < parameters.length; paramIndex++) {
                //获取参数上标注有 CacheKey 注解的参数
                if (parameters[paramIndex].getAnnotation(CacheKey.class)!=null){
                    //当参数为string类型 直接将此当缓存key
                    if (args[paramIndex] instanceof String) {
                        strAppend.append(args[paramIndex]);
                        break;
                    } else {
                        //当不是string类型 根据 RdsServiceCache 注解中的 缓存key类型 进行key的拼装
                        processCacheKeyByType(args, paramIndex, strAppend, serviceCache);
                    }
                }
            }
        }
        //当缓存key的值为空 则使用 当前注解所在类的 全路径名 + 注解标注的方法名
        cacheKey = strAppend.toString();
        //获取 缓存过期时间 默认 十分钟
        long expire = serviceCache.expire();
        long maxSize = serviceCache.maxSize();
        Object result;
        try {
            CacheProcessor cacheProcessor = new RedisCacheProcessor(cacheKey, expire, maxSize,redisTemplate);
            Class<?> returnType = objMethod.getReturnType();
            result = cacheProcessor.getCache(cacheKey,returnType);
            if (result == null) {
                result = joinPoint.proceed(joinPoint.getArgs());
                cacheProcessor.setCache(result);
                return result;
            }
        } catch (Exception e) {
            result = joinPoint.proceed(joinPoint.getArgs());
        }
        return result;
    }

    /**
     * 处理 缓存key标注与实体字段
     * @param args
     * @param paramIndex
     * @param strAppend
     * @param rdsServiceCache
     * @throws IllegalAccessException
     */
    public void processCacheKeyByType(Object[] args,int paramIndex,StringBuilder strAppend,
                                      ServiceCache rdsServiceCache) throws IllegalAccessException {

        Field[] fields = args[paramIndex].getClass().getDeclaredFields();
        FusionCacheKeyGenerate generate = new FusionCacheKeyGenerate();
        for (Field field : fields) {
            field.setAccessible(true);
            if (rdsServiceCache.keyType().equals(KeyType.SINGLE_CACHE_KEY)) {
                //当实体内部的字段 为 CacheKey 注解并且类型为 当个字段当key 则直接使用第一个当做key
                CacheKey fieldAnnotation = field.getAnnotation(CacheKey.class);
                if (fieldAnnotation != null && field.get(args[paramIndex]) != null) {
                    strAppend.append(cacheSplit).append(field.getName()).
                            append(cacheSplit).append(field.get(args[paramIndex]));
                    break;
                }
            } else if (rdsServiceCache.keyType().equals(KeyType.FUSION_CACHE_KEY)) {
                //当是混合key 则进行key拼装
                FusionCacheKey fusionCacheKey = field.getAnnotation(FusionCacheKey.class);
                if (fusionCacheKey != null && field.get(args[paramIndex]) != null) {
                    generate.putIndex(new CacheKeyIndex((String) field.get(args[paramIndex]),
                            fusionCacheKey.index()));
                }
            }
        }
        if (rdsServiceCache.keyType().equals(KeyType.FUSION_CACHE_KEY)) {
            //获取拼装后的key
            strAppend.append(cacheSplit).append(fusionKeyPrefix).
                    append(cacheSplit).append(generate.generateKey());
        }
    }
}