package br.com.softblue.loucademia.application.util;

public class Validation {

	//Valida se o objeto recebido é uma intância de uma String e garante se não está vazio, se sim faz o cast para uma String
	public static void assertNotEmpty(Object obj){
		if (obj instanceof String) {
			String s = (String) obj;
			if (StringUtils.isEmpty(s)) {
				new ValidationException("O texto não pode ser nulo");
			}
		}
		if (obj == null) {
			 new ValidationException("Valor não pode ser nulo");
		}
	}
}
