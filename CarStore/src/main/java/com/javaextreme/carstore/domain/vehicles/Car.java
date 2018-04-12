package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PassengerCar")
public class Car extends Vehicle {
    @Column(name = "num_of_passengers")
    private Byte noOfPassengers;

    public Car() {
    }

    public Byte getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(Byte noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }


}
