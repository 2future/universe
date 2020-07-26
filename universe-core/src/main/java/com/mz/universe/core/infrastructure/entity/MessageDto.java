package com.mz.universe.core.infrastructure.entity;

/**
 * @author mz
 * @version V1.0
 * @Title WxDto
 * @Package com.mz.universe.core.infrastructure.entity
 * @Description 微信请求实体
 * @date 2020/7/20 7:50 下午
 */
public class MessageDto {

    /**
     * 主键
     */
    private String id;

    /**
     * 消息发送平台 默认 微信/邮箱/短信
     */
    private MessageType platform;

    /**
     * 接受者
     */
    private String receiver;

    /**
     * 请求体
     */
    private String requestBody;

    /**
     * 是否使用模版
     */
    private boolean isUseTemplate;

    /**
     * 模版名称
     */
    private boolean templateName;
    /**
     * 求情服务模块名称
     */
    private String serviceCode;

    /**
     * 延迟发送时间
     */
    private long delayTIme;

    /**
     * 是否延迟发送
     */
    private boolean isDelay;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageType getPlatform() {
        return platform;
    }

    public void setPlatform(MessageType platform) {
        this.platform = platform;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public boolean isUseTemplate() {
        return isUseTemplate;
    }

    public void setUseTemplate(boolean useTemplate) {
        isUseTemplate = useTemplate;
    }

    public boolean isTemplateName() {
        return templateName;
    }

    public void setTemplateName(boolean templateName) {
        this.templateName = templateName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public long getDelayTIme() {
        return delayTIme;
    }

    public void setDelayTIme(long delayTIme) {
        this.delayTIme = delayTIme;
    }

    public boolean isDelay() {
        return isDelay;
    }

    public void setDelay(boolean delay) {
        isDelay = delay;
    }
}