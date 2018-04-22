package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
@DiscriminatorValue(value = "Moto")
public class Moto extends Vehicle implements Serializable {
    private static final long serialVersionUID = 263886737484258062L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Moto)) return false;
        if (!super.equals(o)) return false;
        Moto moto = (Moto) o;
        return Objects.equals(frame, moto.frame);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), frame);
    }

    @Override
    public String toString() {
        return "Moto " + brand  + " " + type + " " + frame;
    }
}
