/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service.impl;

import com.lecom.testepet.bean.ServicoBean;
import com.lecom.testepet.dao.ServicoDao;
import com.lecom.testepet.entity.Servico;
import com.lecom.testepet.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoDao servicoDao;

    @Override
    public void save(final ServicoBean servicoBean) {
        servicoDao.save(servicoBean.buildEntity());
    }

    @Override
    public ServicoBean find(final ServicoBean servicoBean) {
        final Servico servico = servicoDao.find(servicoBean.getIdServico());
        return servicoBean.build(servico);
    }

}
