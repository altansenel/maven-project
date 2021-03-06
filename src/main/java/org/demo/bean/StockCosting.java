/*
 * Created on 24 �ub 2016 ( Time 15:56:50 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class StockCosting implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 30 )
    private String name;

    @NotNull
    @Size( min = 1, max = 100 )
    private String properties;


    private Date execDate;

    @NotNull
    private Date calcDate;

    @NotNull
    @Size( min = 1, max = 8 )
    private String costingType;

    @Size( max = 30 )
    private String providerCode;


    private Integer transPointId;


    private Integer categoryId;


    private Integer depotId;


    private Integer stockId;


    private Integer extraField0Id;


    private Integer extraField1Id;


    private Integer extraField2Id;


    private Integer extraField3Id;


    private Integer extraField4Id;


    private Integer extraField5Id;


    private Integer extraField6Id;


    private Integer extraField7Id;


    private Integer extraField8Id;


    private Integer extraField9Id;

    @Size( max = 20 )
    private String insertBy;


    private Date insertAt;

    @Size( max = 20 )
    private String updateBy;


    private Date updateAt;


    private Boolean isActive;

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
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setProperties( String properties ) {
        this.properties = properties;
    }
    public String getProperties() {
        return this.properties;
    }

    public void setExecDate( Date execDate ) {
        this.execDate = execDate;
    }
    public Date getExecDate() {
        return this.execDate;
    }

    public void setCalcDate( Date calcDate ) {
        this.calcDate = calcDate;
    }
    public Date getCalcDate() {
        return this.calcDate;
    }

    public void setCostingType( String costingType ) {
        this.costingType = costingType;
    }
    public String getCostingType() {
        return this.costingType;
    }

    public void setProviderCode( String providerCode ) {
        this.providerCode = providerCode;
    }
    public String getProviderCode() {
        return this.providerCode;
    }

    public void setTransPointId( Integer transPointId ) {
        this.transPointId = transPointId;
    }
    public Integer getTransPointId() {
        return this.transPointId;
    }

    public void setCategoryId( Integer categoryId ) {
        this.categoryId = categoryId;
    }
    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setDepotId( Integer depotId ) {
        this.depotId = depotId;
    }
    public Integer getDepotId() {
        return this.depotId;
    }

    public void setStockId( Integer stockId ) {
        this.stockId = stockId;
    }
    public Integer getStockId() {
        return this.stockId;
    }

    public void setExtraField0Id( Integer extraField0Id ) {
        this.extraField0Id = extraField0Id;
    }
    public Integer getExtraField0Id() {
        return this.extraField0Id;
    }

    public void setExtraField1Id( Integer extraField1Id ) {
        this.extraField1Id = extraField1Id;
    }
    public Integer getExtraField1Id() {
        return this.extraField1Id;
    }

    public void setExtraField2Id( Integer extraField2Id ) {
        this.extraField2Id = extraField2Id;
    }
    public Integer getExtraField2Id() {
        return this.extraField2Id;
    }

    public void setExtraField3Id( Integer extraField3Id ) {
        this.extraField3Id = extraField3Id;
    }
    public Integer getExtraField3Id() {
        return this.extraField3Id;
    }

    public void setExtraField4Id( Integer extraField4Id ) {
        this.extraField4Id = extraField4Id;
    }
    public Integer getExtraField4Id() {
        return this.extraField4Id;
    }

    public void setExtraField5Id( Integer extraField5Id ) {
        this.extraField5Id = extraField5Id;
    }
    public Integer getExtraField5Id() {
        return this.extraField5Id;
    }

    public void setExtraField6Id( Integer extraField6Id ) {
        this.extraField6Id = extraField6Id;
    }
    public Integer getExtraField6Id() {
        return this.extraField6Id;
    }

    public void setExtraField7Id( Integer extraField7Id ) {
        this.extraField7Id = extraField7Id;
    }
    public Integer getExtraField7Id() {
        return this.extraField7Id;
    }

    public void setExtraField8Id( Integer extraField8Id ) {
        this.extraField8Id = extraField8Id;
    }
    public Integer getExtraField8Id() {
        return this.extraField8Id;
    }

    public void setExtraField9Id( Integer extraField9Id ) {
        this.extraField9Id = extraField9Id;
    }
    public Integer getExtraField9Id() {
        return this.extraField9Id;
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

    public void setIsActive( Boolean isActive ) {
        this.isActive = isActive;
    }
    public Boolean getIsActive() {
        return this.isActive;
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
        sb.append(name);
        sb.append("|");
        sb.append(properties);
        sb.append("|");
        sb.append(execDate);
        sb.append("|");
        sb.append(calcDate);
        sb.append("|");
        sb.append(costingType);
        sb.append("|");
        sb.append(providerCode);
        sb.append("|");
        sb.append(transPointId);
        sb.append("|");
        sb.append(categoryId);
        sb.append("|");
        sb.append(depotId);
        sb.append("|");
        sb.append(stockId);
        sb.append("|");
        sb.append(extraField0Id);
        sb.append("|");
        sb.append(extraField1Id);
        sb.append("|");
        sb.append(extraField2Id);
        sb.append("|");
        sb.append(extraField3Id);
        sb.append("|");
        sb.append(extraField4Id);
        sb.append("|");
        sb.append(extraField5Id);
        sb.append("|");
        sb.append(extraField6Id);
        sb.append("|");
        sb.append(extraField7Id);
        sb.append("|");
        sb.append(extraField8Id);
        sb.append("|");
        sb.append(extraField9Id);
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
