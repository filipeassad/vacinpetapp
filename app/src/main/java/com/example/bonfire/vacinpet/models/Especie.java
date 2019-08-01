package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Especie {

    private Integer codigoesp;
    private String nomeesp;
    private String usualt;
    private Date datalt;

    public Especie() {
    }

    public Especie(Integer codigoesp, String nomeesp, String usualt, Date datalt) {
        this.codigoesp = codigoesp;
        this.nomeesp = nomeesp;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigoesp() {
        return codigoesp;
    }

    public void setCodigoesp(Integer codigoesp) {
        this.codigoesp = codigoesp;
    }

    public String getNomeesp() {
        return nomeesp;
    }

    public void setNomeesp(String nomeesp) {
        this.nomeesp = nomeesp;
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
