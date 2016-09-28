package br.com.empresa.sgpbid.enums;

public enum NivelEnum {
		
	COMPONENTE(1),
	SUBCOMPONENTE(2);
	
	private int valor;
	
	NivelEnum(int valor){
		this.setValor(valor);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
