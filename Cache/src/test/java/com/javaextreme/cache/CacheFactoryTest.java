package com.javaextreme.cache;

import com.javaextreme.cache.strategy.Cache;
import com.javaextreme.cache.strategy.impl.LRUCache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class CacheFactoryTest {
    private CacheFactory cacheFactory;
    private Cache cache;
    private CacheableInterfaceForTest cacheableClassForTest;

    @Before
    public void setUp() {
        cache = mock(LRUCache.class);
        cacheFactory = new CacheFactory(cache);
        cacheableClassForTest = new CacheableClassForTest();
    }

    @Test
    public void createCachedObject() {
        CacheableInterfaceForTest test = cacheFactory.createCachedObject(cacheableClassForTest);
        Assert.assertEquals(true, test.getClass().toString().contains("Proxy"));
    }
}