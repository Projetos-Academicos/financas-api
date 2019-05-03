package com.financas.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import com.financas.api.dto.LancamentoDTO;
import com.financas.api.utils.FinUtil;

@Entity
@Audited
@Table(name = "lancamento")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamento")
	@SequenceGenerator(name = "seq_lancamento", sequenceName = "seq_lancamento", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "descricao", columnDefinition = "text")
	private String descricao;

	@Size(min = 3)
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	@NotNull
	@NumberFormat(style = Style.CURRENCY)
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data", nullable = false)
	private LocalDate data;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;

	@Column(name = "quantidade_parcelas")
	private Integer qntParcelas;

	@NumberFormat(style = Style.CURRENCY)
	@Column(name = "valor_parcelas")
	private BigDecimal vlrParcelas;

	@NotNull
	@Column(name = "parcelado", nullable = false)
	private boolean isParcelado;

	@NotNull
	@Column(name = "despesa", nullable = false)
	private boolean isDespesa;

	public Lancamento() {

	}

	public Lancamento(Long id) {
		this.setId(id);
	}

	/**
	 * Construtor de conversão do LancamentoDTO para o Objeto
	 *
	 * converterParaObjeto
	 *
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param categoriaId
	 * @param valor
	 * @param data
	 * @param isParcelado
	 * @param isDespesa
	 * @param qntParcelas
	 * @param vlrParcelas
	 * @param statusId
	 */
	public Lancamento(Long id, String nome, String descricao, Long categoriaId, String valor, String data,
			boolean isParcelado, boolean isDespesa, Integer qntParcelas, String vlrParcelas, Long statusId) {
		this.setId(id);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setCategoria(new Categoria(categoriaId));
		this.setParcelado(isParcelado);
		this.setData(FinUtil.converterStringParaLocalDate(data));
		this.setValor(FinUtil.converterStringParaBigDecimal(valor));
		this.setVlrParcelas(FinUtil.isNullOrEmpty(vlrParcelas) ? null : FinUtil.converterStringParaBigDecimal(vlrParcelas));
		this.setDespesa(isDespesa);
		this.setQntParcelas(qntParcelas);
		this.setStatus(new Status(statusId));
	}

	public LancamentoDTO converterParaDTO() {
		return new LancamentoDTO(this.id, this.nome, this.descricao, this.valor.toString(), FinUtil.converteDataParaString(this.data),
				this.isParcelado, this.isDespesa, this.qntParcelas, this.vlrParcelas != null ? this.vlrParcelas.toString() : null, this.categoria,
						this.status);
	}

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

	public String getNome() {
		return this.nome;
	}

	public Integer getQntParcelas() {
		return this.qntParcelas;
	}

	public Status getStatus() {
		return this.status;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public BigDecimal getVlrParcelas() {
		return this.vlrParcelas;
	}

	public boolean isDespesa() {
		return this.isDespesa;
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

	public void setDespesa(boolean isDespesa) {
		this.isDespesa = isDespesa;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setParcelado(boolean isParcelado) {
		this.isParcelado = isParcelado;
	}

	public void setQntParcelas(Integer qntParcelas) {
		this.qntParcelas = qntParcelas;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setVlrParcelas(BigDecimal vlrParcelas) {
		this.vlrParcelas = vlrParcelas;
	}

}
