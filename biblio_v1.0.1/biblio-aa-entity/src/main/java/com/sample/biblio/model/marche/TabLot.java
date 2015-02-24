/*
 */
package com.sample.biblio.model.marche;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tab_lot")
@XmlRootElement
public class TabLot extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_lot")
    private String idLot;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_ao")
    private String idAo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_lot")
    private String numeroLot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "objet_lot")
    private String objetLot;
    @Size(max = 500)
    @Column(name = "desc_lot")
    private String descLot;
    @Column(name = "montant_prev_lot")
    private Integer montantPrevLot;
    @Column(name = "delai_prev_lot")
    private Integer delaiPrevLot;
    @Size(max = 20)
    @Column(name = "lieu_prev_lot")
    private String lieuPrevLot;
    @Size(max = 20)
    @Column(name = "code_nature_prestation")
    private String codeNaturePrestation;
    @JoinColumn(name = "id_ao", referencedColumnName = "id_ao", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TabAo tabao;

    public TabLot() {
    }

    public TabLot(String idAo) {
        this.idAo = idAo;
    }

    public TabLot(String idAo, String idLot, String numeroLot, String objetLot) {
        this.idAo = idAo;
        this.idLot = idLot;
        this.numeroLot = numeroLot;
        this.objetLot = objetLot;
    }

    public String getIdLot() {
        return idLot;
    }

    public void setIdLot(String idLot) {
        this.idLot = idLot;
    }

    public String getIdAo() {
        return idAo;
    }

    public void setIdAo(String idAo) {
        this.idAo = idAo;
    }

    public String getNumeroLot() {
        return numeroLot;
    }

    public void setNumeroLot(String numeroLot) {
        this.numeroLot = numeroLot;
    }

    public String getObjetLot() {
        return objetLot;
    }

    public void setObjetLot(String objetLot) {
        this.objetLot = objetLot;
    }

    public String getDescLot() {
        return descLot;
    }

    public void setDescLot(String descLot) {
        this.descLot = descLot;
    }

    public Integer getMontantPrevLot() {
        return montantPrevLot;
    }

    public void setMontantPrevLot(Integer montantPrevLot) {
        this.montantPrevLot = montantPrevLot;
    }

    public Integer getDelaiPrevLot() {
        return delaiPrevLot;
    }

    public void setDelaiPrevLot(Integer delaiPrevLot) {
        this.delaiPrevLot = delaiPrevLot;
    }

    public String getLieuPrevLot() {
        return lieuPrevLot;
    }

    public void setLieuPrevLot(String lieuPrevLot) {
        this.lieuPrevLot = lieuPrevLot;
    }

    public String getCodeNaturePrestation() {
        return codeNaturePrestation;
    }

    public void setCodeNaturePrestation(String codeNaturePrestation) {
        this.codeNaturePrestation = codeNaturePrestation;
    }

    public TabAo getTabao() {
        return tabao;
    }

    public void setTabao(TabAo tabao) {
        this.tabao = tabao;
    }

}