package com.mz.universe.core.datasource.strategy;


import com.mz.universe.core.datasource.creater.HikariDataSourceCreater;
import com.mz.universe.core.datasource.dynamic.DynamicDatasource;
import com.mz.universe.properties.datasource.DatasourceProperties;
import com.mz.universe.properties.datasource.type.MasterSlaveDatasourceProperties;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mz
 * @version V1.0
 * @Title MasterSlaveDatasourceStrategy
 * @Package com.mz.universe.config.datasource.configuration.strategy
 * @Description 主从数据源策略
 * @date 2020/7/24 6:35 下午
 */
public class MasterSlaveDatasourceStrategy extends DatasourceStrategy {

    @Override
    public void setDatasourceProperty(DatasourceProperties datasourceProperties) {
        this.datasourceProperties=datasourceProperties;
    }

    @Override
    public DataSource getDatasource() throws SQLException {
        DynamicDatasource dynamicDatasource = new DynamicDatasource();
        Map<Object, Object> targetDataSources = new HashMap(4);
        MasterSlaveDatasourceProperties masterSlave = datasourceProperties.getMasterSlave();
        Assert.notNull(masterSlave,"can you configure masterSlave?");
        masterSlave.getDatasourceProperties().forEach(property -> {
            String name = property.getName();
            DataSource dataSource = new HikariDataSourceCreater(property).createDataSource();
            targetDataSources.put(name, dataSource);
        });
        dynamicDatasource.setTargetDataSources(targetDataSources);
        dynamicDatasource.setDefaultTargetDataSource(masterSlave.getDefaultDatasource());
        return dynamicDatasource;
    }
}