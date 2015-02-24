package com.sample.biblio.model.marche;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 * The persistent class for the tabclass database table.
 * 
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_type_marche")
public class TabTypeMarche extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "code_type_marche")
    private String codeTypeMarche;
    
    @Column(name = "lib_type_marche")
    private String libTypeMarche;

    public TabTypeMarche() {
    }

    public TabTypeMarche(String codeTypeMarche) {
        this.codeTypeMarche = codeTypeMarche;
    }

    public String getCodeTypeMarche() {
        return codeTypeMarche;
    }

    public void setCodeTypeMarche(String codeTypeMarche) {
        this.codeTypeMarche = codeTypeMarche;
    }

    public String getLibTypeMarche() {
        return libTypeMarche;
    }

    public void setLibTypeMarche(String libTypeMarche) {
        this.libTypeMarche = libTypeMarche;
    }

}