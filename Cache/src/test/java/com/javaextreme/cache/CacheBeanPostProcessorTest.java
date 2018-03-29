package com.javaextreme.cache;

import com.javaextreme.cache.strategy.impl.LRUCache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CacheBeanPostProcessorTest {
    @InjectMocks
    private CacheBeanPostProcessor cacheBeanPostProcessor;
    private CacheableInterfaceForTest mocked;
    @Mock
    LRUCache cacheMock;

    @Before
    public void setUp() throws Exception {
        mocked = new CacheableClassForTest();
        cacheBeanPostProcessor = new CacheBeanPostProcessor();
    }

    @Test
    public void postProcessBeforeInitializationFalseProxy() {
        Object objWithoutAnnotation = new Object();
        cacheBeanPostProcessor.postProcessBeforeInitialization(objWithoutAnnotation, "Mocked");
        Assert.assertEquals(false, objWithoutAnnotation.getClass().toString().contains("Proxy"));
    }

    @Test
    public void postProcessBeforeInitializationTrueProxy() throws Exception {
        CacheableInterfaceForTest cacheableInterfaceForTest
                = (CacheableInterfaceForTest) cacheBeanPostProcessor.postProcessBeforeInitialization(mocked, "Mocked");
        Assert.assertEquals(true, cacheableInterfaceForTest.getClass().toString().contains("Proxy"));
    }

    @Test
    public void postProcessAfterInitialization() {
        Assert.assertEquals(mocked, cacheBeanPostProcessor.postProcessAfterInitialization(mocked, "Mocked"));
    }
}