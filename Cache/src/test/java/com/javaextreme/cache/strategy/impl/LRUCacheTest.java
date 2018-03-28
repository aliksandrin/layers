package com.javaextreme.cache.strategy.impl;

import com.javaextreme.cache.strategy.Cache;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
    private Cache cache;
    private String day = "monday";
    private String dateString = "12.03.2018";

    @Before
    public void in() {
        cache = new LRUCache(3);
    }

    @Test
    public void cacheGet() {
        cache.cachePut(dateString, day);

        Assert.assertEquals(day, cache.cacheGet(dateString));
    }

    @Test
    public void cachePut() {
        Assert.assertEquals(null, cache.cachePut(dateString, day));
    }

    @Test
    public void cachePutExisting() {
        cache.cachePut(dateString, day);
        Assert.assertEquals(day, cache.cachePut(dateString, day));
    }

    @Test
    public void cachePutNull() {
        Assert.assertEquals(null, cache.cachePut(null, null));
    }

    @After
    public void after() {
        cache.reset();
    }
}