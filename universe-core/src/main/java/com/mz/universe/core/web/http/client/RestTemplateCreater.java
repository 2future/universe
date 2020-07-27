package com.mz.universe.core.web.http.client;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mz.universe.properties.web.HttpClientProperties;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * @author mz
 * @version V1.0
 * @Title RestTemplateCreater
 * @Package com.mz.universe.core.web.http.client
 * @Description restTemplate 生产者
 * @date 2020/7/27 9:07 上午
 */
public class RestTemplateCreater {

    private HttpClientProperties httpClientProperties;

    public RestTemplateCreater(HttpClientProperties httpClientProperties) {
        this.httpClientProperties = httpClientProperties;
    }

    /**
     * 构建使用okhttp-client rest-template
     *
     * @return
     */
    public RestTemplate createOkHttpRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //连接池设置
                .connectionPool(new ConnectionPool(httpClientProperties.getOkHttpPoolMaxIdleConnections(),
                        httpClientProperties.getOkHttpPoolKeepAliveDuration(), TimeUnit.MILLISECONDS))
                //超时时间设置
                .connectTimeout(httpClientProperties.getOkHttpConnectTimeOut(), TimeUnit.MILLISECONDS)
                .writeTimeout(httpClientProperties.getOkHttpPoolKeepAliveDuration(), TimeUnit.MILLISECONDS)
                .readTimeout(httpClientProperties.getOkHttpReadTimeOut(), TimeUnit.MILLISECONDS)
                //关闭重试
                .retryOnConnectionFailure(httpClientProperties.isOkHttpRetryOnConnectionFailure())
                .build();
        //使用配置好的okHttpClient创建工厂类
        OkHttp3ClientHttpRequestFactory clientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory(okHttpClient);

        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //如果为空 则默认为 0 时区
        objectMapper.setTimeZone(TimeZone.getTimeZone(httpClientProperties.getJsonTimeZone()));
        //设置时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //使用jackson 进行json序列化
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(objectMapper);
        messageConverters.add(0, jsonMessageConverter);
        restTemplate.setMessageConverters(messageConverters);
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }

    /**
     * 构建使用 apache http client rest-template
     *
     * @return
     */
    public RestTemplate createApacheHttpRestTemplate()  {
        RestTemplate restTemplate = new RestTemplate();
        // httpClient连接池配置,指定连接池中连接的Keep-Alive最大时长
        PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager(60, TimeUnit.SECONDS);
        pollingConnectionManager.setMaxTotal(httpClientProperties.getMaxTotal());
        pollingConnectionManager.setDefaultMaxPerRoute(httpClientProperties.getDefaultMaxPerRoute());
        //增加建立socket连接默认超时时间
        pollingConnectionManager.setDefaultSocketConfig(SocketConfig.custom()
                .setSoTimeout(httpClientProperties.getConnectTimeOut()).build());
        //设置连接池检查清理过期连接的间隔时间
        pollingConnectionManager.setValidateAfterInactivity(httpClientProperties.getCheckPooledStaleConnectionThreadInterval());
        RequestConfig.Builder requestBuilder = RequestConfig.custom();
        // 连接超时时间
        requestBuilder = requestBuilder.setConnectTimeout(httpClientProperties.getConnectTimeOut());
        // 从连接池中获取连接超时时间
        requestBuilder = requestBuilder.setConnectionRequestTimeout(httpClientProperties.getRequestTimeOut());
        // 读取超时时间
        requestBuilder = requestBuilder.setSocketTimeout(httpClientProperties.getReadTimeOut());
        // 初始化httpClient
        HttpClient build = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestBuilder.build())
                .setConnectionManager(pollingConnectionManager)
                .evictExpiredConnections()//回收过期连接
                //关闭自动重试
                .disableAutomaticRetries().build();
        // 连接工厂
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(
                build));
        return restTemplate;
    }


    /**
     * 构建使用 无连接池的 okhttp rest-template
     *
     * @return
     */
    public RestTemplate createOkHttpRestTemplateWithoutPool()  {
        RestTemplate restTemplate = new RestTemplate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //超时时间设置
                .connectTimeout(httpClientProperties.getOkHttpConnectTimeOut(), TimeUnit.MILLISECONDS)
                .writeTimeout(httpClientProperties.getOkHttpPoolKeepAliveDuration(), TimeUnit.MILLISECONDS)
                .readTimeout(httpClientProperties.getOkHttpReadTimeOut(), TimeUnit.MILLISECONDS)
                //关闭重试
                .retryOnConnectionFailure(httpClientProperties.isOkHttpRetryOnConnectionFailure())
                .build();
        //使用配置好的okHttpClient创建工厂类
        OkHttp3ClientHttpRequestFactory clientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory(okHttpClient);
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //如果为空 则默认为 0 时区
        objectMapper.setTimeZone(TimeZone.getTimeZone(httpClientProperties.getJsonTimeZone()));
        //设置时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //使用jackson 进行json序列化
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(objectMapper);
        messageConverters.add(0, jsonMessageConverter);
        restTemplate.setMessageConverters(messageConverters);
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }

}