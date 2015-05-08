/*
 */
package com.sample.biblio.model.marche;

import com.sample.frame.core.entity.GenericEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ECHOUPE
 */
@Embeddable
public class TabPlanPassationPK extends GenericEntity {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "exercice")
    private String exercice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_operation")
    private String idOperation;

    public TabPlanPassationPK() {
    }

    public TabPlanPassationPK(String exercice, String idOperation) {
        this.exercice = exercice;
        this.idOperation = idOperation;
    }

    public String getExercice() {
        return exercice;
    }

    public void setExercice(String exercice) {
        this.exercice = exercice;
    }

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exercice != null ? exercice.hashCode() : 0);
        hash += (idOperation != null ? idOperation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabPlanPassationPK)) {
            return false;
        }
        TabPlanPassationPK other = (TabPlanPassationPK) object;
        if ((this.exercice == null && other.exercice != null) || (this.exercice != null && !this.exercice.equals(other.exercice))) {
            return false;
        }
        if ((this.idOperation == null && other.idOperation != null) || (this.idOperation != null && !this.idOperation.equals(other.idOperation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sample.biblio.model.marche.TabPlanPassationPK[ exercice=" + exercice + ", idOperation=" + idOperation + " ]";
    }
    
}
