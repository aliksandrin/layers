package com.javaextreme.carstore.domain.vehicles;

import javax.persistence.CascadeType;
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
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BRANDS")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Integer id;

    @Size(min = 2, max = 150)
    @Column(name = "brand_title", length = 150)
    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BRANDS_TYPES", joinColumns = {
            @JoinColumn(name = "brand_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id")})
    private Set<Type> types;
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicle;

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

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
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
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return Objects.equals(getId(), brand.getId()) &&
                Objects.equals(getTitle(), brand.getTitle());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTitle());
    }
}
