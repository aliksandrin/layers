package com.javaextreme.ui;

import com.javaextreme.service.Service;

public interface UI {
    void showDayOfWeek(String date);
    void setService(Service service);
    Service getService();
}
