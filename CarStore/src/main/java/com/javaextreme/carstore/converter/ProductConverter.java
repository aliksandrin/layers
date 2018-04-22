package com.javaextreme.carstore.converter;

import com.javaextreme.carstore.domain.vehicles.Product;
import com.javaextreme.carstore.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.List;

public class ProductConverter implements Converter {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Product> products = productDAO.findAll();
        for (Product v : products){
            if (v.toString().equals(value)) return v;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
