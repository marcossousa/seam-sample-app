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
@Table(name="tb_agendamento")
@SequenceGenerator(name = "AGENDAMENTOSEQ", sequenceName = "AGENDAMENTOSEQ")
public class Agendamento implements Serializable
{
	private static final long serialVersionUID = 7832172548573807374L;
	@Id 
    @Column(name="agendamento_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENDAMENTOSEQ")
    private Long id;
	@ManyToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	@JoinColumn(name="despesa_id")
	private Despesa despesa;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="periodo", nullable=false)
	private Periodo periodo;
	@Column(name="valor", nullable=false, precision=2, length=10)
	private Double valor;
	@Column(name="dt_iniciarem")
	private Date iniciarEm;
	
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
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getIniciarEm() {
		return iniciarEm;
	}
	public void setIniciarEm(Date iniciarEm) {
		this.iniciarEm = iniciarEm;
	}

    
}
