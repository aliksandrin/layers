package com.javaextreme.service.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CacheProxy implements InvocationHandler {
    private Object object;
    private Cache cache;

    public CacheProxy(Object object, Cache cache) {
        this.object = object;
        this.cache = cache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result = cache.cacheGet(args[0]);
        if (result == null) {
            try {
                result = method.invoke(proxy, args);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e) {
            } catch (InvocationTargetException e) {
            }
            cache.cachePut(result);
        }
        return result;
    }
}
