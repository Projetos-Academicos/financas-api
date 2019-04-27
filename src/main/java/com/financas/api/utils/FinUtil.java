package com.financas.api.utils;

import com.financas.api.enums.FinEnumUtil;

public class FinUtil {

	public static String getValorPropriedadeEnum(Class<? extends Enum<?>> enumClass, String chavePropriedade) {
		FinEnumUtil finEnumUtil = new FinEnumUtil();
		return finEnumUtil.getValorPropriedadeEnum(enumClass, chavePropriedade);
	}
}
