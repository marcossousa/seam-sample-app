package com.marcossousa.despesas.exception;


import org.jboss.seam.Component;
import org.jboss.seam.international.Messages;

public class DespesaBusinessException extends Exception {

	private static final long serialVersionUID = 1477632765567306278L;
	
	public DespesaBusinessException(String message) {
		super(message);
	}

	public DespesaBusinessException(String i18nKey, String message) {
		super(i18nKey != null ? ((Messages) Component.getInstance(Messages.class)).getMessages().get(i18nKey) : message);
	}

}
