/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = -1407330511885290690L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Integer idPerfil;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_perfil")
    private String nomePerfil;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao_perfil")
    private String descricaoPerfil;

    @Column(name = "pct_desconto_perfil")
    private double pctDescontoPerfil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<Cliente> clienteList;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(String nomePerfil, String descricaoPerfil, double pctDescontoPerfil) {
        this.nomePerfil = nomePerfil;
        this.descricaoPerfil = descricaoPerfil;
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    public Perfil(Integer idPerfil, String nomePerfil, String descricaoPerfil, double pctDescontoPerfil) {
        this(idPerfil);
        this.descricaoPerfil = descricaoPerfil;
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public String getDescricaoPerfil() {
        return descricaoPerfil;
    }

    public void setDescricaoPerfil(String descricaoPerfil) {
        this.descricaoPerfil = descricaoPerfil;
    }

    public double getPctDescontoPerfil() {
        return pctDescontoPerfil;
    }

    public void setPctDescontoPerfil(double pctDescontoPerfil) {
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepetdao.entity.Perfil[ idPerfil=" + idPerfil + " ]";
    }

}
