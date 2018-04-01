package com.javaextreme.cache;

import com.javaextreme.cache.strategy.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.ParseException;


public class CacheBeanPostProcessor implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(CacheBeanPostProcessor.class);
    private Cache cache;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class cl = bean.getClass();
        if (isAnnotationPresent(cl)) {
            return Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    logger.info("Proxy invokes method {} with args {}", method, args);
                    Object result = cache.cacheGet(args);
                    if (result == null) {
                        try {

                            result = method.invoke(bean, args);
                            cache.cachePut(args, result);
                        } catch (IllegalAccessException e) {
                            logger.error("There is an error {} in proxy when {} invoked", e, method);
                        } catch (InvocationTargetException e){
                            throw new ParseException("", 1);
                        }
                    } else {
                        logger.info("We have cached result {} for {}", result, args);
                    }

                    return result;
                }
            });
        }
        return bean;
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
        if (parent != null)
            if (isAnnotationPresent(parent))
                return true;
        Class[] interfaces = cl.getInterfaces();
        if (interfaces.length != 0) {
            for (Class interfac : interfaces) {
                if (isAnnotationPresent(interfac))
                    return true;
            }
        }
        return false;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }
}
