package com.mz.universe.core.datasource.strategy;

import com.mz.universe.core.datasource.algorithm.sharding.ShardingAlgorithmParamInit;
import com.mz.universe.core.datasource.creater.ShardingJdbcDataSourceCreater;
import com.mz.universe.exception.UseJavassistException;
import com.mz.universe.properties.datasource.DatasourceProperties;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author mz
 * @version V1.0
 * @Title ShardingDatasourceStrategy
 * @Package com.mz.universe.config.datasource.configuration.strategy
 * @Description shardingjdbc数据源策略
 * @date 2020/7/24 6:36 下午
 */
public class ShardingDatasourceStrategy extends DatasourceStrategy {

    @Override
    public void setDatasourceProperty(DatasourceProperties datasourceProperties) {
        ShardingAlgorithmParamInit init = new ShardingAlgorithmParamInit();
        try {
            //从外部配置中 获取分表 分库 参数 并注入到  并注入到 分表分库 算法类中
            init.initTableCountParam(datasourceProperties.getSharding().getAlgorithmParam());
            init.initDatasourceCountParam(datasourceProperties.getSharding().getAlgorithmParam());
        } catch (Exception e) {
            throw new UseJavassistException(e);
        }
        this.datasourceProperties = datasourceProperties;
    }

    @Override
    public DataSource getDatasource() throws SQLException {
        Assert.notNull(datasourceProperties.getSharding(), "can you configure sharding?");
        return (new ShardingJdbcDataSourceCreater(this.datasourceProperties.getSharding())).createDataSource();
    }

}