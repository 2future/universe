package com.mz.universe.properties.datasource;

import com.mz.universe.config.datasource.properties.type.HikariDatasourceProperties;
import com.mz.universe.config.datasource.properties.type.MasterSlaveDatasourceProperties;
import com.mz.universe.config.datasource.properties.type.ShardingJdbcDatasourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mz
 * @version V1.0
 * @Title DynamicDatasourceProperties
 * @Package com.mz.universe.core.datasource.properties
 * @Description {@link ShardingJdbcDatasourceProperties,HikariDatasourceProperties, DatasourceType}
 * @date 2020/7/24 3:22 下午
 */
@Component
@ConfigurationProperties(prefix = "universe.datasource")
public class DatasourceProperties {

    /**
     * 数据源类型
     */
    private DatasourceType datasourceType;

    /**
     * 单一数据源
     */
    private HikariDatasourceProperties single;

    /**
     * 主从数据源
     */
    private MasterSlaveDatasourceProperties masterSlave;

    /**
     * 分表分裤数据源
     */
    private ShardingJdbcDatasourceProperties sharding;

    public DatasourceType getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(DatasourceType datasourceType) {
        this.datasourceType = datasourceType;
    }

    public HikariDatasourceProperties getSingle() {
        return single;
    }

    public void setSingle(HikariDatasourceProperties single) {
        this.single = single;
    }

    public MasterSlaveDatasourceProperties getMasterSlave() {
        return masterSlave;
    }

    public void setMasterSlave(MasterSlaveDatasourceProperties masterSlave) {
        this.masterSlave = masterSlave;
    }

    public ShardingJdbcDatasourceProperties getSharding() {
        return sharding;
    }

    public void setSharding(ShardingJdbcDatasourceProperties sharding) {
        this.sharding = sharding;
    }
}