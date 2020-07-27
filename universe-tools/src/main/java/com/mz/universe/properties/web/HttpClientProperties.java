package com.mz.universe.properties.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mz
 * @version V1.0
 * @Title HttpClientProperties
 * @Package com.mz.universe.properties.web
 * @Description 配置httpClient
 * @date 2020/7/27 8:28 上午
 */
@Component
@ConfigurationProperties(prefix = "universe.web.http-client")
public class HttpClientProperties {

    /**
     * 最大连接数
     */
    private int maxTotal = 1500;

    /**
     * 单个路由默认最大连接数
     */
    private int defaultMaxPerRoute = 1500;

    /**
     * 从连接池中获取连接超时时间
     */
    private int requestTimeOut = 30 * 1000;

    /**
     * 连接超时时间
     */
    private int connectTimeOut = 30 * 1000;

    /**
     * 读取超时时间
     */
    private int readTimeOut = 60 * 1000;

    /**
     * 检测连接池中过期连接线程的间隔时间 ms
     */
    private int checkPooledStaleConnectionThreadInterval = 1000;


    /**
     * 连接池中每个地址最大的空闲连接数
     */
    private int okHttpPoolMaxIdleConnections = 100;

    /**
     * 连接池中进行连接保持的最大连接数
     */
    private int okHttpPoolKeepAliveDuration = 10;

    /**
     * 连接超时时间
     */
    private int okHttpConnectTimeOut = 30 * 1000;

    /**
     * 写入数据超时时间
     */
    private int okHttpWriteTimeOut = 60 * 1000;

    /**
     * 读取超时时间
     */
    private int okHttpReadTimeOut = 60 * 1000;

    /**
     * 连接失败是否重试
     */
    private boolean okHttpRetryOnConnectionFailure = false;

    /**
     * 时区
     */
    private String jsonTimeZone;

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getDefaultMaxPerRoute() {
        return defaultMaxPerRoute;
    }

    public void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
        this.defaultMaxPerRoute = defaultMaxPerRoute;
    }

    public int getRequestTimeOut() {
        return requestTimeOut;
    }

    public void setRequestTimeOut(int requestTimeOut) {
        this.requestTimeOut = requestTimeOut;
    }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public int getCheckPooledStaleConnectionThreadInterval() {
        return checkPooledStaleConnectionThreadInterval;
    }

    public void setCheckPooledStaleConnectionThreadInterval(int checkPooledStaleConnectionThreadInterval) {
        this.checkPooledStaleConnectionThreadInterval = checkPooledStaleConnectionThreadInterval;
    }

    public int getOkHttpPoolMaxIdleConnections() {
        return okHttpPoolMaxIdleConnections;
    }

    public void setOkHttpPoolMaxIdleConnections(int okHttpPoolMaxIdleConnections) {
        this.okHttpPoolMaxIdleConnections = okHttpPoolMaxIdleConnections;
    }

    public int getOkHttpPoolKeepAliveDuration() {
        return okHttpPoolKeepAliveDuration;
    }

    public void setOkHttpPoolKeepAliveDuration(int okHttpPoolKeepAliveDuration) {
        this.okHttpPoolKeepAliveDuration = okHttpPoolKeepAliveDuration;
    }

    public int getOkHttpConnectTimeOut() {
        return okHttpConnectTimeOut;
    }

    public void setOkHttpConnectTimeOut(int okHttpConnectTimeOut) {
        this.okHttpConnectTimeOut = okHttpConnectTimeOut;
    }

    public int getOkHttpWriteTimeOut() {
        return okHttpWriteTimeOut;
    }

    public void setOkHttpWriteTimeOut(int okHttpWriteTimeOut) {
        this.okHttpWriteTimeOut = okHttpWriteTimeOut;
    }

    public int getOkHttpReadTimeOut() {
        return okHttpReadTimeOut;
    }

    public void setOkHttpReadTimeOut(int okHttpReadTimeOut) {
        this.okHttpReadTimeOut = okHttpReadTimeOut;
    }

    public boolean isOkHttpRetryOnConnectionFailure() {
        return okHttpRetryOnConnectionFailure;
    }

    public void setOkHttpRetryOnConnectionFailure(boolean okHttpRetryOnConnectionFailure) {
        this.okHttpRetryOnConnectionFailure = okHttpRetryOnConnectionFailure;
    }

    public String getJsonTimeZone() {
        return jsonTimeZone;
    }

    public void setJsonTimeZone(String jsonTimeZone) {
        this.jsonTimeZone = jsonTimeZone;
    }
}
