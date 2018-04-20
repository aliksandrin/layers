package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.repository.BrandDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class BrandDAOImpl extends BasicDAOImpl<Brand> implements BrandDAO{
    public BrandDAOImpl() {
        super(Brand.class);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Brand> findAll() {
        return (List<Brand>) entityManager.createNativeQuery("SELECT * from BRANDS", Brand.class).getResultList();
    }

    @Transactional
    @Override
    public List<Type> getTypes(Integer brandId) {
        Brand result = read(brandId);
        return result.getTypes();
    }

    @Override
    public Integer getBrandIdByName(String name) {
        return (Integer)entityManager.createNativeQuery("SELECT brand_id from BRANDS WHERE BRAND_TITLE="+name, Brand.class).getResultList().get(0);
    }
}
