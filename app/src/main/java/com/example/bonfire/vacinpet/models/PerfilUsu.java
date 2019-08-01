package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class PerfilUsu {

    private Integer codigoperfilusu;
    private Integer codigoperfil;
    private Integer codigousu;
    private Integer codigopet;
    private String usualt;
    private Date datalt;

    public PerfilUsu() {
    }

    public PerfilUsu(Integer codigoperfilusu, Integer codigoperfil, Integer codigousu, Integer codigopet, String usualt, Date datalt) {
        this.codigoperfilusu = codigoperfilusu;
        this.codigoperfil = codigoperfil;
        this.codigousu = codigousu;
        this.codigopet = codigopet;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigoperfilusu() {
        return codigoperfilusu;
    }

    public void setCodigoperfilusu(Integer codigoperfilusu) {
        this.codigoperfilusu = codigoperfilusu;
    }

    public Integer getCodigoperfil() {
        return codigoperfil;
    }

    public void setCodigoperfil(Integer codigoperfil) {
        this.codigoperfil = codigoperfil;
    }

    public Integer getCodigousu() {
        return codigousu;
    }

    public void setCodigousu(Integer codigousu) {
        this.codigousu = codigousu;
    }

    public Integer getCodigopet() {
        return codigopet;
    }

    public void setCodigopet(Integer codigopet) {
        this.codigopet = codigopet;
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
