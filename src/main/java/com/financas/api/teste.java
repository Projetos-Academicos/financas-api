package com.financas.api;

import com.financas.api.utils.FinUtil;

public class teste {

	public static void main(String[] args) {

		System.out.println(FinUtil.converterStringParaBigDecimal("2.388,25"));
		System.out.println(FinUtil.colocarMascaraReal(FinUtil.converterStringParaBigDecimal("2.388,25")));

	}

}
