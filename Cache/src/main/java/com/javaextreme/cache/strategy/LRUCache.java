package com.javaextreme.cache.strategy;


import com.javaextreme.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {
    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class);

    private LinkedHashMapWithCapacity<K, V> map;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMapWithCapacity<>(capacity);
    }

    @Override
    public Object cacheGet(K obj) {
        return map.get(obj);
    }

    @Override
    public void cachePut(K obj, V o) {
        map.put(obj, o);
        logger.info("We'll put {} in cache!", obj);
    }


    class LinkedHashMapWithCapacity<K, V> extends LinkedHashMap<K, V> {
        private int capacity;

        public LinkedHashMapWithCapacity(int capacity) {
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return this.size() >= this.capacity;
        }
    }
}