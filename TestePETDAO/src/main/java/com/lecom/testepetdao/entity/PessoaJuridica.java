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

	/**
	 * Default Constructor
	 */
	public PessoaJuridica() {
	}

	/**
	 * @param idCliente
	 */
	public PessoaJuridica(final Integer idCliente) {
		super(idCliente);
	}

	/**
	 * @param nomeCliente
	 * @param perfil
	 * @param cnpjPessoaJuridica
	 */
	public PessoaJuridica(final String nomeCliente, final Perfil perfil, final String cnpjPessoaJuridica) {
		super(nomeCliente, perfil);
		this.cnpjPessoaJuridica = cnpjPessoaJuridica;
	}

	/**
	 * @param idCliente
	 * @param nomeCliente
	 * @param perfil
	 * @param cnpjPessoaJuridica
	 */
	public PessoaJuridica(final Integer idCliente, final String nomeCliente, final Perfil perfil,
			final String cnpjPessoaJuridica) {
		super(idCliente, nomeCliente, perfil);
		this.cnpjPessoaJuridica = cnpjPessoaJuridica;
	}

	/**
	 * @return the cnpjPessoaJuridica
	 */
	public String getCnpjPessoaJuridica() {
		return cnpjPessoaJuridica;
	}

	/**
	 * @param cnpjPessoaJuridica
	 *            the cnpjPessoaJuridica to set
	 */
	public void setCnpjPessoaJuridica(final String cnpjPessoaJuridica) {
		this.cnpjPessoaJuridica = cnpjPessoaJuridica;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PessoaJuridica [cnpjPessoaJuridica=" + cnpjPessoaJuridica + ", getIdCliente()=" + getIdCliente()
				+ ", getNomeCliente()=" + getNomeCliente() + "]";
	}

}
