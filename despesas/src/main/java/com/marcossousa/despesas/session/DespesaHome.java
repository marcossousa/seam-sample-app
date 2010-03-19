package com.marcossousa.despesas.session;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.marcossousa.despesas.entity.Agendamento;
import com.marcossousa.despesas.entity.Despesa;
import com.marcossousa.despesas.entity.GrupoDespesa;


@Name("despesaHome")
public class DespesaHome extends EntityHome<Despesa>
{
    @RequestParameter Long despesaId;
    
    private List<GrupoDespesa> gruposDespesa;
    @In
    private EntityManager entityManager;

    @Override
    public Object getId()
    {
        if (despesaId == null)
        {
            return super.getId();
        }
        else
        {
            return despesaId;
        }
    }
    
    public void habilitarAgendamento() {
    	getInstance().setAgendamento(new Agendamento());
    	getInstance().getAgendamento().setDespesa(getInstance());
    }
    
    @End(beforeRedirect=true)
    public String cancel() {
    	return "/despesaList.xhtml";
    }
    
    

    @Override @Begin(join=true)
    public void create() {
        super.create();
    }

	@SuppressWarnings("unchecked")
	public List<GrupoDespesa> getGruposDespesa() {
		if (gruposDespesa == null) {
			gruposDespesa = entityManager.createQuery("SELECT new GrupoDespesa(g.id, g.name) FROM GrupoDespesa g ORDER BY g.name").getResultList();
		}
		return gruposDespesa;
	}

}
