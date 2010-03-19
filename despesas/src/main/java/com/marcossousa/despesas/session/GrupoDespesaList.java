package com.marcossousa.despesas.session;

import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.framework.EntityQuery;

import com.marcossousa.despesas.entity.Agendamento;
import com.marcossousa.despesas.entity.GrupoDespesa;


@Name("grupoDespesaList")
public class GrupoDespesaList extends EntityQuery<GrupoDespesa>
{
    public GrupoDespesaList()
    {
        setEjbql("select grupoDespesa from GrupoDespesa grupoDespesa");
    }
    
    
}
