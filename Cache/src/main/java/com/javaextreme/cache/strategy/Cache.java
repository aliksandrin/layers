package com.javaextreme.cache.strategy;

public interface Cache {
    Object cacheGet(Object obj);
    Object cachePut(Object obj, Object o);
}
