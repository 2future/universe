package com.mz.universe.core.datasource.algorithm.sharding;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;

/**
 * @author mz
 * @version V1.0
 * @Title DefaultTableRangeShardingAlgorithm
 * @Package com.mz.universe.core.datasource.algorithm.sharding
 * @Description 默认between方法实现
 * @date 2020/7/28 10:18 上午
 */
public class DefaultTableRangeShardingAlgorithm implements RangeShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> collection,
                                                    RangeShardingValue<String> rangeShardingValue) {
        throw new UnsupportedOperationException();
    }

}