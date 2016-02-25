/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service;

import com.lecom.testepet.bean.ClienteBean;

/**
 *
 * @author Ricardo
 */
public interface ClienteService {

    /**
     * Save the Cliente
     *
     * @param clienteBean
     */
    public void save(final ClienteBean clienteBean);

    /**
     * Find the Cliente
     *
     * @param clienteBean
     * @return clienteBean
     */
    public ClienteBean find(final ClienteBean clienteBean);
}
