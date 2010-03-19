package com.marcossousa.despesas.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.seam.annotations.security.management.UserFirstName;
import org.jboss.seam.annotations.security.management.UserLastName;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.annotations.security.management.UserPrincipal;
import org.jboss.seam.annotations.security.management.UserRoles;

@Entity
@Table(name = "tb_user")
@SequenceGenerator(name = "SQUSER", sequenceName = "SQUSER")
public class User {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String username;
	private String passwordHash;
	private Date lastLogin;
	private Boolean enabled;
	private Set<Role> roles;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQUSER")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@UserFirstName
	@Column(name="first_name", length=50, nullable=false)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@UserLastName
	@Column(name="last_name", length=50, nullable=false)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@UserPrincipal
	@Column(name="user_name", length=20, nullable=false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@UserPassword(hash = "md5")
	@Column(name="password", length=20, nullable=false)
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	@Column(name="enable", length=1, nullable=false)
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(name="dt_last_login", nullable=true)
	public Date getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@UserRoles
	@ManyToMany(targetEntity = Role.class)
	@JoinTable(name = "tb_user_roles",
	joinColumns = @JoinColumn(name = "UserId"),
	inverseJoinColumns = @JoinColumn(name = "RoleId"))
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}