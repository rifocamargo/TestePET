/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id_cliente")
public class PessoaJuridica extends Cliente implements Serializable {

    private static final long serialVersionUID = -910091967044863918L;

    @NotNull
    @Column(name = "cnpj_pessoa_juridica")
    private String cnpjPessoaJuridica;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer idCliente) {
        super(idCliente);
    }

    public PessoaJuridica(Integer idCliente, String cnpjPessoaJuridica, Perfil perfil) {
        super(idCliente, perfil);
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
    }

    public PessoaJuridica(String cnpjPessoaJuridica, Perfil perfil) {
        super(perfil);
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
    }

    public String getCnpjPessoaJuridica() {
        return cnpjPessoaJuridica;
    }

    public void setCnpjPessoaJuridica(String cnpjPessoaJuridica) {
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getIdCliente() != null ? this.getIdCliente().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.getIdCliente() == null && other.getIdCliente() != null) || (this.getIdCliente() != null && !this.getIdCliente().equals(other.getIdCliente()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepetdao.entity.PessoaJuridica[ idCliente=" + getIdCliente() + " ]";
    }

}
