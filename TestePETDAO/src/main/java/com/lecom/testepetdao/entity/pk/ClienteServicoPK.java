/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.entity.pk;

import com.lecom.testepetdao.entity.Cliente;
import com.lecom.testepetdao.entity.Servico;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ricardo
 */
@Embeddable
public class ClienteServicoPK implements Serializable {

    private static final long serialVersionUID = 7507169699758411060L;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Servico servico;

    public ClienteServicoPK() {
    }

    public ClienteServicoPK(Cliente cliente, Servico servico) {
        this.cliente = cliente;
        this.servico = servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.cliente);
        hash = 67 * hash + Objects.hashCode(this.servico);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteServicoPK other = (ClienteServicoPK) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteServicoPK{" + "cliente=" + cliente + ", servico=" + servico + '}';
    }

}
