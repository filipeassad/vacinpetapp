package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Usuario {

    private Integer codigousu;
    private String nomeusu;
    private String emailusu;
    private String cpfusu;
    private String veterinariousu;
    private String numcrmvusu;
    private String estadocrmvusu;
    private String logusu;
    private String usualt;
    private Date datalt;
    private String senhausu;

    public Usuario() {
    }

    public Usuario(Integer codigousu, String nomeusu, String emailusu, String cpfusu, String veterinariousu, String numcrmvusu, String estadocrmvusu, String logusu, String usualt, Date datalt, String senhausu) {
        this.codigousu = codigousu;
        this.nomeusu = nomeusu;
        this.emailusu = emailusu;
        this.cpfusu = cpfusu;
        this.veterinariousu = veterinariousu;
        this.numcrmvusu = numcrmvusu;
        this.estadocrmvusu = estadocrmvusu;
        this.logusu = logusu;
        this.usualt = usualt;
        this.datalt = datalt;
        this.senhausu = senhausu;
    }

    public Integer getCodigousu() {
        return codigousu;
    }

    public void setCodigousu(Integer codigousu) {
        this.codigousu = codigousu;
    }

    public String getNomeusu() {
        return nomeusu;
    }

    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }

    public String getEmailusu() {
        return emailusu;
    }

    public void setEmailusu(String emailusu) {
        this.emailusu = emailusu;
    }

    public String getCpfusu() {
        return cpfusu;
    }

    public void setCpfusu(String cpfusu) {
        this.cpfusu = cpfusu;
    }

    public String getVeterinariousu() {
        return veterinariousu;
    }

    public void setVeterinariousu(String veterinariousu) {
        this.veterinariousu = veterinariousu;
    }

    public String getNumcrmvusu() {
        return numcrmvusu;
    }

    public void setNumcrmvusu(String numcrmvusu) {
        this.numcrmvusu = numcrmvusu;
    }

    public String getEstadocrmvusu() {
        return estadocrmvusu;
    }

    public void setEstadocrmvusu(String estadocrmvusu) {
        this.estadocrmvusu = estadocrmvusu;
    }

    public String getLogusu() {
        return logusu;
    }

    public void setLogusu(String logusu) {
        this.logusu = logusu;
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

    public String getSenhausu() {
        return senhausu;
    }

    public void setSenhausu(String senhausu) {
        this.senhausu = senhausu;
    }
}
