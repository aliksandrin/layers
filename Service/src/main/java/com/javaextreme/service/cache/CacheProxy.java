package com.javaextreme.service.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CacheProxy<T> implements InvocationHandler {
    private T proxy;
    private Cache cache;

    public CacheProxy(T object, Cache cache) {
        proxy = object;
        this.cache = cache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result = cache.cacheGet(args[0]);
        if (result == null) {
            try {
                result = method.invoke(this.proxy, args[0]);
                cache.cachePut(args[0], result);
                return result;
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e) {
            } catch (InvocationTargetException e) {

            }
        }
        return result;
    }

    public <T> T getProxy(T t, Class<? super T> interfaceType, Cache cache) {
        CacheProxy handler = new CacheProxy(proxy, cache);
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class<?>[]{interfaceType}, handler);
    }
}
