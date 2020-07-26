package com.mz.universe.core.datasource.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author mz
 * @version V1.0
 * @Title DynamicDatasource
 * @Package com.mz.universe.core.datasource.dynamic
 * @Description spring动态数据源配置
 * @date 2020/7/24 5:12 下午
 */
public class DynamicDatasource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        ContextDatasourceTypeHolder holder=new ContextDatasourceTypeHolder();
        return holder.getDatasourceName();
    }

}