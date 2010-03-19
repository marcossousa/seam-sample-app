package com.marcossousa.despesas.session;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.marcossousa.despesas.entity.User;


@Name("userList")
public class UserList extends EntityQuery<User> {

	private static final long serialVersionUID = -2182390398240329173L;

	private static final String EJBQL = "select tbUser from User tbUser";

	private static final String[] RESTRICTIONS = {
			"lower(tbUser.firstName) like lower(concat(#{userList.tbUser.firstName},'%'))",
			"lower(tbUser.lastName) like lower(concat(#{userList.tbUser.lastName},'%'))",
			"lower(tbUser.username) like lower(concat(#{userList.tbUser.username},'%'))", };

	private User tbUser = new User();

	public UserList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public User getTbUser() {
		return tbUser;
	}
}
