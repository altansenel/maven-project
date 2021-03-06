/*
 * Created on 24 �ub 2016 ( Time 15:56:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;


public class AdminUserGivenRole implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    private Integer userGroupId;


    private Integer workspaceId;


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
    public void setUserGroupId( Integer userGroupId ) {
        this.userGroupId = userGroupId;
    }
    public Integer getUserGroupId() {
        return this.userGroupId;
    }

    public void setWorkspaceId( Integer workspaceId ) {
        this.workspaceId = workspaceId;
    }
    public Integer getWorkspaceId() {
        return this.workspaceId;
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
        sb.append(userGroupId);
        sb.append("|");
        sb.append(workspaceId);
        sb.append("|");
        sb.append(userRoleId);
        return sb.toString(); 
    } 


}
