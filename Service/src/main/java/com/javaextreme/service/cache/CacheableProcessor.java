package com.javaextreme.service.cache;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;


@SupportedAnnotationTypes("com.javaextreme.service.cache.Cacheable")
public class CacheableProcessor extends AbstractProcessor {
    private static final Logger logger = LoggerFactory.getLogger(CacheableProcessor.class);

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Cacheable.class)) {
            Cacheable annotation = element.getAnnotation(Cacheable.class);

            String msg="Element ee :"+element.getSimpleName().toString();
            processingEnv.getMessager().printMessage( javax.tools.Diagnostic.Kind.ERROR, msg, element);

//            Class cacheClass = annotation.strategy();
//            try {
//
//                Set<? extends ExecutableElement> set =  ElementFilter.methodsIn(roundEnv.getElementsAnnotatedWith(Cacheable.class));
//                for (ExecutableElement method : set){
//                    Cache cache = (Cache) cacheClass.newInstance();
////                    cache.cachePut(method.invoke(clazz, args[0]));
//                    logger.info("Simple Name for annotation element {}", method);
//                }
//
//            }
//            catch (InstantiationException e){
//
//            }
//            catch (IllegalAccessException e){
//
//            }


        }
        return true;
    }

//    public void parse(Class clazz) throws Exception {
//        Method[] methods = clazz.getMethods();
//
//
//        for (Method method : methods) {
//            if (method.isAnnotationPresent(Cacheable.class)) {
//                Cacheable annotation = method.getAnnotation(Cacheable.class);
//                Class cacheClass = annotation.strategy();
//                Cache cache = (Cache) cacheClass.newInstance();
//                Object[] args = method.getParameters();
//                cache.cachePut(method.invoke(clazz, args[0]));
//            }
//        }
//    }
}
