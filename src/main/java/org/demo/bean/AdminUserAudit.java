/*
 * Created on 24 �ub 2016 ( Time 15:56:46 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class AdminUserAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 20 )
    private String username;


    private Date date;

    @Size( max = 30 )
    private String right;

    @Size( max = 45 )
    private String ip;

    @Size( max = 255 )
    private String description;

    @Size( max = 7 )
    private String logLevel;

    @Size( max = 30 )
    private String workspace;



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
    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setDate( Date date ) {
        this.date = date;
    }
    public Date getDate() {
        return this.date;
    }

    public void setRight( String right ) {
        this.right = right;
    }
    public String getRight() {
        return this.right;
    }

    public void setIp( String ip ) {
        this.ip = ip;
    }
    public String getIp() {
        return this.ip;
    }

    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setLogLevel( String logLevel ) {
        this.logLevel = logLevel;
    }
    public String getLogLevel() {
        return this.logLevel;
    }

    public void setWorkspace( String workspace ) {
        this.workspace = workspace;
    }
    public String getWorkspace() {
        return this.workspace;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(username);
        sb.append("|");
        sb.append(date);
        sb.append("|");
        sb.append(right);
        sb.append("|");
        sb.append(ip);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(logLevel);
        sb.append("|");
        sb.append(workspace);
        return sb.toString(); 
    } 


}
