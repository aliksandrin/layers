package com.javaextreme.service.cache.strategy;


import com.javaextreme.service.cache.Cache;
import com.javaextreme.service.cache.CacheableProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class LRUCache implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(CacheableProcessor.class);

    private final Map<Object, Object> map = new LinkedHashMap<>();
    private final Deque<Object> queue = new ArrayDeque<>();
    private int maxsize;

    public LRUCache(int maxsize) {
        this.maxsize = maxsize;
    }

    @Override
    public Object cacheGet(Object obj) {

        if (map.containsKey(obj)) {
            logger.info("We have {} in cache!", obj);
            return map.get(obj);
        }
        return null;
    }

    @Override
    public void cachePut(Object obj) {
        if (map.size() == maxsize) {
            Object o = queue.pollFirst();
            map.remove(o);
        }
        queue.addLast(obj);
        logger.info("We'll put {} in cache!", obj);
    }
}
