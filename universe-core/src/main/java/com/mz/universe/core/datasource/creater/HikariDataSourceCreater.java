package com.mz.universe.core.datasource.creater;


import com.mz.universe.properties.datasource.type.HikariDatasourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * @author mz
 * @version V1.0
 * @Title HikariDataSourceConfig
 * @Package com.mz.universe.core.datasource.configuration
 * @Description 日光牌数据源 可靠的雅痞 🤟
 * @date 2020/7/24 3:26 下午
 */
public class HikariDataSourceCreater {

    private HikariDatasourceProperties datasourceProperties;

    public HikariDataSourceCreater(HikariDatasourceProperties datasourceProperties) {
        this.datasourceProperties = datasourceProperties;
    }

    public DataSource createDataSource() {
        //pool size = Tn x (Cm - 1) + 1  线程数*（单个线程数所需要持有链接-1）+1
        Assert.notNull(this.datasourceProperties, "datasourceProperties can not be null");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(this.datasourceProperties.getUrl());
        config.setUsername(this.datasourceProperties.getUsername());
        config.setPassword(this.datasourceProperties.getPassword());
        config.setDriverClassName(this.datasourceProperties.getDriverClassName());
        config.setMaximumPoolSize(this.datasourceProperties.getMaximumPoolSize());
        config.setConnectionTimeout(this.datasourceProperties.getConnectionTimeout());
        config.setConnectionInitSql(this.datasourceProperties.getConnectionInitSql());
        config.setConnectionTestQuery(this.datasourceProperties.getConnectionTestQuery());
        config.setIdleTimeout(this.datasourceProperties.getIdleTimeout());
        config.setInitializationFailTimeout(this.datasourceProperties.getiInitializationFailTimeout());
        config.setMinimumIdle(this.datasourceProperties.getMaximumPoolSize());
        config.setMaxLifetime(this.datasourceProperties.getMaxLifetime());
        config.setAutoCommit(this.datasourceProperties.isAutoCommit());
        return new HikariDataSource(config);
    }

}