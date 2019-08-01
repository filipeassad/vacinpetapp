package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class PerfilTela {

    private Integer codigopertela;
    private Integer codigoperfil;
    private Integer codigotela;
    private String incluir;
    private String excluir;
    private String alterar;
    private String consultar;
    private String usualt;
    private Date datalt;

    public PerfilTela() {
    }

    public PerfilTela(Integer codigopertela, Integer codigoperfil, Integer codigotela, String incluir, String excluir, String alterar, String consultar, String usualt, Date datalt) {
        this.codigopertela = codigopertela;
        this.codigoperfil = codigoperfil;
        this.codigotela = codigotela;
        this.incluir = incluir;
        this.excluir = excluir;
        this.alterar = alterar;
        this.consultar = consultar;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigopertela() {
        return codigopertela;
    }

    public void setCodigopertela(Integer codigopertela) {
        this.codigopertela = codigopertela;
    }

    public Integer getCodigoperfil() {
        return codigoperfil;
    }

    public void setCodigoperfil(Integer codigoperfil) {
        this.codigoperfil = codigoperfil;
    }

    public Integer getCodigotela() {
        return codigotela;
    }

    public void setCodigotela(Integer codigotela) {
        this.codigotela = codigotela;
    }

    public String getIncluir() {
        return incluir;
    }

    public void setIncluir(String incluir) {
        this.incluir = incluir;
    }

    public String getExcluir() {
        return excluir;
    }

    public void setExcluir(String excluir) {
        this.excluir = excluir;
    }

    public String getAlterar() {
        return alterar;
    }

    public void setAlterar(String alterar) {
        this.alterar = alterar;
    }

    public String getConsultar() {
        return consultar;
    }

    public void setConsultar(String consultar) {
        this.consultar = consultar;
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
