/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity;

import com.lecom.testepet.entity.pk.ServicoClientePK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ServicoCliente implements Serializable {

    private static final long serialVersionUID = -1682510963744700640L;

    @EmbeddedId
    protected ServicoClientePK servicoClientePK;

    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @NotNull
    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    @NotNull
    @Column(name = "valor")
    private double valor;

    public ServicoCliente() {
    }

    public ServicoCliente(ServicoClientePK servicoPessoaFisicaPK) {
        this.servicoClientePK = servicoPessoaFisicaPK;
    }

    public ServicoCliente(ServicoClientePK servicoPessoaFisicaPK, Date dataInicio, Date dataFim, double valor) {
        this.servicoClientePK = servicoPessoaFisicaPK;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    public ServicoClientePK getServicoClientePK() {
        return servicoClientePK;
    }

    public void setServicoClientePK(ServicoClientePK servicoClientePK) {
        this.servicoClientePK = servicoClientePK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicoClientePK != null ? servicoClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoCliente)) {
            return false;
        }
        ServicoCliente other = (ServicoCliente) object;
        if ((this.servicoClientePK == null && other.servicoClientePK != null) || (this.servicoClientePK != null && !this.servicoClientePK.equals(other.servicoClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepet.entity.ServicoPessoaFisica[ servicoPessoaFisicaPK=" + servicoClientePK + " ]";
    }

}
