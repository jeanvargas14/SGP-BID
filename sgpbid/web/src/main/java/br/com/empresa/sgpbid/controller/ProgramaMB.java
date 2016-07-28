/**
 * 
 */
package br.com.empresa.sgpbid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import br.com.empresa.sgpbid.programa.Programa;
import br.com.empresa.sgpbid.service.ICadastrobasico;

/**
 * 26 de jul de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
@SessionScoped
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
	
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Programa Selected", ""+((Programa) event.getObject()).getCdPrograma());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void save(){
		try {
			System.out.println("Executando metodo salvar programa ...");
			cadastrobasicoService.salvarPrograma(programa);
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Sucesso",  "Operação realizada com sucesso"));			
		} catch(Exception e ){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Erro ao realizar a operação"));
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