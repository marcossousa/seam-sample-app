package com.marcossousa.despesas.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.marcossousa.despesas.entity.GrupoDespesa;


@Name("grupoDespesaHome")
public class GrupoDespesaHome extends EntityHome<GrupoDespesa>
{
    @RequestParameter Long tipoDespesaId;
    
    private boolean showDespesas;

    @Override
    public Object getId()
    {
        if (tipoDespesaId == null)
        {
            return super.getId();
        }
        else
        {
            return tipoDespesaId;
        }
    }

    @Override @Begin(join=true)
    public void create() {
        super.create();
    }
    
    public boolean isShowDespesas() {
		return showDespesas;
	}
    
    public void mostrarDespesas() {
    	showDespesas = !showDespesas;
    }

}
