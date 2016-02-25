/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import java.io.Serializable;

import com.lecom.testepet.entity.Perfil;

/**
 *
 * @author Ricardo
 */
public class PerfilBean implements Serializable {

    private static final long serialVersionUID = -8807394181939157798L;

    private Integer idPerfil;

    private String nomePerfil;

    private String descricaoPerfil;

    private double pctDescontoPerfil;

    public PerfilBean() {
    }

    public PerfilBean(final Integer idPerfil, final String nomePerfil, final String descricaoPerfil, final double pctDescontoPerfil) {
        this.idPerfil = idPerfil;
        this.nomePerfil = nomePerfil;
        this.descricaoPerfil = descricaoPerfil;
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    public void setIdPerfil(final Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public void setNomePerfil(final String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public void setDescricaoPerfil(final String descricaoPerfil) {
        this.descricaoPerfil = descricaoPerfil;
    }

    public void setPctDescontoPerfil(final double pctDescontoPerfil) {
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public String getDescricaoPerfil() {
        return descricaoPerfil;
    }

    public double getPctDescontoPerfil() {
        return pctDescontoPerfil;
    }

    public Perfil buildEntity() {
        return new Perfil(idPerfil, nomePerfil, descricaoPerfil, pctDescontoPerfil);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PerfilBean [idPerfil=" + idPerfil + ", nomePerfil=" + nomePerfil + ", descricaoPerfil="
                + descricaoPerfil + ", pctDescontoPerfil=" + pctDescontoPerfil + "]";
    }

}
