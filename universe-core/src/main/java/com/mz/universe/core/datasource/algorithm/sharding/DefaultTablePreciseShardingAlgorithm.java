package com.mz.universe.core.datasource.algorithm.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * @author mz
 * @version V1.0
 * @Title DefaultTablePreciseShardingAlgorithm
 * @Package com.mz.universe.core.datasource.algorithm.sharding
 * @Description 默认精确算法实现
 * @date 2020/7/28 10:16 上午
 */
public class DefaultTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    Logger logger = LoggerFactory.getLogger(DefaultTablePreciseShardingAlgorithm.class);

    /**
     * 此字段 会使用Javassist 进行动态class 修改
     */
    private static int tableShardingCount;

    @Override
    public String doSharding(final Collection<String> availableTargetNames,
                             final PreciseShardingValue<String> shardingValue) {
        int size = availableTargetNames.size();
        for (String each : availableTargetNames) {
            //计算分片键的hashcode，再除以15，再取模，防止直接取模结果和数据库分配算法一致导致的只分库未分表
            if (each.endsWith("_" + Math.abs(shardingValue.getValue().hashCode() / 15 % tableShardingCount))) {
                logger.info("sharding key {}, sharding result {}", shardingValue.getValue(), each);
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

}