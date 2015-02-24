/*

 */
package com.sample.biblio.model.marche;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_moa")
public class TabMoa extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_moa")
    private String idMoa;
    @Size(max = 100)
    @Column(name = "nom_moa")
    private String nomMoa;
    @Size(max = 15)
    @Column(name = "sigle_moa")
    private String sigleMoa;
    @Size(max = 30)
    @Column(name = "siege_moa")
    private String siegeMoa;
    @Size(max = 10)
    @Column(name = "logo_moa")
    private String logoMoa;
    @Size(max = 20)
    @Column(name = "site_web_moa")
    private String siteWebMoa;
    @Size(max = 30)
    @Column(name = "tel_moa")
    private String telMoa;
    @Size(max = 30)
    @Column(name = "bp_moa")
    private String bpMoa;
    @Size(max = 30)
    @Column(name = "fax_moa")
    private String faxMoa;

    public TabMoa() {
    }

    public TabMoa(String idMoa) {
        this.idMoa = idMoa;
    }

    public String getIdMoa() {
        return idMoa;
    }

    public void setIdMoa(String idMoa) {
        this.idMoa = idMoa;
    }

    public String getNomMoa() {
        return nomMoa;
    }

    public void setNomMoa(String nomMoa) {
        this.nomMoa = nomMoa;
    }

    public String getSigleMoa() {
        return sigleMoa;
    }

    public void setSigleMoa(String sigleMoa) {
        this.sigleMoa = sigleMoa;
    }

    public String getSiegeMoa() {
        return siegeMoa;
    }

    public void setSiegeMoa(String siegeMoa) {
        this.siegeMoa = siegeMoa;
    }

    public String getLogoMoa() {
        return logoMoa;
    }

    public void setLogoMoa(String logoMoa) {
        this.logoMoa = logoMoa;
    }

    public String getSiteWebMoa() {
        return siteWebMoa;
    }

    public void setSiteWebMoa(String siteWebMoa) {
        this.siteWebMoa = siteWebMoa;
    }

    public String getTelMoa() {
        return telMoa;
    }

    public void setTelMoa(String telMoa) {
        this.telMoa = telMoa;
    }

    public String getBpMoa() {
        return bpMoa;
    }

    public void setBpMoa(String bpMoa) {
        this.bpMoa = bpMoa;
    }

    public String getFaxMoa() {
        return faxMoa;
    }

    public void setFaxMoa(String faxMoa) {
        this.faxMoa = faxMoa;
    }

}
