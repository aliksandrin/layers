package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "model_id")
@DiscriminatorValue("FuelCar")
public class FuelCar extends Car implements Serializable {
    private static final long serialVersionUID = -530086737484258342L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FuelCar)) return false;
        if (!super.equals(o)) return false;
        FuelCar fuelCar = (FuelCar) o;
        return Objects.equals(engineVolume, fuelCar.engineVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineVolume);
    }

    @Override
    public String toString() {
        return "FuelCar "+ brand + " " + type + " number of passengers " + super.getNoOfPassengers() +
                " engineVolume " + engineVolume;
    }
}
