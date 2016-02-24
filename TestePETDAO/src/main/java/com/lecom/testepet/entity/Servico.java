/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "servico")
public class Servico implements Serializable {

	private static final long serialVersionUID = -3103157719881745331L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico")
	private Integer idServico;

	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "nome_servico")
	private String nomeServico;

	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "descricao_servico")
	private String descricaoServico;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoClientePK.servico")
	private List<ServicoPessoaJuridica> servicoPessoaJuridicaList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoClientePK.servico")
	private List<ServicoPessoaFisica> servicoPessoaFisicaList;

	/**
	 * Default Constructor
	 */
	public Servico() {
	}

	/**
	 * @param idServico
	 */
	public Servico(final Integer idServico) {
		this.idServico = idServico;
	}

	/**
	 * @param idServico
	 * @param nomeServico
	 * @param descricaoServico
	 */
	public Servico(final Integer idServico, final String nomeServico, final String descricaoServico) {
		this(idServico);
		this.nomeServico = nomeServico;
		this.descricaoServico = descricaoServico;
	}

	/**
	 * @param nomeServico
	 * @param descricaoServico
	 */
	public Servico(final String nomeServico, final String descricaoServico) {
		this.nomeServico = nomeServico;
		this.descricaoServico = descricaoServico;
	}

	/**
	 * @return the idServico
	 */
	public Integer getIdServico() {
		return idServico;
	}

	/**
	 * @param idServico
	 *            the idServico to set
	 */
	public void setIdServico(final Integer idServico) {
		this.idServico = idServico;
	}

	/**
	 * @return the nomeServico
	 */
	public String getNomeServico() {
		return nomeServico;
	}

	/**
	 * @param nomeServico
	 *            the nomeServico to set
	 */
	public void setNomeServico(final String nomeServico) {
		this.nomeServico = nomeServico;
	}

	/**
	 * @return the descricaoServico
	 */
	public String getDescricaoServico() {
		return descricaoServico;
	}

	/**
	 * @param descricaoServico
	 *            the descricaoServico to set
	 */
	public void setDescricaoServico(final String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public List<ServicoPessoaJuridica> getServicoPessoaJuridicaList() {
		return servicoPessoaJuridicaList;
	}

	public void setServicoPessoaJuridicaList(final List<ServicoPessoaJuridica> servicoPessoaJuridicaList) {
		this.servicoPessoaJuridicaList = servicoPessoaJuridicaList;
	}

	public List<ServicoPessoaFisica> getServicoPessoaFisicaList() {
		return servicoPessoaFisicaList;
	}

	public void setServicoPessoaFisicaList(final List<ServicoPessoaFisica> servicoPessoaFisicaList) {
		this.servicoPessoaFisicaList = servicoPessoaFisicaList;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.idServico).hashCode();
	}

	@Override
	public boolean equals(final Object object) {
		if (!(object instanceof Servico)) {
			return false;
		}
		final Servico other = (Servico) object;

		return new EqualsBuilder().append(this.idServico, other.idServico).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Servico [idServico=" + idServico + ", nomeServico=" + nomeServico + "]";
	}

}
