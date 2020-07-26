package com.mz.universe.core.datasource.dynamic;

import com.mz.universe.properties.datasource.type.DatasourceName;

/**
 * @author mz
 * @Description 动态数据源
 */
public @interface DatasourceRouter {

    /**
     * 动态数据源名称选择 默认单库读库
     *
     * @return
     */
    DatasourceName datasource() default DatasourceName.MASTER;

}
