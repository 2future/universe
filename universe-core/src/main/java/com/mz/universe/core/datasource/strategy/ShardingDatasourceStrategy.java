package com.mz.universe.core.datasource.strategy;

import com.mz.universe.core.datasource.creater.ShardingJdbcDataSourceCreater;
import com.mz.universe.properties.datasource.DatasourceProperties;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author mz
 * @version V1.0
 * @Title ShardingDatasourceStrategy
 * @Package com.mz.universe.config.datasource.configuration.strategy
 * @Description shardingjdbc数据源策略
 * @date 2020/7/24 6:36 下午
 */
public class ShardingDatasourceStrategy extends DatasourceStrategy {

    @Override
    public void setDatasourceProperty(DatasourceProperties datasourceProperties) {
        this.datasourceProperties = datasourceProperties;
    }

    @Override
    public DataSource getDatasource() throws SQLException {
        Assert.notNull(datasourceProperties.getSharding(), "can you configure sharding?");
        return (new ShardingJdbcDataSourceCreater(this.datasourceProperties.getSharding())).createDataSource();
    }

}