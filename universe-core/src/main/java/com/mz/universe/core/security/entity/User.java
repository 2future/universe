package com.mz.universe.core.security.entity;

/**
 * @author mz
 * @version V1.0
 * @Title IUser
 * @Package com.mz.universe.core.security.entity
 * @Description
 * @date 2020/7/20 7:22 下午
 */
public class User {
    /**
     * 用户编号
     */
    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}