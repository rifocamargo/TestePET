/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity.pk;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo
 */
@Embeddable
public class ServicoPessoaJuridicaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servico")
    private int idServico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;

    public ServicoPessoaJuridicaPK() {
    }

    public ServicoPessoaJuridicaPK(int idServico, int idCliente) {
        this.idServico = idServico;
        this.idCliente = idCliente;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idServico;
        hash += (int) idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicoPessoaJuridicaPK)) {
            return false;
        }
        ServicoPessoaJuridicaPK other = (ServicoPessoaJuridicaPK) object;
        if (this.idServico != other.idServico) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepet.entity.ServicoPessoaJuridicaPK[ idServico=" + idServico + ", idCliente=" + idCliente + " ]";
    }
    
}
