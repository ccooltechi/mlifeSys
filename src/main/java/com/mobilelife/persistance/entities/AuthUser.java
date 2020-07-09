/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pods
 */
@Entity
@Table(name = "auth_user", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthUser.findAll", query = "SELECT a FROM AuthUser a")
    , @NamedQuery(name = "AuthUser.findById", query = "SELECT a FROM AuthUser a WHERE a.id = :id")
    , @NamedQuery(name = "AuthUser.findByPassword", query = "SELECT a FROM AuthUser a WHERE a.password = :password")
    , @NamedQuery(name = "AuthUser.findByLastLogin", query = "SELECT a FROM AuthUser a WHERE a.lastLogin = :lastLogin")
    , @NamedQuery(name = "AuthUser.findByIsSuperuser", query = "SELECT a FROM AuthUser a WHERE a.isSuperuser = :isSuperuser")
    , @NamedQuery(name = "AuthUser.findByUsername", query = "SELECT a FROM AuthUser a WHERE a.username = :username")
    , @NamedQuery(name = "AuthUser.findByFirstName", query = "SELECT a FROM AuthUser a WHERE a.firstName = :firstName")
    , @NamedQuery(name = "AuthUser.findByLastName", query = "SELECT a FROM AuthUser a WHERE a.lastName = :lastName")
    , @NamedQuery(name = "AuthUser.findByEmail", query = "SELECT a FROM AuthUser a WHERE a.email = :email")
    , @NamedQuery(name = "AuthUser.findByIsStaff", query = "SELECT a FROM AuthUser a WHERE a.isStaff = :isStaff")
    , @NamedQuery(name = "AuthUser.findByIsActive", query = "SELECT a FROM AuthUser a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "AuthUser.findByDateJoined", query = "SELECT a FROM AuthUser a WHERE a.dateJoined = :dateJoined")})
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Basic(optional = false)
    @Column(name = "is_superuser")
    private boolean isSuperuser;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "is_staff")
    private boolean isStaff;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "date_joined")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateJoined;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<AuthUserGroups> authUserGroupsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<AuthUserUserPermissions> authUserUserPermissionsCollection;

    public AuthUser() {
    }

    public AuthUser(Integer id) {
        this.id = id;
    }

    public AuthUser(Integer id, String password, boolean isSuperuser, String username, String firstName, String lastName, String email, boolean isStaff, boolean isActive, Date dateJoined) {
        this.id = id;
        this.password = password;
        this.isSuperuser = isSuperuser;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    @XmlTransient
    public Collection<AuthUserGroups> getAuthUserGroupsCollection() {
        return authUserGroupsCollection;
    }

    public void setAuthUserGroupsCollection(Collection<AuthUserGroups> authUserGroupsCollection) {
        this.authUserGroupsCollection = authUserGroupsCollection;
    }

    @XmlTransient
    public Collection<AuthUserUserPermissions> getAuthUserUserPermissionsCollection() {
        return authUserUserPermissionsCollection;
    }

    public void setAuthUserUserPermissionsCollection(Collection<AuthUserUserPermissions> authUserUserPermissionsCollection) {
        this.authUserUserPermissionsCollection = authUserUserPermissionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthUser)) {
            return false;
        }
        AuthUser other = (AuthUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AuthUser[ id=" + id + " ]";
    }
    
}
