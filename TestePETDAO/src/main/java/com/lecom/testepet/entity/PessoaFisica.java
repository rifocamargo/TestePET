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
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id_cliente")
public class PessoaFisica extends Cliente implements Serializable {

    private static final long serialVersionUID = 8500276704900728031L;

    @NotNull
    @Column(name = "pessoa_fisica_cpf")
    private String pessoaFisicaCpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoClientePK.cliente")
    private List<ServicoPessoaFisica> servicoPessoaFisicaList;

    /**
     * Default Constructor
     */
    public PessoaFisica() {
    }

    /**
     * @param idCliente
     */
    public PessoaFisica(final Integer idCliente) {
        super(idCliente);
    }

    /**
     * @param nomeCliente
     * @param perfil
     * @param pessoaFisicaCpf
     */
    public PessoaFisica(final String nomeCliente, final Perfil perfil, final String pessoaFisicaCpf) {
        super(nomeCliente, perfil);
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    /**
     * @param idCliente
     * @param nomeCliente
     * @param perfil
     * @param pessoaFisicaCpf
     */
    public PessoaFisica(final Integer idCliente, final String nomeCliente, final Perfil perfil,
            final String pessoaFisicaCpf) {
        super(idCliente, nomeCliente, perfil);
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    /**
     * @return the pessoaFisicaCpf
     */
    public String getPessoaFisicaCpf() {
        return pessoaFisicaCpf;
    }

    /**
     * @param pessoaFisicaCpf the pessoaFisicaCpf to set
     */
    public void setPessoaFisicaCpf(final String pessoaFisicaCpf) {
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    public List<ServicoPessoaFisica> getServicoPessoaFisicaList() {
        return servicoPessoaFisicaList;
    }

    public void setServicoPessoaFisicaList(List<ServicoPessoaFisica> servicoPessoaFisicaList) {
        this.servicoPessoaFisicaList = servicoPessoaFisicaList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PessoaFisica [pessoaFisicaCpf=" + pessoaFisicaCpf + ", getIdCliente()=" + getIdCliente()
                + ", getNomeCliente()=" + getNomeCliente() + "]";
    }

}
