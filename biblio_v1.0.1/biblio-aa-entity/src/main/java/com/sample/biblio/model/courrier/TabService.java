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
@Table(name = "tab_service")
public class TabService extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_service")
    private String idService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sigle_service")
    private String sigleService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_service")
    private String nomService;
    @Size(max = 20)
    @Column(name = "tel_service")
    private String telService;
    @Size(max = 20)
    @Column(name = "fax_service")
    private String faxService;

    public TabService() {
    }

    public TabService(String idService) {
        this.idService = idService;
    }

    public TabService(String idService, String sigleService, String nomService) {
        this.idService = idService;
        this.sigleService = sigleService;
        this.nomService = nomService;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getSigleService() {
        return sigleService;
    }

    public void setSigleService(String sigleService) {
        this.sigleService = sigleService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getTelService() {
        return telService;
    }

    public void setTelService(String telService) {
        this.telService = telService;
    }

    public String getFaxService() {
        return faxService;
    }

    public void setFaxService(String faxService) {
        this.faxService = faxService;
    }
    
}
