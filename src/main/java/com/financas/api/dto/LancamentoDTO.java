package com.financas.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.financas.api.model.Categoria;
import com.financas.api.model.Lancamento;
import com.financas.api.model.Status;

import lombok.Getter;
import lombok.Setter;

public class LancamentoDTO {

	@NotNull
	@Getter @Setter
	private boolean despesa;

	@Getter @Setter
	@Size(min = 3, max = 30)
	private String nome;

	@Size(min = 3)
	@Getter @Setter
	private String descricao;

	@NotNull
	@Getter @Setter
	private String valor;

	@NotNull
	@Getter @Setter
	private String data;

	@NotNull
	@Getter @Setter
	private Long categoriaId;

	@NotNull
	@Getter @Setter
	private Long statusId;

	@Getter @Setter
	private Long id;

	@Getter @Setter
	private boolean parcelado;

	@Getter @Setter
	private Integer qntParcelas;

	@Getter @Setter
	private String vlrParcelas;

	@Getter @Setter
	private Categoria categoria;

	@Getter @Setter
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
		this.setId(id);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setData(data);
		this.setParcelado(parcelado);
		this.setDespesa(despesa);
		this.setQntParcelas(qntParcelas);
		this.setVlrParcelas(vlrParcelas);
		this.setCategoria(categoria);
		this.setCategoriaId(categoria.getId());
		this.setStatus(status);
		this.setStatusId(status.getId());
	}

	public Lancamento converterParaObjeto() {
		return new Lancamento(this.getId(), this.getNome(), this.getDescricao(), this.getCategoriaId(), this.getValor(), this.getData(),
				this.isParcelado(), this.isDespesa(), this.getQntParcelas(), this.getVlrParcelas(), this.getStatusId());
	}

}
