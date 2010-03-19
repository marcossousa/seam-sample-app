package com.marcossousa.despesas.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.marcossousa.despesas.entity.Agendamento;


@Name("agendamentoHome")
public class AgendamentoHome extends EntityHome<Agendamento>
{
    @RequestParameter Long agendamentoId;

    @Override
    public Object getId()
    {
        if (agendamentoId == null)
        {
            return super.getId();
        }
        else
        {
            return agendamentoId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
