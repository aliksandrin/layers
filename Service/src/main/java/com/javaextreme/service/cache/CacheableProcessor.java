package com.javaextreme.service.cache;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;


@SupportedAnnotationTypes("com.javaextreme.service.cache.Cacheable")
public class CacheableProcessor extends AbstractProcessor {
    private static final Logger logger = LoggerFactory.getLogger(CacheableProcessor.class);

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        logger.info("Annotation invoked");
        for (Element element : roundEnv.getElementsAnnotatedWith(Cacheable.class)) {
            Cacheable annotation = element.getAnnotation(Cacheable.class);
            Class cl = annotation.targetClass();
            try {
                Method method = cl.getDeclaredMethod(annotation.invocatedMethod());
                Class cacheClass = annotation.strategy();
                Cache cache = (Cache) cacheClass.newInstance();
                Object[] args = method.getParameters();

                if (cache.cacheGet(args) == null)
                cache.cachePut(method.invoke(cl, args), args);

            } catch (NoSuchMethodException |InvocationTargetException | IllegalAccessException |InstantiationException e) {
            }

        }
        return true;
    }
}
