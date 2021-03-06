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

import com.lecom.testepet.bean.ClienteBean;
import com.lecom.testepet.dao.ClienteDao;
import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.service.ClienteService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(final ClienteBean clienteBean) {
    	LOGGER.info("Save Cliente begin");
    	LOGGER.info("Saving: {}", clienteBean);
        clienteDao.save(clienteBean.buildEntity());
        LOGGER.info("Save Cliente end");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ClienteBean find(final ClienteBean clienteBean) {
    	LOGGER.info("Find Cliente begin");
        final Cliente cliente = clienteDao.find(clienteBean.entityType(), clienteBean.getIdCliente());
        LOGGER.info("Found: {}", cliente);
        LOGGER.info("Find Cliente end");
        return clienteBean.build(cliente);
    }
    
}
