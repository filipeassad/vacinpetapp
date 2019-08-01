package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Telefone {

    private Integer codigousu;
    private Integer codigopet;
    private String telefonetel;
    private String tipotel;
    private String usualt;
    private Date datalt;
    private Integer codigotel;

    public Telefone() {
    }

    public Telefone(Integer codigousu, Integer codigopet, String telefonetel, String tipotel, String usualt, Date datalt, Integer codigotel) {
        this.codigousu = codigousu;
        this.codigopet = codigopet;
        this.telefonetel = telefonetel;
        this.tipotel = tipotel;
        this.usualt = usualt;
        this.datalt = datalt;
        this.codigotel = codigotel;
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

    public String getTelefonetel() {
        return telefonetel;
    }

    public void setTelefonetel(String telefonetel) {
        this.telefonetel = telefonetel;
    }

    public String getTipotel() {
        return tipotel;
    }

    public void setTipotel(String tipotel) {
        this.tipotel = tipotel;
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

    public Integer getCodigotel() {
        return codigotel;
    }

    public void setCodigotel(Integer codigotel) {
        this.codigotel = codigotel;
    }
}
