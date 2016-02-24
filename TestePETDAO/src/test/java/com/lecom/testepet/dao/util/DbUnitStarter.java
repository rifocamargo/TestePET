/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.dao.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.orm.jpa.JpaTransactionManager;

/**
 *
 * @author rcamargo
 */
public class DbUnitStarter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbUnitStarter.class);

    private List<Resource> dataSetLocations;

    private DataSource dataSource;

    @Autowired
    JpaTransactionManager transactionManager;

    private IDataSet getDataSet() throws DataSetException, IOException {
        final List<IDataSet> dbUnitDataSets = new ArrayList<IDataSet>(dataSetLocations.size());
        final FlatXmlDataSetBuilder flatBuilder = new FlatXmlDataSetBuilder();
        flatBuilder.setColumnSensing(true);
        for (Resource dataSetLocation : dataSetLocations) {
            LOGGER.info("Mapping table {}", dataSetLocation.getFilename());
            final ReplacementDataSet dataSet = new ReplacementDataSet(flatBuilder.build(dataSetLocation.getInputStream()));
            dataSet.addReplacementObject("[null]", null);
            dbUnitDataSets.add(dataSet);
        }
        final CompositeDataSet dataSet = new CompositeDataSet(dbUnitDataSets.toArray(new IDataSet[dbUnitDataSets.size()]));

        return dataSet;
    }

    @PostConstruct
    public void createDatabase() throws SQLException, DataSetException, IOException {
        transactionManager.getEntityManagerFactory().createEntityManager();
        final IDatabaseTester databaseTester = new DataSourceDatabaseTester(dataSource);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(this.getDataSet());
        try {
            databaseTester.onSetup();
        } catch (Exception ex) {
            LOGGER.error("Error", ex);
        }
    }

    /**
     * Return the dataSetLocations
     *
     * @return dataSetLocations
     */
    public List<Resource> getDataSetLocations() {
        return dataSetLocations;
    }

    /**
     * Set the dataSetLocations
     *
     * @param dataSetLocations
     */
    public void setDataSetLocations(final List<Resource> dataSetLocations) {
        this.dataSetLocations = dataSetLocations;
    }

    /**
     * Return the dataSource
     *
     * @return dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Set the dataSource
     *
     * @param dataSource
     */
    public void setDataSource(final DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
