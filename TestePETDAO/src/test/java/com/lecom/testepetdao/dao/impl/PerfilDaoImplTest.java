/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.dao.impl;

import com.lecom.testepetdao.dao.AbstractDaoTest;
import com.lecom.testepetdao.dao.GenericDao;
import com.lecom.testepetdao.dao.PerfilDao;
import com.lecom.testepetdao.entity.Perfil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ricardo
 */
public class PerfilDaoImplTest extends AbstractDaoTest<Perfil> {
    
    @Autowired
    private PerfilDao pessoaFisicaDao;

    @Override
    public GenericDao<Perfil> dao() {
        return pessoaFisicaDao;
    }

    @Override
    public Object getKey() {
        return 1;
    }

    @Override
    public Object getModelToInsert() {
        return new Perfil("Perfil to Insert", "Desc Perfil to Insert", 10.5d);
    }

    @Override
    public Object getModelToUpdate() {
        return new Perfil(2, "Perfil to Update", "Desc Perfil to Update", 10.45d);
    }
    
}
