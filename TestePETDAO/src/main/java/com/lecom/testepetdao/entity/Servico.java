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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "servico")
public class Servico implements Serializable {
    
    private static final long serialVersionUID = -3103157719881745331L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "id_servico")
    private Integer idServico;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_servico")
    private String nomeServico;
    
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao_servico")
    private String descricaoServico;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteServicoPK.servico")
    private List<ClienteServico> clienteServicoList;

    public Servico() {
    }

    public Servico(Integer idServico) {
        this.idServico = idServico;
    }

    public Servico(Integer idServico, String nomeServico, String descricaoServico) {
        this(idServico);
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
    }

    public Servico(String nomeServico, String descricaoServico) {
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    @XmlTransient
    public List<ClienteServico> getClienteServicoList() {
        return clienteServicoList;
    }

    public void setClienteServicoList(List<ClienteServico> clienteServicoList) {
        this.clienteServicoList = clienteServicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServico != null ? idServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.idServico == null && other.idServico != null) || (this.idServico != null && !this.idServico.equals(other.idServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepetdao.entity.Servico[ idServico=" + idServico + " ]";
    }
    
}
