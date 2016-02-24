/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.entity.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.lecom.testepet.entity.Cliente;
import com.lecom.testepet.entity.Servico;

/**
 *
 * @author Ricardo
 */
@Embeddable
public class ServicoClientePK implements Serializable {

	private static final long serialVersionUID = 7206724053848590107L;

	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Cliente cliente;

	@JoinColumn(name = "id_servico", referencedColumnName = "id_servico", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Servico servico;

	/**
	 * Default Constructor
	 */
	public ServicoClientePK() {
	}

	/**
	 * @param cliente
	 * @param servico
	 */
	public ServicoClientePK(final Cliente cliente, final Servico servico) {
		this.cliente = cliente;
		this.servico = servico;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(final Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the servico
	 */
	public Servico getServico() {
		return servico;
	}

	/**
	 * @param servico
	 *            the servico to set
	 */
	public void setServico(final Servico servico) {
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.cliente).append(this.servico).hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ServicoClientePK other = (ServicoClientePK) obj;

		return new EqualsBuilder().append(this.cliente, other.cliente).append(this.servico, other.servico).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServicoClientePK [cliente=" + cliente + ", servico=" + servico + "]";
	}

}
