/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.entity;

import com.lecom.testepetdao.entity.pk.ClienteServicoPK;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "cliente_servico")
public class ClienteServico implements Serializable {

    private static final long serialVersionUID = 8386035898841065567L;

    @EmbeddedId
    protected ClienteServicoPK clienteServicoPK;

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
    private BigDecimal valor;

    public ClienteServico() {
    }

    public ClienteServico(ClienteServicoPK clienteServicoPK) {
        this.clienteServicoPK = clienteServicoPK;
    }

    public ClienteServico(ClienteServicoPK clienteServicoPK, Date dataInicio, Date dataFim, BigDecimal valor) {
        this.clienteServicoPK = clienteServicoPK;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    public ClienteServicoPK getClienteServicoPK() {
        return clienteServicoPK;
    }

    public void setClienteServicoPK(ClienteServicoPK clienteServicoPK) {
        this.clienteServicoPK = clienteServicoPK;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteServicoPK != null ? clienteServicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteServico)) {
            return false;
        }
        ClienteServico other = (ClienteServico) object;
        if ((this.clienteServicoPK == null && other.clienteServicoPK != null) || (this.clienteServicoPK != null && !this.clienteServicoPK.equals(other.clienteServicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepetdao.entity.ClienteServico[ clienteServicoPK=" + clienteServicoPK + " ]";
    }

}
