/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Size(max = 255)
    @Column(name = "nome_cliente")
    private String nomeCliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteServicoPK.cliente")
    private List<ClienteServico> clienteServicoList;

    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    @ManyToOne(optional = false)
    private Perfil perfil;

    public Cliente() {
    }

    public Cliente(Integer idCliente, Perfil perfil) {
        this.idCliente = idCliente;
        this.perfil = perfil;
    }
    
    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Perfil perfil) {
        this.perfil = perfil;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<ClienteServico> getClienteServicoList() {
        return clienteServicoList;
    }

    public void setClienteServicoList(List<ClienteServico> clienteServicoList) {
        this.clienteServicoList = clienteServicoList;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepetdao.entity.Cliente[ idCliente=" + idCliente + " ]";
    }

}
