package com.javaextreme.ui;

import com.javaextreme.cache.CacheFactory;
import com.javaextreme.cache.strategy.impl.LRUCache;
import com.javaextreme.dao.StringDAO;
import com.javaextreme.dao.StringDAOImpl;
import com.javaextreme.service.StringValidatorService;
import com.javaextreme.service.StringValidatorServiceImpl;

public class MainApplication {

    public static void main(String[] args) {
        CacheFactory cacheFactory = new CacheFactory(new LRUCache(200));
        // возможно потом можно будет отойти от такого объявления к какой нибудь AbstractFactory
        StringReceiverUI stringReceiver =
                cacheFactory.createCachedObject(new StringReceiverUIImpl());
        StringValidatorService stringValidator =
                cacheFactory.createCachedObject(new StringValidatorServiceImpl());
        StringDAO stringDAO =
                cacheFactory.createCachedObject(new StringDAOImpl());

        stringValidator.setStringDAO(stringDAO);
        stringReceiver.setStringValidatorService(stringValidator);

        stringReceiver.receive(args);
    }
}
