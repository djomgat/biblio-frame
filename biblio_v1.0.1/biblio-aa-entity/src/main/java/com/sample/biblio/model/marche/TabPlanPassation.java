/*

 */
package com.sample.biblio.model.marche;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_plan_passation")
public class TabPlanPassation extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TabPlanPassationPK tabPlanPassationPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_lancement")
    @Temporal(TemporalType.DATE)
    private Date dateLancement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_attribution")
    @Temporal(TemporalType.DATE)
    private Date dateAttribution;
    @Column(name = "date_demarrage")
    @Temporal(TemporalType.DATE)
    private Date dateDemarrage;
    @Column(name = "date_reception")
    @Temporal(TemporalType.DATE)
    private Date dateReception;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_mod")
    @Temporal(TemporalType.DATE)
    private Date dateMod;

    public TabPlanPassation() {
    }

    public TabPlanPassation(TabPlanPassationPK tabPlanPassationPK) {
        this.tabPlanPassationPK = tabPlanPassationPK;
    }

    public TabPlanPassation(TabPlanPassationPK tabPlanPassationPK, Date dateLancement, Date dateAttribution, Date dateMod) {
        this.tabPlanPassationPK = tabPlanPassationPK;
        this.dateLancement = dateLancement;
        this.dateAttribution = dateAttribution;
        this.dateMod = dateMod;
    }

    public TabPlanPassation(String exercice, String idOperation) {
        this.tabPlanPassationPK = new TabPlanPassationPK(exercice, idOperation);
    }

    public TabPlanPassationPK getTabPlanPassationPK() {
        return tabPlanPassationPK;
    }

    public void setTabPlanPassationPK(TabPlanPassationPK tabPlanPassationPK) {
        this.tabPlanPassationPK = tabPlanPassationPK;
    }

    public Date getDateLancement() {
        return dateLancement;
    }

    public void setDateLancement(Date dateLancement) {
        this.dateLancement = dateLancement;
    }

    public Date getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(Date dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public Date getDateDemarrage() {
        return dateDemarrage;
    }

    public void setDateDemarrage(Date dateDemarrage) {
        this.dateDemarrage = dateDemarrage;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Date getDateMod() {
        return dateMod;
    }

    public void setDateMod(Date dateMod) {
        this.dateMod = dateMod;
    }
    
}