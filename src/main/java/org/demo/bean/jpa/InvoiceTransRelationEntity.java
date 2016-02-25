/*
 * Created on 24 �ub 2016 ( Time 16:18:05 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "invoice_trans_relation"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="invoice_trans_relation", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="InvoiceTransRelationEntity.countAll", query="SELECT COUNT(x) FROM InvoiceTransRelationEntity x" )
} )
public class InvoiceTransRelationEntity implements Serializable {

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
    @Column(name="rel_id", nullable=false)
    private Integer    relId        ;

    @Column(name="rel_right", nullable=false, length=30)
    private String     relRight     ;

    @Column(name="rel_receipt_no", nullable=false)
    private Integer    relReceiptNo ;

	// "transId" (column "trans_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="trans_id", referencedColumnName="id")
    private InvoiceTransEntity invoiceTrans;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public InvoiceTransRelationEntity() {
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
    //--- DATABASE MAPPING : rel_id ( INT ) 
    public void setRelId( Integer relId ) {
        this.relId = relId;
    }
    public Integer getRelId() {
        return this.relId;
    }

    //--- DATABASE MAPPING : rel_right ( VARCHAR ) 
    public void setRelRight( String relRight ) {
        this.relRight = relRight;
    }
    public String getRelRight() {
        return this.relRight;
    }

    //--- DATABASE MAPPING : rel_receipt_no ( INT ) 
    public void setRelReceiptNo( Integer relReceiptNo ) {
        this.relReceiptNo = relReceiptNo;
    }
    public Integer getRelReceiptNo() {
        return this.relReceiptNo;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setInvoiceTrans( InvoiceTransEntity invoiceTrans ) {
        this.invoiceTrans = invoiceTrans;
    }
    public InvoiceTransEntity getInvoiceTrans() {
        return this.invoiceTrans;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(relId);
        sb.append("|");
        sb.append(relRight);
        sb.append("|");
        sb.append(relReceiptNo);
        return sb.toString(); 
    } 

}
