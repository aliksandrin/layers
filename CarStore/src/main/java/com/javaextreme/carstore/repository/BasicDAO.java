package com.javaextreme.carstore.repository;

import java.util.List;

public interface BasicDAO<T> {
    void create(T object);

    T update(T object);

    T read(Integer objectId);

    @SuppressWarnings("unchecked")
    List<T> findAll();

    void delete(T object);
}
