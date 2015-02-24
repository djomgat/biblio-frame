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
@Table(name = "tab_piece_jointe")
public class TabPieceJointe extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_piece_jointe")
    private String numeroPieceJointe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_courrier")
    private String numeroCourrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_ordre")
    private String numeroOrdre;

    public TabPieceJointe() {
    }

    public TabPieceJointe(String numeroPieceJointe) {
        this.numeroPieceJointe = numeroPieceJointe;
    }

    public TabPieceJointe(String numeroPieceJointe, String numeroCourrier, String numeroOrdre) {
        this.numeroPieceJointe = numeroPieceJointe;
        this.numeroCourrier = numeroCourrier;
        this.numeroOrdre = numeroOrdre;
    }

    public String getNumeroPieceJointe() {
        return numeroPieceJointe;
    }

    public void setNumeroPieceJointe(String numeroPieceJointe) {
        this.numeroPieceJointe = numeroPieceJointe;
    }

    public String getNumeroCourrier() {
        return numeroCourrier;
    }

    public void setNumeroCourrier(String numeroCourrier) {
        this.numeroCourrier = numeroCourrier;
    }

    public String getNumeroOrdre() {
        return numeroOrdre;
    }

    public void setNumeroOrdre(String numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }
    
}
