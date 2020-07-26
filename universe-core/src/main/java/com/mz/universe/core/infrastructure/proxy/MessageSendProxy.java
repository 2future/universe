package com.mz.universe.core.infrastructure.proxy;

import com.mz.universe.core.infrastructure.entity.MessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mz
 * @version V1.0
 * @Title MessageSendProxy
 * @Package com.mz.universe.core.infrastructure.proxy
 * @Description 消息发送调用
 * @date 2020/7/20 7:58 下午
 */
@FeignClient(value = "${universe.service.msg.service-name:universe-msg}")
public interface MessageSendProxy {

    /**
     * 消息发送
     *
     * @param messageDto
     * @return
     */
    @RequestMapping(value = "${universe.service.infrastructure.msg:/id/v1/msg:/}", method = RequestMethod.GET)
    String sendMsg(MessageDto messageDto);


}