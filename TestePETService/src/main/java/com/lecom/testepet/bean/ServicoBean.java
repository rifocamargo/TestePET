/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import com.lecom.testepet.entity.Servico;
import java.io.Serializable;

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

    public ServicoBean(Integer idServico) {
        this.idServico = idServico;
    }

    public ServicoBean(String nomeServico, String descricaoServico) {
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
    }

    public ServicoBean(Integer idServico, String nomeServico, String descricaoServico) {
        this(idServico);
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
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

}
