package com.mz.universe.properties.datasource.type;

import com.mz.universe.config.datasource.properties.BaseDatasourceProperties;

/**
 * @author mz
 * @version V1.0
 * @Title Hikari
 * @Package com.mz.universe.core.datasource.properties
 * @Description
 * @date 2020/7/24 3:29 下午
 */
public class HikariDatasourceProperties extends BaseDatasourceProperties {

    /**
     * 最大链接数 推荐的公式：((core_count * 2) + effective_spindle_count) 最好使用默认值
     */
    private int maximumPoolSize;

    /**
     * 等待连接池分配连接的最大时长
     */
    private long connectionTimeout;

    /**
     * 链接初始化sql
     */
    private String connectionInitSql;

    /**
     * 链接测试查询sql
     */
    private String connectionTestQuery;

    /**
     * 一个连接idle状态的最大时长
     */
    private long idleTimeout;

    /**
     * 初始化 失败超时时间
     */
    private long iInitializationFailTimeout;

    /**
     * 最小空闲时间
     */
    private long minimumIdle;

    /**
     * 一个连接的生命时长
     */
    private long maxLifetime;

    /**
     * 是否自动提交
     */
    private boolean autoCommit;

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(long connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getConnectionInitSql() {
        return connectionInitSql;
    }

    public void setConnectionInitSql(String connectionInitSql) {
        this.connectionInitSql = connectionInitSql;
    }

    public String getConnectionTestQuery() {
        return connectionTestQuery;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
    }

    public long getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(long idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public long getiInitializationFailTimeout() {
        return iInitializationFailTimeout;
    }

    public void setiInitializationFailTimeout(long iInitializationFailTimeout) {
        this.iInitializationFailTimeout = iInitializationFailTimeout;
    }

    public long getMinimumIdle() {
        return minimumIdle;
    }

    public void setMinimumIdle(long minimumIdle) {
        this.minimumIdle = minimumIdle;
    }

    public long getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(long maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }
}