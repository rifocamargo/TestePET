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

import com.lecom.testepet.bean.PerfilBean;
import com.lecom.testepet.bean.PessoaFisicaBean;
import com.lecom.testepet.bean.PessoaJuridicaBean;
import com.lecom.testepet.dao.ClienteDao;
import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.service.ClienteService;

/**
 *
 * @author Ricardo
 */
@RunWith(PowerMockRunner.class)
public class ClienteServiceImplTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImplTest.class);

    @InjectMocks
    private final ClienteService clienteService = new ClienteServiceImpl();
    
    @Mock
    private ClienteDao clienteDao;
    
    private final PessoaFisicaBean pessoaFisicaBean = new PessoaFisicaBean();
    
    private final PessoaJuridicaBean pessoaJuridicaBean = new PessoaJuridicaBean();
    
    @Before
    public void setup() {
        final PerfilBean perfilBeanOuro = new PerfilBean();
        perfilBeanOuro.setIdPerfil(1);
        
        final PerfilBean perfilBeanPrata = new PerfilBean();
        perfilBeanPrata.setIdPerfil(2);
        
        pessoaFisicaBean.setNomeCliente("Teste Insert PF");
        pessoaFisicaBean.setPessoaFisicaCpf("123.456.789-12");
        pessoaFisicaBean.setPerfilBean(perfilBeanOuro);
        
        pessoaJuridicaBean.setNomeCliente("Teste Insert PJ");
        pessoaJuridicaBean.setCnpjPessoaJuridica("987.654.321/0001-45");
        pessoaJuridicaBean.setPerfilBean(perfilBeanPrata);
    }

    @Test
    public void saveFindPessoaFisicaTest() {        
        LOGGER.info("saveFindPessoaFisicaTest");        
        clienteService.save(pessoaFisicaBean);
        
        final Cliente cliente = pessoaFisicaBean.buildEntity();
        cliente.setIdCliente(1);
        PowerMockito.when(clienteDao.find(Mockito.any())).thenReturn(cliente);
        
        final PessoaFisicaBean clienteBean = (PessoaFisicaBean) clienteService.find(pessoaFisicaBean);
        
        Assert.assertNotNull(clienteBean);
        Assert.assertEquals(pessoaFisicaBean.getIdCliente(), clienteBean.getIdCliente());        
        Assert.assertEquals(pessoaFisicaBean.getPessoaFisicaCpf(), clienteBean.getPessoaFisicaCpf());        
    }
    
    @Test
    public void saveFindPessoaJuridicaTest() {        
        LOGGER.info("saveFindPessoaJuridicaTest");        
        clienteService.save(pessoaJuridicaBean);
        
        final Cliente cliente = pessoaJuridicaBean.buildEntity();
        cliente.setIdCliente(1);
        PowerMockito.when(clienteDao.find(Mockito.any())).thenReturn(cliente);
        
        final PessoaJuridicaBean clienteBean = (PessoaJuridicaBean) clienteService.find(pessoaJuridicaBean);
        
        Assert.assertNotNull(clienteBean);
        Assert.assertEquals(pessoaJuridicaBean.getIdCliente(), clienteBean.getIdCliente());        
        Assert.assertEquals(pessoaJuridicaBean.getCnpjPessoaJuridica(), clienteBean.getCnpjPessoaJuridica());        
    }

}
