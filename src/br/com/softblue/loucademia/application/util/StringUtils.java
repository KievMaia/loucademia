package br.com.softblue.loucademia.application.util;

public class StringUtils {

	//Verifica se a string est� nula, ou vazia.
	public static boolean isEmpty(String s) {
		if (s == null) {
			return true;
		}
		//.trim() retira os espa�os da String.
		return s.trim().length() == 0;
	}
	
	//Adiciona zeros a esquerda.
	public static String leftZeroes(int value, int finalsize) {
		return String.format("%0" + finalsize + "d", value);
	}
}

