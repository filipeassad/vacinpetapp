package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Pelagem {

    private Integer codigopel;
    private String nomepel;
    private String usualt;
    private Date datalt;

    public Pelagem() {
    }

    public Pelagem(Integer codigopel, String nomepel, String usualt, Date datalt) {
        this.codigopel = codigopel;
        this.nomepel = nomepel;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigopel() {
        return codigopel;
    }

    public void setCodigopel(Integer codigopel) {
        this.codigopel = codigopel;
    }

    public String getNomepel() {
        return nomepel;
    }

    public void setNomepel(String nomepel) {
        this.nomepel = nomepel;
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
}
