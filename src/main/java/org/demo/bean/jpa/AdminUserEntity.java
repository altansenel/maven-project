/*
 * Created on 24 �ub 2016 ( Time 16:18:04 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

/**
 * Persistent class for entity stored in table "admin_user"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="admin_user", catalog="seyhan" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AdminUserEntity.countAll", query="SELECT COUNT(x) FROM AdminUserEntity x" )
} )
public class AdminUserEntity implements Serializable {

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
    @Column(name="username", nullable=false, length=20)
    private String     username     ;

    @Column(name="title", length=30)
    private String     title        ;

    @Column(name="email", length=100)
    private String     email        ;

    @Column(name="auth_token", length=32)
    private String     authToken    ;

    @Column(name="password_hash", length=60)
    private String     passwordHash ;

    @Column(name="is_admin")
    private Boolean    isAdmin      ;

    @Column(name="is_active")
    private Boolean    isActive     ;

    @Column(name="profile", length=20)
    private String     profile      ;

    @Column(name="workspace")
    private Integer    workspace    ;

    @Column(name="version")
    private Integer    version      ;

	// "userGroupId" (column "user_group_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="user_group_id", referencedColumnName="id")
    private AdminUserGroupEntity adminUserGroup;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AdminUserEntity() {
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
    //--- DATABASE MAPPING : username ( VARCHAR ) 
    public void setUsername( String username ) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    //--- DATABASE MAPPING : title ( VARCHAR ) 
    public void setTitle( String title ) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }

    //--- DATABASE MAPPING : email ( VARCHAR ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    //--- DATABASE MAPPING : auth_token ( VARCHAR ) 
    public void setAuthToken( String authToken ) {
        this.authToken = authToken;
    }
    public String getAuthToken() {
        return this.authToken;
    }

    //--- DATABASE MAPPING : password_hash ( VARCHAR ) 
    public void setPasswordHash( String passwordHash ) {
        this.passwordHash = passwordHash;
    }
    public String getPasswordHash() {
        return this.passwordHash;
    }

    //--- DATABASE MAPPING : is_admin ( BIT ) 
    public void setIsAdmin( Boolean isAdmin ) {
        this.isAdmin = isAdmin;
    }
    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    //--- DATABASE MAPPING : is_active ( BIT ) 
    public void setIsActive( Boolean isActive ) {
        this.isActive = isActive;
    }
    public Boolean getIsActive() {
        return this.isActive;
    }

    //--- DATABASE MAPPING : profile ( VARCHAR ) 
    public void setProfile( String profile ) {
        this.profile = profile;
    }
    public String getProfile() {
        return this.profile;
    }

    //--- DATABASE MAPPING : workspace ( INT ) 
    public void setWorkspace( Integer workspace ) {
        this.workspace = workspace;
    }
    public Integer getWorkspace() {
        return this.workspace;
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
    public void setAdminUserGroup( AdminUserGroupEntity adminUserGroup ) {
        this.adminUserGroup = adminUserGroup;
    }
    public AdminUserGroupEntity getAdminUserGroup() {
        return this.adminUserGroup;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(username);
        sb.append("|");
        sb.append(title);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(authToken);
        sb.append("|");
        sb.append(passwordHash);
        sb.append("|");
        sb.append(isAdmin);
        sb.append("|");
        sb.append(isActive);
        sb.append("|");
        sb.append(profile);
        sb.append("|");
        sb.append(workspace);
        sb.append("|");
        sb.append(version);
        return sb.toString(); 
    } 

}
