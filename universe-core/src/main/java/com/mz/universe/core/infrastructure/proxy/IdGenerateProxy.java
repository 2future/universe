package com.mz.universe.core.infrastructure.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mz
 * @version V1.0
 * @Title IdGenerateProxy
 * @Package com.mz.universe.core.infrastructure.proxy
 * @Description 获取主键
 * @date 2020/7/20 7:49 下午
 */
@FeignClient(value = "${universe.service.infrastructure.id.service-name:universe-id}")
public interface IdGenerateProxy {

    /**
     * 主键获取
     *
     * @return
     */
    @RequestMapping(value = "${universe.service.infrastructure.id:/id/v1/snowflake}", method = RequestMethod.GET)
    String getIdFromSnowflake();

}