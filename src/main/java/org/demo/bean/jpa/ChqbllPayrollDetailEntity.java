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
 * Persistent class for entity stored in table "chqbll_payroll_detail"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="chqbll_payroll_detail", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ChqbllPayrollDetailEntity.countAll", query="SELECT COUNT(x) FROM ChqbllPayrollDetailEntity x" )
} )
public class ChqbllPayrollDetailEntity implements Serializable {

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

    @Column(name="is_customer")
    private Boolean    isCustomer   ;

    @Column(name="portfolio_no", nullable=false)
    private Integer    portfolioNo  ;

    @Column(name="row_no", nullable=false)
    private Integer    rowNo        ;

    @Column(name="serial_no", length=25)
    private String     serialNo     ;

    @Temporal(TemporalType.DATE)
    @Column(name="due_date", nullable=false)
    private Date       dueDate      ;

    @Column(name="amount", nullable=false)
    private Double     amount       ;

    @Column(name="description", length=100)
    private String     description  ;

    @Column(name="due_year")
    private Integer    dueYear      ;

    @Column(name="due_month", length=7)
    private String     dueMonth     ;

    @Column(name="owner", length=70)
    private String     owner        ;

    @Column(name="payment_place", length=30)
    private String     paymentPlace ;

    @Column(name="bank_account_no", length=15)
    private String     bankAccountNo ;

    @Column(name="bank_name", length=50)
    private String     bankName     ;

    @Column(name="bank_branch", length=30)
    private String     bankBranch   ;

    @Column(name="correspondent_branch", length=30)
    private String     correspondentBranch ;

    @Column(name="contact_name", length=100)
    private String     contactName  ;

    @Column(name="last_step", nullable=false, length=15)
    private String     lastStep     ;

    @Column(name="last_contact_name", length=100)
    private String     lastContactName ;

    @Column(name="surety", length=100)
    private String     surety       ;

    @Column(name="surety_address", length=100)
    private String     suretyAddress ;

    @Column(name="surety_phone1", length=15)
    private String     suretyPhone1 ;

    @Column(name="surety_phone2", length=15)
    private String     suretyPhone2 ;

    @Column(name="exc_code", length=3)
    private String     excCode      ;

    @Column(name="exc_rate")
    private Double     excRate      ;

    @Column(name="exc_equivalent")
    private Double     excEquivalent ;

    @Column(name="total_paid")
    private Double     totalPaid    ;

    @Column(name="bank_id")
    private Integer    bankId       ;

    @Column(name="workspace", nullable=false)
    private Integer    workspace    ;

	// "cbtypeId" (column "cbtype_id") is not defined by itself because used as FK in a link 
	// "transId" (column "trans_id") is not defined by itself because used as FK in a link 
	// "transSourceId" (column "trans_source_id") is not defined by itself because used as FK in a link 
	// "transPointId" (column "trans_point_id") is not defined by itself because used as FK in a link 
	// "privateCodeId" (column "private_code_id") is not defined by itself because used as FK in a link 
	// "contactId" (column "contact_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="chqbllPayrollDetail", targetEntity=ChqbllTransDetailEntity.class)
    private List<ChqbllTransDetailEntity> listOfChqbllTransDetail;

    @ManyToOne
    @JoinColumn(name="private_code_id", referencedColumnName="id")
    private GlobalPrivateCodeEntity globalPrivateCode;

    @ManyToOne
    @JoinColumn(name="trans_id", referencedColumnName="id")
    private ChqbllPayrollEntity chqbllPayroll;

    @ManyToOne
    @JoinColumn(name="contact_id", referencedColumnName="id")
    private ContactEntity contact     ;

    @OneToMany(mappedBy="chqbllPayrollDetail", targetEntity=ChqbllDetailHistoryEntity.class)
    private List<ChqbllDetailHistoryEntity> listOfChqbllDetailHistory;

    @OneToMany(mappedBy="chqbllPayrollDetail", targetEntity=ChqbllDetailPartialEntity.class)
    private List<ChqbllDetailPartialEntity> listOfChqbllDetailPartial;

    @ManyToOne
    @JoinColumn(name="trans_source_id", referencedColumnName="id")
    private ChqbllPayrollSourceEntity chqbllPayrollSource;

    @ManyToOne
    @JoinColumn(name="trans_point_id", referencedColumnName="id")
    private GlobalTransPointEntity globalTransPoint;

