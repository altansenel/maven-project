/*
 * Created on 24 �ub 2016 ( Time 15:56:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class StockBarcode implements Serializable {

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
    @Size( min = 1, max = 128 )
    private String barcode;

    @Size( max = 30 )
    private String prefix;

    @Size( max = 30 )
    private String suffix;


    private Short unitNo;


    private Boolean isPrimary;

    @Size( max = 20 )
    private String insertBy;


    private Date insertAt;

    @Size( max = 20 )
    private String updateBy;


    private Date updateAt;


    private Integer stockId;

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
    public void setBarcode( String barcode ) {
        this.barcode = barcode;
    }
    public String getBarcode() {
        return this.barcode;
    }

    public void setPrefix( String prefix ) {
        this.prefix = prefix;
    }
    public String getPrefix() {
        return this.prefix;
    }

    public void setSuffix( String suffix ) {
        this.suffix = suffix;
    }
    public String getSuffix() {
        return this.suffix;
    }

    public void setUnitNo( Short unitNo ) {
        this.unitNo = unitNo;
    }
    public Short getUnitNo() {
        return this.unitNo;
    }

    public void setIsPrimary( Boolean isPrimary ) {
        this.isPrimary = isPrimary;
    }
    public Boolean getIsPrimary() {
        return this.isPrimary;
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

    public void setStockId( Integer stockId ) {
        this.stockId = stockId;
    }
    public Integer getStockId() {
        return this.stockId;
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
        sb.append(barcode);
        sb.append("|");
        sb.append(prefix);
        sb.append("|");
        sb.append(suffix);
        sb.append("|");
        sb.append(unitNo);
        sb.append("|");
        sb.append(isPrimary);
        sb.append("|");
        sb.append(insertBy);
        sb.append("|");
        sb.append(insertAt);
        sb.append("|");
        sb.append(updateBy);
        sb.append("|");
        sb.append(updateAt);
        sb.append("|");
        sb.append(stockId);
        sb.append("|");
        sb.append(workspace);
        return sb.toString(); 
    } 


}