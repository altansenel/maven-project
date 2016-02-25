/*
 * Created on 24 �ub 2016 ( Time 15:56:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class ChqbllPayrollSource implements Serializable {

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

    @NotNull
    @Size( min = 1, max = 30 )
    private String name;

    @Size( max = 30 )
    private String suitableRight;

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
    public void setSort( String sort ) {
        this.sort = sort;
    }
    public String getSort() {
        return this.sort;
    }

    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setSuitableRight( String suitableRight ) {
        this.suitableRight = suitableRight;
    }
    public String getSuitableRight() {
        return this.suitableRight;
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
