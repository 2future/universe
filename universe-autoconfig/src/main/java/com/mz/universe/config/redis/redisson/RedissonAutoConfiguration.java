package com.mz.universe.config.redis.redisson;

import com.mz.universe.core.redis.RedissonCreater;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mz
 * @version V1.0
 * @Title Redisson
 * @Package com.mz.universe.config.redis.redisson
 * @Description
 * @date 2020/7/27 6:52 下午
 */
@Configuration
@ConditionalOnClass({RedissonClient.class})
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedissonAutoConfiguration {

    @Autowired
    private RedisProperties redisProperties;

    /**
     * 自动配置  redission 客户端
     *
     * @return
     */
    @Bean(name = "redissonClient")
    @ConditionalOnMissingBean(name = "redissonClient")
    public RedissonClient configRedissonClient() {
        return new RedissonCreater(redisProperties).createRedissonClient();
    }

}