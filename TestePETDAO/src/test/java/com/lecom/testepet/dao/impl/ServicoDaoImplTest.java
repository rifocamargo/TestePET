/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.dao.impl;

import com.lecom.testepet.dao.AbstractDaoTest;
import com.lecom.testepet.dao.GenericDao;
import com.lecom.testepet.dao.ServicoDao;
import com.lecom.testepet.entity.Servico;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ricardo
 */
public class ServicoDaoImplTest extends AbstractDaoTest<Servico> {
    
    @Autowired
    private ServicoDao servicoDao;

    @Override
    public GenericDao<Servico> dao() {
        return servicoDao;
    }

    @Override
    public Object getKey() {
        return 1;
    }

    @Override
    public Object getModelToInsert() {
        return new Servico("Serviço to Insert", "Desc Serviço to Insert");
    }

    @Override
    public Object getModelToUpdate() {
        return new Servico(1, "Serviço to Update", "Desc Serviço to Update");
    }
    
}
