package com.marcossousa.despesas.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.marcossousa.despesas.entity.Role;


@Name("tbRoleHome")
public class RoleHome extends EntityHome<Role> {

	private static final long serialVersionUID = 3980560519208635280L;

	public void setTbRoleRoleid(Integer id) {
		setId(id);
	}

	public Integer getTbRoleRoleid() {
		return (Integer) getId();
	}

	@Override
	protected Role createInstance() {
		Role tbRole = new Role();
		return tbRole;
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

	public Role getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
