package com.javaextreme.ui;

import com.javaextreme.cache.CacheFactory;
import com.javaextreme.cache.strategy.LRUCache;
import com.javaextreme.dao.StringDAO;
import com.javaextreme.dao.StringDAOImpl;
import com.javaextreme.service.StringValidatorService;
import com.javaextreme.service.StringValidatorServiceImpl;

public class MainApplication {

    public static void main(String[] args) {
        CacheFactory cacheFactory = new CacheFactory(new LRUCache(200));
        StringReceiverUI stringReceiver =
                (StringReceiverUI) cacheFactory.createCachedObject(new StringReceiverUIImpl());
        StringValidatorService stringValidator =
                (StringValidatorService) cacheFactory.createCachedObject(new StringValidatorServiceImpl());
        StringDAO stringDAO =
                (StringDAO) cacheFactory.createCachedObject(new StringDAOImpl());

        stringValidator.setStringDAO(stringDAO);
        stringReceiver.setStringValidatorService(stringValidator);

        stringReceiver.receive(args);
    }
}
