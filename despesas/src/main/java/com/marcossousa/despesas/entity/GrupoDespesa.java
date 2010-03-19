package com.marcossousa.despesas.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name="tb_grupodespesa")
@SequenceGenerator(name = "GRUPODESPESASEQ", sequenceName = "GRUPODESPESASEQ")
public class GrupoDespesa implements Serializable
{
	private static final long serialVersionUID = -8504912940883431698L;
	@Id 
    @Column(name="grupodespesa_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRUPODESPESASEQ")
    private Long id;
	@NotNull
    @Column(name="name")
    @Length(max = 60, min=4)
    private String name;
	@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY, mappedBy="grupoDespesa")
	@JoinColumn(name="grupodespesa_id")
	private List<Despesa> despesas;

	public GrupoDespesa() { }
	
	public GrupoDespesa(Long id, String name) { 
		this.id = id;
		this.name = name;
	}
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		} else if (obj instanceof GrupoDespesa) {
			return id != null && id.equals(((GrupoDespesa) obj).id);
		}
		return false;
	}

}
