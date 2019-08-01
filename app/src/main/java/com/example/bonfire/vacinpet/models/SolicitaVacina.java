package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class SolicitaVacina {

    private Integer codigosolvac;
    private String nomesolvac;
    private String descricaosolvac;
    private Integer codigolab;
    private String especievacinasolvac;
    private String atendidasolvac;
    private String usualt;
    private Date datalt;

    public SolicitaVacina() {
    }

    public SolicitaVacina(Integer codigosolvac, String nomesolvac, String descricaosolvac, Integer codigolab, String especievacinasolvac, String atendidasolvac, String usualt, Date datalt) {
        this.codigosolvac = codigosolvac;
        this.nomesolvac = nomesolvac;
        this.descricaosolvac = descricaosolvac;
        this.codigolab = codigolab;
        this.especievacinasolvac = especievacinasolvac;
        this.atendidasolvac = atendidasolvac;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigosolvac() {
        return codigosolvac;
    }

    public void setCodigosolvac(Integer codigosolvac) {
        this.codigosolvac = codigosolvac;
    }

    public String getNomesolvac() {
        return nomesolvac;
    }

    public void setNomesolvac(String nomesolvac) {
        this.nomesolvac = nomesolvac;
    }

    public String getDescricaosolvac() {
        return descricaosolvac;
    }

    public void setDescricaosolvac(String descricaosolvac) {
        this.descricaosolvac = descricaosolvac;
    }

    public Integer getCodigolab() {
        return codigolab;
    }

    public void setCodigolab(Integer codigolab) {
        this.codigolab = codigolab;
    }

    public String getEspecievacinasolvac() {
        return especievacinasolvac;
    }

    public void setEspecievacinasolvac(String especievacinasolvac) {
        this.especievacinasolvac = especievacinasolvac;
    }

    public String getAtendidasolvac() {
        return atendidasolvac;
    }

    public void setAtendidasolvac(String atendidasolvac) {
        this.atendidasolvac = atendidasolvac;
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
