package com.financas.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status")
	@SequenceGenerator(name = "seq_status", sequenceName = "seq_status", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Size(min=3)
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", columnDefinition = "text")
	private String descricao;

	public Status() {

	}

	public Status(Long id) {
		this.setId(id);
	}


	public String getDescricao() {
		return this.descricao;
	}
	public Long getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
