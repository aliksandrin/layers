package com.javaextreme.carstore.converter;

import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.repository.TypeDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class TypeConverter implements Converter {
    @Autowired
    private TypeDAO typeDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Type type = typeDAO.getTypeByName(value);
        return type;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return null;
        return ((Type)value).toString();
    }
}
