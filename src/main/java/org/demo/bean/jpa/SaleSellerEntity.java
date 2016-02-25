/*
 * Created on 24 �ub 2016 ( Time 16:18:05 )
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
 * Persistent class for entity stored in table "sale_seller"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="sale_seller", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="SaleSellerEntity.countAll", query="SELECT COUNT(x) FROM SaleSellerEntity x" )
} )
public class SaleSellerEntity implements Serializable {

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
    @Column(name="name", nullable=false, length=30)
    private String     name         ;

    @Column(name="prim_rate", nullable=false)
    private Double     primRate     ;

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
    @OneToMany(mappedBy="saleSeller", targetEntity=StockTransDetailEntity.class)
    private List<StockTransDetailEntity> listOfStockTransDetail;

    @OneToMany(mappedBy="saleSeller", targetEntity=StockTransEntity.class)
    private List<StockTransEntity> listOfStockTrans;

    @OneToMany(mappedBy="saleSeller", targetEntity=WaybillTransEntity.class)
    private List<WaybillTransEntity> listOfWaybillTrans;

    @OneToMany(mappedBy="saleSeller", targetEntity=InvoiceTransDetailEntity.class)
    private List<InvoiceTransDetailEntity> listOfInvoiceTransDetail;

    @OneToMany(mappedBy="saleSeller", targetEntity=WaybillTransDetailEntity.class)
    private List<WaybillTransDetailEntity> listOfWaybillTransDetail;

    @OneToMany(mappedBy="saleSeller", targetEntity=InvoiceTransEntity.class)
    private List<InvoiceTransEntity> listOfInvoiceTrans;

    @OneToMany(mappedBy="saleSeller", targetEntity=ContactEntity.class)
    private List<ContactEntity> listOfContact;

    @OneToMany(mappedBy="saleSeller", targetEntity=OrderTransDetailEntity.class)
    private List<OrderTransDetailEntity> listOfOrderTransDetail;

    @OneToMany(mappedBy="saleSeller", targetEntity=OrderTransEntity.class)
    private List<OrderTransEntity> listOfOrderTrans;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public SaleSellerEntity() {
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
    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : prim_rate ( DOUBLE ) 
    public void setPrimRate( Double primRate ) {
        this.primRate = primRate;
    }
    public Double getPrimRate() {
        return this.primRate;
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
    public void setListOfStockTransDetail( List<StockTransDetailEntity> listOfStockTransDetail ) {
        this.listOfStockTransDetail = listOfStockTransDetail;
    }
    public List<StockTransDetailEntity> getListOfStockTransDetail() {
        return this.listOfStockTransDetail;
    }

    public void setListOfStockTrans( List<StockTransEntity> listOfStockTrans ) {
        this.listOfStockTrans = listOfStockTrans;
    }
    public List<StockTransEntity> getListOfStockTrans() {
        return this.listOfStockTrans;
    }

    public void setListOfWaybillTrans( List<WaybillTransEntity> listOfWaybillTrans ) {
        this.listOfWaybillTrans = listOfWaybillTrans;
    }
    public List<WaybillTransEntity> getListOfWaybillTrans() {
        return this.listOfWaybillTrans;
    }

    public void setListOfInvoiceTransDetail( List<InvoiceTransDetailEntity> listOfInvoiceTransDetail ) {
        this.listOfInvoiceTransDetail = listOfInvoiceTransDetail;
    }
    public List<InvoiceTransDetailEntity> getListOfInvoiceTransDetail() {
        return this.listOfInvoiceTransDetail;
    }

    public void setListOfWaybillTransDetail( List<WaybillTransDetailEntity> listOfWaybillTransDetail ) {
        this.listOfWaybillTransDetail = listOfWaybillTransDetail;
    }
    public List<WaybillTransDetailEntity> getListOfWaybillTransDetail() {
        return this.listOfWaybillTransDetail;
    }

    public void setListOfInvoiceTrans( List<InvoiceTransEntity> listOfInvoiceTrans ) {
        this.listOfInvoiceTrans = listOfInvoiceTrans;
    }
    public List<InvoiceTransEntity> getListOfInvoiceTrans() {
        return this.listOfInvoiceTrans;
    }

    public void setListOfContact( List<ContactEntity> listOfContact ) {
        this.listOfContact = listOfContact;
    }
    public List<ContactEntity> getListOfContact() {
        return this.listOfContact;
    }

    public void setListOfOrderTransDetail( List<OrderTransDetailEntity> listOfOrderTransDetail ) {
        this.listOfOrderTransDetail = listOfOrderTransDetail;
    }
    public List<OrderTransDetailEntity> getListOfOrderTransDetail() {
        return this.listOfOrderTransDetail;
    }

    public void setListOfOrderTrans( List<OrderTransEntity> listOfOrderTrans ) {
        this.listOfOrderTrans = listOfOrderTrans;
    }
    public List<OrderTransEntity> getListOfOrderTrans() {
        return this.listOfOrderTrans;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(primRate);
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