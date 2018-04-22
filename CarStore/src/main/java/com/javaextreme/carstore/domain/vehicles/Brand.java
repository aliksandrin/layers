package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BRANDS")
public class Brand implements Serializable{
    private static final long serialVersionUID = -530086737484258062L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Integer id;

    @Size(min = 2, max = 150)
    @Column(name = "brand_title", length = 150, unique = true)
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BRANDS_TYPES", joinColumns = {
            @JoinColumn(name = "brand_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id")})
    private List<Type> types;
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Vehicle> vehicle;

    public Brand() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return Objects.equals(title, brand.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }

}
