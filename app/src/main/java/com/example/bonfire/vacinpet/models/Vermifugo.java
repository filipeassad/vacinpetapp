package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Vermifugo {

    private Integer codigovermi;
    private String nomevermi;
    private String usualt;
    private Date datalt;
    private String descricaovermi;
    private String especievermi;
    private Integer codigolab;

    public Vermifugo() {
    }

    public Vermifugo(Integer codigovermi, String nomevermi, String usualt, Date datalt, String descricaovermi, String especievermi, Integer codigolab) {
        this.codigovermi = codigovermi;
        this.nomevermi = nomevermi;
        this.usualt = usualt;
        this.datalt = datalt;
        this.descricaovermi = descricaovermi;
        this.especievermi = especievermi;
        this.codigolab = codigolab;
    }

    public Integer getCodigovermi() {
        return codigovermi;
    }

    public void setCodigovermi(Integer codigovermi) {
        this.codigovermi = codigovermi;
    }

    public String getNomevermi() {
        return nomevermi;
    }

    public void setNomevermi(String nomevermi) {
        this.nomevermi = nomevermi;
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

    public String getDescricaovermi() {
        return descricaovermi;
    }

    public void setDescricaovermi(String descricaovermi) {
        this.descricaovermi = descricaovermi;
    }

    public String getEspecievermi() {
        return especievermi;
    }

    public void setEspecievermi(String especievermi) {
        this.especievermi = especievermi;
    }

    public Integer getCodigolab() {
        return codigolab;
    }

    public void setCodigolab(Integer codigolab) {
        this.codigolab = codigolab;
    }
}
