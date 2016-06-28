/**
 * 
 */
package br.com.empresa.sgpbid.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.empresa.sgpbid.model.projeto.Projeto;
import br.com.empresa.sgpbid.service.ICadastrobasico;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Model
//@ManagedBean
//@SessionScoped
public class ProjetoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String CADASTRO_JSF = "/jsf/projeto/sgpCadProjeto";
	private static final String CONSULTA_JSF = "/jsf/projeto/sgpConProjeto";
	
	private List<Projeto> projetos;
	
	private Projeto projeto;
	
	private Projeto filtro;
	
	@Inject
	private ICadastrobasico cadastrobasicoService;
	
	public ProjetoMB() {
		System.out.println("Criando instancia de ProjetoMB");		
	}
	
	@PostConstruct
	public void init(){
		projeto  = new Projeto();
		projetos = new ArrayList<Projeto>();
		filtro = new Projeto();
	}
	
	public String novo(){
		System.out.println("Executando o m�todo NOVO projeto....");
		projeto = new Projeto();
		return CADASTRO_JSF;
	}
	
	public String editar(){
		System.out.println("Executando o m�todo EDITAR projeto....");		
		return CADASTRO_JSF;
	}	
	
	public void save(){
		try {
			System.out.println("Executando m�todo SAVE projeto ...");
			cadastrobasicoService.salvarProjeto(projeto);			
			addMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Projeto salvo com sucesso");
			projeto = new Projeto();
		} catch(Exception e ){
			addMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar projeto");			
		}
	}
	
	public String abrirConProjetos(){		
		filtro = new Projeto();
		return CONSULTA_JSF;
	}
	
	public void consultarProjetos(){
		System.out.println("Consulta de projetos tem q implementar o filtro: "+filtro.toString());
		setProjetos(cadastrobasicoService.findProjetos(filtro));
		System.out.println("Projetos encontrados: "+projetos.size());
		//return CONSULTA_JSF;		
	}
	
	public void addMessage(Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Projeto getFiltro() {
		return filtro;
	}

	public void setFiltro(Projeto filtro) {
		this.filtro = filtro;
	}
}