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
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "global_currency_rate"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="global_currency_rate", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="GlobalCurrencyRateEntity.countAll", query="SELECT COUNT(x) FROM GlobalCurrencyRateEntity x" )
} )
public class GlobalCurrencyRateEntity implements Serializable {

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
    @Temporal(TemporalType.DATE)
    @Column(name="_date", nullable=false)
    private Date       date         ;

    @Column(name="source", length=100)
    private String     source       ;

    @Column(name="insert_by", length=20)
    private String     insertBy     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="insert_at")
    private Date       insertAt     ;

    @Column(name="update_by", length=20)
    private String     updateBy     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_at")
    private Date       updateAt     ;

    @Column(name="version")
    private Integer    version      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="globalCurrencyRate", targetEntity=GlobalCurrencyRateDetailEntity.class)
    private List<GlobalCurrencyRateDetailEntity> listOfGlobalCurrencyRateDetail;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public GlobalCurrencyRateEntity() {
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
    //--- DATABASE MAPPING : _date ( DATE ) 
    public void setDate( Date date ) {
        this.date = date;
    }
    public Date getDate() {
        return this.date;
    }

    //--- DATABASE MAPPING : source ( VARCHAR ) 
    public void setSource( String source ) {
        this.source = source;
    }
    public String getSource() {
        return this.source;
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

    //--- DATABASE MAPPING : update_by ( VARCHAR ) 
    public void setUpdateBy( String updateBy ) {
        this.updateBy = updateBy;
    }
    public String getUpdateBy() {
        return this.updateBy;
    }

    //--- DATABASE MAPPING : update_at ( DATETIME ) 
    public void setUpdateAt( Date updateAt ) {
        this.updateAt = updateAt;
    }
    public Date getUpdateAt() {
        return this.updateAt;
    }

    //--- DATABASE MAPPING : version ( INT ) 
    public void setVersion( Integer version ) {
        this.version = version;
    }
    public Integer getVersion() {
        return this.version;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfGlobalCurrencyRateDetail( List<GlobalCurrencyRateDetailEntity> listOfGlobalCurrencyRateDetail ) {
        this.listOfGlobalCurrencyRateDetail = listOfGlobalCurrencyRateDetail;
    }
    public List<GlobalCurrencyRateDetailEntity> getListOfGlobalCurrencyRateDetail() {
        return this.listOfGlobalCurrencyRateDetail;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(date);
        sb.append("|");
        sb.append(source);
        sb.append("|");
        sb.append(insertBy);
        sb.append("|");
        sb.append(insertAt);
        sb.append("|");
        sb.append(updateBy);
        sb.append("|");
        sb.append(updateAt);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 

}
