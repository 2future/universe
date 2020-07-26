package com.mz.universe.config.datasource.configuration.strategy;

import com.mz.universe.config.datasource.properties.DatasourceProperties;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author mz
 * @version V1.0
 * @Title DatasourceStrategy
 * @Package com.mz.universe.config.datasource.configuration.strategy
 * @Description 数据源
 * @date 2020/7/24 6:50 下午
 */
public abstract class DatasourceStrategy {

    protected DatasourceProperties datasourceProperties;

    public abstract void setDatasourceProperty(DatasourceProperties datasourceProperties);

    public abstract DataSource getDatasource() throws SQLException;

}