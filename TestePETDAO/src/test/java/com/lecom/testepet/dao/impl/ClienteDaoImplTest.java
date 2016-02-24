/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.dao.impl;

import com.lecom.testepet.dao.AbstractDaoTest;
import com.lecom.testepet.dao.GenericDao;
import com.lecom.testepet.dao.ClienteDao;
import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.entity.Perfil;
import com.lecom.testepet.entity.PessoaFisica;
import com.lecom.testepet.entity.PessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ricardo
 */
public class ClienteDaoImplTest extends AbstractDaoTest<Cliente> {
    
    @Autowired
    private ClienteDao clienteDao;

    @Override
    public GenericDao<Cliente> dao() {
        return clienteDao;
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
        return new PessoaJuridica(2, "Teste Cliente Update", new Perfil(2), "987.654.321/4432-21");
    }
    
}
