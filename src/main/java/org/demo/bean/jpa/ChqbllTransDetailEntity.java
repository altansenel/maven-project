/*
 * Created on 24 �ub 2016 ( Time 16:18:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "chqbll_trans_detail"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="chqbll_trans_detail", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ChqbllTransDetailEntity.countAll", query="SELECT COUNT(x) FROM ChqbllTransDetailEntity x" )
} )
public class ChqbllTransDetailEntity implements Serializable {

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
	// "transId" (column "trans_id") is not defined by itself because used as FK in a link 
	// "detailId" (column "detail_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="detail_id", referencedColumnName="id")
    private ChqbllPayrollDetailEntity chqbllPayrollDetail;

    @ManyToOne
    @JoinColumn(name="trans_id", referencedColumnName="id")
    private ChqbllTransEntity chqbllTrans ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ChqbllTransDetailEntity() {
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

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setChqbllPayrollDetail( ChqbllPayrollDetailEntity chqbllPayrollDetail ) {
        this.chqbllPayrollDetail = chqbllPayrollDetail;
    }
    public ChqbllPayrollDetailEntity getChqbllPayrollDetail() {
        return this.chqbllPayrollDetail;
    }

    public void setChqbllTrans( ChqbllTransEntity chqbllTrans ) {
        this.chqbllTrans = chqbllTrans;
    }
    public ChqbllTransEntity getChqbllTrans() {
        return this.chqbllTrans;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        return sb.toString(); 
    } 

}
