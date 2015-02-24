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
@Table(name = "tab_personne")
public class TabPersonne extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_personne")
    private String idPersonne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_personne")
    private String nomPersonne;
    @Size(max = 20)
    @Column(name = "tel_personne")
    private String telPersonne;
    @Size(max = 20)
    @Column(name = "fax_personne")
    private String faxPersonne;

    public TabPersonne() {
    }

    public TabPersonne(String idPersonne) {
        this.idPersonne = idPersonne;
    }

    public TabPersonne(String idPersonne, String nomPersonne) {
        this.idPersonne = idPersonne;
        this.nomPersonne = nomPersonne;
    }

    public String getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(String idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNomPersonne() {
        return nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public String getTelPersonne() {
        return telPersonne;
    }

    public void setTelPersonne(String telPersonne) {
        this.telPersonne = telPersonne;
    }

    public String getFaxPersonne() {
        return faxPersonne;
    }

    public void setFaxPersonne(String faxPersonne) {
        this.faxPersonne = faxPersonne;
    }

}
