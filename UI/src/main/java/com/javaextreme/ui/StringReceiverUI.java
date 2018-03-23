package com.javaextreme.ui;

import com.javaextreme.service.StringValidatorService;

public interface StringReceiverUI {
    void receive(String[] args);
    void setStringValidatorService(StringValidatorService stringValidator);
}
