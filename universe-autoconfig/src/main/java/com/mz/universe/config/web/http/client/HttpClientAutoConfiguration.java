package com.mz.universe.config.web.http.client;

import com.mz.universe.core.web.http.client.RestTemplateCreater;
import com.mz.universe.properties.web.HttpClientProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

/**
 * @author mz
 * @version V1.0
 * @Title HttpClientAutoConfiguration
 * @Package com.mz.universe.config.web
 * @Description http-client自动配置
 * @date 2020/7/27 8:27 上午
 */
@Configuration
@EnableConfigurationProperties(HttpClientProperties.class)
public class HttpClientAutoConfiguration {

    @Autowired
    private HttpClientProperties httpClientProperties;

    /**
     * 此bean 为多例 可以任意进行head 等自定义
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @ConditionalOnClass(name = "okhttp3.OkHttpClient")
    public RestTemplate createProtoRestTemplate(){
        RestTemplateCreater creater=new RestTemplateCreater(httpClientProperties);
        return creater.createOkHttpRestTemplateWithoutPool();
    }


    @Bean("okHttpRestClient")
    @Primary
    @ConditionalOnClass(name = "okhttp3.OkHttpClient")
    public RestTemplate createOkHttpRestTemplate(){
       RestTemplateCreater creater=new RestTemplateCreater(httpClientProperties);
       return creater.createOkHttpRestTemplate();
    }

    @Bean("apacheHttpRestClient")
    @ConditionalOnClass(name = "org.apache.http.client.HttpClient")
    public RestTemplate createApacheHttpRestTemplate(){
        RestTemplateCreater creater=new RestTemplateCreater(httpClientProperties);
        return creater.createApacheHttpRestTemplate();
    }

}