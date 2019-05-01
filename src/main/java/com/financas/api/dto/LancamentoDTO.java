package com.financas.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.financas.api.model.Categoria;
import com.financas.api.model.Lancamento;
import com.financas.api.model.Status;

public class LancamentoDTO {

	@NotNull
	private boolean despesa;

	@Size(min = 3, max = 30)
	private String nome;

	@Size(min = 3)
	private String descricao;

	@NotNull
	private String valor;

	@NotNull
	private String data;

	@NotNull
	private Long categoriaId;

	@NotNull
	private Long statusId;

	private Long id;
	private boolean parcelado;
	private Integer qntParcelas;
	private String vlrParcelas;
	private Categoria categoria;
	private Status status;

	public LancamentoDTO() {

	}

	/**
	 * Construtor para converter o Objeto Lancamento para o DTO
	 *
	 * converterParaDTO
	 *
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param categoriaId
	 * @param valor
	 * @param data
	 * @param parcelado
	 * @param despesa
	 * @param qntParcelas
	 * @param vlrParcelas
	 * @param statusId
	 */
	public LancamentoDTO(Long id, String nome, String descricao, String valor, String data, boolean parcelado,
			boolean despesa, Integer qntParcelas, String vlrParcelas, Categoria categoria, Status status) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoriaId = categoria.getId();
		this.valor = valor;
		this.data = data;
		this.setParcelado(parcelado);
		this.setDespesa(despesa);
		this.qntParcelas = qntParcelas;
		this.vlrParcelas = vlrParcelas;
		this.statusId = status.getId();
		this.categoria = categoria;
		this.status = status;
	}

	public Lancamento converterParaObjeto() {
		return new Lancamento(this.id, this.nome, this.descricao, this.categoriaId, this.valor, this.data,
				this.parcelado, this.despesa, this.qntParcelas, this.vlrParcelas, this.statusId);
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public Long getCategoriaId() {
		return this.categoriaId;
	}

	public String getData() {
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

	public Long getStatusId() {
		return this.statusId;
	}

	public String getValor() {
		return this.valor;
	}

	public String getVlrParcelas() {
		return this.vlrParcelas;
	}

	public boolean isDespesa() {
		return this.despesa;
	}

	public boolean isParcelado() {
		return this.parcelado;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDespesa(boolean despesa) {
		this.despesa = despesa;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setParcelado(boolean parcelado) {
		this.parcelado = parcelado;
	}

	public void setQntParcelas(Integer qntParcelas) {
		this.qntParcelas = qntParcelas;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setVlrParcelas(String vlrParcelas) {
		this.vlrParcelas = vlrParcelas;
	}

}
