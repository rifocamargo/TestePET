/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import com.lecom.testepet.entity.PessoaFisica;
import com.lecom.testepet.entity.Servico;
import com.lecom.testepet.entity.ServicoCliente;
import com.lecom.testepet.entity.ServicoPessoaFisica;
import com.lecom.testepet.entity.pk.ServicoClientePK;

public class ServicoPessoaFisicaBean extends ServicoClienteBean {

    private static final long serialVersionUID = -7774205866705558482L;

    private String pessoaFisicaCpf;

    public ServicoPessoaFisicaBean() {
    }

    public String getPessoaFisicaCpf() {
        return pessoaFisicaCpf;
    }

    public void setPessoaFisicaCpf(final String pessoaFisicaCpf) {
        this.pessoaFisicaCpf = pessoaFisicaCpf;
    }

    @Override
    public ServicoCliente buildEntity() {
        final PessoaFisica cliente = new PessoaFisica(super.getIdCliente(), this.pessoaFisicaCpf);
        final Servico servico = new Servico(super.getIdServico());
        final ServicoClientePK servicoClientePK = new ServicoClientePK(cliente, servico);
        return new ServicoPessoaFisica(servicoClientePK, super.getDataInicio(), super.getDataFim(), super.getValor());
    }

    @Override
    public ServicoClientePK buildPK() {
        final PessoaFisica cliente = new PessoaFisica(super.getIdCliente());
        final Servico servico = new Servico(super.getIdServico());
        return new ServicoClientePK(cliente, servico);
    }

}
