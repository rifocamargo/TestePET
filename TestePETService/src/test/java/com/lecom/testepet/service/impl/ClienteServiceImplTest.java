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
import com.lecom.testepet.bean.ServicoClienteBean;
import com.lecom.testepet.dao.ClienteDao;
import com.lecom.testepet.entity.PessoaFisica;
import com.lecom.testepet.entity.PessoaJuridica;
import com.lecom.testepet.entity.Servico;
import com.lecom.testepet.entity.ServicoPessoaFisica;
import com.lecom.testepet.entity.ServicoPessoaJuridica;
import com.lecom.testepet.entity.pk.ServicoClientePK;
import com.lecom.testepet.service.ClienteService;
import java.util.ArrayList;
import java.util.Date;

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
        perfilBeanOuro.setNomePerfil("Ouro");
        perfilBeanOuro.setDescricaoPerfil("Desc Ouro");
        perfilBeanOuro.setPctDescontoPerfil(10);

        final PerfilBean perfilBeanPrata = new PerfilBean();
        perfilBeanPrata.setIdPerfil(2);
        perfilBeanPrata.setNomePerfil("Prata");
        perfilBeanPrata.setDescricaoPerfil("Desc Prata");
        perfilBeanPrata.setPctDescontoPerfil(5);

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

        final PessoaFisica cliente = pessoaFisicaBean.buildEntity();
        cliente.setIdCliente(1);
        cliente.setServicoPessoaFisicaList(new ArrayList<ServicoPessoaFisica>());
        for (int i = 0; i < 4; i++) {
            final Servico servico = new Servico((i + 1), "Nome Serviço " + (i + 1), "Desc Serviço " + (i + 1));
            final ServicoClientePK servicoClientePK = new ServicoClientePK(cliente, servico);
            final ServicoPessoaFisica servicoPessoaFisica = new ServicoPessoaFisica(servicoClientePK, new Date(), new Date(), 100 + i);
            cliente.getServicoPessoaFisicaList().add(servicoPessoaFisica);
        }
        
        PowerMockito.when(clienteDao.find(Mockito.any(Class.class), Mockito.any())).thenReturn(cliente);

        final PessoaFisicaBean clienteBean = (PessoaFisicaBean) clienteService.find(pessoaFisicaBean);

        LOGGER.info("Cliente: {}", clienteBean);
        
        Assert.assertNotNull(clienteBean);
        Assert.assertEquals(pessoaFisicaBean.getIdCliente(), clienteBean.getIdCliente());
        Assert.assertEquals(pessoaFisicaBean.getPessoaFisicaCpf(), clienteBean.getPessoaFisicaCpf());    
        
        LOGGER.info("Serviços");
        for (final ServicoClienteBean servicoClienteBean : clienteBean.getServicoClienteBeanList()) {
            LOGGER.info("Serviço: {}", servicoClienteBean);
            Assert.assertNotNull(servicoClienteBean.getIdServico());
            Assert.assertNotNull(servicoClienteBean.getIdCliente());
            Assert.assertNotNull(servicoClienteBean.getDataFim());
            Assert.assertNotNull(servicoClienteBean.getDataInicio());
            Assert.assertTrue(servicoClienteBean.getValor() >= 100);
        }        
    }

    @Test
    public void saveFindPessoaJuridicaTest() {
        LOGGER.info("saveFindPessoaJuridicaTest");
        clienteService.save(pessoaJuridicaBean);
        pessoaJuridicaBean.setIdCliente(1);

        final PessoaJuridica cliente = pessoaJuridicaBean.buildEntity();
        cliente.setIdCliente(1);
        cliente.setServicoPessoaJuridicaList(new ArrayList<ServicoPessoaJuridica>());
        for (int i = 0; i < 4; i++) {
            final Servico servico = new Servico((i + 1), "Nome Serviço " + (i + 1), "Desc Serviço " + (i + 1));
            final ServicoClientePK servicoClientePK = new ServicoClientePK(cliente, servico);
            final ServicoPessoaJuridica servicoPessoaJuridica = new ServicoPessoaJuridica(servicoClientePK, new Date(), new Date(), 100 + i);
            cliente.getServicoPessoaJuridicaList().add(servicoPessoaJuridica);
        }
        
        PowerMockito.when(clienteDao.find(Mockito.any(Class.class), Mockito.any())).thenReturn(cliente);

        final PessoaJuridicaBean clienteBean = (PessoaJuridicaBean) clienteService.find(pessoaJuridicaBean);
        
        LOGGER.info("Cliente: {}", clienteBean);

        Assert.assertNotNull(clienteBean);
        Assert.assertEquals(pessoaJuridicaBean.getIdCliente(), clienteBean.getIdCliente());
        Assert.assertEquals(pessoaJuridicaBean.getCnpjPessoaJuridica(), clienteBean.getCnpjPessoaJuridica());
        
        LOGGER.info("Serviços");
        for (final ServicoClienteBean servicoClienteBean : clienteBean.getServicoClienteBeanList()) {
            LOGGER.info("Serviço: {}", servicoClienteBean);
            Assert.assertNotNull(servicoClienteBean.getIdServico());
            Assert.assertNotNull(servicoClienteBean.getIdCliente());
            Assert.assertNotNull(servicoClienteBean.getDataFim());
            Assert.assertNotNull(servicoClienteBean.getDataInicio());
            Assert.assertTrue(servicoClienteBean.getValor() >= 100);
        }
    }

}
