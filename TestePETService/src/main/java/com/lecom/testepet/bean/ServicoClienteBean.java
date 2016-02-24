/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import com.lecom.testepet.entity.ServicoCliente;
import com.lecom.testepet.entity.pk.ServicoClientePK;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public abstract class ServicoClienteBean implements Serializable {

    private static final long serialVersionUID = -8807394181939157798L;

    private Integer idCliente;

    private Integer idServico;

    private Date dataInicio;

    private Date dataFim;

    private double valor;

    private double pctDescontoPerfil;

    public abstract ServicoCliente buildEntity();

    public abstract ServicoClientePK buildPK();

    public final ServicoClienteBean build(final ServicoCliente cliente) {
        this.idCliente = cliente.getServicoClientePK().getCliente().getIdCliente();
        this.idServico = cliente.getServicoClientePK().getServico().getIdServico();
        this.dataInicio = cliente.getDataInicio();
        this.dataFim = cliente.getDataFim();
        this.valor = cliente.getValor();
        this.pctDescontoPerfil = cliente.getServicoClientePK().getCliente().getPerfil().getPctDescontoPerfil();
        return this;
    }

    public ServicoClienteBean() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPctDescontoPerfil() {
        return pctDescontoPerfil;
    }

    public void setPctDescontoPerfil(double pctDescontoPerfil) {
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    public double getValorComDesconto() {
        double valorComDesconto = valor - (valor * (pctDescontoPerfil / 100));
        return valorComDesconto;
    }

}
