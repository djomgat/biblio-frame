/*
 */
package com.sample.biblio.model.marche;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sample.frame.core.entity.GenericEntity;

/**
 *
 * @author ECHOUPE
 */
@Embeddable
public class TabAttributionPK extends GenericEntity {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_lot")
    private String idLot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_societe")
    private String idSociete;

    public TabAttributionPK() {
    }

    public TabAttributionPK(String idLot, String idSociete) {
        this.idLot = idLot;
        this.idSociete = idSociete;
    }

    public String getIdLot() {
        return idLot;
    }

    public void setIdLot(String idLot) {
        this.idLot = idLot;
    }

    public String getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLot != null ? idLot.hashCode() : 0);
        hash += (idSociete != null ? idSociete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabAttributionPK)) {
            return false;
        }
        TabAttributionPK other = (TabAttributionPK) object;
        if ((this.idLot == null && other.idLot != null) || (this.idLot != null && !this.idLot.equals(other.idLot))) {
            return false;
        }
        if ((this.idSociete == null && other.idSociete != null) || (this.idSociete != null && !this.idSociete.equals(other.idSociete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sample.biblio.model.TabattributionPK[ idLot=" + idLot + ", idSociete=" + idSociete + " ]";
    }
    
}
