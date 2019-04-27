package com.financas.api.enums;

import com.financas.api.utils.FinUtil;

public enum StatusEnum implements FinEnum<Long>{
	PAGO(1L), RECEBIDO(2L), FUTURO(3L), PARCELAMENTO(4L);

	public static StatusEnum getEnumPorDescricao(String descricao) {
		for (StatusEnum statusEnum : StatusEnum.values()) {
			if (statusEnum.getDescricao().equalsIgnoreCase(descricao)) {
				return statusEnum;
			}
		}
		return null;
	}

	public static StatusEnum getEnumPorName(String name) {
		for (StatusEnum statusEnum : StatusEnum.values()) {
			if (statusEnum.name().equalsIgnoreCase(name)) {
				return statusEnum;
			}
		}
		return null;
	}

	private String descricao;

	private Long id;

	private StatusEnum(final Long id) {
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
