package com.marcossousa.despesas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.seam.annotations.security.management.RoleName;

@Entity
@Table(name = "tb_role")
@SequenceGenerator(name = "SQROLE", sequenceName = "SQROLE")
public class Role {
	private Integer roleId;
	private String rolename;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQROLE")
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@RoleName
	@Column(name = "role", length = 30, nullable = false)
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}