package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class AnimalUsu {

    private Integer codigoaniusu;
    private Integer codigousu;
    private Integer codigoani;
    private String usualt;
    private Date datalt;

    private Usuario usuario;
    private Animal animal;

    public AnimalUsu() {
    }

    public AnimalUsu(Integer codigoaniusu, Integer codigousu, Integer codigoani, String usualt, Date datalt) {
        this.codigoaniusu = codigoaniusu;
        this.codigousu = codigousu;
        this.codigoani = codigoani;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigoaniusu() {
        return codigoaniusu;
    }

    public void setCodigoaniusu(Integer codigoaniusu) {
        this.codigoaniusu = codigoaniusu;
    }

    public Integer getCodigousu() {
        return codigousu;
    }

    public void setCodigousu(Integer codigousu) {
        this.codigousu = codigousu;
    }

    public Integer getCodigoani() {
        return codigoani;
    }

    public void setCodigoani(Integer codigoani) {
        this.codigoani = codigoani;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
