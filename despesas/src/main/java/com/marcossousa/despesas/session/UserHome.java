package com.marcossousa.despesas.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.marcossousa.despesas.entity.User;


@Name("userHome")
public class UserHome extends EntityHome<User> {

	public void setTbUserUserid(Integer id) {
		setId(id);
	}

	public Integer getTbUserUserid() {
		return (Integer) getId();
	}

	@Override
	protected User createInstance() {
		User tbUser = new User();
		return tbUser;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public User getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
