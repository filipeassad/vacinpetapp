package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Perfil {

    private Integer codigoperfil;
    private String nomeperfil;
    private String usualt;
    private Date datalt;

    public Perfil() {
    }

    public Perfil(Integer codigoperfil, String nomeperfil, String usualt, Date datalt) {
        this.codigoperfil = codigoperfil;
        this.nomeperfil = nomeperfil;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigoperfil() {
        return codigoperfil;
    }

    public void setCodigoperfil(Integer codigoperfil) {
        this.codigoperfil = codigoperfil;
    }

    public String getNomeperfil() {
        return nomeperfil;
    }

    public void setNomeperfil(String nomeperfil) {
        this.nomeperfil = nomeperfil;
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
