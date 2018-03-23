package com.javaextreme.cache;

import com.javaextreme.cache.strategy.Cache;
import com.javaextreme.cache.strategy.impl.LRUCache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CacheProxyTest {
    private CacheFactory cacheFactory;
    private Cache cache;
    private CacheableInterfaceForTest cacheableClassForTest;

    @Before
    public void setUp() {
        cache = mock(LRUCache.class);
        cacheFactory = new CacheFactory(cache);
        cacheableClassForTest = cacheFactory.createCachedObject(new CacheableClassForTest());
    }

    @Test
    public void invokePut() {
        when(cache.cacheGet("String")).thenReturn(6);
        Assert.assertEquals(6, cacheableClassForTest.doSometh("String"));
        verify(cache).cacheGet("String");
        verify(cache, never()).cachePut("String", 6);
    }

    @Test
    public void invokeGet() {
        when(cache.cacheGet("String")).thenReturn(null);
        Assert.assertEquals(6, cacheableClassForTest.doSometh("String"));
        verify(cache).cacheGet("String");
        verify(cache).cachePut("String", 6);
    }
}