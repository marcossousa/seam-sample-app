package com.marcossousa.despesas.service;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import com.marcossousa.despesas.entity.Lancamento;
import com.marcossousa.despesas.exception.DespesaBusinessException;


@Name("lancamentoService")
public class LancamentoService {
	
	@In
	private EntityManager entityManager;
	
	public LancamentoService createLancamento(Lancamento lancamento) throws DespesaBusinessException {
		if (lancamento.getData().after(new Date())) {
			throw new DespesaBusinessException("msg.lancamento.dataFutura", "Data futura não permitida");
		}
		
		if (hasLancamentoDuplicada(lancamento)) {
			throw new DespesaBusinessException("msg.lancamento.duplicado", "Lançamento duplicado");
		}
		return this;
	}

	private boolean hasLancamentoDuplicada(Lancamento lancamento) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		Date dataInicial = c.getTime(); 
		c.set(Calendar.HOUR, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		Date dataFinal = c.getTime(); 
		return !((Long) entityManager.createQuery("SELECT COUNT(*) FROM Lancamento l " +
				"WHERE l.data BETWEEN :dt_inicial AND :dt_final AND l.despesa = :despesa and l.id <> :id")
				.setParameter("dt_inicial", dataInicial)
				.setParameter("dt_final", dataFinal)
				.setParameter("despesa", lancamento.getDespesa())
				.setParameter("id", lancamento.getId())
				.getSingleResult()).equals(0L);
	}
}
