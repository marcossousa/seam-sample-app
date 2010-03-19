package com.marcossousa.despesas.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.marcossousa.despesas.entity.Agendamento;


@Name("agendamentoList")
public class AgendamentoList extends EntityQuery<Agendamento>
{
    public AgendamentoList()
    {
        setEjbql("select agendamento from Agendamento agendamento");
    }
}
