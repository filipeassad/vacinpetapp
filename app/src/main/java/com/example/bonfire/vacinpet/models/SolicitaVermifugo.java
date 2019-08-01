package com.example.bonfire.vacinpet.models;

import java.util.Date;

/**
 * Created by hugo on 15/04/16.
 */
public class SolicitaVermifugo {

    private Integer codigosolvermi;
    private String nomesolvermi;
    private String descricaosolvermi;
    private Integer codigolab;
    private String especievermisolvermi;
    private String atendidasolvermi;
    private String usualt;
    private Date datalt;

    public SolicitaVermifugo() {
    }

    public SolicitaVermifugo(Integer codigosolvermi, String nomesolvermi, String descricaosolvermi, Integer codigolab, String especievermisolvermi, String atendidasolvermi, String usualt, Date datalt) {
        this.codigosolvermi = codigosolvermi;
        this.nomesolvermi = nomesolvermi;
        this.descricaosolvermi = descricaosolvermi;
        this.codigolab = codigolab;
        this.especievermisolvermi = especievermisolvermi;
        this.atendidasolvermi = atendidasolvermi;
        this.usualt = usualt;
        this.datalt = datalt;
    }

    public Integer getCodigosolvermi() {
        return codigosolvermi;
    }

    public void setCodigosolvermi(Integer codigosolvermi) {
        this.codigosolvermi = codigosolvermi;
    }

    public String getNomesolvermi() {
        return nomesolvermi;
    }

    public void setNomesolvermi(String nomesolvermi) {
        this.nomesolvermi = nomesolvermi;
    }

    public String getDescricaosolvermi() {
        return descricaosolvermi;
    }

    public void setDescricaosolvermi(String descricaosolvermi) {
        this.descricaosolvermi = descricaosolvermi;
    }

    public Integer getCodigolab() {
        return codigolab;
    }

    public void setCodigolab(Integer codigolab) {
        this.codigolab = codigolab;
    }

    public String getEspecievermisolvermi() {
        return especievermisolvermi;
    }

    public void setEspecievermisolvermi(String especievermisolvermi) {
        this.especievermisolvermi = especievermisolvermi;
    }

    public String getAtendidasolvermi() {
        return atendidasolvermi;
    }

    public void setAtendidasolvermi(String atendidasolvermi) {
        this.atendidasolvermi = atendidasolvermi;
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
