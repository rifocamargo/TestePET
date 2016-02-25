/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service;

import com.lecom.testepet.bean.ServicoBean;
import java.util.List;

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
    
    /**
     * find the Servico
     *
     * @return List<ServicoBean>
     */
    public List<ServicoBean> findAll();
}
