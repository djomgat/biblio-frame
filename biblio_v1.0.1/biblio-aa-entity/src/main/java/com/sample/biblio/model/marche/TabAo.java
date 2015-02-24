/*
 */
package com.sample.biblio.model.marche;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "tab_ao")
@XmlRootElement
public class TabAo extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_ao")
    private String idAo;
    @Size(max = 20)
    @Column(name = "code_type_ao")
    private String codeTypeAo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_ao")
    private String numeroAo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "objet_ao")
    private String objetAo;
    @Size(max = 500)
    @Column(name = "desc_ao")
    private String descAo;
    @Size(max = 2)
    @Column(name = "nombre_lot_ao")
    private String nombreLotAo;
    @Size(max = 20)
    @Column(name = "code_moa_ao")
    private String codeMoaAo;
    @Size(max = 20)
    @Column(name = "date_depot_offre")
    private String dateDepotOffre;
    @Size(max = 20)
    @Column(name = "lieu_depot_offre")
    private String lieuDepotOffre;
    @Size(max = 20)
    @Column(name = "date_ouv_offre")
    private String dateOuvOffre;
    @Size(max = 20)
    @Column(name = "date_valid_offre")
    private String dateValidOffre;
    @Size(max = 20)
    @Column(name = "date_valid_dao")
    private String dateValidDao;
    @Size(max = 20)
    @Column(name = "fichier_dao")
    private String fichierDao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tabao")
    private TabLot tablot;

    public TabAo() {
    }

    public TabAo(String idAo) {
        this.idAo = idAo;
    }

    public TabAo(String idAo, String numeroAo, String objetAo) {
        this.idAo = idAo;
        this.numeroAo = numeroAo;
        this.objetAo = objetAo;
    }

    public String getIdAo() {
        return idAo;
    }

    public void setIdAo(String idAo) {
        this.idAo = idAo;
    }

    public String getCodeTypeAo() {
        return codeTypeAo;
    }

    public void setCodeTypeAo(String codeTypeAo) {
        this.codeTypeAo = codeTypeAo;
    }

    public String getNumeroAo() {
        return numeroAo;
    }

    public void setNumeroAo(String numeroAo) {
        this.numeroAo = numeroAo;
    }

    public String getObjetAo() {
        return objetAo;
    }

    public void setObjetAo(String objetAo) {
        this.objetAo = objetAo;
    }

    public String getDescAo() {
        return descAo;
    }

    public void setDescAo(String descAo) {
        this.descAo = descAo;
    }

    public String getNombreLotAo() {
        return nombreLotAo;
    }

    public void setNombreLotAo(String nombreLotAo) {
        this.nombreLotAo = nombreLotAo;
    }

    public String getCodeMoaAo() {
        return codeMoaAo;
    }

    public void setCodeMoaAo(String codeMoaAo) {
        this.codeMoaAo = codeMoaAo;
    }

    public String getDateDepotOffre() {
        return dateDepotOffre;
    }

    public void setDateDepotOffre(String dateDepotOffre) {
        this.dateDepotOffre = dateDepotOffre;
    }

    public String getLieuDepotOffre() {
        return lieuDepotOffre;
    }

    public void setLieuDepotOffre(String lieuDepotOffre) {
        this.lieuDepotOffre = lieuDepotOffre;
    }

    public String getDateOuvOffre() {
        return dateOuvOffre;
    }

    public void setDateOuvOffre(String dateOuvOffre) {
        this.dateOuvOffre = dateOuvOffre;
    }

    public String getDateValidOffre() {
        return dateValidOffre;
    }

    public void setDateValidOffre(String dateValidOffre) {
        this.dateValidOffre = dateValidOffre;
    }

    public String getDateValidDao() {
        return dateValidDao;
    }

    public void setDateValidDao(String dateValidDao) {
        this.dateValidDao = dateValidDao;
    }

    public String getFichierDao() {
        return fichierDao;
    }

    public void setFichierDao(String fichierDao) {
        this.fichierDao = fichierDao;
    }

    public TabLot getTablot() {
        return tablot;
    }

    public void setTablot(TabLot tablot) {
        this.tablot = tablot;
    }
  
}