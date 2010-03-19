package com.marcossousa.despesas.session;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.marcossousa.despesas.entity.Role;


@Name("tbRoleList")
public class RoleList extends EntityQuery<Role> {

	private static final String EJBQL = "select tbRole from Role tbRole";

	private static final String[] RESTRICTIONS = { "lower(tbRole.rolename) like lower(concat(#{tbRoleList.tbRole.rolename},'%'))", };

	private Role tbRole = new Role();

	public RoleList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Role getTbRole() {
		return tbRole;
	}
}
