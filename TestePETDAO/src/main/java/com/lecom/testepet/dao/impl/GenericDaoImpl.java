/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.dao.impl;

import com.lecom.testepet.dao.GenericDao;
import com.lecom.testepet.util.DaoUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> type;

    public GenericDaoImpl() {
        final Type t = getClass().getGenericSuperclass();
        final ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public long countAll(final Map<String, Object> params) {

        final StringBuilder queryString = new StringBuilder("SELECT count(o) from ");

        queryString.append(type.getSimpleName()).append(" o ");
        queryString.append(this.getQueryClauses(params));

        final Query query = this.entityManager.createQuery(queryString.toString());
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return (Long) query.getSingleResult();
    }

    @Override
    public T save(final T t) {
        this.entityManager.persist(t);
        return t;
    }

    @Override
    public void delete(final Object id) {
        this.entityManager.remove(this.entityManager.getReference(type, id));
    }

    @Override
    public T find(final Object id) {
        return (T) this.entityManager.find(type, id);
    }

    @Override
    public T update(final T t) {
        return this.entityManager.merge(t);
    }

    @Override
    public List<T> findAll() {
         final StringBuilder queryString = new StringBuilder("SELECT o from ");

        queryString.append(type.getSimpleName()).append(" o ");

        final Query query = this.entityManager.createQuery(queryString.toString());
        
        return query.getResultList();
    }

    private String getQueryClauses(final Map<String, Object> params) {
        final StringBuilder queryClauses = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            queryClauses.append(DaoUtils.returnWhereOrAnd(queryClauses.toString()));
            queryClauses.append(entry.getKey()).append(" = :").append(entry.getKey());
        }
        return queryClauses.toString();
    }
}
