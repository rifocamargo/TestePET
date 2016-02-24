/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import com.lecom.testepet.entity.PessoaJuridica;
import com.lecom.testepet.entity.Servico;
import com.lecom.testepet.entity.ServicoCliente;
import com.lecom.testepet.entity.ServicoPessoaJuridica;
import com.lecom.testepet.entity.pk.ServicoClientePK;

public class ServicoPessoaJuridicaBean extends ServicoClienteBean {

    private static final long serialVersionUID = -7774205866705558482L;
    
    private String cnpjPessoaJuridica;

    public ServicoPessoaJuridicaBean() {
    }

    public String getCnpjPessoaJuridica() {
        return cnpjPessoaJuridica;
    }

    public void setCnpjPessoaJuridica(final String cnpjPessoaJuridica) {
        this.cnpjPessoaJuridica = cnpjPessoaJuridica;
    }
    
    @Override
    public ServicoCliente buildEntity() {
        final PessoaJuridica cliente = new PessoaJuridica(super.getIdCliente(), this.cnpjPessoaJuridica);
        final Servico servico = new Servico(super.getIdServico());
        final ServicoClientePK servicoClientePK = new ServicoClientePK(cliente, servico);
        return new ServicoPessoaJuridica(servicoClientePK, super.getDataInicio(), super.getDataFim(), super.getValor());
    }

    @Override
    public ServicoClientePK buildPK() {
        final PessoaJuridica cliente = new PessoaJuridica(super.getIdCliente());
        final Servico servico = new Servico(super.getIdServico());
        return new ServicoClientePK(cliente, servico);
    }

}
