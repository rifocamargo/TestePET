/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lecom.testepetdao.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author rcamargo
 */
public interface GenericDao<T> {
    long countAll(final Map<String, Object> params);
    
    List<T> findAll();

    T save(final T t);

    void delete(final Object id);

    T find(final Object id);

    T update(final T t); 
}
