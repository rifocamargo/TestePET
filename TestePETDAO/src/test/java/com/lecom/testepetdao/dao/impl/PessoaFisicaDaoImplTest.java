/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.lecom.testepetdao.dao.AbstractDaoTest;
import com.lecom.testepetdao.dao.GenericDao;
import com.lecom.testepetdao.dao.PessoaFisicaDao;
import com.lecom.testepetdao.entity.Perfil;
import com.lecom.testepetdao.entity.PessoaFisica;

/**
 *
 * @author Ricardo
 */
public class PessoaFisicaDaoImplTest extends AbstractDaoTest<PessoaFisica> {
    
    @Autowired
    private PessoaFisicaDao pessoaFisicaDao;

    @Override
    public GenericDao<PessoaFisica> dao() {
        return pessoaFisicaDao;
    }

    @Override
    public Object getKey() {
        return 1;
    }

    @Override
    public Object getModelToInsert() {
        return new PessoaFisica("Teste Cliente Insert", new Perfil(1), "123.456.789-98");
    }

    @Override
    public Object getModelToUpdate() {
        return new PessoaFisica(1, "Teste Cliente Update", new Perfil(2), "987.654.321-00");
    }
    
}
