package com.javaextreme.cache.strategy;

public interface Cache<K, V> {
    V cacheGet(K obj);
    V cachePut(K obj, V o);
    void reset();
}
