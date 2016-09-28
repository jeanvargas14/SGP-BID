package br.com.empresa.sgpbid.util;

public class Utils {

	public static boolean isNullOrZero(Integer valor){
		return valor == null || valor == 0;
	}
	
	public static boolean isNullOrZero(Double valor){
		return valor == null || valor == 0D;
	}
	
	public static boolean isNullOrBlank(String valor){
		return valor == null || valor.isEmpty();
	}
}
