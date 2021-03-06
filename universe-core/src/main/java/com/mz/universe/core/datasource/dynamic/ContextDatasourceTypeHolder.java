package com.mz.universe.core.datasource.dynamic;

/**
 * @author mz
 * @version V1.0
 * @Title ContextDatasourceTypeHolder
 * @Package com.mz.universe.core.datasource.dynamic
 * @Description 数据源上下文
 * @date 2020/7/24 5:09 下午
 */
public class ContextDatasourceTypeHolder implements AutoCloseable {

    private static ThreadLocal<String> datasourceTypeHolder = new ThreadLocal<>();

    public  String getDatasourceName() {
        return datasourceTypeHolder.get();
    }

    public void setDatasourceName(String datasourceName) {
        ContextDatasourceTypeHolder.datasourceTypeHolder.set(datasourceName);
    }

    @Override
    public void close() throws Exception {
        ContextDatasourceTypeHolder.datasourceTypeHolder.remove();
    }
}