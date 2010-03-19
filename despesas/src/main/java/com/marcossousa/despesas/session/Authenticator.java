package com.marcossousa.despesas.session;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import com.marcossousa.despesas.entity.Role;
import com.marcossousa.despesas.entity.User;


@Name("authenticator")
public class Authenticator {
	@Logger
	private Log log;

	@In
	private Identity identity;
	@In
	private Credentials credentials;
	@In
	private EntityManager entityManager;

	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		try {

			User user = (User) entityManager
					.createQuery("from User where username = :username and password = :password")
					.setParameter("username", credentials.getUsername())
					.setParameter("password", credentials.getPassword())
					.getSingleResult();

			if (user.getRoles() != null) {
				for (Role mr : user.getRoles())
					identity.addRole(mr.getRolename());
			}

			return true;

		} catch (NoResultException ex) {
			return false;
		}
	}

}
