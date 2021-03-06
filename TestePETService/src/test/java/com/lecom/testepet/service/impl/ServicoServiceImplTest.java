/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lecom.testepet.bean.ServicoBean;
import com.lecom.testepet.dao.ServicoDao;
import com.lecom.testepet.entity.Servico;
import com.lecom.testepet.service.ServicoService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
@RunWith(PowerMockRunner.class)
public class ServicoServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicoServiceImplTest.class);

    @InjectMocks
    private final ServicoService servicosService = new ServicoServiceImpl();

    @Mock
    private ServicoDao servicoDao;

    private final ServicoBean servicoBean = new ServicoBean();
    
    @Before
    public void setup() {
        servicoBean.setNomeServico("Serviço Test");
        servicoBean.setDescricaoServico("Desc Serviço Test");
    }

    @Test
    public void saveFindServicoTest() {
        LOGGER.info("saveFindServicoTest");
        servicosService.save(servicoBean);
        
        final Servico servico = servicoBean.buildEntity();
        servico.setIdServico(1);
        PowerMockito.when(servicoDao.find(Mockito.any())).thenReturn(servico);
        
        final ServicoBean servicoBeanFind = servicosService.find(servicoBean);
        Assert.assertNotNull(servicoBeanFind);
        Assert.assertEquals(servicoBean.getIdServico(), servicoBean.getIdServico());
        Assert.assertEquals(servicoBean.getNomeServico(), servicoBean.getNomeServico());
        Assert.assertEquals(servicoBean.getDescricaoServico(), servicoBean.getDescricaoServico());
    }
    
    @Test
    public void findAllServicoTest() {
        LOGGER.info("findAllServicoTest");
        
        final List<Servico> servicoList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            servicoList.add(new Servico(i + 1, "Servico " + (i + 1), "Desc Servico " + (i + 1)));            
        }
        
        PowerMockito.when(servicoDao.findAll()).thenReturn(servicoList);
        
        final List<ServicoBean> servicoBeanList = servicosService.findAll();
        
        Assert.assertFalse(servicoBeanList.isEmpty());
        
        int i = 1;
        for (final ServicoBean bean : servicoBeanList) {
            Assert.assertTrue(i == bean.getIdServico());
            Assert.assertEquals("Servico " + i,bean.getNomeServico());
            Assert.assertEquals("Desc Servico " + i,bean.getDescricaoServico());
            i++;
        }
    }

}
