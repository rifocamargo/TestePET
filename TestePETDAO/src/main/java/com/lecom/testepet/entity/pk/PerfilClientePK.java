/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity.pk;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo
 */
@Embeddable
public class PerfilClientePK implements Serializable {
    
    private static final long serialVersionUID = 1685964825890543739L;
    
    @NotNull
    @Column(name = "perfil_id_perfil")
    private int perfilIdPerfil;
    
    @NotNull
    @Column(name = "cliente_id_cliente")
    private int clienteIdCliente;

    public PerfilClientePK() {
    }

    public PerfilClientePK(int perfilIdPerfil, int clienteIdCliente) {
        this.perfilIdPerfil = perfilIdPerfil;
        this.clienteIdCliente = clienteIdCliente;
    }

    public int getPerfilIdPerfil() {
        return perfilIdPerfil;
    }

    public void setPerfilIdPerfil(int perfilIdPerfil) {
        this.perfilIdPerfil = perfilIdPerfil;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) perfilIdPerfil;
        hash += (int) clienteIdCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilClientePK)) {
            return false;
        }
        PerfilClientePK other = (PerfilClientePK) object;
        if (this.perfilIdPerfil != other.perfilIdPerfil) {
            return false;
        }
        if (this.clienteIdCliente != other.clienteIdCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepetdao.entity.PerfilClientePK[ perfilIdPerfil=" + perfilIdPerfil + ", clienteIdCliente=" + clienteIdCliente + " ]";
    }
    
}
