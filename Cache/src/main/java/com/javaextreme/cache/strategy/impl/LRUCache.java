package com.javaextreme.cache.strategy.impl;


import com.javaextreme.cache.strategy.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {
    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class);

    private CachedLinkedHashMap<K, V> map;

    public LRUCache(int capacity) {
        this.map = new CachedLinkedHashMap<>(capacity);
    }

    @Override
    public V cacheGet(K obj) {
        return map.get(obj);
    }

    @Override
    public V cachePut(K obj, V o) {
        logger.info("We'll put {} in cache!", obj);
        return map.put(obj, o);
    }

    @Override
    public void reset() {
        map.clear();
    }

    private class CachedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private int capacity;

        public CachedLinkedHashMap(int capacity) {
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return this.size() >= this.capacity;
        }
    }
}