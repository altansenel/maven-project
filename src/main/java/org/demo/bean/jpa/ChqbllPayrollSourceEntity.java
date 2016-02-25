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
 * Persistent class for entity stored in table "chqbll_payroll_source"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="chqbll_payroll_source", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ChqbllPayrollSourceEntity.countAll", query="SELECT COUNT(x) FROM ChqbllPayrollSourceEntity x" )
} )
public class ChqbllPayrollSourceEntity implements Serializable {

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

    @Column(name="name", nullable=false, length=30)
    private String     name         ;

    @Column(name="suitable_right", length=30)
    private String     suitableRight ;

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

    @Column(name="is_active")
    private Boolean    isActive     ;

    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;

    @Column(name="version")
    private Integer    version      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="chqbllPayrollSource", targetEntity=ChqbllPayrollDetailEntity.class)
    private List<ChqbllPayrollDetailEntity> listOfChqbllPayrollDetail;

    @OneToMany(mappedBy="chqbllPayrollSource", targetEntity=ChqbllPayrollEntity.class)
    private List<ChqbllPayrollEntity> listOfChqbllPayroll;

    @OneToMany(mappedBy="chqbllPayrollSource", targetEntity=ChqbllTransEntity.class)
    private List<ChqbllTransEntity> listOfChqbllTrans;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ChqbllPayrollSourceEntity() {
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

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : suitable_right ( VARCHAR ) 
    public void setSuitableRight( String suitableRight ) {
        this.suitableRight = suitableRight;
    }
    public String getSuitableRight() {
        return this.suitableRight;
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

    //--- DATABASE MAPPING : is_active ( BIT ) 
    public void setIsActive( Boolean isActive ) {
        this.isActive = isActive;
    }
    public Boolean getIsActive() {
        return this.isActive;
    }

    //--- DATABASE MAPPING : workspace ( INT ) 
    public void setWorkspace( Integer workspace ) {
        this.workspace = workspace;
    }
    public Integer getWorkspace() {
        return this.workspace;
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
    public void setListOfChqbllPayrollDetail( List<ChqbllPayrollDetailEntity> listOfChqbllPayrollDetail ) {
        this.listOfChqbllPayrollDetail = listOfChqbllPayrollDetail;
    }
    public List<ChqbllPayrollDetailEntity> getListOfChqbllPayrollDetail() {
        return this.listOfChqbllPayrollDetail;
    }

    public void setListOfChqbllPayroll( List<ChqbllPayrollEntity> listOfChqbllPayroll ) {
        this.listOfChqbllPayroll = listOfChqbllPayroll;
    }
    public List<ChqbllPayrollEntity> getListOfChqbllPayroll() {
        return this.listOfChqbllPayroll;
    }

    public void setListOfChqbllTrans( List<ChqbllTransEntity> listOfChqbllTrans ) {
        this.listOfChqbllTrans = listOfChqbllTrans;
    }
    public List<ChqbllTransEntity> getListOfChqbllTrans() {
        return this.listOfChqbllTrans;
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
        sb.append(name);
        sb.append("|");
        sb.append(suitableRight);
        sb.append("|");
        sb.append(insertBy);
        sb.append("|");
        sb.append(insertAt);
        sb.append("|");
        sb.append(updateBy);
        sb.append("|");
        sb.append(updateAt);
        sb.append("|");
        sb.append(isActive);
        sb.append("|");
        sb.append(workspace);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 

}