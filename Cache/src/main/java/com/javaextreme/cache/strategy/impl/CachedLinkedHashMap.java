package com.javaextreme.cache.strategy.impl;

import java.util.LinkedHashMap;
import java.util.Map;

class CachedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public CachedLinkedHashMap(int capacity) {
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() >= this.capacity;
    }
}