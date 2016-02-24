/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.lecom.testepet.entity.pk.ServicoClientePK;

/**
 *
 * @author Ricardo
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ServicoCliente implements Serializable {

	private static final long serialVersionUID = -1682510963744700640L;

	@EmbeddedId
	protected ServicoClientePK servicoClientePK;

	@NotNull
	@Column(name = "data_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@NotNull
	@Column(name = "data_fim")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;

	@NotNull
	@Column(name = "valor")
	private double valor;

	public ServicoCliente() {
	}

	public ServicoCliente(final ServicoClientePK servicoClientePK) {
		this.servicoClientePK = servicoClientePK;
	}

	public ServicoCliente(final ServicoClientePK servicoClientePK, final Date dataInicio, final Date dataFim,
			final double valor) {
		this.servicoClientePK = servicoClientePK;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valor = valor;
	}

	/**
	 * @return the servicoClientePK
	 */
	public ServicoClientePK getServicoClientePK() {
		return servicoClientePK;
	}

	/**
	 * @param servicoClientePK
	 *            the servicoClientePK to set
	 */
	public void setServicoClientePK(final ServicoClientePK servicoClientePK) {
		this.servicoClientePK = servicoClientePK;
	}

	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio
	 *            the dataInicio to set
	 */
	public void setDataInicio(final Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the dataFim
	 */
	public Date getDataFim() {
		return dataFim;
	}

	/**
	 * @param dataFim
	 *            the dataFim to set
	 */
	public void setDataFim(final Date dataFim) {
		this.dataFim = dataFim;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(final double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.servicoClientePK).hashCode();
	}

	@Override
	public boolean equals(final Object object) {
		if (!(object instanceof ServicoCliente)) {
			return false;
		}
		final ServicoCliente other = (ServicoCliente) object;

		return new EqualsBuilder().append(this.servicoClientePK, other.servicoClientePK).isEquals();
	}
}
