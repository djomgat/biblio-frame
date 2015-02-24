/*

 */
package com.sample.biblio.model.courrier;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_destinataire")
public class TabDestinataire extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TabDestinatairePK tabDestinatairePK;

    public TabDestinataire() {
    }

    public TabDestinataire(TabDestinatairePK tabDestinatairePK) {
        this.tabDestinatairePK = tabDestinatairePK;
    }

    public TabDestinataire(String numeroCourrier, String codeDestinataire) {
        this.tabDestinatairePK = new TabDestinatairePK(numeroCourrier, codeDestinataire);
    }

    public TabDestinatairePK getTabDestinatairePK() {
        return tabDestinatairePK;
    }

    public void setTabDestinatairePK(TabDestinatairePK tabDestinatairePK) {
        this.tabDestinatairePK = tabDestinatairePK;
    }
    
}
