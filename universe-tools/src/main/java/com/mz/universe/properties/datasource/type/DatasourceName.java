package com.mz.universe.properties.datasource.type;

/**
 * @author mz
 * @version V1.0
 * @Title DatasourceName
 * @Package com.mz.universe.properties.datasource.type
 * @Description 数据源名称
 * @date 2020/7/26 8:36 下午
 */
public enum DatasourceName {

    MASTER("master"),
    SLAVE("slave"),
    SHARDING("sharding");

    DatasourceName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}