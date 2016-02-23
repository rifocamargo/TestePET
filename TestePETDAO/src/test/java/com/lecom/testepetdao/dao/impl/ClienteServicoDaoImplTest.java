/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.dao.impl;

import com.lecom.testepetdao.dao.AbstractDaoTest;
import com.lecom.testepetdao.dao.GenericDao;
import com.lecom.testepetdao.dao.ClienteServicoDao;
import com.lecom.testepetdao.entity.ClienteServico;
import com.lecom.testepetdao.entity.PessoaFisica;
import com.lecom.testepetdao.entity.PessoaJuridica;
import com.lecom.testepetdao.entity.Servico;
import com.lecom.testepetdao.entity.pk.ClienteServicoPK;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ricardo
 */
public class ClienteServicoDaoImplTest extends AbstractDaoTest<ClienteServico> {
    
    @Autowired
    private ClienteServicoDao pessoaFisicaDao;

    @Override
    public GenericDao<ClienteServico> dao() {
        return pessoaFisicaDao;
    }

    @Override
    public Object getKey() {
        return new ClienteServicoPK(new PessoaJuridica(1), new Servico(1));
    }

    @Override
    public Object getModelToInsert() {
        final ClienteServicoPK clienteServicoPK = new ClienteServicoPK(new PessoaFisica(1), new Servico(4));
        return new ClienteServico(clienteServicoPK, new Date(), new Date(), BigDecimal.ZERO);
    }

    @Override
    public Object getModelToUpdate() {
        final ClienteServicoPK clienteServicoPK = new ClienteServicoPK(new PessoaFisica(1), new Servico(1));
        return new ClienteServico(clienteServicoPK, new Date(), new Date(), BigDecimal.ZERO);
    }
    
}
