package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class PetUsu {

    private Integer codigopetusu;
    private Integer codigopet;
    private Integer codigousu;
    private String usualt;
    private Date datalt;
    private String tipopetusu;

    public PetUsu() {
    }

    public PetUsu(Integer codigopetusu, Integer codigopet, Integer codigousu, String usualt, Date datalt, String tipopetusu) {
        this.codigopetusu = codigopetusu;
        this.codigopet = codigopet;
        this.codigousu = codigousu;
        this.usualt = usualt;
        this.datalt = datalt;
        this.tipopetusu = tipopetusu;
    }

    public Integer getCodigopetusu() {
        return codigopetusu;
    }

    public void setCodigopetusu(Integer codigopetusu) {
        this.codigopetusu = codigopetusu;
    }

    public Integer getCodigopet() {
        return codigopet;
    }

    public void setCodigopet(Integer codigopet) {
        this.codigopet = codigopet;
    }

    public Integer getCodigousu() {
        return codigousu;
    }

    public void setCodigousu(Integer codigousu) {
        this.codigousu = codigousu;
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

    public String getTipopetusu() {
        return tipopetusu;
    }

    public void setTipopetusu(String tipopetusu) {
        this.tipopetusu = tipopetusu;
    }
}
