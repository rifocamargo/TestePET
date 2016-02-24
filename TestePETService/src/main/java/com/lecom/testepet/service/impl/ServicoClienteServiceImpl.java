/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service.impl;

import com.lecom.testepet.bean.ServicoClienteBean;
import com.lecom.testepet.dao.ServicoClienteDao;
import com.lecom.testepet.entity.ServicoCliente;
import com.lecom.testepet.service.ServicoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoClienteServiceImpl implements ServicoClienteService {

    @Autowired
    private ServicoClienteDao servicoClienteDao;

    @Override
    public void save(final ServicoClienteBean servicoClienteBean) {
        servicoClienteDao.save(servicoClienteBean.buildEntity());
    }

    @Override
    public ServicoClienteBean find(ServicoClienteBean servicoClienteBean) {
        final ServicoCliente servicoCliente = servicoClienteDao.find(servicoClienteBean.buildPK());
        return servicoClienteBean.build(servicoCliente);
    }

}
