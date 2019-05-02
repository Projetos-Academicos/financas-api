package com.financas.api.enums;

import java.io.Serializable;

public interface FinEnum <I extends Serializable> extends Serializable {

	public String getDescricao();

	public I getId();
}