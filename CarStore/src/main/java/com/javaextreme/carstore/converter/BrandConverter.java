package com.javaextreme.carstore.converter;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.repository.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class BrandConverter implements Converter {
    @Autowired
    private BrandDAO brandDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Brand brand = brandDAO.getBrandByName(value);
        return brand;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return null;

        Brand brand = (Brand) value;
        return brand.toString();
    }
}
