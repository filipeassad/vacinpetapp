package com.example.bonfire.vacinpet.models;

import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class Vacinacao {

    private Integer codigovacin;
    private Date datavacin;
    private Integer codigousuvet;
    private Double pesovacin;
    private String statusvacin;
    private Date dtproxvacin;
    private Integer codigousuprop;
    private Integer codigoani;
    private Integer codigovacina;
    private Integer codigovermi;
    private String usualt;
    private Date datalt;
    private String lotevacin;
    private String fabricacaovacin;
    private Date vencimentovacin;

    private Vacina vacina;
    private Vermifugo vermifugo;

    public Vacinacao() {
    }

    public Vacinacao(Integer codigovacin, Date datavacin, Integer codigousuvet, Double pesovacin, String statusvacin, Date dtproxvacin, Integer codigousuprop, Integer codigoani, Integer codigovacina, Integer codigovermi, String usualt, Date datalt, String lotevacin, String fabricacaovacin, Date vencimentovacin) {
        this.codigovacin = codigovacin;
        this.datavacin = datavacin;
        this.codigousuvet = codigousuvet;
        this.pesovacin = pesovacin;
        this.statusvacin = statusvacin;
        this.dtproxvacin = dtproxvacin;
        this.codigousuprop = codigousuprop;
        this.codigoani = codigoani;
        this.codigovacina = codigovacina;
        this.codigovermi = codigovermi;
        this.usualt = usualt;
        this.datalt = datalt;
        this.lotevacin = lotevacin;
        this.fabricacaovacin = fabricacaovacin;
        this.vencimentovacin = vencimentovacin;
    }

    public Integer getCodigovacin() {
        return codigovacin;
    }

    public void setCodigovacin(Integer codigovacin) {
        this.codigovacin = codigovacin;
    }

    public Date getDatavacin() {
        return datavacin;
    }

    public void setDatavacin(Date datavacin) {
        this.datavacin = datavacin;
    }

    public Integer getCodigousuvet() {
        return codigousuvet;
    }

    public void setCodigousuvet(Integer codigousuvet) {
        this.codigousuvet = codigousuvet;
    }

    public Double getPesovacin() {
        return pesovacin;
    }

    public void setPesovacin(Double pesovacin) {
        this.pesovacin = pesovacin;
    }

    public String getStatusvacin() {
        return statusvacin;
    }

    public void setStatusvacin(String statusvacin) {
        this.statusvacin = statusvacin;
    }

    public Date getDtproxvacin() {
        return dtproxvacin;
    }

    public void setDtproxvacin(Date dtproxvacin) {
        this.dtproxvacin = dtproxvacin;
    }

    public Integer getCodigousuprop() {
        return codigousuprop;
    }

    public void setCodigousuprop(Integer codigousuprop) {
        this.codigousuprop = codigousuprop;
    }

    public Integer getCodigoani() {
        return codigoani;
    }

    public void setCodigoani(Integer codigoani) {
        this.codigoani = codigoani;
    }

    public Integer getCodigovacina() {
        return codigovacina;
    }

    public void setCodigovacina(Integer codigovacina) {
        this.codigovacina = codigovacina;
    }

    public Integer getCodigovermi() {
        return codigovermi;
    }

    public void setCodigovermi(Integer codigovermi) {
        this.codigovermi = codigovermi;
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

    public String getLotevacin() {
        return lotevacin;
    }

    public void setLotevacin(String lotevacin) {
        this.lotevacin = lotevacin;
    }

    public String getFabricacaovacin() {
        return fabricacaovacin;
    }

    public void setFabricacaovacin(String fabricacaovacin) {
        this.fabricacaovacin = fabricacaovacin;
    }

    public Date getVencimentovacin() {
        return vencimentovacin;
    }

    public void setVencimentovacin(Date vencimentovacin) {
        this.vencimentovacin = vencimentovacin;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public String dataVacinaFormat(){
        return MetodosBasicos.DateToString(datavacin);
    }

    public String dataProxVacinaFormat(){
        return MetodosBasicos.DateToString(dtproxvacin);
    }

    public Vermifugo getVermifugo() {
        return vermifugo;
    }

    public void setVermifugo(Vermifugo vermifugo) {
        this.vermifugo = vermifugo;
    }
}
