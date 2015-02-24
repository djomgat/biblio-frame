/*

 */
package com.sample.biblio.model.marche;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_consultation")
public class TabConsultation extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_consultation")
    private String idConsultation;
    @Size(max = 20)
    @Column(name = "code_type_consultation")
    private String codeTypeConsultation;
    @Size(max = 20)
    @Column(name = "code_mode_selection")
    private String codeModeSelection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_consultation")
    private String numeroConsultation;
    @Column(name = "date_consultation")
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "objet_consultation")
    private String objetConsultation;
    @Size(max = 500)
    @Column(name = "desc_consultation")
    private String descConsultation;
    @Size(max = 2)
    @Column(name = "nombre_lot_consultation")
    private String nombreLotConsultation;
    @Size(max = 20)
    @Column(name = "code_moa_consultation")
    private String codeMoaConsultation;
    @Column(name = "date_depot_offre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDepotOffre;
    @Size(max = 20)
    @Column(name = "lieu_depot_offre")
    private String lieuDepotOffre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_ouv_offre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOuvOffre;
    @Size(max = 20)
    @Column(name = "delai_valid_offre")
    private String delaiValidOffre;
    @Size(max = 20)
    @Column(name = "fichier_dao")
    private String fichierDao;

    public TabConsultation() {
    }

    public TabConsultation(String idConsultation) {
        this.idConsultation = idConsultation;
    }

    public TabConsultation(String idConsultation, String numeroConsultation, String objetConsultation, Date dateOuvOffre) {
        this.idConsultation = idConsultation;
        this.numeroConsultation = numeroConsultation;
        this.objetConsultation = objetConsultation;
        this.dateOuvOffre = dateOuvOffre;
    }

    public String getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(String idConsultation) {
        this.idConsultation = idConsultation;
    }

    public String getCodeTypeConsultation() {
        return codeTypeConsultation;
    }

    public void setCodeTypeConsultation(String codeTypeConsultation) {
        this.codeTypeConsultation = codeTypeConsultation;
    }

    public String getCodeModeSelection() {
        return codeModeSelection;
    }

    public void setCodeModeSelection(String codeModeSelection) {
        this.codeModeSelection = codeModeSelection;
    }

    public String getNumeroConsultation() {
        return numeroConsultation;
    }

    public void setNumeroConsultation(String numeroConsultation) {
        this.numeroConsultation = numeroConsultation;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getObjetConsultation() {
        return objetConsultation;
    }

    public void setObjetConsultation(String objetConsultation) {
        this.objetConsultation = objetConsultation;
    }

    public String getDescConsultation() {
        return descConsultation;
    }

    public void setDescConsultation(String descConsultation) {
        this.descConsultation = descConsultation;
    }

    public String getNombreLotConsultation() {
        return nombreLotConsultation;
    }

    public void setNombreLotConsultation(String nombreLotConsultation) {
        this.nombreLotConsultation = nombreLotConsultation;
    }

    public String getCodeMoaConsultation() {
        return codeMoaConsultation;
    }

    public void setCodeMoaConsultation(String codeMoaConsultation) {
        this.codeMoaConsultation = codeMoaConsultation;
    }

    public Date getDateDepotOffre() {
        return dateDepotOffre;
    }

    public void setDateDepotOffre(Date dateDepotOffre) {
        this.dateDepotOffre = dateDepotOffre;
    }

    public String getLieuDepotOffre() {
        return lieuDepotOffre;
    }

    public void setLieuDepotOffre(String lieuDepotOffre) {
        this.lieuDepotOffre = lieuDepotOffre;
    }

    public Date getDateOuvOffre() {
        return dateOuvOffre;
    }

    public void setDateOuvOffre(Date dateOuvOffre) {
        this.dateOuvOffre = dateOuvOffre;
    }

    public String getDelaiValidOffre() {
        return delaiValidOffre;
    }

    public void setDelaiValidOffre(String delaiValidOffre) {
        this.delaiValidOffre = delaiValidOffre;
    }

    public String getFichierDao() {
        return fichierDao;
    }

    public void setFichierDao(String fichierDao) {
        this.fichierDao = fichierDao;
    }

}
