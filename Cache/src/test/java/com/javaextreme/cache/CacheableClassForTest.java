package com.javaextreme.cache;

public class CacheableClassForTest  implements CacheableInterfaceForTest {
    @Cacheable
    public int doSometh(String string){
        return string.length();
    }
}
