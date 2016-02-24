/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecom.testepet.bean.ServicoClienteBean;
import com.lecom.testepet.dao.ServicoClienteDao;
import com.lecom.testepet.entity.ServicoCliente;
import com.lecom.testepet.service.ServicoClienteService;

@Service
public class ServicoClienteServiceImpl implements ServicoClienteService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicoClienteServiceImpl.class);

    @Autowired
    private ServicoClienteDao servicoClienteDao;

    @Override
    public void save(final ServicoClienteBean servicoClienteBean) {
    	LOGGER.info("Save ServicoCliente begin");
    	LOGGER.info("Saving: {}", servicoClienteBean);
        servicoClienteDao.save(servicoClienteBean.buildEntity());
        LOGGER.info("Save ServicoCliente end");
    }

    @Override
    public ServicoClienteBean find(final ServicoClienteBean servicoClienteBean) {
    	LOGGER.info("Find ServicoCliente begin");
        final ServicoCliente servicoCliente = servicoClienteDao.find(servicoClienteBean.buildPK());
        LOGGER.info("Found: {}", servicoCliente);
        LOGGER.info("Find ServicoCliente end");
        return servicoClienteBean.build(servicoCliente);
    }

}
