/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import java.io.Serializable;

import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.entity.PessoaJuridica;
import com.lecom.testepet.entity.ServicoCliente;

public class PessoaJuridicaBean extends ClienteBean implements Serializable {

    private static final long serialVersionUID = 1544942947362249944L;

    private String cnpjPessoaJuridica;

    public String getCnpjPessoaJuridica() {
        return cnpjPessoaJuridica;
    }

    public void setCnpjPessoaJuridica(final String cnpjPessoaJuridica) {
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
    }

    @Override
    public PessoaJuridica buildEntity() {
        return new PessoaJuridica(super.getNomeCliente(), super.getPerfilBean().buildEntity(), this.cnpjPessoaJuridica);
    }

    @Override
    public ClienteBean build(final Cliente cliente) {
        final PessoaJuridica pessoaFisica = (PessoaJuridica) cliente;
        this.cnpjPessoaJuridica = pessoaFisica.getCnpjPessoaJuridica();           
        for (final ServicoCliente servicoCliente : cliente.getServicoClienteList()) {
            super.getServicoClienteBeanList().add(new ServicoPessoaJuridicaBean().build(servicoCliente));
        }
        return super.build(cliente);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PessoaJuridicaBean [cnpjPessoaJuridica=" + cnpjPessoaJuridica + ", getNomeCliente()=" + getNomeCliente()
                + ", getPerfilBean()=" + getPerfilBean() + ", getIdCliente()=" + getIdCliente() + "]";
    }
}
