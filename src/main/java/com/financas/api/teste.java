package com.financas.api;

import java.math.BigDecimal;

import com.financas.api.utils.FinUtil;

public class teste {

	public static void main(String[] args) {
		System.out.println(FinUtil.colocarMascaraReal(new BigDecimal(2500.000)));

	}

}
