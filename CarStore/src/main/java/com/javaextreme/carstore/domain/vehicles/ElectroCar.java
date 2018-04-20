package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "model_id")
@DiscriminatorValue("ElectroCar")
public class ElectroCar extends Car implements Serializable {
    private static final long serialVersionUID = 120086737484258062L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectroCar)) return false;
        if (!super.equals(o)) return false;
        ElectroCar that = (ElectroCar) o;
        return Objects.equals(batteryPower, that.batteryPower);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), batteryPower);
    }

    @Override
    public String toString() {
        return "ElectroCar " +
                "batteryPower=" + batteryPower +
                ", noOfPassengers=" + noOfPassengers +
                ", brand=" + brand +
                ", type=" + type;
    }
}

