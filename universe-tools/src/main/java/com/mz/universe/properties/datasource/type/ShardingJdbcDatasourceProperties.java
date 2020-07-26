package com.mz.universe.properties.datasource.type;

import org.apache.shardingsphere.core.yaml.config.sharding.YamlRootShardingConfiguration;

import java.util.List;

/**
 * @author mz
 * @version V1.0
 * @Title ShardingJdbcDatasourceProperties
 * @Package com.mz.universe.core.datasource.properties
 * @Description shardingjdbc数据源属性
 * @date 2020/7/24 4:04 下午
 */
public class ShardingJdbcDatasourceProperties  {

    /**
     * 默认数据源名称
     */
    private String defaultDatasourceName;
    /**
     * 多数据源配置
     */
    private List<HikariDatasourceProperties> datasourceList;

    /**
     * sharding配置
     */
    private YamlRootShardingConfiguration config;


    public String getDefaultDatasourceName() {
        return defaultDatasourceName;
    }

    public void setDefaultDatasourceName(String defaultDatasourceName) {
        this.defaultDatasourceName = defaultDatasourceName;
    }

    public List<HikariDatasourceProperties> getDatasourceList() {
        return datasourceList;
    }

    public void setDatasourceList(List<HikariDatasourceProperties> datasourceList) {
        this.datasourceList = datasourceList;
    }

    public YamlRootShardingConfiguration getConfig() {
        return config;
    }

    public void setConfig(YamlRootShardingConfiguration config) {
        this.config = config;
    }
}