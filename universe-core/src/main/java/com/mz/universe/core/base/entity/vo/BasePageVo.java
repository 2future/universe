package com.mz.universe.core.pojo.vo;

/**
 * @author mz
 * @version V1.0
 * @Title BasePageVo
 * @Package com.mz.universe.core.datasource.po
 * @Description 视图层基本vo
 * @date 2020/7/20 7:03 下午
 */
public class BasePageVo {

    /**
     * 当前页面数
     */
    private int page;

    /**
     *  分页偏移量
     */
    private int limit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}