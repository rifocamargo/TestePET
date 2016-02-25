/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.controller;

import com.lecom.testepet.bean.ServicoBean;
import com.lecom.testepet.service.ServicoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ricardo
 */
@Controller
@RequestMapping("/servico")
public class ServicoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicoController.class);

    @Autowired
    private ServicoService servicoService;

    @RequestMapping(value = "/find/all", method = RequestMethod.GET)
    public @ResponseBody List<ServicoBean> findServices() {
        LOGGER.info("findServices Begin");
        final List<ServicoBean> servicoBeanList = servicoService.findAll();
        LOGGER.info("findServices End");
        return servicoBeanList;
    }
}
