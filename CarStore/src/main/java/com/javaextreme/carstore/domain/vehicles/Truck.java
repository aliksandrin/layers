package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@DiscriminatorValue(value = "Truck")
public class Truck extends Vehicle implements Serializable {
    private static final long serialVersionUID = -530012337484258062L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return Objects.equals(cargoCapacity, truck.cargoCapacity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), cargoCapacity);
    }

    @Override
    public String toString() {
        return "Truck" +
                "cargoCapacity=" + cargoCapacity +
                ", brand=" + brand +
                ", type=" + type;
    }
}
