package com.marcossousa.despesas.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

@Entity
@Table(name="tb_despesa")
@SequenceGenerator(name = "DESPESASEQ", sequenceName = "DESPESASEQ")
public class Despesa implements Serializable
{
	private static final long serialVersionUID = -8504912940883431698L;
	@Id 
    @Column(name="despesa_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESPESASEQ")
    private Long id;
	@NotEmpty
    @Column(name="descricao")
    @Length(max = 60, min=3)
    private String descricao;
	@ManyToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	@JoinColumn(name="grupodespesa_id")
	private GrupoDespesa grupoDespesa;
	@Column(name="flag_agendamento")
	private Boolean isDespesaAgendada;
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="agendamento_id")
	private Agendamento agendamento;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="categoria")
	private Categoria categoria;	
	
	public Despesa() {
	}
	
	public Despesa(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GrupoDespesa getGrupoDespesa() {
		return grupoDespesa;
	}

	public void setGrupoDespesa(GrupoDespesa grupoDespesa) {
		this.grupoDespesa = grupoDespesa;
	}

	public Boolean getIsDespesaAgendada() {
		return isDespesaAgendada;
	}

	public void setIsDespesaAgendada(Boolean isDespesaAgendada) {
		this.isDespesaAgendada = isDespesaAgendada;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		} else if (obj instanceof Despesa) {
			return id != null && id.equals(((Despesa) obj).id);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}
    
   
}
