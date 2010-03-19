package com.marcossousa.despesas.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.marcossousa.despesas.entity.Lancamento;


@Name("lancamentoList")
public class LancamentoList extends EntityQuery<Lancamento>
{
	private static final long serialVersionUID = -6371824297778437362L;
	private static final int ROWS_PER_PAGE = 5;
	
    public LancamentoList()
    {
        setEjbql("select lancamento from Lancamento lancamento");
        setOrder("lancamento.data");
        setMaxResults(ROWS_PER_PAGE);
    }
  
}
