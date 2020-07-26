package com.mz.universe.properties.datasource.type;

public enum DatasourceType {

    MASTER("single"),

    SLAVE("masterSlave"),

    SHARDING("sharding");

    DatasourceType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
