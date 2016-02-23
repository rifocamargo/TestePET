/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.dao.impl;

import com.lecom.testepetdao.dao.AbstractDaoTest;
import com.lecom.testepetdao.dao.GenericDao;
import com.lecom.testepetdao.dao.PessoaJuridicaDao;
import com.lecom.testepetdao.entity.Perfil;
import com.lecom.testepetdao.entity.PessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ricardo
 */
public class PessoaJuridicaDaoImplTest extends AbstractDaoTest<PessoaJuridica> {
    
    @Autowired
    private PessoaJuridicaDao pessoaJuridicaDao;

    @Override
    public GenericDao<PessoaJuridica> dao() {
        return pessoaJuridicaDao;
    }

    @Override
    public Object getKey() {
        return 2;
    }

    @Override
    public Object getModelToInsert() {
        return new PessoaJuridica("Teste Cliente Insert", new Perfil(1));
    }

    @Override
    public Object getModelToUpdate() {
        return new PessoaJuridica(2, "Teste Cliente Update", new Perfil(2));
    }
    
}
