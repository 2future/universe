package com.mz.universe.core.datasource.dynamic;

public enum DatasourceType {
    MASTER("master"),
    SLAVE("slave"),
    SHARDING("sharding");

    DatasourceType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
