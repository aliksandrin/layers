package com.javaextreme.cache;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CacheFactory {
    private Cache cache;

    public Object createCachedObject(Object o){
        Class cl = o.getClass();
        Method[] methos = cl.getDeclaredMethods();
        for ( Method method : methos){
            if (method.isAnnotationPresent(Cacheable.class)){
                return Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), new CacheProxy(o, cache));
            }
        }
        return o;
    }

    public CacheFactory(Cache cache) {
        this.cache = cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }
}
