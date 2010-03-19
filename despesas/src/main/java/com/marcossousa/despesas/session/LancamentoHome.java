package com.marcossousa.despesas.session;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityNotFoundException;
import org.jboss.seam.persistence.PersistenceProvider;

import com.marcossousa.despesas.entity.Despesa;
import com.marcossousa.despesas.entity.Lancamento;
import com.marcossousa.despesas.exception.DespesaBusinessException;
import com.marcossousa.despesas.service.LancamentoService;


@Name("lancamentoHome")
@Scope(ScopeType.CONVERSATION)
public class LancamentoHome {
	@RequestParameter
	Long lancamentoId;
	private List<Despesa> despesas;

	private Lancamento instance;
	
	public void setLancamentoId(Long lancamentoId) {
		this.lancamentoId = lancamentoId;
	}
	
	public Long getLancamentoId() {
		return lancamentoId;
	}

	@In
	private EntityManager entityManager;
	@In
	private FacesMessages facesMessages;
	@In(create=true)
	private LancamentoService lancamentoService;
	
	@Transactional
	public String save() throws DespesaBusinessException {
		lancamentoService.createLancamento(instance);
		
		boolean isManaged = isManaged();
		if (!isManaged()) {
			entityManager.persist(getInstance());
		}
		entityManager.flush();
		lancamentoId = (Long) PersistenceProvider.instance().getId(
				getInstance(), entityManager);
		facesMessages.addFromResourceBundle(isManaged ? "msg.alterado.sucesso"
				: "msg.incluido.sucesso");
		return "persisted";
	}

	@Transactional
	public String remove() {
		entityManager.remove(getInstance());
		entityManager.flush();
		facesMessages.addFromResourceBundle("msg.excluido.sucesso");
		return "removed";
	}

	@Transactional
	public boolean isManaged() {
		return getInstance() != null && entityManager.contains(getInstance());
	}

	public Lancamento getInstance() {
		if (instance == null) {
			instance = new Lancamento();
		}
		return instance;
	}
	
	@Begin
	public String editar() {
		instance = entityManager.find(Lancamento.class, lancamentoId);
		if (instance == null) {
			throw new EntityNotFoundException( lancamentoId, Lancamento.class );
		}
		
		return "sucesso";
	}
	
	@Begin
	@Restrict("#{s:hasRole('master')}")
	public String novo() {
		return "sucesso";
	}

	@SuppressWarnings("unchecked")
	public List<Despesa> getDespesas() {
		if (despesas == null) {
			despesas = entityManager
					.createQuery(
							"SELECT new Despesa(d.id, d.descricao) FROM Despesa d ORDER BY d.descricao")
					.getResultList();
		}
		return despesas;
	}

}
