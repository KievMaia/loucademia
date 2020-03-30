package br.com.softblue.loucademia.application.util;

public class Validation {

	//Valida se o objeto recebido � uma int�ncia de uma String e garante se n�o est� vazio, se sim faz o cast para uma String
	public static void assertNotEmpty(Object obj){
		if (obj instanceof String) {
			String s = (String) obj;
			if (StringUtils.isEmpty(s)) {
				new ValidationException("O texto n�o pode ser nulo");
			}
		}
		if (obj == null) {
			 new ValidationException("Valor n�o pode ser nulo");
		}
	}
}
