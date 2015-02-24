/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.biblio.model.marche;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tab_attribution")
@XmlRootElement
public class TabAttribution extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TabAttributionPK tabattributionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "numero_lot")
    private String numeroLot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_attr_lot")
    private Double montantAttrLot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "delai_exec_lot")
    private String delaiExecLot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "lieu_exec_lot")
    private String lieuExecLot;
    @Size(max = 20)
    @Column(name = "code_nature_prestation")
    private String codeNaturePrestation;
    @JoinColumn(name = "id_societe", referencedColumnName = "id_societe", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TabSociete tabsociete;

    public TabAttribution() {
    }

    public TabAttribution(TabAttributionPK tabattributionPK) {
        this.tabattributionPK = tabattributionPK;
    }

    public TabAttribution(TabAttributionPK tabattributionPK, String numeroLot, String delaiExecLot, String lieuExecLot) {
        this.tabattributionPK = tabattributionPK;
        this.numeroLot = numeroLot;
        this.delaiExecLot = delaiExecLot;
        this.lieuExecLot = lieuExecLot;
    }

    public TabAttribution(String idLot, String idSociete) {
        this.tabattributionPK = new TabAttributionPK(idLot, idSociete);
    }

    public TabAttributionPK getTabattributionPK() {
        return tabattributionPK;
    }

    public void setTabattributionPK(TabAttributionPK tabattributionPK) {
        this.tabattributionPK = tabattributionPK;
    }

    public String getNumeroLot() {
        return numeroLot;
    }

    public void setNumeroLot(String numeroLot) {
        this.numeroLot = numeroLot;
    }

    public Double getMontantAttrLot() {
        return montantAttrLot;
    }

    public void setMontantAttrLot(Double montantAttrLot) {
        this.montantAttrLot = montantAttrLot;
    }

    public String getDelaiExecLot() {
        return delaiExecLot;
    }

    public void setDelaiExecLot(String delaiExecLot) {
        this.delaiExecLot = delaiExecLot;
    }

    public String getLieuExecLot() {
        return lieuExecLot;
    }

    public void setLieuExecLot(String lieuExecLot) {
        this.lieuExecLot = lieuExecLot;
    }

    public String getCodeNaturePrestation() {
        return codeNaturePrestation;
    }

    public void setCodeNaturePrestation(String codeNaturePrestation) {
        this.codeNaturePrestation = codeNaturePrestation;
    }

    public TabSociete getTabsociete() {
        return tabsociete;
    }

    public void setTabsociete(TabSociete tabsociete) {
        this.tabsociete = tabsociete;
    }

}