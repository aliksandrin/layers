package com.javaextreme.cache.strategy.impl;


import com.javaextreme.cache.strategy.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class LRUCache implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class);

    private CachedLinkedHashMap<Integer, Object> map;

    public LRUCache(int capacity) {
        this.map = new CachedLinkedHashMap<>(capacity);
    }

    @Override
    public Object cacheGet(Object obj) {
        Object[] arr = new Object[]{obj};
        int hash = Arrays.deepHashCode(arr);
        return map.get(hash);
    }

    @Override
    public Object cachePut(Object obj, Object o) {
        Object[] arr = new Object[]{obj};
        int hash = Arrays.deepHashCode(arr);
        logger.info("We'll put {} in cache!", obj);
        return map.put(hash, o);
    }
}