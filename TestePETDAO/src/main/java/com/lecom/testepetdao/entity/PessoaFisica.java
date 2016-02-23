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
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name="id_cliente")
public class PessoaFisica extends Cliente implements Serializable {
    
    private static final long serialVersionUID = 8500276704900728031L;
    
    @NotNull
    @Column(name = "pessoa_fisica_cpf")
    private String pessoaFisicaCpf;

    public PessoaFisica() {
    }

    public PessoaFisica(Integer idCliente) {
        super(idCliente);
    }

    public PessoaFisica(Integer idCliente, String pessoaFisicaCpf, Perfil perfil) {
        super(idCliente, perfil);
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    public PessoaFisica(String pessoaFisicaCpf, Perfil perfil) {
        super(perfil);
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    public String getPessoaFisicaCpf() {
        return pessoaFisicaCpf;
    }

    public void setPessoaFisicaCpf(String pessoaFisicaCpf) {
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdCliente() != null ? getIdCliente().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.getIdCliente() == null && other.getIdCliente() != null) || (this.getIdCliente() != null && !this.getIdCliente().equals(other.getIdCliente()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lecom.testepetdao.entity.PessoaFisica[ idCliente=" + getIdCliente() + " ]";
    }
    
}
