/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.lecom.testepet.dao.AbstractDaoTest;
import com.lecom.testepet.dao.GenericDao;
import com.lecom.testepet.dao.PessoaJuridicaDao;
import com.lecom.testepet.entity.Perfil;
import com.lecom.testepet.entity.PessoaJuridica;

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
        return new PessoaJuridica("Teste Cliente Insert", new Perfil(1), "123.456.789/1234-12");
    }

    @Override
    public Object getModelToUpdate() {
        return new PessoaJuridica(2, "Teste Cliente Update", new Perfil(2), "987.654.321/4432-21");
    }
    
}
