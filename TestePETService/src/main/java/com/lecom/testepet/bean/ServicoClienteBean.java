/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import com.lecom.testepet.entity.ServicoCliente;
import com.lecom.testepet.entity.pk.ServicoClientePK;
import com.lecom.testepet.util.JsonDateSerializer;
import java.io.Serializable;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author Ricardo
 */
public abstract class ServicoClienteBean implements Serializable {

    private static final long serialVersionUID = -8807394181939157798L;

    @JsonIgnore
    private Integer idCliente;

    private Integer idServico;

    @JsonSerialize(using = JsonDateSerializer.class)
    private Date dataInicio;

    @JsonSerialize(using = JsonDateSerializer.class)
    private Date dataFim;

    private double valor;

    @JsonIgnore
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

    public double getValorComDescontoPerfil() {
        return valor - (valor * (pctDescontoPerfil / 100));
    }
    
    public double getValorParaPagarHoje() {
        double pctDesconto = pctDescontoPerfil + 5;
        if (this.getDiasParaFinalizarServico() >= 10) {
            pctDesconto += 5;
        }        
        return valor - (valor * (pctDesconto / 100));
    }
    
    public int getDiasParaFinalizarServico() {
        final DateTime dateTimeInicio = new DateTime(new Date());
        final DateTime dateTimeFinal = new DateTime(this.dataFim.getTime()); 
        return Days.daysBetween(dateTimeInicio, dateTimeFinal).getDays();
    }

}
