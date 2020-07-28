package com.mz.universe.properties.datasource;

/**
 * @author mz
 * @version V1.0
 * @Title ShardingAlgorithmParamProperties
 * @Package com.mz.universe.properties.datasource
 * @Description 分表分库算法参数配置
 * @date 2020/7/28 10:58 上午
 */
public class ShardingAlgorithmParamProperties {

    /**
     * 分表分库莫表数值
     */
    private int tableShardingCount;
    /**
     * 分表分库莫库数值
     */
    private int databaseShardingCount;

    public int getTableShardingCount() {
        return tableShardingCount;
    }

    public void setTableShardingCount(int tableShardingCount) {
        this.tableShardingCount = tableShardingCount;
    }

    public int getDatabaseShardingCount() {
        return databaseShardingCount;
    }

    public void setDatabaseShardingCount(int databaseShardingCount) {
        this.databaseShardingCount = databaseShardingCount;
    }
}