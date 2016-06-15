/**
 * 
 */
package br.com.exemplojsf.jsf;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.exemplojsf.ejb.CadastrobasicoLocal;
import br.com.exemplojsf.entity.Projeto;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
public class ProjetoMB implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Projeto> projetos;
	private Projeto projeto;
	
	@EJB
	private CadastrobasicoLocal cadastrobasicoBean;
	
	public ProjetoMB() {
		System.out.println("Criando instancia de ProjetoMB");		
	}
	
	public void save(){
		try {
			cadastrobasicoBean.salvarProjeto(projeto);			
			addMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Projeto salvo com sucesso");
		} catch(Exception e ){
			addMessage(FacesMessage.SEVERITY_ERROR, "Sucesso", "Projeto salvo com sucesso");			
		}
	}
	
	public void listar(){
		
	}
	
	public void addMessage(Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}