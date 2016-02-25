/*
 * Created on 24 �ub 2016 ( Time 16:18:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "chqbll_detail_history"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="chqbll_detail_history", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ChqbllDetailHistoryEntity.countAll", query="SELECT COUNT(x) FROM ChqbllDetailHistoryEntity x" )
} )
public class ChqbllDetailHistoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="sort", nullable=false, length=6)
    private String     sort         ;

    @Temporal(TemporalType.DATE)
    @Column(name="step_date", nullable=false)
    private Date       stepDate     ;

    @Column(name="step", nullable=false, length=15)
    private String     step         ;

    @Column(name="insert_by", length=20)
    private String     insertBy     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="insert_at")
    private Date       insertAt     ;

	// "detailId" (column "detail_id") is not defined by itself because used as FK in a link 
	// "contactId" (column "contact_id") is not defined by itself because used as FK in a link 
	// "bankId" (column "bank_id") is not defined by itself because used as FK in a link 
	// "safeId" (column "safe_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="contact_id", referencedColumnName="id")
    private ContactEntity contact     ;

    @ManyToOne
    @JoinColumn(name="safe_id", referencedColumnName="id")
    private SafeEntity safe        ;

    @ManyToOne
    @JoinColumn(name="bank_id", referencedColumnName="id")
    private BankEntity bank        ;

    @ManyToOne
    @JoinColumn(name="detail_id", referencedColumnName="id")
    private ChqbllPayrollDetailEntity chqbllPayrollDetail;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ChqbllDetailHistoryEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : sort ( VARCHAR ) 
    public void setSort( String sort ) {
        this.sort = sort;
    }
    public String getSort() {
        return this.sort;
    }

    //--- DATABASE MAPPING : step_date ( DATE ) 
    public void setStepDate( Date stepDate ) {
        this.stepDate = stepDate;
    }
    public Date getStepDate() {
        return this.stepDate;
    }

    //--- DATABASE MAPPING : step ( VARCHAR ) 
    public void setStep( String step ) {
        this.step = step;
    }
    public String getStep() {
        return this.step;
    }

    //--- DATABASE MAPPING : insert_by ( VARCHAR ) 
    public void setInsertBy( String insertBy ) {
        this.insertBy = insertBy;
    }
    public String getInsertBy() {
        return this.insertBy;
    }

    //--- DATABASE MAPPING : insert_at ( DATETIME ) 
    public void setInsertAt( Date insertAt ) {
        this.insertAt = insertAt;
    }
    public Date getInsertAt() {
        return this.insertAt;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setContact( ContactEntity contact ) {
        this.contact = contact;
    }
    public ContactEntity getContact() {
        return this.contact;
    }

    public void setSafe( SafeEntity safe ) {
        this.safe = safe;
    }
    public SafeEntity getSafe() {
        return this.safe;
    }

    public void setBank( BankEntity bank ) {
        this.bank = bank;
    }
    public BankEntity getBank() {
        return this.bank;
    }

    public void setChqbllPayrollDetail( ChqbllPayrollDetailEntity chqbllPayrollDetail ) {
        this.chqbllPayrollDetail = chqbllPayrollDetail;
    }
    public ChqbllPayrollDetailEntity getChqbllPayrollDetail() {
        return this.chqbllPayrollDetail;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(sort);
        sb.append("|");
        sb.append(stepDate);
        sb.append("|");
        sb.append(step);
        sb.append("|");
        sb.append(insertBy);
        sb.append("|");
        sb.append(insertAt);
        return sb.toString(); 
    } 

}
