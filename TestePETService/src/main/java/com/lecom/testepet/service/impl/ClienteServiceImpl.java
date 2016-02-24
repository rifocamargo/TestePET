/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service.impl;

import com.lecom.testepet.bean.ClienteBean;
import com.lecom.testepet.dao.ClienteDao;
import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    public void save(final ClienteBean clienteBean) {
        clienteDao.save(clienteBean.buildEntity());
    }

    @Override
    public ClienteBean find(final ClienteBean clienteBean) {
        final Cliente cliente = clienteDao.find(clienteBean.getIdCliente());
        return clienteBean.build(cliente);
    }
    
}
