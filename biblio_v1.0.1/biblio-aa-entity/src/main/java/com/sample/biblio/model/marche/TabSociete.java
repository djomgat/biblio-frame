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
import javax.xml.bind.annotation.XmlRootElement;

import com.sample.biblio.model.core.BiblioBaseEntity;
/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_societe")
@XmlRootElement
public class TabSociete extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_societe")
    private String idSociete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "num_contrib_societe")
    private String numContribSociete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "rc_societe")
    private String rcSociete;
    @Size(max = 100)
    @Column(name = "nom_societe")
    private String nomSociete;
    @Size(max = 10)
    @Column(name = "sigle_societe")
    private String sigleSociete;
    @Size(max = 30)
    @Column(name = "siege_social_societe")
    private String siegeSocialSociete;
    @Size(max = 10)
    @Column(name = "logo_societe")
    private String logoSociete;
    @Size(max = 20)
    @Column(name = "site_web_societe")
    private String siteWebSociete;
    @Size(max = 30)
    @Column(name = "tel_societe")
    private String telSociete;
    @Size(max = 30)
    @Column(name = "bp_societe")
    private String bpSociete;
    @Size(max = 30)
    @Column(name = "fax_societe")
    private String faxSociete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "num_compte_societe")
    private String numCompteSociete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "domicil_bancaire_societe")
    private String domicilBancaireSociete;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeTitulaireContrat")
//    private Collection<TabContrat> tabcontratCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tabsociete")
//    private Collection<TabAttribution> tabattributionCollection;

    public TabSociete() {
    }

    public TabSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    public TabSociete(String idSociete, String numContribSociete, String rcSociete, String numCompteSociete, String domicilBancaireSociete) {
        this.idSociete = idSociete;
        this.numContribSociete = numContribSociete;
        this.rcSociete = rcSociete;
        this.numCompteSociete = numCompteSociete;
        this.domicilBancaireSociete = domicilBancaireSociete;
    }

    public String getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    public String getNumContribSociete() {
        return numContribSociete;
    }

    public void setNumContribSociete(String numContribSociete) {
        this.numContribSociete = numContribSociete;
    }

    public String getRcSociete() {
        return rcSociete;
    }

    public void setRcSociete(String rcSociete) {
        this.rcSociete = rcSociete;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getSigleSociete() {
        return sigleSociete;
    }

    public void setSigleSociete(String sigleSociete) {
        this.sigleSociete = sigleSociete;
    }

    public String getSiegeSocialSociete() {
        return siegeSocialSociete;
    }

    public void setSiegeSocialSociete(String siegeSocialSociete) {
        this.siegeSocialSociete = siegeSocialSociete;
    }

    public String getLogoSociete() {
        return logoSociete;
    }

    public void setLogoSociete(String logoSociete) {
        this.logoSociete = logoSociete;
    }

    public String getSiteWebSociete() {
        return siteWebSociete;
    }

    public void setSiteWebSociete(String siteWebSociete) {
        this.siteWebSociete = siteWebSociete;
    }

    public String getTelSociete() {
        return telSociete;
    }

    public void setTelSociete(String telSociete) {
        this.telSociete = telSociete;
    }

    public String getBpSociete() {
        return bpSociete;
    }

    public void setBpSociete(String bpSociete) {
        this.bpSociete = bpSociete;
    }

    public String getFaxSociete() {
        return faxSociete;
    }

    public void setFaxSociete(String faxSociete) {
        this.faxSociete = faxSociete;
    }

    public String getNumCompteSociete() {
        return numCompteSociete;
    }

    public void setNumCompteSociete(String numCompteSociete) {
        this.numCompteSociete = numCompteSociete;
    }

    public String getDomicilBancaireSociete() {
        return domicilBancaireSociete;
    }

    public void setDomicilBancaireSociete(String domicilBancaireSociete) {
        this.domicilBancaireSociete = domicilBancaireSociete;
    }

}