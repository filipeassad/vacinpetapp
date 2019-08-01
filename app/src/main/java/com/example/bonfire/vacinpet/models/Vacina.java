package com.example.bonfire.vacinpet.models;

import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Vacina {

    private Integer codigovacina;
    private String nomevacina;
    private String usualt;
    private Date datalt;
    private String descricaovaci;
    private Integer codigolab;
    private String especievacina;

    private Laboratorio laboratorio;

    public Vacina() {
    }

    public Vacina(Integer codigovacina, String nomevacina, String usualt, Date datalt, String descricaovaci, Integer codigolab, String especievacina) {
        this.codigovacina = codigovacina;
        this.nomevacina = nomevacina;
        this.usualt = usualt;
        this.datalt = datalt;
        this.descricaovaci = descricaovaci;
        this.codigolab = codigolab;
        this.especievacina = especievacina;
    }

    public Integer getCodigovacina() {
        return codigovacina;
    }

    public void setCodigovacina(Integer codigovacina) {
        this.codigovacina = codigovacina;
    }

    public String getNomevacina() {
        return nomevacina;
    }

    public void setNomevacina(String nomevacina) {
        this.nomevacina = nomevacina;
    }

    public String getUsualt() {
        return usualt;
    }

    public void setUsualt(String usualt) {
        this.usualt = usualt;
    }

    public Date getDatalt() {
        return datalt;
    }

    public void setDatalt(Date datalt) {
        this.datalt = datalt;
    }

    public String getDescricaovaci() {
        return descricaovaci;
    }

    public void setDescricaovaci(String descricaovaci) {
        this.descricaovaci = descricaovaci;
    }

    public Integer getCodigolab() {
        return codigolab;
    }

    public void setCodigolab(Integer codigolab) {
        this.codigolab = codigolab;
    }

    public String getEspecievacina() {
        return especievacina;
    }

    public void setEspecievacina(String especievacina) {
        this.especievacina = especievacina;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
