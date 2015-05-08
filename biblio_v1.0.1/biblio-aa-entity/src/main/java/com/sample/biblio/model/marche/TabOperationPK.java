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
public class TabOperationPK extends GenericEntity {
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

    public TabOperationPK() {
    }

    public TabOperationPK(String exercice, String idOperation) {
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
    
}