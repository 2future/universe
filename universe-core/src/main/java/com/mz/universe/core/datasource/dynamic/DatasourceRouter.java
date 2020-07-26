package com.mz.universe.core.datasource.dynamic;

import com.mz.universe.properties.datasource.type.DatasourceType;

/**
 * @author mz
 * @Description 动态数据源
 */
public @interface DatasourceRouter {

    /**
     * 动态数据源选择 默认单库读库
     *
     * @return
     */
    DatasourceType datasource() default DatasourceType.MASTER;

}
