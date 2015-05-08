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
@Table(name = "tab_compteur_courrier")
public class TabCompteurCourrier extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_numero")
    private String idNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_courant")
    private String numeroCourant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code_service")
    private String codeService;
    @Size(max = 1)
    @Column(name = "code_type_courrier")
    private String codeTypeCourrier;
    @Size(max = 3)
    @Column(name = "code_nature_courrier")
    private String codeNatureCourrier;
    @Size(max = 4)
    @Column(name = "annee_courrier")
    private String anneeCourrier;

    public TabCompteurCourrier() {
    }

    public TabCompteurCourrier(String idNumero) {
        this.idNumero = idNumero;
    }

    public TabCompteurCourrier(String idNumero, String numeroCourant, String codeService) {
        this.idNumero = idNumero;
        this.numeroCourant = numeroCourant;
        this.codeService = codeService;
    }

    public String getIdNumero() {
        return idNumero;
    }

    public void setIdNumero(String idNumero) {
        this.idNumero = idNumero;
    }

    public String getNumeroCourant() {
        return numeroCourant;
    }

    public void setNumeroCourant(String numeroCourant) {
        this.numeroCourant = numeroCourant;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getCodeTypeCourrier() {
        return codeTypeCourrier;
    }

    public void setCodeTypeCourrier(String codeTypeCourrier) {
        this.codeTypeCourrier = codeTypeCourrier;
    }

    public String getCodeNatureCourrier() {
        return codeNatureCourrier;
    }

    public void setCodeNatureCourrier(String codeNatureCourrier) {
        this.codeNatureCourrier = codeNatureCourrier;
    }

    public String getAnneeCourrier() {
        return anneeCourrier;
    }

    public void setAnneeCourrier(String anneeCourrier) {
        this.anneeCourrier = anneeCourrier;
    }
   
}