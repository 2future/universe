package com.mz.universe.properties.datasource.type;

public enum DatasourceType {
    /**
     *  单数据源模式
     */
    SINGLE("single"),
    /**
     * 主从数据源模式
     */
    MASTER_SLAVE("masterSlave"),
    /**
     * 分表分裤数据源模式
     */
    SHARDING("sharding");

    DatasourceType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
