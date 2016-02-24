/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity;

import com.lecom.testepet.entity.pk.ServicoClientePK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "servico_pessoa_fisica")
public class ServicoPessoaFisica extends ServicoCliente implements Serializable {

    private static final long serialVersionUID = 2600283794069576675L;

    public ServicoPessoaFisica() {
    }

    public ServicoPessoaFisica(ServicoClientePK servicoPessoaFisicaPK) {
        super(servicoPessoaFisicaPK);
    }

    public ServicoPessoaFisica(ServicoClientePK servicoPessoaFisicaPK, Date dataInicio, Date dataFim, double valor) {
        super(servicoPessoaFisicaPK, dataInicio, dataFim, valor);
    }
    
}
