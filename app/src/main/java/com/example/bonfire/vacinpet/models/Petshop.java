package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Petshop {

    private Integer codigopet;
    private String nomepet;
    private String usualt;
    private Date datalt;
    private String cnpjpet;

    public Petshop() {
    }

    public Petshop(Integer codigopet, String nomepet, String usualt, Date datalt, String cnpjpet) {
        this.codigopet = codigopet;
        this.nomepet = nomepet;
        this.usualt = usualt;
        this.datalt = datalt;
        this.cnpjpet = cnpjpet;
    }

    public Integer getCodigopet() {
        return codigopet;
    }

    public void setCodigopet(Integer codigopet) {
        this.codigopet = codigopet;
    }

    public String getNomepet() {
        return nomepet;
    }

    public void setNomepet(String nomepet) {
        this.nomepet = nomepet;
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

    public String getCnpjpet() {
        return cnpjpet;
    }

    public void setCnpjpet(String cnpjpet) {
        this.cnpjpet = cnpjpet;
    }
}
