package com.marcossousa.despesas.session;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.framework.EntityQuery;
import org.jboss.seam.log.Log;

import com.marcossousa.despesas.entity.Despesa;


@Name("despesaList")
@Scope(ScopeType.CONVERSATION)
public class DespesaList extends EntityQuery<Despesa>
{
	@DataModel("ListaDespesa")
	private List<Despesa> resultList;
	@DataModelSelection("ListaDespesa")
    private Despesa despesa;
    @In(create=true)
    private DespesaHome despesaHome;
    @Logger
    private Log log;
	public DespesaList()
    {
        setEjbql("select despesa from Despesa despesa");
    }
    
    
    @Factory("ListaDespesa")
    @Begin(join=true)
    public void listar() {
    	log.info("Chama o método apenas para que o DataSelection seja populado");
        resultList = super.getResultList();
    }
    
    
    public void selecionar() {
    	log.info("Selecionando a despesa: #0 - #1", despesa.getId(), despesa.getDescricao());
    	despesaHome.setInstance(despesa);
    }
}
