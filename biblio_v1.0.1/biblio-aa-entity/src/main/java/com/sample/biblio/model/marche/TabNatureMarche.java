/*
 */
package com.sample.biblio.model.marche;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_nature_marche")
@XmlRootElement
public class TabNatureMarche extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "code_nature_marche")
    private String codeNatureMarche;
    @Size(max = 20)
    @Column(name = "lib_nature_marche")
    private String libNatureMarche;

    public TabNatureMarche() {
    }

    public TabNatureMarche(String codeNatureMarche) {
        this.codeNatureMarche = codeNatureMarche;
    }

    public String getCodeNatureMarche() {
        return codeNatureMarche;
    }

    public void setCodeNatureMarche(String codeNatureMarche) {
        this.codeNatureMarche = codeNatureMarche;
    }

    public String getLibNatureMarche() {
        return libNatureMarche;
    }

    public void setLibNatureMarche(String libNatureMarche) {
        this.libNatureMarche = libNatureMarche;
    }
    
}