package com.javaextreme.cache;

import com.javaextreme.cache.strategy.LRUCache;

import java.lang.reflect.Proxy;

public class CacheToLRU {
    public Object cacheEnable(Object o){
        Class cl = o.getClass();
        return Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), new CacheProxy(o, new LRUCache(200)));
    }
}
