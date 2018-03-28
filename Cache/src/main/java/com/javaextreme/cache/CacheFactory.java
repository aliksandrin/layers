package com.javaextreme.cache;

import com.javaextreme.cache.strategy.Cache;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CacheFactory {
    private Cache cache;

    public <T> T createCachedObject(T o) {
        Class cl = o.getClass();
        if (isAnnotationPresent(cl)) {
            return (T) Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), new CacheProxy(o, cache));
        }
        return o;
    }

    private boolean isAnnotationPresent(Class c) {
        Class cl = c;
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Cacheable.class)) {
                return true;
            }
        }
        Class parent = cl.getSuperclass();
        isAnnotationPresent(parent);
        return false;
    }

    public CacheFactory(Cache cache) {
        this.cache = cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public Cache getCache() {
        return cache;
    }
}
