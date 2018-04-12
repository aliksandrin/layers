package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Moto")
public class Moto extends Vehicle {
    @Column(name = "frame_type")
    private String frame;

    public Moto() {
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }
}
