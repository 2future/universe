package com.mz.universe.core.pojo.po;

import com.mz.universe.core.security.context.UserContext;
import com.mz.universe.util.constant.ApplicationConstants;

import java.util.Date;
import java.util.List;

/**
 * @author mz
 * @version V1.0
 * @Title BasicPoInitializer
 * @Package com.mz.universe.core.datasource.po
 * @Description po实体初始化工具类
 * @date 2020/7/20 7:04 下午
 */
public class BasicPoInitializer {

    /**
     * 初始化新增参数
     *
     * @param basePo
     * @param date
     * @date 2020/7/20 7:04 下午
     */
    public void initAdd(BasePo basePo, Date date) {
        basePo.setActive(ApplicationConstants.ACTIVE);
        basePo.setCreateTime(date);
        basePo.setModifyTime(date);
        basePo.setCreateUserCode(UserContext.getCurrentUserCode());
        basePo.setModifyUserCode(UserContext.getCurrentUserCode());
    }

    /**
     * 初始化新增参数
     *
     * @param basePo
     * @date 2020/7/20 7:04 下午
     */
    public void initAdd(BasePo basePo) {
        initAdd(basePo, new Date());
    }

    /**
     * 初始化新增参数
     *
     * @param basePo
     * @param date
     * @param userCode
     * @date 2020/7/20 7:04 下午
     */
    public void initAdd(BasePo basePo, Date date, String userCode) {
        basePo.setActive(ApplicationConstants.ACTIVE);
        basePo.setCreateTime(date);
        basePo.setModifyTime(date);
        basePo.setCreateUserCode(userCode);
        basePo.setModifyUserCode(userCode);
    }

    /**
     * 初始化新增参数
     *
     * @param basePo
     * @date 2020/7/20 7:04 下午
     */
    public void initModify(BasePo basePo) {
        Date date = new Date();
        basePo.setModifyTime(date);
        basePo.setModifyUserCode(UserContext.getCurrentUserCode());

    }

    /**
     * 初始化修改参数
     *
     * @param basePo
     * @date 2020/7/20 7:04 下午
     */
    public void initModify(BasePo basePo, Date date) {
        basePo.setModifyTime(date);
        basePo.setModifyUserCode(UserContext.getCurrentUserCode());
    }

    /**
     * 初始化修改参数
     * 0
     *
     * @param basePo
     * @date 2020/7/20 7:04 下午
     */
    public void initModify(BasePo basePo, Date date, String userCode) {
        basePo.setModifyTime(date);
        basePo.setModifyUserCode(userCode);
    }

    /**
     * 批量初始化
     *
     * @param basePos
     * @date 2020/7/20 7:04 下午
     */
    public void batchInitAdd(List<? extends BasePo> basePos) {
        basePos.forEach(basicEntity -> initAdd(basicEntity, new Date()));
    }

    /**
     * 批量初始化
     *
     * @param basePos
     * @date 2020/7/20 7:04 下午
     */
    public void batchInitAdd(List<? extends BasePo> basePos, Date date) {
        basePos.forEach(basicEntity -> initAdd(basicEntity, date));
    }


}