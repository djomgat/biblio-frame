/*

 */
package com.sample.biblio.model.marche;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_operation")
public class TabOperation extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TabOperationPK tabOperationPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "localisation")
    private String localisation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private int montant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "livrable")
    private String livrable;

    public TabOperation() {
    }

    public TabOperation(TabOperationPK tabOperationPK) {
        this.tabOperationPK = tabOperationPK;
    }

    public TabOperation(TabOperationPK tabOperationPK, String designation, String localisation, int montant, String livrable) {
        this.tabOperationPK = tabOperationPK;
        this.designation = designation;
        this.localisation = localisation;
        this.montant = montant;
        this.livrable = livrable;
    }

    public TabOperation(String exercice, String idOperation) {
        this.tabOperationPK = new TabOperationPK(exercice, idOperation);
    }

    public TabOperationPK getTabOperationPK() {
        return tabOperationPK;
    }

    public void setTabOperationPK(TabOperationPK tabOperationPK) {
        this.tabOperationPK = tabOperationPK;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getLivrable() {
        return livrable;
    }

    public void setLivrable(String livrable) {
        this.livrable = livrable;
    }
    
}