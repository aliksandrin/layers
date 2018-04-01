package com.javaextreme.cache.strategy.impl;

import com.javaextreme.cache.strategy.Cache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
    private Cache cache;
    private String day = "monday";
    private String dateString = "12.03.2018";

    @Before
    public void in() {
        cache = new LRUCache(4);
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
    public void cachePutMoreArgs() {
        //int hash = Arrays.deepHashCode();
        cache.cachePut(new Object[]{"some", "string"}, day);
        Assert.assertEquals(day, cache.cachePut(new Object[]{"some", "string"}, day));
        Assert.assertEquals(day, cache.cacheGet(new Object[]{"some", "string"}));
    }

    @Test
    public void cachePutNull() {
        Assert.assertEquals(null, cache.cachePut(null, null));
    }

    @Test
    public void cacheOverCapacity() {
        cache.cachePut(0, 0);
        cache.cachePut(1, 1);
        cache.cachePut(2, 2);
        Assert.assertEquals(0, cache.cacheGet(0));
        cache.cachePut(3, 3);
        Assert.assertEquals(null, cache.cacheGet(0));
    }
}