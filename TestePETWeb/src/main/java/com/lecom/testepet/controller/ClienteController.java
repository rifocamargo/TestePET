/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.controller;

import com.lecom.testepet.bean.ClienteBean;
import com.lecom.testepet.bean.ClienteRequest;
import com.lecom.testepet.bean.PessoaJuridicaBean;
import com.lecom.testepet.service.ClienteService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ricardo
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/find/services", method = RequestMethod.POST)
//    public @ResponseBody ClienteBean findServices(@RequestBody final ClienteRequest clienteBean) {
    public @ResponseBody ClienteBean findServices(@RequestBody final ClienteBean clienteBean) {
        LOGGER.info("findServices Begin");
//        PessoaJuridicaBean pessoaJuridicaBean = new PessoaJuridicaBean();
//        pessoaJuridicaBean.setIdCliente(clienteBean.getIdCliente());
//        final ClienteBean clienteBeanRetorno = clienteService.find(pessoaJuridicaBean);
        final ClienteBean clienteBeanRetorno = clienteService.find(clienteBean);
        LOGGER.info("findServices End");
        return clienteBeanRetorno;
    }
    
//    @RequestMapping(value = "/find/services", method = RequestMethod.GET)
//    public @ResponseBody ClienteBean findServices(final HttpServletResponse response) {
//        LOGGER.info("findServices Begin");
//        final PessoaJuridicaBean pessoaFisicaBean = new PessoaJuridicaBean();
//        pessoaFisicaBean.setIdCliente(2);
//        ClienteBean clienteBeanRetorno = null;
//        try {
//            clienteBeanRetorno = clienteService.find(pessoaFisicaBean);
//        } catch (Exception e) {
//            LOGGER.error("Error", e);
//        }
//        
//        LOGGER.info("findServices End");
//        return clienteBeanRetorno;
//    }
    
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClienteBean clienteBean = mapper.readValue("{\"idCliente\": 2,\"cnpjPessoaJuridica\": \"123.456.789/1234-12\"}", ClienteBean.class);
        System.out.println(clienteBean);
    }
}
