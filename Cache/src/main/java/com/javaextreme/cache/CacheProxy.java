package com.javaextreme.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CacheProxy implements InvocationHandler {
    private Object proxy;
    private Cache cache;

    public CacheProxy(Object object, Cache cache) {
        proxy = object;
        this.cache = cache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        Object result = cache.cacheGet(args[0]);
        if (result == null) {
            result = method.invoke(this.proxy, args[0]);
            cache.cachePut(args[0], result);
        }
        return result;
    }
}
