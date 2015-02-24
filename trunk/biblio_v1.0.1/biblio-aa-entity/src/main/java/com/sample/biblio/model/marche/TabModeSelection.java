/*

 */
package com.sample.biblio.model.marche;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_mode_selection")
public class TabModeSelection extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_mode_selection")
    private String idModeSelection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code_mode_selection")
    private String codeModeSelection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lib_mode_selection")
    private String libModeSelection;
    @Size(max = 500)
    @Column(name = "desc_mode_selection")
    private String descModeSelection;

    public TabModeSelection() {
    }

    public TabModeSelection(String idModeSelection) {
        this.idModeSelection = idModeSelection;
    }

    public TabModeSelection(String idModeSelection, String codeModeSelection, String libModeSelection) {
        this.idModeSelection = idModeSelection;
        this.codeModeSelection = codeModeSelection;
        this.libModeSelection = libModeSelection;
    }

    public String getIdModeSelection() {
        return idModeSelection;
    }

    public void setIdModeSelection(String idModeSelection) {
        this.idModeSelection = idModeSelection;
    }

    public String getCodeModeSelection() {
        return codeModeSelection;
    }

    public void setCodeModeSelection(String codeModeSelection) {
        this.codeModeSelection = codeModeSelection;
    }

    public String getLibModeSelection() {
        return libModeSelection;
    }

    public void setLibModeSelection(String libModeSelection) {
        this.libModeSelection = libModeSelection;
    }

    public String getDescModeSelection() {
        return descModeSelection;
    }

    public void setDescModeSelection(String descModeSelection) {
        this.descModeSelection = descModeSelection;
    }

}
