package com.javaextreme.cache;

import com.javaextreme.cache.strategy.impl.LRUCache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CacheBeanPostProcessorTest {
    @InjectMocks
    private CacheBeanPostProcessor cacheBeanPostProcessor = new CacheBeanPostProcessor();
    private CacheableInterfaceForTest testClass;
    @Mock
    private LRUCache cacheMock = new LRUCache(10);

    @Before
    public void setUp() {
        testClass = new CacheableClassForTest();
    }

    @Test
    public void postProcessBeforeInitializationFalseProxy() {
        Object objWithoutAnnotation = new Object();
        cacheBeanPostProcessor.postProcessBeforeInitialization(objWithoutAnnotation, "Mocked");
        Assert.assertEquals(false, objWithoutAnnotation.getClass().toString().contains("Proxy"));
    }

    @Test
    public void postProcessBeforeInitializationTrueProxy() {
        CacheableInterfaceForTest cacheableInterfaceForTest
                = (CacheableInterfaceForTest) cacheBeanPostProcessor.postProcessBeforeInitialization(testClass, "Mocked");
        Assert.assertEquals(true, cacheableInterfaceForTest.getClass().toString().contains("Proxy"));
    }

    @Test
    public void cachePutInvocated() {
        CacheableInterfaceForTest cacheableInterfaceForTest
                = (CacheableInterfaceForTest) cacheBeanPostProcessor.postProcessBeforeInitialization(testClass, "Mocked");
        cacheableInterfaceForTest.doSometh("some");
        verify(cacheMock).cachePut(new String[]{"some"}, 4);
    }

    @Test
    public void cacheGetInvocated() {
        CacheableInterfaceForTest cacheableInterfaceForTest
                = (CacheableInterfaceForTest) cacheBeanPostProcessor.postProcessBeforeInitialization(testClass, "Mocked");
        when(cacheMock.cacheGet(new String[]{"some"})).thenReturn(4);
        cacheableInterfaceForTest.doSometh("some");
        verify(cacheMock).cacheGet(new String[]{"some"});
        verify(cacheMock, never()).cachePut(new String[]{"some"}, 4);
    }


    @Test
    public void postProcessAfterInitialization() {
        Assert.assertEquals(testClass, cacheBeanPostProcessor.postProcessAfterInitialization(testClass, "Mocked"));
    }


    /*
    Test classes below
     */

    public interface CacheableInterfaceForTest {
        @Cacheable
        int doSometh(String string);
    }

    public class CacheableClassForTest  implements CacheableInterfaceForTest {
        public int doSometh(String string){
            return string.length();
        }
    }
}