package com.mz.universe.properties.datasource;

import com.mz.universe.properties.datasource.type.DatasourceName;

/**
 * @author mz
 * @version V1.0
 * @Title DatasourceProperties
 * @Package com.mz.universe.core.datasource.properties
 * @Description 数据源配置文件
 * @date 2020/7/24 3:22 下午
 */
public class BaseDatasourceProperties {

    /**
     * 数据源名称
     */
    private String name;

    /**
     * 动态数据源名称
     */
    private DatasourceName dynamicDatasourceName;

    /**
     * 数据源地址
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 驱动
     */
    private String driverClassName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DatasourceName getDynamicDatasourceName() {
        return dynamicDatasourceName;
    }

    public void setDynamicDatasourceName(DatasourceName dynamicDatasourceName) {
        this.dynamicDatasourceName = dynamicDatasourceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}