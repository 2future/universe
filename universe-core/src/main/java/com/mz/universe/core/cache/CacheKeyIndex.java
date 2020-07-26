package com.deppon.cache;

import java.util.Objects;

/**
 * @author mz
 * @version V1.0
 * @Title CacheKeyIndex
 * @Package com.deppon.cache
 * @Description
 * @date 2020/7/7 11:00 上午
 */
public class CacheKeyIndex implements Comparable<CacheKeyIndex> {

    private String key;

    private int index;

    public CacheKeyIndex(String key, int index) {
        this.key = key;
        this.index = index;
    }

    public String getKey() {
        return key;
    }


    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(CacheKeyIndex o) {
        return this.index - o.getIndex();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheKeyIndex that = (CacheKeyIndex) o;
        return index == that.index &&
                Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, index);
    }
}