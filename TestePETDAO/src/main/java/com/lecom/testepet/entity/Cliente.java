/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity;

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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente implements Serializable {

    private static final long serialVersionUID = -3571362049296436942L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Size(max = 255)
    @Column(name = "nome_cliente")
    private String nomeCliente;

    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    @ManyToOne(optional = false)
    private Perfil perfil;

    /**
     * Default Constructor
     */
    public Cliente() {
    }

    /**
     * @param idCliente
     */
    public Cliente(final Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @param nomeCliente
     * @param perfil
     */
    public Cliente(final String nomeCliente, final Perfil perfil) {
        this.nomeCliente = nomeCliente;
        this.perfil = perfil;
    }

    /**
     * @param idCliente
     * @param nomeCliente
     * @param perfil
     */
    public Cliente(final Integer idCliente, final String nomeCliente, final Perfil perfil) {
        this(idCliente);
        this.nomeCliente = nomeCliente;
        this.perfil = perfil;
    }

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(final Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(final String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(final Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idCliente).hashCode();
    }

    @Override
    public boolean equals(final Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        final Cliente other = (Cliente) object;

        return new EqualsBuilder().append(this.idCliente, other.idCliente).isEquals();
    }

    @Override
    public String toString() {
        return "Cliente[ idCliente=" + idCliente + " ]";
    }

}
