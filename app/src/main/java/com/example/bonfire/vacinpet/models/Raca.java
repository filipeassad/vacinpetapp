package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Raca {

    private Integer codigoraca;
    private String nomeraca;
    private Integer codigoesp;
    private String usualt;
    private Date datalt;

    public Raca() {
    }

    public Raca(Integer codigoraca, String nomeraca, Integer codigoesp, String usualt, Date datalt) {
        this.codigoraca = codigoraca;
        this.nomeraca = nomeraca;
        this.codigoesp = codigoesp;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigoraca() {
        return codigoraca;
    }

    public void setCodigoraca(Integer codigoraca) {
        this.codigoraca = codigoraca;
    }

    public String getNomeraca() {
        return nomeraca;
    }

    public void setNomeraca(String nomeraca) {
        this.nomeraca = nomeraca;
    }

    public Integer getCodigoesp() {
        return codigoesp;
    }

    public void setCodigoesp(Integer codigoesp) {
        this.codigoesp = codigoesp;
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
