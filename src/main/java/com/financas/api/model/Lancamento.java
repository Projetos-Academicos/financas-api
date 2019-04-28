package com.financas.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.financas.api.enums.StatusEnum;
import com.financas.api.enums.TipoLancamentoEnum;

@Entity
@Audited
@Table(name = "lancamento")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamento")
	@SequenceGenerator(name = "seq_lancamento", sequenceName = "seq_lancamento", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Size(min = 3)
	@Column(name = "descricao", columnDefinition = "text", nullable = false)
	private String descricao;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	@NotNull
	@NumberFormat(style=Style.CURRENCY)
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data", nullable = false)
	private LocalDate data;

	@NotNull
	@Column(name = "parcelado", nullable = false)
	private boolean isParcelado;

	@Column(name = "quantidade_parcelas")
	private Integer qntParcelas;

	@NumberFormat(style=Style.CURRENCY)
	@Column(name = "valor_parcelas")
	private BigDecimal vlrParcelas;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private StatusEnum status;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoLancamentoEnum tipo;

	public Categoria getCategoria() {
		return this.categoria;
	}
	public LocalDate getData() {
		return this.data;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public Long getId() {
		return this.id;
	}
	public Integer getQntParcelas() {
		return this.qntParcelas;
	}
	public StatusEnum getStatus() {
		return this.status;
	}
	public TipoLancamentoEnum getTipo() {
		return this.tipo;
	}
	public BigDecimal getValor() {
		return this.valor;
	}
	public BigDecimal getVlrParcelas() {
		return this.vlrParcelas;
	}
	public boolean isParcelado() {
		return this.isParcelado;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setParcelado(boolean isParcelado) {
		this.isParcelado = isParcelado;
	}
	public void setQntParcelas(Integer qntParcelas) {
		this.qntParcelas = qntParcelas;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public void setTipo(TipoLancamentoEnum tipo) {
		this.tipo = tipo;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public void setVlrParcelas(BigDecimal vlrParcelas) {
		this.vlrParcelas = vlrParcelas;
	}

}
