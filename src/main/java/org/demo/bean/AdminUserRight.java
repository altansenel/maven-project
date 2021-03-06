/*
 * Created on 24 �ub 2016 ( Time 15:56:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;


public class AdminUserRight implements Serializable {

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
    @Size( min = 1, max = 50 )
    private String name;

    @NotNull
    @Size( min = 1, max = 7 )
    private String rightLevel;


    private Boolean isCrud;


    private Integer userRoleId;



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

    public void setRightLevel( String rightLevel ) {
        this.rightLevel = rightLevel;
    }
    public String getRightLevel() {
        return this.rightLevel;
    }

    public void setIsCrud( Boolean isCrud ) {
        this.isCrud = isCrud;
    }
    public Boolean getIsCrud() {
        return this.isCrud;
    }

    public void setUserRoleId( Integer userRoleId ) {
        this.userRoleId = userRoleId;
    }
    public Integer getUserRoleId() {
        return this.userRoleId;
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
        sb.append(rightLevel);
        sb.append("|");
        sb.append(isCrud);
        sb.append("|");
        sb.append(userRoleId);
        return sb.toString(); 
    } 


}
