/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import java.io.Serializable;

import com.lecom.testepet.entity.Servico;

/**
 *
 * @author Ricardo
 */
public class ServicoBean implements Serializable {

    private static final long serialVersionUID = -8807394181939157798L;

    private Integer idServico;

    private String nomeServico;

    private String descricaoServico;

    public ServicoBean() {
    }

    public ServicoBean(final Integer idServico) {
        this.idServico = idServico;
    }

    public ServicoBean(final String nomeServico, final String descricaoServico) {
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
    }

    public ServicoBean(final Integer idServico, final String nomeServico, final String descricaoServico) {
        this(idServico);
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(final Integer idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(final String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(final String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Servico buildEntity() {
        return new Servico(nomeServico, descricaoServico);
    }

    public ServicoBean build(final Servico servico) {
        this.idServico = servico.getIdServico();
        this.nomeServico = servico.getNomeServico();
        this.descricaoServico = servico.getDescricaoServico();
        return this;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServicoBean [idServico=" + idServico + ", nomeServico=" + nomeServico + ", descricaoServico="
				+ descricaoServico + "]";
	}

}
