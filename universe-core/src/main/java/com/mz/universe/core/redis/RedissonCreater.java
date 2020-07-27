package com.mz.universe.core.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mz
 * @version V1.0
 * @Title RedissionCreater
 * @Package com.mz.universe.core.redis
 * @Description
 * @date 2020/7/27 6:49 下午
 */
public class RedissonCreater {

    private RedisProperties redisProperties;

    public RedissonCreater(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    public RedissonClient createRedissonClient() {
        Config config = new Config();
        if (redisProperties.getSentinel() != null) {
            List<String> sentinelNodes = redisProperties.getSentinel().getNodes();
            List<String> redissonSentinelNodes = new ArrayList<>(sentinelNodes.size());
            for (int i = 0; i < sentinelNodes.size(); i++) {
                if (!sentinelNodes.get(i).startsWith("redis://") && !sentinelNodes.get(i).startsWith("rediss://")) {
                    redissonSentinelNodes.add("redis://" + sentinelNodes.get(i));
                }
            }
            SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
            sentinelServersConfig.getSentinelAddresses().addAll(redissonSentinelNodes);
            sentinelServersConfig.setMasterName(redisProperties.getSentinel().getMaster())
                    .setPassword(redisProperties.getPassword())
                    .setDatabase(redisProperties.getDatabase());
            if (redisProperties.getTimeout() != null) {
                sentinelServersConfig.setConnectTimeout((int) redisProperties.getTimeout().getSeconds() * 1000);
            }
            if (redisProperties.getJedis() != null
                    && redisProperties.getJedis().getPool() != null) {
                if (redisProperties.getJedis().getPool().getMaxWait() != null) {
                    sentinelServersConfig.setTimeout((int) redisProperties.getJedis().getPool().getMaxWait().getSeconds() * 1000);
                }
            }
        } else if (redisProperties.getCluster() != null) {
            ClusterServersConfig clusterServersConfig = config.useClusterServers()
                    .addNodeAddress((String[]) redisProperties.getCluster().getNodes().toArray());
            if (redisProperties.getTimeout() != null) {
                clusterServersConfig.setConnectTimeout((int) redisProperties.getTimeout().getSeconds() * 1000);
            }
        } else {
            String host = redisProperties.getHost();
            if (!host.startsWith("redis://") && !host.startsWith("rediss://")) {
                host = "redis://" + host;
            }
            SingleServerConfig singleServerConfig = config.useSingleServer()
                    .setAddress(host + ":" + redisProperties.getPort())
                    .setPassword(redisProperties.getPassword())
                    .setDatabase(redisProperties.getDatabase());
            if (redisProperties.getTimeout() != null) {
                singleServerConfig.setConnectTimeout((int) redisProperties.getTimeout().getSeconds() * 1000);
            }
        }
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create(config);
    }


}