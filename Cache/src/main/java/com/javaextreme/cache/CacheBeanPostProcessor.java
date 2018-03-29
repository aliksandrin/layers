package com.javaextreme.cache;

import com.javaextreme.cache.strategy.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.io.InputStream;
import java.lang.reflect.*;
import java.text.ParseException;
import java.util.Properties;


public class CacheBeanPostProcessor implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(CacheBeanPostProcessor.class);
    private Cache cache;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        setupCacheProperties();

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
            });
        }
        return bean;
    }

    private void setupCacheProperties() {
        Properties property = new Properties();
        try (InputStream fis = this.getClass().getClassLoader().getResourceAsStream("cache.properties")) {
            property.load(fis);

            String strategy = property.getProperty("strategy");
            int capacity = Integer.parseInt(property.getProperty("capacity"));
            Class<?> cla = Class.forName("com.javaextreme.cache.strategy.impl."+ strategy);
            Constructor<?> constructor = cla.getConstructor(int.class);
            cache = (Cache) constructor.newInstance(new Object[]{capacity});
        }
        catch (Exception e){
            logger.error("Please check your cache properties file");
        }
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
        isAnnotationPresent(parent);
        return false;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
