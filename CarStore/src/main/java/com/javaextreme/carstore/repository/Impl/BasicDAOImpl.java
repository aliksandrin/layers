package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.repository.BasicDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class BasicDAOImpl<T> implements BasicDAO<T> {
    @PersistenceContext
    EntityManager entityManager;

    private Class<T> type;

    public BasicDAOImpl(Class<T> type) {
        this.type = type;
    }

    @Transactional
    @Override
    public void create(T object) {
        entityManager.persist(object);
    }

    @Transactional
    @Override
    public T update(T object) {
        return entityManager.merge(object);
    }

    @Transactional
    @Override
    public T read(Integer objectId) {
        return entityManager.find(type, objectId);
    }

    @Transactional
    @Override
    public abstract List<T> findAll();

    @Transactional
    @Override
    public void delete(T object) {
        entityManager.remove(object);
    }
}
