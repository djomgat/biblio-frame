/*

 */
package com.sample.biblio.model.courrier;

import com.sample.biblio.model.core.BiblioBaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_courrier_reponse")
public class TabCourrierReponse extends BiblioBaseEntity {    
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_courrier")
    private String numeroCourrier;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "re_numero_courrier")
    private String reNumeroCourrier;    

    public TabCourrierReponse() {
    }

    public String getNumeroCourrier() {
        return numeroCourrier;
    }

    public void setNumeroCourrier(String numeroCourrier) {
        this.numeroCourrier = numeroCourrier;
    }

}