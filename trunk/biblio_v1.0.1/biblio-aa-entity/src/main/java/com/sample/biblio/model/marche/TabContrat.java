/*
 */
package com.sample.biblio.model.marche;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_contrat")
@XmlRootElement
public class TabContrat extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_contrat")
    private String idContrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_lot")
    private String idLot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "num_contrat")
    private String numContrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "num_ao")
    private String numAo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "objet_contrat")
    private String objetContrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descr_contrat")
    private String descrContrat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_contrat")
    private int montantContrat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant_caution")
    private int montantCaution;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delai_exec_contrat")
    private int delaiExecContrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lieu_exec_contrat")
    private String lieuExecContrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "financ_contrat")
    private String financContrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "imput_contrat")
    private String imputContrat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delai_garanti_contrat")
    private int delaiGarantiContrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code_cs_contrat")
    private String codeCsContrat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code_ing_contrat")
    private String codeIngContrat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_souscr_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateSouscrContrat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_sign_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateSignContrat;
    @Column(name = "date_notif_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateNotifContrat;
    @Column(name = "date_enreg_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateEnregContrat;
    @Column(name = "date_recep_contrat")
    @Temporal(TemporalType.DATE)
    private Date dateRecepContrat;
    @JoinColumn(name = "code_nature_marche", referencedColumnName = "code_nature_marche")
    @ManyToOne(optional = false)
    private TabNatureMarche codeNatureMarche;
    @JoinColumn(name = "code_titulaire_contrat", referencedColumnName = "id_societe")
    @ManyToOne(optional = false)
    private TabSociete codeTitulaireContrat;

    public TabContrat() {
    }

    public TabContrat(String idContrat) {
        this.idContrat = idContrat;
    }

    public TabContrat(String idContrat, String idLot, String numContrat, String numAo, String objetContrat, String descrContrat, int montantContrat, int montantCaution, int delaiExecContrat, String lieuExecContrat, String financContrat, String imputContrat, int delaiGarantiContrat, String codeCsContrat, String codeIngContrat, Date dateSouscrContrat, Date dateSignContrat) {
        this.idContrat = idContrat;
        this.idLot = idLot;
        this.numContrat = numContrat;
        this.numAo = numAo;
        this.objetContrat = objetContrat;
        this.descrContrat = descrContrat;
        this.montantContrat = montantContrat;
        this.montantCaution = montantCaution;
        this.delaiExecContrat = delaiExecContrat;
        this.lieuExecContrat = lieuExecContrat;
        this.financContrat = financContrat;
        this.imputContrat = imputContrat;
        this.delaiGarantiContrat = delaiGarantiContrat;
        this.codeCsContrat = codeCsContrat;
        this.codeIngContrat = codeIngContrat;
        this.dateSouscrContrat = dateSouscrContrat;
        this.dateSignContrat = dateSignContrat;
    }

    public String getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(String idContrat) {
        this.idContrat = idContrat;
    }

    public String getIdLot() {
        return idLot;
    }

    public void setIdLot(String idLot) {
        this.idLot = idLot;
    }

    public String getNumContrat() {
        return numContrat;
    }

    public void setNumContrat(String numContrat) {
        this.numContrat = numContrat;
    }

    public String getNumAo() {
        return numAo;
    }

    public void setNumAo(String numAo) {
        this.numAo = numAo;
    }

    public String getObjetContrat() {
        return objetContrat;
    }

    public void setObjetContrat(String objetContrat) {
        this.objetContrat = objetContrat;
    }

    public String getDescrContrat() {
        return descrContrat;
    }

    public void setDescrContrat(String descrContrat) {
        this.descrContrat = descrContrat;
    }

    public int getMontantContrat() {
        return montantContrat;
    }

    public void setMontantContrat(int montantContrat) {
        this.montantContrat = montantContrat;
    }

    public int getMontantCaution() {
        return montantCaution;
    }

    public void setMontantCaution(int montantCaution) {
        this.montantCaution = montantCaution;
    }

    public int getDelaiExecContrat() {
        return delaiExecContrat;
    }

    public void setDelaiExecContrat(int delaiExecContrat) {
        this.delaiExecContrat = delaiExecContrat;
    }

    public String getLieuExecContrat() {
        return lieuExecContrat;
    }

    public void setLieuExecContrat(String lieuExecContrat) {
        this.lieuExecContrat = lieuExecContrat;
    }

    public String getFinancContrat() {
        return financContrat;
    }

    public void setFinancContrat(String financContrat) {
        this.financContrat = financContrat;
    }

    public String getImputContrat() {
        return imputContrat;
    }

    public void setImputContrat(String imputContrat) {
        this.imputContrat = imputContrat;
    }

    public int getDelaiGarantiContrat() {
        return delaiGarantiContrat;
    }

    public void setDelaiGarantiContrat(int delaiGarantiContrat) {
        this.delaiGarantiContrat = delaiGarantiContrat;
    }

    public String getCodeCsContrat() {
        return codeCsContrat;
    }

    public void setCodeCsContrat(String codeCsContrat) {
        this.codeCsContrat = codeCsContrat;
    }

    public String getCodeIngContrat() {
        return codeIngContrat;
    }

    public void setCodeIngContrat(String codeIngContrat) {
        this.codeIngContrat = codeIngContrat;
    }

    public Date getDateSouscrContrat() {
        return dateSouscrContrat;
    }

    public void setDateSouscrContrat(Date dateSouscrContrat) {
        this.dateSouscrContrat = dateSouscrContrat;
    }

    public Date getDateSignContrat() {
        return dateSignContrat;
    }

    public void setDateSignContrat(Date dateSignContrat) {
        this.dateSignContrat = dateSignContrat;
    }

    public Date getDateNotifContrat() {
        return dateNotifContrat;
    }

    public void setDateNotifContrat(Date dateNotifContrat) {
        this.dateNotifContrat = dateNotifContrat;
    }

    public Date getDateEnregContrat() {
        return dateEnregContrat;
    }

    public void setDateEnregContrat(Date dateEnregContrat) {
        this.dateEnregContrat = dateEnregContrat;
    }

    public Date getDateRecepContrat() {
        return dateRecepContrat;
    }

    public void setDateRecepContrat(Date dateRecepContrat) {
        this.dateRecepContrat = dateRecepContrat;
    }

    public TabNatureMarche getCodeNatureMarche() {
        return codeNatureMarche;
    }

    public void setCodeNatureMarche(TabNatureMarche codeNatureMarche) {
        this.codeNatureMarche = codeNatureMarche;
    }

    public TabSociete getCodeTitulaireContrat() {
        return codeTitulaireContrat;
    }

    public void setCodeTitulaireContrat(TabSociete codeTitulaireContrat) {
        this.codeTitulaireContrat = codeTitulaireContrat;
    }

}