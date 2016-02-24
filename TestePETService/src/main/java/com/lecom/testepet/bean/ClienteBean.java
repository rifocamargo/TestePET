/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.entity.ServicoCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public abstract class ClienteBean {

    private Integer idCliente;

    private String nomeCliente;

    private PerfilBean perfilBean;

    private final List<ServicoClienteBean> servicoClienteBeanList = new ArrayList<>();

    public abstract Cliente buildEntity();

    public ClienteBean build(final Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCliente = cliente.getNomeCliente();
        this.perfilBean = new PerfilBean(cliente.getPerfil().getIdPerfil(), cliente.getPerfil().getNomePerfil(), cliente.getPerfil().getDescricaoPerfil(), cliente.getPerfil().getPctDescontoPerfil());
        return this;
    }

    public ClienteBean() {
    }

    public ClienteBean(final String nomeCliente, final PerfilBean perfilBean) {
        this.nomeCliente = nomeCliente;
        this.perfilBean = perfilBean;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<ServicoClienteBean> getServicoClienteBeanList() {
        return servicoClienteBeanList;
    }

}
