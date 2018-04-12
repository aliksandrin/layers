package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "model_id")
public class FuelCar extends Car {
    @Column(name = "engine_volume")
    private Integer engineVolume;

    public FuelCar() {
    }

    public Integer getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Integer engineVolume) {
        this.engineVolume = engineVolume;
    }
}
