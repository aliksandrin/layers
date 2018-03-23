package com.javaextreme.cache;

import java.lang.annotation.Annotation;

public class CacheableAnnotation implements Cacheable{

    @Override
    public Class<? extends Cache> strategy() {
        return null;
    }

    @Override
    public Class targetClass() {
        return null;
    }

    @Override
    public String invocatedMethod() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
