package com.javaextreme.ui;

import com.javaextreme.dao.StringDAOImpl;
import com.javaextreme.service.StringValidatorServiceImpl;

public class MainApplication {

    public static void main(String[] args) {
        StringReceiverUIImpl stringReceiver = new StringReceiverUIImpl();
        StringValidatorServiceImpl stringValidator = new StringValidatorServiceImpl();
        stringValidator.setStringDAO(new StringDAOImpl());
        stringReceiver.setStringValidatorService(stringValidator);

        //e.g. for creating cached object
//        stringValidator.setStringDAO(new StringDAOImpl());
//        CacheToLRU cacheToLRU = new CacheToLRU();
//        StringValidatorService stVProxy = (StringValidatorService) cacheToLRU.cacheEnable(stringValidator);
//        stringReceiver.setStringValidatorService(stVProxy);
        stringReceiver.receive(args);
    }
}
