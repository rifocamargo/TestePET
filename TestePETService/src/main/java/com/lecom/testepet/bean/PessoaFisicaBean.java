/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import java.io.Serializable;

import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.entity.PessoaFisica;
import com.lecom.testepet.entity.ServicoCliente;
import org.codehaus.jackson.annotate.JsonTypeName;

@JsonTypeName("pessoaFisica")
public class PessoaFisicaBean extends ClienteBean implements Serializable {

    private static final long serialVersionUID = 3182275309394504973L;

    private String pessoaFisicaCpf;

    public PessoaFisicaBean() {
    }

    public PessoaFisicaBean(final String pessoaFisicaCpf, final String nomeCliente, final PerfilBean perfilBean) {
        super(nomeCliente, perfilBean);
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    public String getPessoaFisicaCpf() {
        return pessoaFisicaCpf;
    }

    public void setPessoaFisicaCpf(final String pessoaFisicaCpf) {
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    @Override
    public PessoaFisica buildEntity() {
        return new PessoaFisica(super.getNomeCliente(), super.getPerfilBean().buildEntity(), this.pessoaFisicaCpf);
    }
    
    @Override
    public Class entityType() {
        return PessoaFisica.class;
    }

    @Override
    public ClienteBean build(final Cliente cliente) {
        final PessoaFisica pessoaFisica = (PessoaFisica) cliente;
        this.pessoaFisicaCpf = pessoaFisica.getPessoaFisicaCpf();  
        for (final ServicoCliente servicoCliente : pessoaFisica.getServicoPessoaFisicaList()) {
            super.getServicoClienteBeanList().add(new ServicoPessoaFisicaBean().build(servicoCliente));
        }
        return super.build(cliente);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PessoaFisicaBean [pessoaFisicaCpf=" + pessoaFisicaCpf + ", getNomeCliente()=" + getNomeCliente()
                + ", getPerfilBean()=" + getPerfilBean() + ", getIdCliente()=" + getIdCliente() + "]";
    }

    

}
