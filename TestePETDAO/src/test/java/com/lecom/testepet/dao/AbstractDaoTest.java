/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.dao;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rcamargo
 * @param <T> The generic type
 */
@Service
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@Transactional
public abstract class AbstractDaoTest<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDaoTest.class);
    
    private static final String MESSAGE_LOGGER = "Entity : {}";

    @Autowired
    protected EntityManager entityManager;

    public abstract GenericDao<T> dao();

    public abstract Object getKey();

    public abstract Object getModelToInsert();

    public abstract Object getModelToUpdate();

    /**
     * Find All Test
     */
    @Test
    @Rollback(true)
    public void findAll() {
        final List<T> list = this.dao().findAll();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    @Rollback(true)
    public void save() {
        final T entity = (T) this.getModelToInsert();
        this.dao().save(entity);

        LOGGER.info(MESSAGE_LOGGER, entity);

        entityManager.flush();
        entityManager.detach(entity);

        final Object id = this.getEntityId(entity);
        final T entitySaved = dao().find(id);

        Assert.assertTrue(entitySaved.equals(entity));
    }

    @Test
    @Rollback(true)
    public void find() {
        final Object key = this.getKey();
        final T entity = this.dao().find(key);

        LOGGER.info(MESSAGE_LOGGER, entity);

        Assert.assertNotNull(entity);
    }

    @Test
    @Rollback(true)
    public void update() {
        T entity = (T) getModelToUpdate();
        final Object key = this.getEntityId(entity);

        final T entityFind = this.dao().find(key);

        Assert.assertNotNull(entityFind);

        entity = this.dao().update(entity);

        LOGGER.info(MESSAGE_LOGGER, entity);

        Assert.assertNotNull(entity);
    }

    @Test
    @Rollback(true)
    public void delete() {
        final Object key = this.getKey();

        T entity = this.dao().find(key);

        Assert.assertNotNull(entity);

        this.dao().delete(key);

        LOGGER.info(MESSAGE_LOGGER, entity);

        entity = this.dao().find(key);

        Assert.assertNull(entity);
    }

    @Test
    @Rollback(true)
    public void countAll() {
        final long count = this.dao().countAll(new HashMap<String, Object>());
        Assert.assertTrue(0 < count);
    }

    private Object getEntityId(final T entity) {
        return entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
    }
}
