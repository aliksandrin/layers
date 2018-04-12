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
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TYPES")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer id;

    @NotNull
    @Column(name = "type_title", length = 50)
    private String title;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BRANDS_TYPES", joinColumns = {
            @JoinColumn(name = "type_id")},
            inverseJoinColumns = {@JoinColumn(name = "brand_id")})
    private Set<Brand> brands;
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicle;

    public Type() {
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

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    public Set<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type)) return false;
        Type type = (Type) o;
        return Objects.equals(getId(), type.getId()) &&
                Objects.equals(getTitle(), type.getTitle());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTitle());
    }
}
