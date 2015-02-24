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
@Table(name = "tab_type_commission")
@Entity
public class TabTypeCommission extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_type_commission")
    private String idTypeCommission;

    @Column(name = "lib_type_commission")
    private String libTypeCommission;

    public TabTypeCommission() {
    }

    public TabTypeCommission(String idTypeCommission) {
        this.idTypeCommission = idTypeCommission;
    }

    public String getIdTypeCommission() {
        return idTypeCommission;
    }

    public void setIdTypeCommission(String idTypeCommission) {
        this.idTypeCommission = idTypeCommission;
    }

    public String getLibTypeCommission() {
        return libTypeCommission;
    }

    public void setLibTypeCommission(String libTypeCommission) {
        this.libTypeCommission = libTypeCommission;
    }
   
}