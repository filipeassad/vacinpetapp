package com.example.bonfire.vacinpet.models;

import android.graphics.Bitmap;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Animal {

    private Integer codigoani;
    private String nomeani;
    private Date dtnascani;
    private String sexoani;
    private Integer codigoraca;
    private Integer codigopel;
    private String usualt;
    private Date datalt;
    private Integer codigopet;
    private Date dataregani;
    private String urlImagem;
    private Bitmap imagem;

    public Animal() {
    }

    public Animal(String nomeani) {
        this.nomeani = nomeani;
    }

    public Animal(Integer codigoani, String nomeani, Date dtnascani, String sexoani, Integer codigoraca, Integer codigopel, String usualt, Date datalt, Integer codigopet, Date dataregani) {
        this.codigoani = codigoani;
        this.nomeani = nomeani;
        this.dtnascani = dtnascani;
        this.sexoani = sexoani;
        this.codigoraca = codigoraca;
        this.codigopel = codigopel;
        this.usualt = usualt;
        this.datalt = datalt;
        this.codigopet = codigopet;
        this.dataregani = dataregani;
    }

    public Integer getCodigoani() {
        return codigoani;
    }

    public void setCodigoani(Integer codigoani) {
        this.codigoani = codigoani;
    }

    public String getNomeani() {
        return nomeani;
    }

    public void setNomeani(String nomeani) {
        this.nomeani = nomeani;
    }

    public Date getDtnascani() {
        return dtnascani;
    }

    public void setDtnascani(Date dtnascani) {
        this.dtnascani = dtnascani;
    }

    public String getSexoani() {
        return sexoani;
    }

    public void setSexoani(String sexoani) {
        this.sexoani = sexoani;
    }

    public Integer getCodigoraca() {
        return codigoraca;
    }

    public void setCodigoraca(Integer codigoraca) {
        this.codigoraca = codigoraca;
    }

    public Integer getCodigopel() {
        return codigopel;
    }

    public void setCodigopel(Integer codigopel) {
        this.codigopel = codigopel;
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

    public Integer getCodigopet() {
        return codigopet;
    }

    public void setCodigopet(Integer codigopet) {
        this.codigopet = codigopet;
    }

    public Date getDataregani() {
        return dataregani;
    }

    public void setDataregani(Date dataregani) {
        this.dataregani = dataregani;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }
}
