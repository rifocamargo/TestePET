/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepetdao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.lecom.testepetdao.entity.pk.ClienteServicoPK;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "cliente_servico")
public class ClienteServico implements Serializable {

	private static final long serialVersionUID = 8386035898841065567L;

	@EmbeddedId
	protected ClienteServicoPK clienteServicoPK;

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

	/**
	 * Default Constructor
	 */
	public ClienteServico() {
	}

	/**
	 * @param clienteServicoPK
	 */
	public ClienteServico(final ClienteServicoPK clienteServicoPK) {
		this.clienteServicoPK = clienteServicoPK;
	}

	/**
	 * @param clienteServicoPK
	 * @param dataInicio
	 * @param dataFim
	 * @param valor
	 */
	public ClienteServico(final ClienteServicoPK clienteServicoPK, final Date dataInicio, final Date dataFim,
			final double valor) {
		this(clienteServicoPK);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valor = valor;
	}

	/**
	 * @return the clienteServicoPK
	 */
	public ClienteServicoPK getClienteServicoPK() {
		return clienteServicoPK;
	}

	/**
	 * @param clienteServicoPK
	 *            the clienteServicoPK to set
	 */
	public void setClienteServicoPK(final ClienteServicoPK clienteServicoPK) {
		this.clienteServicoPK = clienteServicoPK;
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
		return new HashCodeBuilder().append(this.clienteServicoPK).hashCode();
	}

	@Override
	public boolean equals(final Object object) {
		if (!(object instanceof ClienteServico)) {
			return false;
		}
		final ClienteServico other = (ClienteServico) object;
		return new EqualsBuilder().append(this.clienteServicoPK, other.clienteServicoPK).isEquals();
	}

	@Override
	public String toString() {
		return "com.lecom.testepetdao.entity.ClienteServico[ clienteServicoPK=" + clienteServicoPK + " ]";
	}

}
