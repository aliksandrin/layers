package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "model_id")
public class ElectroCar extends Car {
    @Column(name = "battery_power")
    private Integer batteryPower;

    public ElectroCar() {
        super();
    }

    public Integer getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Integer batteryPower) {
        this.batteryPower = batteryPower;
    }
}

