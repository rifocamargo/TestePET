/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.entity.PessoaFisica;
import com.lecom.testepet.entity.Servico;
import com.lecom.testepet.entity.ServicoPessoaFisica;
import com.lecom.testepet.entity.pk.ServicoClientePK;

public class ServicoPessoaFisicaBean extends ServicoClienteBean {

    private static final long serialVersionUID = -7774205866705558482L;

    public ServicoPessoaFisicaBean() {
    }

    @Override
    public ServicoPessoaFisica buildEntity() {
        return new ServicoPessoaFisica(this.buildPK(), super.getDataInicio(), super.getDataFim(), super.getValor());
    }

    @Override
    public ServicoClientePK buildPK() {
        final Servico servico = new Servico(super.getIdServico());
        final Cliente cliente = new PessoaFisica(super.getIdCliente());
        return new ServicoClientePK(cliente, servico);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ServicoPessoaFisicaBean [getIdCliente()=" + getIdCliente() + ", getIdServico()=" + getIdServico()
                + ", getDataInicio()=" + getDataInicio() + ", getDataFim()=" + getDataFim() + ", getValor()=" + getValor() 
                + ", getPctDescontoPerfil()=" + getPctDescontoPerfil() + ", getValorComDesconto()=" + getValorComDescontoPerfil()+ "]";
    }

}
