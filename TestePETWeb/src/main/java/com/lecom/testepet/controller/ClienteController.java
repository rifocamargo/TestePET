/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.controller;

import com.lecom.testepet.bean.ClienteBean;
import com.lecom.testepet.service.ClienteService;
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
    public @ResponseBody ClienteBean findServices(@RequestBody final ClienteBean clienteBean) {
        LOGGER.info("findServices Begin");
        final ClienteBean clienteBeanRetorno = clienteService.find(clienteBean);
        LOGGER.info("findServices End");
        return clienteBeanRetorno;
    }
}
