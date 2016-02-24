/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity;

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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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

    /**
     * Default Constructor
     */
    public Perfil() {
    }

    /**
     * @param idPerfil
     */
    public Perfil(final Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    /**
     * @param nomePerfil
     * @param descricaoPerfil
     * @param pctDescontoPerfil
     */
    public Perfil(final String nomePerfil, final String descricaoPerfil, final double pctDescontoPerfil) {
        this.nomePerfil = nomePerfil;
        this.descricaoPerfil = descricaoPerfil;
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    /**
     * @param idPerfil
     * @param nomePerfil
     * @param descricaoPerfil
     * @param pctDescontoPerfil
     */
    public Perfil(final Integer idPerfil, final String nomePerfil, final String descricaoPerfil,
            final double pctDescontoPerfil) {
        this(idPerfil);
        this.nomePerfil = nomePerfil;
        this.descricaoPerfil = descricaoPerfil;
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    /**
     * @return the idPerfil
     */
    public Integer getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(final Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    /**
     * @return the nomePerfil
     */
    public String getNomePerfil() {
        return nomePerfil;
    }

    /**
     * @param nomePerfil the nomePerfil to set
     */
    public void setNomePerfil(final String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    /**
     * @return the descricaoPerfil
     */
    public String getDescricaoPerfil() {
        return descricaoPerfil;
    }

    /**
     * @param descricaoPerfil the descricaoPerfil to set
     */
    public void setDescricaoPerfil(final String descricaoPerfil) {
        this.descricaoPerfil = descricaoPerfil;
    }

    /**
     * @return the pctDescontoPerfil
     */
    public double getPctDescontoPerfil() {
        return pctDescontoPerfil;
    }

    /**
     * @param pctDescontoPerfil the pctDescontoPerfil to set
     */
    public void setPctDescontoPerfil(final double pctDescontoPerfil) {
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    /**
     * @return the clienteList
     */
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    /**
     * @param clienteList the clienteList to set
     */
    public void setClienteList(final List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idPerfil).hashCode();
    }

    @Override
    public boolean equals(final Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        final Perfil other = (Perfil) object;

        return new EqualsBuilder().append(this.idPerfil, other.idPerfil).isEquals();
    }

    @Override
    public String toString() {
        return "com.lecom.testepetdao.entity.Perfil[ idPerfil=" + idPerfil + " ]";
    }

}
