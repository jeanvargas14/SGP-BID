package br.com.exemplojsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ExemploMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public ExemploMB() {
		System.out.println("Criando instancia de ExemploMB");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void executar(){
		System.out.println("Executando o método ...");
		System.out.println("Nome: "+nome);
	}
}