/*

 */
package com.sample.biblio.model.courrier;

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
@Table(name = "tab_nature_courrier")
public class TabNatureCourrier extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "code_nature_courrier")
    private String codeNatureCourrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lib_nature_courrier")
    private String libNatureCourrier;
    @Size(max = 100)
    @Column(name = "desc_nature_courrier")
    private String descNatureCourrier;

    public TabNatureCourrier() {
    }

    public TabNatureCourrier(String codeNatureCourrier) {
        this.codeNatureCourrier = codeNatureCourrier;
    }

    public TabNatureCourrier(String codeNatureCourrier, String libNatureCourrier) {
        this.codeNatureCourrier = codeNatureCourrier;
        this.libNatureCourrier = libNatureCourrier;
    }

    public String getCodeNatureCourrier() {
        return codeNatureCourrier;
    }

    public void setCodeNatureCourrier(String codeNatureCourrier) {
        this.codeNatureCourrier = codeNatureCourrier;
    }

    public String getLibNatureCourrier() {
        return libNatureCourrier;
    }

    public void setLibNatureCourrier(String libNatureCourrier) {
        this.libNatureCourrier = libNatureCourrier;
    }

    public String getDescNatureCourrier() {
        return descNatureCourrier;
    }

    public void setDescNatureCourrier(String descNatureCourrier) {
        this.descNatureCourrier = descNatureCourrier;
    }
    
}