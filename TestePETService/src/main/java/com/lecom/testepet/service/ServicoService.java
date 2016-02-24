/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service;

import com.lecom.testepet.bean.ServicoBean;

/**
 *
 * @author Ricardo
 */
public interface ServicoService {

    /**
     * Save the Servico
     *
     * @param servicoBean
     */
    public void save(final ServicoBean servicoBean);
    
    /**
     * find the Servico
     *
     * @param servicoBean
     * @return ServicoBean
     */
    public ServicoBean find(final ServicoBean servicoBean);
}
