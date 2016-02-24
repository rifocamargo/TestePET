/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecom.testepet.bean;

import com.lecom.testepet.entity.Perfil;
import java.io.Serializable;

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

    public PerfilBean(Integer idPerfil, String nomePerfil, String descricaoPerfil, double pctDescontoPerfil) {
        this.idPerfil = idPerfil;
        this.nomePerfil = nomePerfil;
        this.descricaoPerfil = descricaoPerfil;
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public void setDescricaoPerfil(String descricaoPerfil) {
        this.descricaoPerfil = descricaoPerfil;
    }

    public void setPctDescontoPerfil(double pctDescontoPerfil) {
        this.pctDescontoPerfil = pctDescontoPerfil;
    }

    public Perfil buildEntity() {
        return new Perfil(idPerfil, nomePerfil, descricaoPerfil, pctDescontoPerfil);
    }

}
