package com.mz.universe.core.cache;

import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author mz
 * @version V1.0
 * @Title FusionCacheKeyGenet
 * @Package com.mz.universe.core.cache
 * @Description
 * @date 2020/7/7 10:53 上午
 */
public class FusionCacheKeyGenerate {

    private final TreeSet<CacheKeyIndex> cacheKeySet = new TreeSet();

    public void putIndex(CacheKeyIndex keyIndex) {
        cacheKeySet.add(keyIndex);
    }

    public String generateKey() {
        String collect = cacheKeySet.stream().map(item -> item.getKey()).
                collect(Collectors.joining(".", "", ""));
        return collect;
    }

}