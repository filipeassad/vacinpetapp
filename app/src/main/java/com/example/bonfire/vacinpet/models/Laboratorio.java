package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Laboratorio {

    private Integer codigolab;
    private String nomelab;
    private String usualt;
    private Date datalt;

    public Laboratorio() {
    }

    public Laboratorio(Integer codigolab, String nomelab, String usualt, Date datalt) {
        this.codigolab = codigolab;
        this.nomelab = nomelab;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigolab() {
        return codigolab;
    }

    public void setCodigolab(Integer codigolab) {
        this.codigolab = codigolab;
    }

    public String getNomelab() {
        return nomelab;
    }

    public void setNomelab(String nomelab) {
        this.nomelab = nomelab;
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
