/*
 * Created on 24 �ub 2016 ( Time 16:18:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "admin_user_group"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="admin_user_group", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AdminUserGroupEntity.countAll", query="SELECT COUNT(x) FROM AdminUserGroupEntity x" )
} )
public class AdminUserGroupEntity implements Serializable {

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
    @Column(name="name", nullable=false, length=30)
    private String     name         ;

    @Column(name="description", length=50)
    private String     description  ;

    @Column(name="editing_timeout")
    private Short      editingTimeout ;

    @Column(name="editing_limit", length=10)
    private String     editingLimit ;

    @Column(name="has_edit_dif_date")
    private Boolean    hasEditDifDate ;

    @Column(name="version")
    private Integer    version      ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="adminUserGroup", targetEntity=AdminUserEntity.class)
    private List<AdminUserEntity> listOfAdminUser;

    @OneToMany(mappedBy="adminUserGroup", targetEntity=AdminUserGivenRoleEntity.class)
    private List<AdminUserGivenRoleEntity> listOfAdminUserGivenRole;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AdminUserGroupEntity() {
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
    //--- DATABASE MAPPING : name ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : description ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    //--- DATABASE MAPPING : editing_timeout ( SMALLINT ) 
    public void setEditingTimeout( Short editingTimeout ) {
        this.editingTimeout = editingTimeout;
    }
    public Short getEditingTimeout() {
        return this.editingTimeout;
    }

    //--- DATABASE MAPPING : editing_limit ( VARCHAR ) 
    public void setEditingLimit( String editingLimit ) {
        this.editingLimit = editingLimit;
    }
    public String getEditingLimit() {
        return this.editingLimit;
    }

    //--- DATABASE MAPPING : has_edit_dif_date ( BIT ) 
    public void setHasEditDifDate( Boolean hasEditDifDate ) {
        this.hasEditDifDate = hasEditDifDate;
    }
    public Boolean getHasEditDifDate() {
        return this.hasEditDifDate;
    }

    //--- DATABASE MAPPING : version ( INT ) 
    public void setVersion( Integer version ) {
        this.version = version;
    }
    public Integer getVersion() {
        return this.version;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfAdminUser( List<AdminUserEntity> listOfAdminUser ) {
        this.listOfAdminUser = listOfAdminUser;
    }
    public List<AdminUserEntity> getListOfAdminUser() {
        return this.listOfAdminUser;
    }

    public void setListOfAdminUserGivenRole( List<AdminUserGivenRoleEntity> listOfAdminUserGivenRole ) {
        this.listOfAdminUserGivenRole = listOfAdminUserGivenRole;
    }
    public List<AdminUserGivenRoleEntity> getListOfAdminUserGivenRole() {
        return this.listOfAdminUserGivenRole;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
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
