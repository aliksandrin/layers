package com.javaextreme.ui;

import com.javaextreme.dao.StringDAOImpl;
import com.javaextreme.service.StringValidatorServiceImpl;

public class MainApplication {

    public static void main(String[] args) {
        StringReceiverUIImpl stringReceiver = new StringReceiverUIImpl();
        StringValidatorServiceImpl stringValidator = new StringValidatorServiceImpl();
        stringValidator.setStringDAOImpl(new StringDAOImpl());
        stringReceiver.setStringValidator(stringValidator);

        stringReceiver.receive(args);
    }
}
