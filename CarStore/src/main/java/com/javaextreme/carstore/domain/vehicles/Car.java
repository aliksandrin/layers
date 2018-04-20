package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class Car extends Vehicle implements Serializable {
    private static final long serialVersionUID = -530080000084258062L;

    @Column(name = "num_of_passengers")
    protected Byte noOfPassengers;

    public Car() {
    }

    public Byte getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(Byte noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(noOfPassengers, car.noOfPassengers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), noOfPassengers);
    }
}
