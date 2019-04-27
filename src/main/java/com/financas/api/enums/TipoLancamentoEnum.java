package com.financas.api.enums;

import com.financas.api.utils.FinUtil;

public enum TipoLancamentoEnum implements FinEnum<Long>{
	ENTRADA(1L), SAIDA(2L);

	public static TipoLancamentoEnum getEnumPorDescricao(String descricao) {
		for (TipoLancamentoEnum tipoLancamentoEnum : TipoLancamentoEnum.values()) {
			if (tipoLancamentoEnum.getDescricao().equalsIgnoreCase(descricao)) {
				return tipoLancamentoEnum;
			}
		}
		return null;
	}

	public static TipoLancamentoEnum getEnumPorName(String name) {
		for (TipoLancamentoEnum tipoLancamentoEnum : TipoLancamentoEnum.values()) {
			if (tipoLancamentoEnum.name().equalsIgnoreCase(name)) {
				return tipoLancamentoEnum;
			}
		}
		return null;
	}

	private String descricao;

	private Long id;

	private TipoLancamentoEnum(final Long id) {
		this.id = id;
	}

	@Override
	public String getDescricao() {
		if (this.descricao == null) {
			this.descricao = FinUtil.getValorPropriedadeEnum(this.getClass(), this.name());
		}
		return this.descricao;
	}

	@Override
	public Long getId() {
		return this.id;
	}

}
