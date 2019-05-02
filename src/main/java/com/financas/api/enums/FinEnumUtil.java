package com.financas.api.enums;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FinEnumUtil {
	/**
	 * ResourceBundle com as inforamacoes das classes do sistema
	 */
	private ResourceBundle enumResouceBundle;

	private ResourceBundle getEnumResouceBundle() {
		if (this.enumResouceBundle == null) {
			this.enumResouceBundle = ResourceBundle.getBundle("enums");
		}
		return this.enumResouceBundle;
	}

	public String getValorPropriedadeEnum(Class<? extends Enum<?>> enumClazz, String chavePropriedade) {
		String valor = chavePropriedade;
		String key = enumClazz.getName() + "." + chavePropriedade;
		try {
			valor = this.getEnumResouceBundle().getString(key);
		} catch (MissingResourceException exc) {
			valor = chavePropriedade;
		}
		return valor;
	}

}
