package com.javaextreme.service.cache;

public interface Cache {
    Object cacheGet(Object obj);
    void cachePut(Object obj);
}
