package com.javaextreme.carstore.converter;

import com.javaextreme.carstore.domain.vehicles.Vehicle;
import com.javaextreme.carstore.repository.VehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;

public class VehicleConverter implements Converter {
    @Autowired
    private VehicleDAO vehicledao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Vehicle> vehicles = vehicledao.findAll();

        for (Vehicle v : vehicles){
            if (v.toString().equals(value)) return v;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Vehicle vehicle = (Vehicle) value;
        return vehicle.toString();
    }
}

