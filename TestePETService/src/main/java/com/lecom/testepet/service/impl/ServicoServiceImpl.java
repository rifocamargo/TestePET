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

import com.lecom.testepet.bean.ServicoBean;
import com.lecom.testepet.dao.ServicoDao;
import com.lecom.testepet.entity.Servico;
import com.lecom.testepet.service.ServicoService;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoServiceImpl implements ServicoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServicoServiceImpl.class);
	
    @Autowired
    private ServicoDao servicoDao;

    @Override
    public void save(final ServicoBean servicoBean) {
    	LOGGER.info("Save Servico begin");
    	LOGGER.info("Saving: {}", servicoBean);
        servicoDao.save(servicoBean.buildEntity());
        LOGGER.info("Save Servico end");
    }

    @Override
    public ServicoBean find(final ServicoBean servicoBean) {
    	LOGGER.info("Find Servico begin");
        final Servico servico = servicoDao.find(servicoBean.getIdServico());
        LOGGER.info("Found: {}", servico);
        LOGGER.info("Find Servico end");
        return servicoBean.build(servico);
    }

    @Override
    public List<ServicoBean> findAll() {
        final List<Servico> servicoList = servicoDao.findAll();
        final List<ServicoBean> servicoBeanList = new ArrayList<>();
        for (final Servico servico : servicoList) {
            servicoBeanList.add(new ServicoBean().build(servico));
        }
        return servicoBeanList;
    }

}
