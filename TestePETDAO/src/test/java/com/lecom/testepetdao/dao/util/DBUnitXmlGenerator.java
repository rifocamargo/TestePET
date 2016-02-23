/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.dao.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Table;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 */
public class DBUnitXmlGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUnitXmlGenerator.class);

    public static void main(String[] args) throws ClassNotFoundException, SQLException, DataSetException, FileNotFoundException, IOException, DatabaseUnitException {
        Class.forName("com.mysql.jdbc.Driver");
        final Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste_pet?zeroDateTimeBehavior=convertToNull", "user_pet", "admin");
        final IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
        final DatabaseConfig dbConfig = connection.getConfig();
        dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new DefaultDataTypeFactory());

        final List<ClassLoader> classLoadersList = new LinkedList<>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());
        final Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("com.lecom.testepetdao.entity"))));

        final Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
        int countTables = 0;
        for (final Class<? extends Object> classe : classes) {
            if (classe.isAnnotationPresent(Table.class)) {
                final Table tabela = classe.getAnnotation(Table.class);
                final File xml = new File("src/test/resources/dbunit/" + tabela.name() + ".xml");
                if (!xml.exists()) {
                    LOGGER.info("Tabela: {}", tabela.name());
                    final QueryDataSet partialDataSet = new QueryDataSet(connection);
                    // Mention all the tables here for which you want data to be extracted
                    // take note of the order to prevent FK constraint violation when re-inserting
                    partialDataSet.addTable(tabela.name());
                    
                    // XML file into which data needs to be extracted
                    FlatXmlDataSet.write(partialDataSet, new FileWriter("src/test/resources/dbunit/" + tabela.name() + ".xml"));
                    countTables++;
                    LOGGER.info("Tabela {} criada", tabela.name());
                }
            }
        }
        LOGGER.info("{} tabelas criadas criadas.", countTables);
    }
}
