/*
 * Created on 24 �ub 2016 ( Time 15:56:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class OrderTrans implements Serializable {

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
    private Integer receiptNo;

    @NotNull
    @Size( min = 1, max = 50 )
    private String right;


    private Boolean isCompleted;

    @NotNull
    private Date transDate;


    private Date realDate;


    private Date deliveryDate;

    @Size( max = 20 )
    private String transNo;


    private Boolean isTaxInclude;


    private Boolean roundingDigits;


    private Double total;


    private Double discountTotal;


    private Double subtotal;


    private Double roundingDiscount;


    private Double totalDiscountRate;


    private Double taxTotal;


    private Double netTotal;


    private Double plusFactorTotal;


    private Double minusFactorTotal;

    @Size( max = 100 )
    private String description;


    private Integer transYear;

    @Size( max = 7 )
    private String transMonth;


    private Integer contactId;

    @Size( max = 100 )
    private String contactName;

    @Size( max = 20 )
    private String contactTaxOffice;

    @Size( max = 15 )
    private String contactTaxNumber;

    @Size( max = 100 )
    private String contactAddress1;

    @Size( max = 100 )
    private String contactAddress2;

    @Size( max = 50 )
    private String consigner;

    @Size( max = 50 )
    private String recepient;

    @NotNull
    @Size( min = 1, max = 6 )
    private String transType;

    @Size( max = 3 )
    private String excCode;


    private Double excRate;


    private Double excEquivalent;


    private Boolean isTransfer;

    @Size( max = 20 )
    private String insertBy;


    private Date insertAt;

    @Size( max = 20 )
    private String updateBy;


    private Date updateAt;


    private Integer contactTransId;


    private Integer sellerId;


    private Integer transSourceId;


    private Integer transPointId;


    private Integer privateCodeId;


    private Integer depotId;


    private Integer waybillId;


    private Integer invoiceId;

    @Size( max = 10 )
    private String refModule;


    private Integer refId;


    private Integer statusId;

    @NotNull
    private Integer workspace;


    private Integer version;



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
    public void setReceiptNo( Integer receiptNo ) {
        this.receiptNo = receiptNo;
    }
    public Integer getReceiptNo() {
        return this.receiptNo;
    }

    public void setRight( String right ) {
        this.right = right;
    }
    public String getRight() {
        return this.right;
    }

    public void setIsCompleted( Boolean isCompleted ) {
        this.isCompleted = isCompleted;
    }
    public Boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setTransDate( Date transDate ) {
        this.transDate = transDate;
    }
    public Date getTransDate() {
        return this.transDate;
    }

    public void setRealDate( Date realDate ) {
        this.realDate = realDate;
    }
    public Date getRealDate() {
        return this.realDate;
    }

    public void setDeliveryDate( Date deliveryDate ) {
        this.deliveryDate = deliveryDate;
    }
    public Date getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setTransNo( String transNo ) {
        this.transNo = transNo;
    }
    public String getTransNo() {
        return this.transNo;
    }

    public void setIsTaxInclude( Boolean isTaxInclude ) {
        this.isTaxInclude = isTaxInclude;
    }
    public Boolean getIsTaxInclude() {
        return this.isTaxInclude;
    }

    public void setRoundingDigits( Boolean roundingDigits ) {
        this.roundingDigits = roundingDigits;
    }
    public Boolean getRoundingDigits() {
        return this.roundingDigits;
    }

    public void setTotal( Double total ) {
        this.total = total;
    }
    public Double getTotal() {
        return this.total;
    }

    public void setDiscountTotal( Double discountTotal ) {
        this.discountTotal = discountTotal;
    }
    public Double getDiscountTotal() {
        return this.discountTotal;
    }

    public void setSubtotal( Double subtotal ) {
        this.subtotal = subtotal;
    }
    public Double getSubtotal() {
        return this.subtotal;
    }

    public void setRoundingDiscount( Double roundingDiscount ) {
        this.roundingDiscount = roundingDiscount;
    }
    public Double getRoundingDiscount() {
        return this.roundingDiscount;
    }

    public void setTotalDiscountRate( Double totalDiscountRate ) {
        this.totalDiscountRate = totalDiscountRate;
    }
    public Double getTotalDiscountRate() {
        return this.totalDiscountRate;
    }

    public void setTaxTotal( Double taxTotal ) {
        this.taxTotal = taxTotal;
    }
    public Double getTaxTotal() {
        return this.taxTotal;
    }

    public void setNetTotal( Double netTotal ) {
        this.netTotal = netTotal;
    }
    public Double getNetTotal() {
        return this.netTotal;
    }

    public void setPlusFactorTotal( Double plusFactorTotal ) {
        this.plusFactorTotal = plusFactorTotal;
    }
    public Double getPlusFactorTotal() {
        return this.plusFactorTotal;
    }

    public void setMinusFactorTotal( Double minusFactorTotal ) {
        this.minusFactorTotal = minusFactorTotal;
    }
    public Double getMinusFactorTotal() {
        return this.minusFactorTotal;
    }

    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setTransYear( Integer transYear ) {
        this.transYear = transYear;
    }
    public Integer getTransYear() {
        return this.transYear;
    }

    public void setTransMonth( String transMonth ) {
        this.transMonth = transMonth;
    }
    public String getTransMonth() {
        return this.transMonth;
    }

    public void setContactId( Integer contactId ) {
        this.contactId = contactId;
    }
    public Integer getContactId() {
        return this.contactId;
    }

    public void setContactName( String contactName ) {
        this.contactName = contactName;
    }
    public String getContactName() {
        return this.contactName;
    }

    public void setContactTaxOffice( String contactTaxOffice ) {
        this.contactTaxOffice = contactTaxOffice;
    }
    public String getContactTaxOffice() {
        return this.contactTaxOffice;
    }

    public void setContactTaxNumber( String contactTaxNumber ) {
        this.contactTaxNumber = contactTaxNumber;
    }
    public String getContactTaxNumber() {
        return this.contactTaxNumber;
    }

    public void setContactAddress1( String contactAddress1 ) {
        this.contactAddress1 = contactAddress1;
    }
    public String getContactAddress1() {
        return this.contactAddress1;
    }

    public void setContactAddress2( String contactAddress2 ) {
        this.contactAddress2 = contactAddress2;
    }
    public String getContactAddress2() {
        return this.contactAddress2;
    }

    public void setConsigner( String consigner ) {
        this.consigner = consigner;
    }
    public String getConsigner() {
        return this.consigner;
    }

    public void setRecepient( String recepient ) {
        this.recepient = recepient;
    }
    public String getRecepient() {
        return this.recepient;
    }

    public void setTransType( String transType ) {
        this.transType = transType;
    }
    public String getTransType() {
        return this.transType;
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

    public void setIsTransfer( Boolean isTransfer ) {
        this.isTransfer = isTransfer;
    }
    public Boolean getIsTransfer() {
        return this.isTransfer;
    }

    public void setInsertBy( String insertBy ) {
        this.insertBy = insertBy;
    }
    public String getInsertBy() {
        return this.insertBy;
    }

    public void setInsertAt( Date insertAt ) {
        this.insertAt = insertAt;
    }
    public Date getInsertAt() {
        return this.insertAt;
    }

    public void setUpdateBy( String updateBy ) {
        this.updateBy = updateBy;
    }
    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateAt( Date updateAt ) {
        this.updateAt = updateAt;
    }
    public Date getUpdateAt() {
        return this.updateAt;
    }

    public void setContactTransId( Integer contactTransId ) {
        this.contactTransId = contactTransId;
    }
    public Integer getContactTransId() {
        return this.contactTransId;
    }

    public void setSellerId( Integer sellerId ) {
        this.sellerId = sellerId;
    }
    public Integer getSellerId() {
        return this.sellerId;
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

    public void setDepotId( Integer depotId ) {
        this.depotId = depotId;
    }
    public Integer getDepotId() {
        return this.depotId;
    }

    public void setWaybillId( Integer waybillId ) {
        this.waybillId = waybillId;
    }
    public Integer getWaybillId() {
        return this.waybillId;
    }

    public void setInvoiceId( Integer invoiceId ) {
        this.invoiceId = invoiceId;
    }
    public Integer getInvoiceId() {
        return this.invoiceId;
    }

    public void setRefModule( String refModule ) {
        this.refModule = refModule;
    }
    public String getRefModule() {
        return this.refModule;
    }

    public void setRefId( Integer refId ) {
        this.refId = refId;
    }
    public Integer getRefId() {
        return this.refId;
    }

    public void setStatusId( Integer statusId ) {
        this.statusId = statusId;
    }
    public Integer getStatusId() {
        return this.statusId;
    }

    public void setWorkspace( Integer workspace ) {
        this.workspace = workspace;
    }
    public Integer getWorkspace() {
        return this.workspace;
    }

    public void setVersion( Integer version ) {
        this.version = version;
    }
    public Integer getVersion() {
        return this.version;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(receiptNo);
        sb.append("|");
        sb.append(right);
        sb.append("|");
        sb.append(isCompleted);
        sb.append("|");
        sb.append(transDate);
        sb.append("|");
        sb.append(realDate);
        sb.append("|");
        sb.append(deliveryDate);
        sb.append("|");
        sb.append(transNo);
        sb.append("|");
        sb.append(isTaxInclude);
        sb.append("|");
        sb.append(roundingDigits);
        sb.append("|");
        sb.append(total);
        sb.append("|");
        sb.append(discountTotal);
        sb.append("|");
        sb.append(subtotal);
        sb.append("|");
        sb.append(roundingDiscount);
        sb.append("|");
        sb.append(totalDiscountRate);
        sb.append("|");
        sb.append(taxTotal);
        sb.append("|");
        sb.append(netTotal);
        sb.append("|");
        sb.append(plusFactorTotal);
        sb.append("|");
        sb.append(minusFactorTotal);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(transYear);
        sb.append("|");
        sb.append(transMonth);
        sb.append("|");
        sb.append(contactId);
        sb.append("|");
        sb.append(contactName);
        sb.append("|");
        sb.append(contactTaxOffice);
        sb.append("|");
        sb.append(contactTaxNumber);
        sb.append("|");
        sb.append(contactAddress1);
        sb.append("|");
        sb.append(contactAddress2);
        sb.append("|");
        sb.append(consigner);
        sb.append("|");
        sb.append(recepient);
        sb.append("|");
        sb.append(transType);
        sb.append("|");
        sb.append(excCode);
        sb.append("|");
        sb.append(excRate);
        sb.append("|");
        sb.append(excEquivalent);
        sb.append("|");
        sb.append(isTransfer);
        sb.append("|");
        sb.append(insertBy);
        sb.append("|");
        sb.append(insertAt);
        sb.append("|");
        sb.append(updateBy);
        sb.append("|");
        sb.append(updateAt);
        sb.append("|");
        sb.append(contactTransId);
        sb.append("|");
        sb.append(sellerId);
        sb.append("|");
        sb.append(transSourceId);
        sb.append("|");
        sb.append(transPointId);
        sb.append("|");
        sb.append(privateCodeId);
        sb.append("|");
        sb.append(depotId);
        sb.append("|");
        sb.append(waybillId);
        sb.append("|");
        sb.append(invoiceId);
        sb.append("|");
        sb.append(refModule);
        sb.append("|");
        sb.append(refId);
        sb.append("|");
        sb.append(statusId);
        sb.append("|");
        sb.append(workspace);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 


}
