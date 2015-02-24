/*

*/
package com.sample.biblio.model.courrier;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sample.biblio.model.core.BiblioBaseEntity;

/**
 *
 * @author ECHOUPE
 */
@Entity
@Table(name = "tab_courrier")
public class TabCourrier extends BiblioBaseEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_courrier")
    private String numeroCourrier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_courrier")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCourrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "objet_courrier")
    private String objetCourrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "desc_courrier")
    private String descCourrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "mots_cles")
    private String motsCles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ref_ext_courrier")
    private String refExtCourrier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_ext_courrier")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExtCourrier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_crea_courrier")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreaCourrier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_mod_courrier")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModCourrier;
    

    @ManyToOne
	@JoinColumn(name = "code_type_courrier")
    private TabTypeCourrier typeCourrier;
    
    @ManyToOne
  	@JoinColumn(name = "code_nature_courrier")
    private TabNatureCourrier natureCourrier;
    
    @ManyToOne
  	@JoinColumn(name = "code_pers_crea")
    private TabPersonne persCrea;

    public TabCourrier() {
    }

    public TabCourrier(String numeroCourrier) {
        this.numeroCourrier = numeroCourrier;
    }

    public TabCourrier(String numeroCourrier, Date dateCourrier, String objetCourrier, String descCourrier, String motsCles, String refExtCourrier, Date dateExtCourrier, Date dateCreaCourrier, Date dateModCourrier, String codeTypeCourrier, String codeNatureCourrier, String codePersCrea) {
        this.numeroCourrier = numeroCourrier;
        this.dateCourrier = dateCourrier;
        this.objetCourrier = objetCourrier;
        this.descCourrier = descCourrier;
        this.motsCles = motsCles;
        this.refExtCourrier = refExtCourrier;
        this.dateExtCourrier = dateExtCourrier;
        this.dateCreaCourrier = dateCreaCourrier;
        this.dateModCourrier = dateModCourrier;
//        this.codeTypeCourrier = codeTypeCourrier;
//        this.codeNatureCourrier = codeNatureCourrier;
//        this.codePersCrea = codePersCrea;
    }

    public String getNumeroCourrier() {
        return numeroCourrier;
    }

    public void setNumeroCourrier(String numeroCourrier) {
        this.numeroCourrier = numeroCourrier;
    }

    public Date getDateCourrier() {
        return dateCourrier;
    }

    public void setDateCourrier(Date dateCourrier) {
        this.dateCourrier = dateCourrier;
    }

    public String getObjetCourrier() {
        return objetCourrier;
    }

    public void setObjetCourrier(String objetCourrier) {
        this.objetCourrier = objetCourrier;
    }

    public String getDescCourrier() {
        return descCourrier;
    }

    public void setDescCourrier(String descCourrier) {
        this.descCourrier = descCourrier;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public String getRefExtCourrier() {
        return refExtCourrier;
    }

    public void setRefExtCourrier(String refExtCourrier) {
        this.refExtCourrier = refExtCourrier;
    }

    public Date getDateExtCourrier() {
        return dateExtCourrier;
    }

    public void setDateExtCourrier(Date dateExtCourrier) {
        this.dateExtCourrier = dateExtCourrier;
    }

    public Date getDateCreaCourrier() {
        return dateCreaCourrier;
    }

    public void setDateCreaCourrier(Date dateCreaCourrier) {
        this.dateCreaCourrier = dateCreaCourrier;
    }

    public Date getDateModCourrier() {
        return dateModCourrier;
    }

    public void setDateModCourrier(Date dateModCourrier) {
        this.dateModCourrier = dateModCourrier;
    }

	public TabTypeCourrier getTypeCourrier() {
		return typeCourrier;
	}

	public void setTypeCourrier(TabTypeCourrier typeCourrier) {
		this.typeCourrier = typeCourrier;
	}

	public TabNatureCourrier getNatureCourrier() {
		return natureCourrier;
	}

	public void setNatureCourrier(TabNatureCourrier natureCourrier) {
		this.natureCourrier = natureCourrier;
	}

	public TabPersonne getPersCrea() {
		return persCrea;
	}

	public void setPersCrea(TabPersonne persCrea) {
		this.persCrea = persCrea;
	}

  

}
