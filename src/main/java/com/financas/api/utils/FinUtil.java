package com.financas.api.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.financas.api.enums.FinEnumUtil;

public class FinUtil {

	/**
	 * Converte um valor decimal em String para BigDecimal
	 *
	 * @param valor em String
	 * @return valor em BigDecimal
	 */
	public static BigDecimal converterStringParaBigDecimal(String valor) {
		String valorFormatado = retirarFormatacaoNumeroDecimal(valor);
		return new BigDecimal(valorFormatado);
	}

	/**
	 * Converte uma data em String para LocalDate
	 *
	 * @param data em string
	 * @return data em LocalDate
	 */
	public static LocalDate converterStringParaLocalDate(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(data, formatter);
		return localDate;
	}

	/**
	 * Metodo que retorna o valor da propriedade do enum passado
	 *
	 * @param enumClass
	 *            Classe referente ao Enum
	 * @param chavePropriedade
	 *            Chave do enum
	 * @return Valor via properties referente a chave passada
	 */
	public static String getValorPropriedadeEnum(Class<? extends Enum<?>> enumClass, String chavePropriedade) {
		FinEnumUtil finEnumUtil = new FinEnumUtil();
		return finEnumUtil.getValorPropriedadeEnum(enumClass, chavePropriedade);
	}

	/**
	 * Converte a string passada para um valor decimal que utiliza o ponto (.)
	 * como separador.
	 *
	 * @param valor
	 *            String que deseja-se converter
	 * @return String de valor convertida
	 */
	public static String retirarFormatacaoNumeroDecimal(String valor) {
		String retorno = null;
		if ((valor != null) && !valor.isEmpty()) {
			retorno = valor.replaceAll("\\.", "").replaceAll(",", ".");
		}
		return retorno;
	}
}
