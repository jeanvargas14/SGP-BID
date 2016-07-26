/**
 * 
 */
package br.com.empresa.sgpbid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.empresa.sgpbid.programa.Programa;
import br.com.empresa.sgpbid.service.ICadastrobasico;

/**
 * 26 de jul de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
public class ProgramaMB {

	private static final String CADASTRO_JSF = "/restrito/jsf/programa/sgpCadPrograma.xhtml";
	private static final String CONSULTA_JSF = "/restrito/jsf/programa/sgpConPrograma.xhtml";
	
	@Inject
	private ICadastrobasico cadastrobasicoService;
	
	private List<Programa> lista;
	private Programa programa;	
	private Programa filtro;
	
	
	public ProgramaMB() {
		System.out.println("[ProgramaMB] instanciando ...");
	}

	@PostConstruct
	public void init(){
		programa = new Programa();
		filtro = new Programa();
		lista = new ArrayList<Programa>();
	}
	
	public String abrirConPrograma(){
		return CONSULTA_JSF;
	}
	
	public void consultarPrograma(){
		setLista(cadastrobasicoService.findProgramas(filtro));
	}
	
	public String novo(){
		programa = new Programa();
		return CADASTRO_JSF;
	}
	
	public String editar(){
		return CADASTRO_JSF;		
	}
	
	public void save(){
		try {
			System.out.println("Executando metodo salvar programa ...");
			cadastrobasicoService.salvarPrograma(programa);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		} catch(Exception e ){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar o programa", "");
	        FacesContext.getCurrentInstance().addMessage(null, message);						
		}		
	}

	public List<Programa> getLista() {
		return lista;
	}

	public void setLista(List<Programa> lista) {
		this.lista = lista;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Programa getFiltro() {
		return filtro;
	}

	public void setFiltro(Programa filtro) {
		this.filtro = filtro;
	}
}