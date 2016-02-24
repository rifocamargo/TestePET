/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.service.impl;

import java.util.Date;

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

import com.lecom.testepet.bean.ServicoPessoaFisicaBean;
import com.lecom.testepet.bean.ServicoPessoaJuridicaBean;
import com.lecom.testepet.dao.ServicoClienteDao;
import com.lecom.testepet.entity.ServicoCliente;
import com.lecom.testepet.service.ServicoClienteService;

/**
 *
 * @author Ricardo
 */
@RunWith(PowerMockRunner.class)
public class ServicoClienteServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicoClienteServiceImplTest.class);

    @InjectMocks
    private final ServicoClienteService servicoClienteService = new ServicoClienteServiceImpl();

    @Mock
    private ServicoClienteDao servicoClienteDao;

    private final ServicoPessoaFisicaBean servicoPessoaFisicaBean = new ServicoPessoaFisicaBean();

    private final ServicoPessoaJuridicaBean servicoPessoaJuridicaBean = new ServicoPessoaJuridicaBean();

    @Before
    public void setup() {
        servicoPessoaFisicaBean.setDataFim(new Date());
        servicoPessoaFisicaBean.setDataInicio(new Date());
        servicoPessoaFisicaBean.setIdCliente(1);
        servicoPessoaFisicaBean.setIdServico(1);
        servicoPessoaFisicaBean.setPessoaFisicaCpf("123.456.789-12");
        servicoPessoaFisicaBean.setValor(1d);

        servicoPessoaJuridicaBean.setDataFim(new Date());
        servicoPessoaJuridicaBean.setDataInicio(new Date());
        servicoPessoaJuridicaBean.setIdCliente(1);
        servicoPessoaJuridicaBean.setIdServico(1);
        servicoPessoaJuridicaBean.setCnpjPessoaJuridica("987.654.321/0001-45");
        servicoPessoaJuridicaBean.setValor(2d);
    }

    @Test
    public void saveFindServicoPessoaFisicaTest() {
        LOGGER.info("saveFindServicoPessoaFisicaTest");
        servicoClienteService.save(servicoPessoaFisicaBean);
	
        final ServicoCliente servicoCliente = servicoPessoaFisicaBean.buildEntity();
        servicoCliente.getServicoClientePK().getCliente().setNomeCliente("Nome Teste");
        PowerMockito.when(servicoClienteDao.find(Mockito.any())).thenReturn(servicoCliente);

        final ServicoPessoaFisicaBean clienteBean = (ServicoPessoaFisicaBean) servicoClienteService.find(servicoPessoaFisicaBean);

        Assert.assertNotNull(clienteBean);
        Assert.assertEquals(servicoPessoaFisicaBean.getIdCliente(), clienteBean.getIdCliente());
        Assert.assertEquals(servicoPessoaFisicaBean.getPessoaFisicaCpf(), clienteBean.getPessoaFisicaCpf());
    }

    @Test
    public void saveFindServicoPessoaJuridicaTest() {
        LOGGER.info("saveFindServicoPessoaJuridicaTest");
        servicoClienteService.save(servicoPessoaJuridicaBean);

        final ServicoCliente servicoCliente = servicoPessoaJuridicaBean.buildEntity();
        servicoCliente.getServicoClientePK().getCliente().setNomeCliente("Nome Teste");
        PowerMockito.when(servicoClienteDao.find(Mockito.any())).thenReturn(servicoCliente);

        final ServicoPessoaJuridicaBean clienteBean = (ServicoPessoaJuridicaBean) servicoClienteService.find(servicoPessoaJuridicaBean);

        Assert.assertNotNull(clienteBean);
        Assert.assertEquals(servicoPessoaJuridicaBean.getIdCliente(), clienteBean.getIdCliente());
        Assert.assertEquals(servicoPessoaJuridicaBean.getCnpjPessoaJuridica(), clienteBean.getCnpjPessoaJuridica());
    }

}
