/**
 * 
 */
package br.com.exemplojsf.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.exemplojsf.ejb.CadastrobasicoLocal;
import br.com.exemplojsf.entity.Projeto;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
@SessionScoped
public class ProjetoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String CADASTRO_JSF = "/jsf/projeto/sgpCadProjeto";
	private static final String CONSULTA_JSF = "/jsf/projeto/sgpConProjeto";
	
	@Named
	private List<Projeto> projetos;
	
	@Named
	private Projeto projeto;
	
	@EJB
	private CadastrobasicoLocal cadastrobasicoBean;
	
	public ProjetoMB() {
		System.out.println("Criando instancia de ProjetoMB");		
	}
	
	@PostConstruct
	public void init(){
		projeto  = new Projeto();
		projetos = new ArrayList<Projeto>();
	}
	
	public String novo(){
		System.out.println("Executando o método NOVO projeto....");
		projeto = new Projeto();
		return CADASTRO_JSF;
	}
	
	public String editar(){
		System.out.println("Executando o método EDITAR projeto....");		
		return CADASTRO_JSF;
	}	
	
	public void save(){
		try {
			System.out.println("Executando método SAVE projeto ...");
			cadastrobasicoBean.salvarProjeto(projeto);			
			addMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Projeto salvo com sucesso");
		} catch(Exception e ){
			addMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao salvar projeto");			
		}
	}
	
	public String abrirConProjetos(){
		System.out.println("Executando método LISTAR projeto ...");
		setProjetos(cadastrobasicoBean.findAllProjeto());
		System.out.println("Total de projetos: "+projetos.size());
		return CONSULTA_JSF;
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
}