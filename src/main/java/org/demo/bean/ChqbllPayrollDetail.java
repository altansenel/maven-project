/*
 * Created on 24 �ub 2016 ( Time 15:56:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class ChqbllPayrollDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    @Size( min = 1, max = 6 )
    private String sort;


    private Boolean isCustomer;

    @NotNull
    private Integer portfolioNo;

    @NotNull
    private Integer rowNo;

    @Size( max = 25 )
    private String serialNo;

    @NotNull
    private Date dueDate;

    @NotNull
    private Double amount;

    @Size( max = 100 )
    private String description;


    private Integer dueYear;

    @Size( max = 7 )
    private String dueMonth;

    @Size( max = 70 )
    private String owner;

    @Size( max = 30 )
    private String paymentPlace;

    @Size( max = 15 )
    private String bankAccountNo;

    @Size( max = 50 )
    private String bankName;

    @Size( max = 30 )
    private String bankBranch;

    @Size( max = 30 )
    private String correspondentBranch;

    @Size( max = 100 )
    private String contactName;

    @NotNull
    @Size( min = 1, max = 15 )
    private String lastStep;

    @Size( max = 100 )
    private String lastContactName;

    @Size( max = 100 )
    private String surety;

    @Size( max = 100 )
    private String suretyAddress;

    @Size( max = 15 )
    private String suretyPhone1;

    @Size( max = 15 )
    private String suretyPhone2;

    @Size( max = 3 )
    private String excCode;


    private Double excRate;


    private Double excEquivalent;


    private Double totalPaid;


    private Integer cbtypeId;


    private Integer transId;


    private Integer transSourceId;


    private Integer transPointId;


    private Integer privateCodeId;


    private Integer contactId;


    private Integer bankId;

    @NotNull
    private Integer workspace;



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
    public void setSort( String sort ) {
        this.sort = sort;
    }
    public String getSort() {
        return this.sort;
    }

    public void setIsCustomer( Boolean isCustomer ) {
        this.isCustomer = isCustomer;
    }
    public Boolean getIsCustomer() {
        return this.isCustomer;
    }

    public void setPortfolioNo( Integer portfolioNo ) {
        this.portfolioNo = portfolioNo;
    }
    public Integer getPortfolioNo() {
        return this.portfolioNo;
    }

    public void setRowNo( Integer rowNo ) {
        this.rowNo = rowNo;
    }
    public Integer getRowNo() {
        return this.rowNo;
    }

    public void setSerialNo( String serialNo ) {
        this.serialNo = serialNo;
    }
    public String getSerialNo() {
        return this.serialNo;
    }

    public void setDueDate( Date dueDate ) {
        this.dueDate = dueDate;
    }
    public Date getDueDate() {
        return this.dueDate;
    }

    public void setAmount( Double amount ) {
        this.amount = amount;
    }
    public Double getAmount() {
        return this.amount;
    }

    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDueYear( Integer dueYear ) {
        this.dueYear = dueYear;
    }
    public Integer getDueYear() {
        return this.dueYear;
    }

    public void setDueMonth( String dueMonth ) {
        this.dueMonth = dueMonth;
    }
    public String getDueMonth() {
        return this.dueMonth;
    }

    public void setOwner( String owner ) {
        this.owner = owner;
    }
    public String getOwner() {
        return this.owner;
    }

    public void setPaymentPlace( String paymentPlace ) {
        this.paymentPlace = paymentPlace;
    }
    public String getPaymentPlace() {
        return this.paymentPlace;
    }

    public void setBankAccountNo( String bankAccountNo ) {
        this.bankAccountNo = bankAccountNo;
    }
    public String getBankAccountNo() {
        return this.bankAccountNo;
    }

    public void setBankName( String bankName ) {
        this.bankName = bankName;
    }
    public String getBankName() {
        return this.bankName;
    }

    public void setBankBranch( String bankBranch ) {
        this.bankBranch = bankBranch;
    }
    public String getBankBranch() {
        return this.bankBranch;
    }

    public void setCorrespondentBranch( String correspondentBranch ) {
        this.correspondentBranch = correspondentBranch;
    }
    public String getCorrespondentBranch() {
        return this.correspondentBranch;
    }

    public void setContactName( String contactName ) {
        this.contactName = contactName;
    }
    public String getContactName() {
        return this.contactName;
    }

    public void setLastStep( String lastStep ) {
        this.lastStep = lastStep;
    }
    public String getLastStep() {
        return this.lastStep;
    }

    public void setLastContactName( String lastContactName ) {
        this.lastContactName = lastContactName;
    }
    public String getLastContactName() {
        return this.lastContactName;
    }

    public void setSurety( String surety ) {
        this.surety = surety;
    }
    public String getSurety() {
        return this.surety;
    }

    public void setSuretyAddress( String suretyAddress ) {
        this.suretyAddress = suretyAddress;
    }
    public String getSuretyAddress() {
        return this.suretyAddress;
    }

    public void setSuretyPhone1( String suretyPhone1 ) {
        this.suretyPhone1 = suretyPhone1;
    }
    public String getSuretyPhone1() {
        return this.suretyPhone1;
    }

    public void setSuretyPhone2( String suretyPhone2 ) {
        this.suretyPhone2 = suretyPhone2;
    }
    public String getSuretyPhone2() {
        return this.suretyPhone2;
    }

    public void setExcCode( String excCode ) {
        this.excCode = excCode;
    }
    public String getExcCode() {
        return this.excCode;
    }

    public void setExcRate( Double excRate ) {
        this.excRate = excRate;
    }
    public Double getExcRate() {
        return this.excRate;
    }

    public void setExcEquivalent( Double excEquivalent ) {
        this.excEquivalent = excEquivalent;
    }
    public Double getExcEquivalent() {
        return this.excEquivalent;
    }

    public void setTotalPaid( Double totalPaid ) {
        this.totalPaid = totalPaid;
    }
    public Double getTotalPaid() {
        return this.totalPaid;
    }

    public void setCbtypeId( Integer cbtypeId ) {
        this.cbtypeId = cbtypeId;
    }
    public Integer getCbtypeId() {
        return this.cbtypeId;
    }

    public void setTransId( Integer transId ) {
        this.transId = transId;
    }
    public Integer getTransId() {
        return this.transId;
    }

    public void setTransSourceId( Integer transSourceId ) {
        this.transSourceId = transSourceId;
    }
    public Integer getTransSourceId() {
        return this.transSourceId;
    }

    public void setTransPointId( Integer transPointId ) {
        this.transPointId = transPointId;
    }
    public Integer getTransPointId() {
        return this.transPointId;
    }

    public void setPrivateCodeId( Integer privateCodeId ) {
        this.privateCodeId = privateCodeId;
    }
    public Integer getPrivateCodeId() {
        return this.privateCodeId;
    }

    public void setContactId( Integer contactId ) {
        this.contactId = contactId;
    }
    public Integer getContactId() {
        return this.contactId;
    }

    public void setBankId( Integer bankId ) {
        this.bankId = bankId;
    }
    public Integer getBankId() {
        return this.bankId;
    }

    public void setWorkspace( Integer workspace ) {
        this.workspace = workspace;
    }
    public Integer getWorkspace() {
        return this.workspace;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
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
        sb.append(cbtypeId);
        sb.append("|");
        sb.append(transId);
        sb.append("|");
        sb.append(transSourceId);
        sb.append("|");
        sb.append(transPointId);
        sb.append("|");
        sb.append(privateCodeId);
        sb.append("|");
        sb.append(contactId);
        sb.append("|");
        sb.append(bankId);
        sb.append("|");
        sb.append(workspace);
        return sb.toString(); 
    } 


}
