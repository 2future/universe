package com.mz.universe.config.datasource.configuration.strategy;

import com.mz.universe.config.datasource.configuration.creater.HikariDataSourceCreater;
import com.mz.universe.config.datasource.properties.DatasourceProperties;
import com.mz.universe.config.datasource.properties.type.HikariDatasourceProperties;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author mz
 * @version V1.0
 * @Title SingleDatasourceStrategy
 * @Package com.mz.universe.config.datasource.configuration.strategy
 * @Description 单机数据源策略
 * @date 2020/7/24 6:35 下午
 */
public class SingleDatasourceStrategy extends DatasourceStrategy {

    @Override
    public void setDatasourceProperty(DatasourceProperties datasourceProperties) {
        this.datasourceProperties = datasourceProperties;
    }

    @Override
    public DataSource getDatasource() throws SQLException {
        HikariDatasourceProperties single = datasourceProperties.getSingle();
        Assert.notNull(single, "can you configure single datasource?");
        return new HikariDataSourceCreater(single).createDataSource();
    }
}