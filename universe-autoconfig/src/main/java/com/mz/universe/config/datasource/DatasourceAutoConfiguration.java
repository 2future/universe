package com.mz.universe.config.datasource;


import com.mz.universe.core.datasource.strategy.DatasourceStrategy;
import com.mz.universe.core.datasource.strategy.MasterSlaveDatasourceStrategy;
import com.mz.universe.core.datasource.strategy.ShardingDatasourceStrategy;
import com.mz.universe.core.datasource.strategy.SingleDatasourceStrategy;
import com.mz.universe.properties.datasource.DatasourceProperties;
import com.mz.universe.properties.datasource.type.DatasourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author mz
 * @version V1.0
 * @Title DynamicDatasourceAutoConfiguration
 * @Package com.mz.universe.core.datasource.configuration
 * @Description 动态数据源配置 坐上来自己动
 * @date 2020/7/24 3:21 下午
 */
@Configuration
@ConditionalOnBean(DataSource.class)
@EnableConfigurationProperties(DatasourceProperties.class)
public class DatasourceAutoConfiguration {

    @Autowired
    private DatasourceProperties datasourceProperties;

    @Bean
    public DataSource configDataSource() throws SQLException {
        DatasourceType datasourceType = datasourceProperties.getDatasourceType();
        DatasourceStrategy datasourceStrategy = null;
        switch (datasourceType.getName()) {
            case "single":
                datasourceStrategy = new SingleDatasourceStrategy();
                break;
            case "masterSlave":
                datasourceStrategy = new MasterSlaveDatasourceStrategy();
                break;
            case "sharding":
                datasourceStrategy = new ShardingDatasourceStrategy();
                break;
        }
        Assert.notNull(datasourceStrategy, " datasource is null");
        datasourceStrategy.setDatasourceProperty(datasourceProperties);
        DataSource datasource = datasourceStrategy.getDatasource();
        return datasource;
    }

}