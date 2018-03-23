package com.javaextreme.cache;

import com.javaextreme.cache.strategy.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;

public class CacheProxy implements InvocationHandler {
    private static final Logger logger = LoggerFactory.getLogger(CacheProxy.class);

    private Object proxy;
    private Cache cache;

    public CacheProxy(Object object, Cache cache) {
        proxy = object;
        this.cache = cache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws ParseException {
        logger.info("Proxy invokes method {} with args {}", method, args);
        Object result = cache.cacheGet(args[0]);
        if (result == null) {
            try {
                result = method.invoke(this.proxy, args[0]);
                cache.cachePut(args[0], result);
            }
            catch (IllegalAccessException | InvocationTargetException e){
                throw new ParseException("", 1);
            }
        }
        else {
            logger.info("We have cached result {} for {}", result, args);
        }

        return result;
    }
}
