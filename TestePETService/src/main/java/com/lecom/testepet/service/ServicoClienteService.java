/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service;

import com.lecom.testepet.bean.ServicoClienteBean;

/**
 *
 * @author Ricardo
 */
public interface ServicoClienteService {

    /**
     * Save the ServicoCliente
     *
     * @param servicoClienteBean
     */
    public void save(final ServicoClienteBean servicoClienteBean);
    
    /**
     * Find the ServicoCliente
     * @param servicoClienteBean
     * @return servicoClienteBean
     */
    public ServicoClienteBean find(final ServicoClienteBean servicoClienteBean);
}
