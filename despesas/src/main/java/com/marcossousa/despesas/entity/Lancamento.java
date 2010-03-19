package com.marcossousa.despesas.entity;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name="tb_lancamento")
@SequenceGenerator(name = "LANCAMENTOSEQ", sequenceName = "LANCAMENTOSEQ")
public class Lancamento implements Serializable
{
	private static final long serialVersionUID = 7325337272156056192L;
	@Id
    @Column(name="lancamento_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LANCAMENTOSEQ")
    private Long id;
	@ManyToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	@JoinColumn(name="despesa_id")
	private Despesa despesa;
	@Column(name="valor", nullable=false, precision=2, length=10)
	private Double valor;
	@Column(name="data")
	private Date data;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="tipo", nullable=false)
	private TipoLancamento tipo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Despesa getDespesa() {
		return despesa;
	}
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public TipoLancamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

}
