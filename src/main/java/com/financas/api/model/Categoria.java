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

import lombok.Getter;
import lombok.Setter;

@Entity
@Audited
@Table(name = "categoria")
public class Categoria {

	@Id
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
	@SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Size(min = 3, max = 30)
	@Getter @Setter
	@Column(name = "nome", nullable = false, unique = true)
	private String nome;

	@Size(min = 3)
	@Getter @Setter
	@Column(name = "descricao", columnDefinition = "text", nullable = false)
	private String descricao;

	public Categoria() {

	}

	public Categoria(Long id) {
		this.setId(id);
	}
}
