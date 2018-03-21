package com.javaextreme.service.cache;

public interface Cache<K, V> {
    Object cacheGet(K obj);
    void cachePut(K obj, V o);
}
