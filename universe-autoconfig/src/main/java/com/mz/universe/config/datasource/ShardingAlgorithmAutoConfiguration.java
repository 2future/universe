package com.mz.universe.config.datasource;

import com.mz.universe.core.datasource.algorithm.sharding.ShardingAlgorithmParamInit;
import com.mz.universe.properties.datasource.DatasourceProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author mz
 * @version V1.0
 * @Title ShardingAlgorithmAutoConfiguration
 * @Package com.mz.universe.config.datasource
 * @Description 分表分库 算法类 动态初始化方法
 * @date 2020/7/28 11:06 上午
 */
@Configuration
@ConditionalOnBean(DataSource.class)
@EnableConfigurationProperties(DatasourceProperties.class)
public class ShardingAlgorithmAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "universe.datasource.sharding.algorithmParam", name = "tableShardingCount")
    public ShardingAlgorithmParamInit initTableParam(DatasourceProperties datasourceProperties) throws Exception {
        ShardingAlgorithmParamInit init =new ShardingAlgorithmParamInit();
        init.initTableCountParam(datasourceProperties.getSharding().getAlgorithmParam());
        return init;
    }

    @Bean
    @ConditionalOnProperty(prefix = "universe.datasource.sharding.algorithmParam", name = "databaseShardingCount")
    public ShardingAlgorithmParamInit initDatasourceParam(DatasourceProperties datasourceProperties) throws Exception {
        ShardingAlgorithmParamInit init =new ShardingAlgorithmParamInit();
        init.initDatasourceCountParam(datasourceProperties.getSharding().getAlgorithmParam());
        return init;
    }
}