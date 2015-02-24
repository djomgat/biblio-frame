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
@Table(name = "tab_type_courrier")
public class TabTypeCourrier extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "code_type_courrier")
    private String codeTypeCourrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lib_type_courrier")
    private String libTypeCourrier;
    @Size(max = 100)
    @Column(name = "desc_type_courrier")
    private String descTypeCourrier;

    public TabTypeCourrier() {
    }

    public TabTypeCourrier(String codeTypeCourrier) {
        this.codeTypeCourrier = codeTypeCourrier;
    }

    public TabTypeCourrier(String codeTypeCourrier, String libTypeCourrier) {
        this.codeTypeCourrier = codeTypeCourrier;
        this.libTypeCourrier = libTypeCourrier;
    }

    public String getCodeTypeCourrier() {
        return codeTypeCourrier;
    }

    public void setCodeTypeCourrier(String codeTypeCourrier) {
        this.codeTypeCourrier = codeTypeCourrier;
    }

    public String getLibTypeCourrier() {
        return libTypeCourrier;
    }

    public void setLibTypeCourrier(String libTypeCourrier) {
        this.libTypeCourrier = libTypeCourrier;
    }

    public String getDescTypeCourrier() {
        return descTypeCourrier;
    }

    public void setDescTypeCourrier(String descTypeCourrier) {
        this.descTypeCourrier = descTypeCourrier;
    }
    
}
