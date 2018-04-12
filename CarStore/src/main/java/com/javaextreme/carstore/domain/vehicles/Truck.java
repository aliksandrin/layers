package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Truck")
public class Truck extends Vehicle {
    @Column(name = "cargoCapacity")
    private Integer cargoCapacity;

    public Truck() {
    }

    public Integer getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(Integer cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}
