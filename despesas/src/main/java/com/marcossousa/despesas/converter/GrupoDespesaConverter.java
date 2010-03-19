package com.marcossousa.despesas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.EntityManager;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

import com.marcossousa.despesas.entity.GrupoDespesa;


@Name("grupoDespesaConverter") 
@BypassInterceptors 
@org.jboss.seam.annotations.faces.Converter
public class GrupoDespesaConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		EntityManager entityManager = (EntityManager) Component.getInstance("entityManager");
	    entityManager.joinTransaction();
	    if (value!=null && !"".equals(value)) {
	    	Long id = new Long(value);
	    	return entityManager.find(GrupoDespesa.class, id);
	    }
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof GrupoDespesa) {
			return ((GrupoDespesa) arg2).getId() != null ? ((GrupoDespesa) arg2).getId().toString() : null;
		}
		return null;
	}

}
