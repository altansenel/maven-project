/*
 * Created on 24 �ub 2016 ( Time 15:56:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;


public class AdminUserGroup implements Serializable {

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
    @Size( min = 1, max = 30 )
    private String name;

    @Size( max = 50 )
    private String description;


    private Short editingTimeout;

    @Size( max = 10 )
    private String editingLimit;


    private Boolean hasEditDifDate;


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

    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setEditingTimeout( Short editingTimeout ) {
        this.editingTimeout = editingTimeout;
    }
    public Short getEditingTimeout() {
        return this.editingTimeout;
    }

    public void setEditingLimit( String editingLimit ) {
        this.editingLimit = editingLimit;
    }
    public String getEditingLimit() {
        return this.editingLimit;
    }

    public void setHasEditDifDate( Boolean hasEditDifDate ) {
        this.hasEditDifDate = hasEditDifDate;
    }
    public Boolean getHasEditDifDate() {
        return this.hasEditDifDate;
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
        sb.append(description);
        sb.append("|");
        sb.append(editingTimeout);
        sb.append("|");
        sb.append(editingLimit);
        sb.append("|");
        sb.append(hasEditDifDate);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 


}
