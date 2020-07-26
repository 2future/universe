package com.mz.universe.properties.datasource.type;

import java.util.List;

/**
 * @author mz
 * @version V1.0
 * @Title DynamicDatasource
 * @Package com.mz.universe.config.datasource.properties
 * @Description 动态数据源配置
 * @date 2020/7/24 7:10 下午
 */
public class MasterSlaveDatasourceProperties {

    private String defaultDatasource;

    private List<HikariDatasourceProperties> datasourceProperties;

    public String getDefaultDatasource() {
        return defaultDatasource;
    }

    public void setDefaultDatasource(String defaultDatasource) {
        this.defaultDatasource = defaultDatasource;
    }

    public List<HikariDatasourceProperties> getDatasourceProperties() {
        return datasourceProperties;
    }

    public void setDatasourceProperties(List<HikariDatasourceProperties> datasourceProperties) {
        this.datasourceProperties = datasourceProperties;
    }
}