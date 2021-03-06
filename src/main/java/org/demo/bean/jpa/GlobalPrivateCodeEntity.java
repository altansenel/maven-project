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
 * Persistent class for entity stored in table "global_private_code"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="global_private_code", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="GlobalPrivateCodeEntity.countAll", query="SELECT COUNT(x) FROM GlobalPrivateCodeEntity x" )
} )
public class GlobalPrivateCodeEntity implements Serializable {

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
    @Column(name="par1id")
    private Integer    par1id       ;

    @Column(name="par2id")
    private Integer    par2id       ;

    @Column(name="par3id")
    private Integer    par3id       ;

    @Column(name="par4id")
    private Integer    par4id       ;

    @Column(name="par5id")
    private Integer    par5id       ;

    @Column(name="name", nullable=false, length=30)
    private String     name         ;

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

    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;

    @Column(name="version")
    private Integer    version      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="globalPrivateCode", targetEntity=InvoiceTransDetailEntity.class)
    private List<InvoiceTransDetailEntity> listOfInvoiceTransDetail;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=OrderTransEntity.class)
    private List<OrderTransEntity> listOfOrderTrans;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=BankTransEntity.class)
    private List<BankTransEntity> listOfBankTrans;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=WaybillTransDetailEntity.class)
    private List<WaybillTransDetailEntity> listOfWaybillTransDetail;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=SafeTransEntity.class)
    private List<SafeTransEntity> listOfSafeTrans;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=StockTransEntity.class)
    private List<StockTransEntity> listOfStockTrans;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=ChqbllPayrollDetailEntity.class)
    private List<ChqbllPayrollDetailEntity> listOfChqbllPayrollDetail;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=WaybillTransEntity.class)
    private List<WaybillTransEntity> listOfWaybillTrans;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=OrderTransDetailEntity.class)
    private List<OrderTransDetailEntity> listOfOrderTransDetail;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=StockTransDetailEntity.class)
    private List<StockTransDetailEntity> listOfStockTransDetail;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=InvoiceTransEntity.class)
    private List<InvoiceTransEntity> listOfInvoiceTrans;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=ContactTransEntity.class)
    private List<ContactTransEntity> listOfContactTrans;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=ChqbllPayrollEntity.class)
    private List<ChqbllPayrollEntity> listOfChqbllPayroll;

    @OneToMany(mappedBy="globalPrivateCode", targetEntity=ChqbllTransEntity.class)
    private List<ChqbllTransEntity> listOfChqbllTrans;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public GlobalPrivateCodeEntity() {
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
    //--- DATABASE MAPPING : par1id ( INT ) 
    public void setPar1id( Integer par1id ) {
        this.par1id = par1id;
    }
    public Integer getPar1id() {
        return this.par1id;
    }

    //--- DATABASE MAPPING : par2id ( INT ) 
    public void setPar2id( Integer par2id ) {
        this.par2id = par2id;
    }
    public Integer getPar2id() {
        return this.par2id;
    }

    //--- DATABASE MAPPING : par3id ( INT ) 
    public void setPar3id( Integer par3id ) {
        this.par3id = par3id;
    }
    public Integer getPar3id() {
        return this.par3id;
    }

    //--- DATABASE MAPPING : par4id ( INT ) 
    public void setPar4id( Integer par4id ) {
        this.par4id = par4id;
    }
    public Integer getPar4id() {
        return this.par4id;
    }

    //--- DATABASE MAPPING : par5id ( INT ) 
    public void setPar5id( Integer par5id ) {
        this.par5id = par5id;
    }
    public Integer getPar5id() {
        return this.par5id;
    }

    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
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
    public void setListOfInvoiceTransDetail( List<InvoiceTransDetailEntity> listOfInvoiceTransDetail ) {
        this.listOfInvoiceTransDetail = listOfInvoiceTransDetail;
    }
    public List<InvoiceTransDetailEntity> getListOfInvoiceTransDetail() {
        return this.listOfInvoiceTransDetail;
    }

    public void setListOfOrderTrans( List<OrderTransEntity> listOfOrderTrans ) {
        this.listOfOrderTrans = listOfOrderTrans;
    }
    public List<OrderTransEntity> getListOfOrderTrans() {
        return this.listOfOrderTrans;
    }

    public void setListOfBankTrans( List<BankTransEntity> listOfBankTrans ) {
        this.listOfBankTrans = listOfBankTrans;
    }
    public List<BankTransEntity> getListOfBankTrans() {
        return this.listOfBankTrans;
    }

    public void setListOfWaybillTransDetail( List<WaybillTransDetailEntity> listOfWaybillTransDetail ) {
        this.listOfWaybillTransDetail = listOfWaybillTransDetail;
    }
    public List<WaybillTransDetailEntity> getListOfWaybillTransDetail() {
        return this.listOfWaybillTransDetail;
    }

    public void setListOfSafeTrans( List<SafeTransEntity> listOfSafeTrans ) {
        this.listOfSafeTrans = listOfSafeTrans;
    }
    public List<SafeTransEntity> getListOfSafeTrans() {
        return this.listOfSafeTrans;
    }

    public void setListOfStockTrans( List<StockTransEntity> listOfStockTrans ) {
        this.listOfStockTrans = listOfStockTrans;
    }
    public List<StockTransEntity> getListOfStockTrans() {
        return this.listOfStockTrans;
    }

    public void setListOfChqbllPayrollDetail( List<ChqbllPayrollDetailEntity> listOfChqbllPayrollDetail ) {
        this.listOfChqbllPayrollDetail = listOfChqbllPayrollDetail;
    }
    public List<ChqbllPayrollDetailEntity> getListOfChqbllPayrollDetail() {
        return this.listOfChqbllPayrollDetail;
    }

    public void setListOfWaybillTrans( List<WaybillTransEntity> listOfWaybillTrans ) {
        this.listOfWaybillTrans = listOfWaybillTrans;
    }
    public List<WaybillTransEntity> getListOfWaybillTrans() {
        return this.listOfWaybillTrans;
    }

    public void setListOfOrderTransDetail( List<OrderTransDetailEntity> listOfOrderTransDetail ) {
        this.listOfOrderTransDetail = listOfOrderTransDetail;
    }
    public List<OrderTransDetailEntity> getListOfOrderTransDetail() {
        return this.listOfOrderTransDetail;
    }

    public void setListOfStockTransDetail( List<StockTransDetailEntity> listOfStockTransDetail ) {
        this.listOfStockTransDetail = listOfStockTransDetail;
    }
    public List<StockTransDetailEntity> getListOfStockTransDetail() {
        return this.listOfStockTransDetail;
    }

    public void setListOfInvoiceTrans( List<InvoiceTransEntity> listOfInvoiceTrans ) {
        this.listOfInvoiceTrans = listOfInvoiceTrans;
    }
    public List<InvoiceTransEntity> getListOfInvoiceTrans() {
        return this.listOfInvoiceTrans;
    }

    public void setListOfContactTrans( List<ContactTransEntity> listOfContactTrans ) {
        this.listOfContactTrans = listOfContactTrans;
    }
    public List<ContactTransEntity> getListOfContactTrans() {
        return this.listOfContactTrans;
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
        sb.append(par1id);
        sb.append("|");
        sb.append(par2id);
        sb.append("|");
        sb.append(par3id);
        sb.append("|");
        sb.append(par4id);
        sb.append("|");
        sb.append(par5id);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(insertBy);
        sb.append("|");
        sb.append(insertAt);
        sb.append("|");
        sb.append(updateBy);
        sb.append("|");
        sb.append(updateAt);
        sb.append("|");
        sb.append(workspace);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 

}