    @ManyToOne
    @JoinColumn(name="cbtype_id", referencedColumnName="id")
    private ChqbllTypeEntity chqbllType  ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ChqbllPayrollDetailEntity() {
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

    //--- DATABASE MAPPING : is_customer ( BIT ) 
    public void setIsCustomer( Boolean isCustomer ) {
        this.isCustomer = isCustomer;
    }
    public Boolean getIsCustomer() {
        return this.isCustomer;
    }

    //--- DATABASE MAPPING : portfolio_no ( INT ) 
    public void setPortfolioNo( Integer portfolioNo ) {
        this.portfolioNo = portfolioNo;
    }
    public Integer getPortfolioNo() {
        return this.portfolioNo;
    }

    //--- DATABASE MAPPING : row_no ( INT ) 
    public void setRowNo( Integer rowNo ) {
        this.rowNo = rowNo;
    }
    public Integer getRowNo() {
        return this.rowNo;
    }

    //--- DATABASE MAPPING : serial_no ( VARCHAR ) 
    public void setSerialNo( String serialNo ) {
        this.serialNo = serialNo;
    }
    public String getSerialNo() {
        return this.serialNo;
    }

    //--- DATABASE MAPPING : due_date ( DATE ) 
    public void setDueDate( Date dueDate ) {
        this.dueDate = dueDate;
    }
    public Date getDueDate() {
        return this.dueDate;
    }

    //--- DATABASE MAPPING : amount ( DOUBLE ) 
    public void setAmount( Double amount ) {
        this.amount = amount;
    }
    public Double getAmount() {
        return this.amount;
    }

    //--- DATABASE MAPPING : description ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    //--- DATABASE MAPPING : due_year ( INT ) 
    public void setDueYear( Integer dueYear ) {
        this.dueYear = dueYear;
    }
    public Integer getDueYear() {
        return this.dueYear;
    }

    //--- DATABASE MAPPING : due_month ( VARCHAR ) 
    public void setDueMonth( String dueMonth ) {
        this.dueMonth = dueMonth;
    }
    public String getDueMonth() {
        return this.dueMonth;
    }

    //--- DATABASE MAPPING : owner ( VARCHAR ) 
    public void setOwner( String owner ) {
        this.owner = owner;
    }
    public String getOwner() {
        return this.owner;
    }

    //--- DATABASE MAPPING : payment_place ( VARCHAR ) 
    public void setPaymentPlace( String paymentPlace ) {
        this.paymentPlace = paymentPlace;
    }
    public String getPaymentPlace() {
        return this.paymentPlace;
    }

    //--- DATABASE MAPPING : bank_account_no ( VARCHAR ) 
    public void setBankAccountNo( String bankAccountNo ) {
        this.bankAccountNo = bankAccountNo;
    }
    public String getBankAccountNo() {
        return this.bankAccountNo;
    }

    //--- DATABASE MAPPING : bank_name ( VARCHAR ) 
    public void setBankName( String bankName ) {
        this.bankName = bankName;
    }
    public String getBankName() {
        return this.bankName;
    }

    //--- DATABASE MAPPING : bank_branch ( VARCHAR ) 
    public void setBankBranch( String bankBranch ) {
        this.bankBranch = bankBranch;
    }
    public String getBankBranch() {
        return this.bankBranch;
    }

    //--- DATABASE MAPPING : correspondent_branch ( VARCHAR ) 
    public void setCorrespondentBranch( String correspondentBranch ) {
        this.correspondentBranch = correspondentBranch;
    }
    public String getCorrespondentBranch() {
        return this.correspondentBranch;
    }

    //--- DATABASE MAPPING : contact_name ( VARCHAR ) 
    public void setContactName( String contactName ) {
        this.contactName = contactName;
    }
    public String getContactName() {
        return this.contactName;
    }

    //--- DATABASE MAPPING : last_step ( VARCHAR ) 
    public void setLastStep( String lastStep ) {
        this.lastStep = lastStep;
    }
    public String getLastStep() {
        return this.lastStep;
    }

    //--- DATABASE MAPPING : last_contact_name ( VARCHAR ) 
    public void setLastContactName( String lastContactName ) {
        this.lastContactName = lastContactName;
    }
    public String getLastContactName() {
        return this.lastContactName;
    }

    //--- DATABASE MAPPING : surety ( VARCHAR ) 
    public void setSurety( String surety ) {
        this.surety = surety;
    }
    public String getSurety() {
        return this.surety;
    }

    //--- DATABASE MAPPING : surety_address ( VARCHAR ) 
    public void setSuretyAddress( String suretyAddress ) {
        this.suretyAddress = suretyAddress;
    }
    public String getSuretyAddress() {
        return this.suretyAddress;
    }

    //--- DATABASE MAPPING : surety_phone1 ( VARCHAR ) 
    public void setSuretyPhone1( String suretyPhone1 ) {
        this.suretyPhone1 = suretyPhone1;
    }
    public String getSuretyPhone1() {
        return this.suretyPhone1;
    }

    //--- DATABASE MAPPING : surety_phone2 ( VARCHAR ) 
    public void setSuretyPhone2( String suretyPhone2 ) {
        this.suretyPhone2 = suretyPhone2;
    }
    public String getSuretyPhone2() {
        return this.suretyPhone2;
    }

    //--- DATABASE MAPPING : exc_code ( VARCHAR ) 
    public void setExcCode( String excCode ) {
        this.excCode = excCode;
    }
    public String getExcCode() {
        return this.excCode;
    }

    //--- DATABASE MAPPING : exc_rate ( DOUBLE ) 
    public void setExcRate( Double excRate ) {
        this.excRate = excRate;
    }
    public Double getExcRate() {
        return this.excRate;
    }

    //--- DATABASE MAPPING : exc_equivalent ( DOUBLE ) 
    public void setExcEquivalent( Double excEquivalent ) {
        this.excEquivalent = excEquivalent;
    }
    public Double getExcEquivalent() {
        return this.excEquivalent;
    }

    //--- DATABASE MAPPING : total_paid ( DOUBLE ) 
    public void setTotalPaid( Double totalPaid ) {
        this.totalPaid = totalPaid;
    }
    public Double getTotalPaid() {
        return this.totalPaid;
    }

    //--- DATABASE MAPPING : bank_id ( INT ) 
    public void setBankId( Integer bankId ) {
        this.bankId = bankId;
    }
    public Integer getBankId() {
        return this.bankId;
    }

    //--- DATABASE MAPPING : workspace ( INT ) 
    public void setWorkspace( Integer workspace ) {
        this.workspace = workspace;
    }
    public Integer getWorkspace() {
        return this.workspace;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfChqbllTransDetail( List<ChqbllTransDetailEntity> listOfChqbllTransDetail ) {
        this.listOfChqbllTransDetail = listOfChqbllTransDetail;
    }
    public List<ChqbllTransDetailEntity> getListOfChqbllTransDetail() {
        return this.listOfChqbllTransDetail;
    }

    public void setGlobalPrivateCode( GlobalPrivateCodeEntity globalPrivateCode ) {
        this.globalPrivateCode = globalPrivateCode;
    }
    public GlobalPrivateCodeEntity getGlobalPrivateCode() {
        return this.globalPrivateCode;
    }

    public void setChqbllPayroll( ChqbllPayrollEntity chqbllPayroll ) {
        this.chqbllPayroll = chqbllPayroll;
    }
    public ChqbllPayrollEntity getChqbllPayroll() {
        return this.chqbllPayroll;
    }

    public void setContact( ContactEntity contact ) {
        this.contact = contact;
    }
    public ContactEntity getContact() {
        return this.contact;
    }

    public void setListOfChqbllDetailHistory( List<ChqbllDetailHistoryEntity> listOfChqbllDetailHistory ) {
        this.listOfChqbllDetailHistory = listOfChqbllDetailHistory;
    }
    public List<ChqbllDetailHistoryEntity> getListOfChqbllDetailHistory() {
        return this.listOfChqbllDetailHistory;
    }

    public void setListOfChqbllDetailPartial( List<ChqbllDetailPartialEntity> listOfChqbllDetailPartial ) {
        this.listOfChqbllDetailPartial = listOfChqbllDetailPartial;
    }
    public List<ChqbllDetailPartialEntity> getListOfChqbllDetailPartial() {
        return this.listOfChqbllDetailPartial;
    }

    public void setChqbllPayrollSource( ChqbllPayrollSourceEntity chqbllPayrollSource ) {
        this.chqbllPayrollSource = chqbllPayrollSource;
    }
    public ChqbllPayrollSourceEntity getChqbllPayrollSource() {
        return this.chqbllPayrollSource;
    }

    public void setGlobalTransPoint( GlobalTransPointEntity globalTransPoint ) {
        this.globalTransPoint = globalTransPoint;
    }
    public GlobalTransPointEntity getGlobalTransPoint() {
        return this.globalTransPoint;
    }

    public void setChqbllType( ChqbllTypeEntity chqbllType ) {
        this.chqbllType = chqbllType;
    }
    public ChqbllTypeEntity getChqbllType() {
        return this.chqbllType;
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
        sb.append(isCustomer);
        sb.append("|");
        sb.append(portfolioNo);
        sb.append("|");
        sb.append(rowNo);
        sb.append("|");
        sb.append(serialNo);
        sb.append("|");
        sb.append(dueDate);
        sb.append("|");
        sb.append(amount);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(dueYear);
        sb.append("|");
        sb.append(dueMonth);
        sb.append("|");
        sb.append(owner);
        sb.append("|");
        sb.append(paymentPlace);
        sb.append("|");
        sb.append(bankAccountNo);
        sb.append("|");
        sb.append(bankName);
        sb.append("|");
        sb.append(bankBranch);
        sb.append("|");
        sb.append(correspondentBranch);
        sb.append("|");
        sb.append(contactName);
        sb.append("|");
        sb.append(lastStep);
        sb.append("|");
        sb.append(lastContactName);
        sb.append("|");
        sb.append(surety);
        sb.append("|");
        sb.append(suretyAddress);
        sb.append("|");
        sb.append(suretyPhone1);
        sb.append("|");
        sb.append(suretyPhone2);
        sb.append("|");
        sb.append(excCode);
        sb.append("|");
        sb.append(excRate);
        sb.append("|");
        sb.append(excEquivalent);
        sb.append("|");
        sb.append(totalPaid);
        sb.append("|");
        sb.append(bankId);
        sb.append("|");
        sb.append(workspace);
        return sb.toString(); 
    } 

}
