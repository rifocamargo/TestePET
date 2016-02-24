/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.dao.impl;

import com.lecom.testepet.dao.AbstractDaoTest;
import com.lecom.testepet.dao.GenericDao;
import com.lecom.testepet.dao.ServicoClienteDao;
import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.entity.PessoaFisica;
import com.lecom.testepet.entity.PessoaJuridica;
import com.lecom.testepet.entity.Servico;
import com.lecom.testepet.entity.ServicoCliente;
import com.lecom.testepet.entity.ServicoPessoaFisica;
import com.lecom.testepet.entity.ServicoPessoaJuridica;
import com.lecom.testepet.entity.pk.ServicoClientePK;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ricardo
 */
public class ServicoClienteDaoImplTest extends AbstractDaoTest<ServicoCliente> {
    
    @Autowired
    private ServicoClienteDao servicoClienteDao;

    @Override
    public GenericDao<ServicoCliente> dao() {
        return servicoClienteDao;
    }

    @Override
    public Object getKey() {
        final Cliente cliente = new PessoaFisica(1);
        final Servico servico = new Servico(1);
        return new ServicoClientePK(cliente, servico);
    }

    @Override
    public Object getModelToInsert() {
        final PessoaFisica cliente = new PessoaFisica(1);
        final Servico servico = new Servico(2);
        final ServicoClientePK servicoClientePK = new ServicoClientePK(cliente, servico);
        return new ServicoPessoaFisica(servicoClientePK, new Date(), new Date(), 1.1d);
    }

    @Override
    public Object getModelToUpdate() {
        final PessoaJuridica cliente = new PessoaJuridica(2);
        final Servico servico = new Servico(3);
        final ServicoClientePK servicoClientePK = new ServicoClientePK(cliente, servico);
        return new ServicoPessoaJuridica(servicoClientePK, new Date(), new Date(), 10d);
    }
    
}
