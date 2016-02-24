/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lecom.testepet.entity.pk.ServicoClientePK;

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

	public ServicoPessoaFisica(final ServicoClientePK servicoPessoaFisicaPK) {
		super(servicoPessoaFisicaPK);
	}

	public ServicoPessoaFisica(final ServicoClientePK servicoPessoaFisicaPK, final Date dataInicio, final Date dataFim, final double valor) {
		super(servicoPessoaFisicaPK, dataInicio, dataFim, valor);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServicoPessoaFisica [servicoClientePK=" + servicoClientePK + "]";
	}
}
