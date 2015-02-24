/*
 *
 */
package com.sample.biblio.model.securite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 * The persistent class for the tabmouchard database table.
 * 
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_mouchard")
public class TabMouchard extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "sequenceId")
    private String sequenceId;
    
    @Column(name = "userName")
    private String userName;
    
    @Column(name = "hostName")
    private String hostName;
    
    @Column(name = "codeFonction")
    private String codeFonction;
    
    @Column(name = "codeCommande")
    private String codeCommande;
    
    @Column(name = "codeTable")
    private String codeTable;
    
    @Column(name = "logDetails")
    private String logDetails;
    
    @Column(name = "dateOperation")
    private String dateOperation;

    public TabMouchard() {
    }

    public TabMouchard(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getCodeFonction() {
        return codeFonction;
    }

    public void setCodeFonction(String codeFonction) {
        this.codeFonction = codeFonction;
    }

    public String getCodeCommande() {
        return codeCommande;
    }

    public void setCodeCommande(String codeCommande) {
        this.codeCommande = codeCommande;
    }

    public String getCodeTable() {
        return codeTable;
    }

    public void setCodeTable(String codeTable) {
        this.codeTable = codeTable;
    }

    public String getLogDetails() {
        return logDetails;
    }

    public void setLogDetails(String logDetails) {
        this.logDetails = logDetails;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }
    
}
