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
 * Persistent class for entity stored in table "invoice_trans_currency"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="invoice_trans_currency", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="InvoiceTransCurrencyEntity.countAll", query="SELECT COUNT(x) FROM InvoiceTransCurrencyEntity x" )
} )
public class InvoiceTransCurrencyEntity implements Serializable {

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
    @Column(name="currency", length=3)
    private String     currency     ;

    @Column(name="amount")
    private Double     amount       ;

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
    public InvoiceTransCurrencyEntity() {
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
    //--- DATABASE MAPPING : currency ( VARCHAR ) 
    public void setCurrency( String currency ) {
        this.currency = currency;
    }
    public String getCurrency() {
        return this.currency;
    }

    //--- DATABASE MAPPING : amount ( DOUBLE ) 
    public void setAmount( Double amount ) {
        this.amount = amount;
    }
    public Double getAmount() {
        return this.amount;
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
        sb.append(currency);
        sb.append("|");
        sb.append(amount);
        return sb.toString(); 
    } 

}
