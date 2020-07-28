package com.mz.universe.core.datasource.creater;

import com.mz.universe.properties.datasource.type.ShardingJdbcDatasourceProperties;
import org.apache.shardingsphere.core.yaml.swapper.impl.ShardingRuleConfigurationYamlSwapper;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author mz
 * @version V1.0
 * @Title ShardingJdbcDataSourceConfiguration
 * @Package com.mz.universe.core.datasource.configuration
 * @Description sharingjdbc数据源配置
 * @date 2020/7/24 4:03 下午
 */
public class ShardingJdbcDataSourceCreater {

    private ShardingJdbcDatasourceProperties shardingJdbcDatasourceProperties;

    public ShardingJdbcDataSourceCreater(ShardingJdbcDatasourceProperties shardingJdbcDatasourceProperties) {


        this.shardingJdbcDatasourceProperties = shardingJdbcDatasourceProperties;
    }

    public DataSource createDataSource() throws SQLException {
        return ShardingDataSourceFactory.createDataSource(shardingJdbcDatasourceProperties.getConfig().getDataSources(),
                new ShardingRuleConfigurationYamlSwapper().swap(shardingJdbcDatasourceProperties.getConfig().getShardingRule()),
                shardingJdbcDatasourceProperties.getConfig().getProps());
    }
}