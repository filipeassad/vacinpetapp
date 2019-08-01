package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Tela {

    private Integer codigotela;
    private String nometela;
    private String usualt;
    private Date datalt;

    public Tela() {
    }

    public Tela(Integer codigotela, String nometela, String usualt, Date datalt) {
        this.codigotela = codigotela;
        this.nometela = nometela;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigotela() {
        return codigotela;
    }

    public void setCodigotela(Integer codigotela) {
        this.codigotela = codigotela;
    }

    public String getNometela() {
        return nometela;
    }

    public void setNometela(String nometela) {
        this.nometela = nometela;
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
