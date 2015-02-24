/*

 */
package com.sample.biblio.model.courrier;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ECHOUPE
 */
@Embeddable
public class TabDestinatairePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_courrier")
    private String numeroCourrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code_destinataire")
    private String codeDestinataire;

    public TabDestinatairePK() {
    }

    public TabDestinatairePK(String numeroCourrier, String codeDestinataire) {
        this.numeroCourrier = numeroCourrier;
        this.codeDestinataire = codeDestinataire;
    }

    public String getNumeroCourrier() {
        return numeroCourrier;
    }

    public void setNumeroCourrier(String numeroCourrier) {
        this.numeroCourrier = numeroCourrier;
    }

    public String getCodeDestinataire() {
        return codeDestinataire;
    }

    public void setCodeDestinataire(String codeDestinataire) {
        this.codeDestinataire = codeDestinataire;
    }

}
