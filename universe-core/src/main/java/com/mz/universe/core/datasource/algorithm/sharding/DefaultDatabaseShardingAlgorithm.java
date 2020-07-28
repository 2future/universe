package com.mz.universe.core.datasource.algorithm.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * @author mz
 * @version V1.0
 * @Title DefaultDatabaseShardingAlgorithm
 * @Package com.mz.universe.core.datasource.algorithm.sharding
 * @Description 默认分表分库算法
 * @date 2020/7/28 10:15 上午
 */
public class DefaultDatabaseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    Logger logger = LoggerFactory.getLogger(DefaultDatabaseShardingAlgorithm.class);

    /**
     * 此字段 会使用Javassist 进行动态class 修改
     */
    private static int databaseShardingCount;

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        for (String each : collection) {
            if (each.equals("ds" + Math.abs(preciseShardingValue.getValue().hashCode() % databaseShardingCount))) {
                logger.info("sharding key {}, sharding result {}", preciseShardingValue.getValue(), each);
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

}