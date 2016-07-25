/**
 * 
 */
package br.com.empresa.sgpbid.controller;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 11 de jul de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
@ViewScoped
public class LoginMB {

    private static final String PAGINA_INDEX = "/restrito/jsf/index.xhtml";
    private static final String PAGINA_LOGIN = "/public/login.xhtml";

    private String usuario;
    private String senha;

    public String onClickLogar() {
    	System.out.println("[LoginMB] metodo onClickLogar");
        try {
	    HttpServletRequest request = (HttpServletRequest) FacesContext.
                getCurrentInstance().getExternalContext().getRequest();
            request.login(this.usuario, this.senha);
            return PAGINA_INDEX;
        } catch (ServletException e) {
        	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuário/senha inválido", "usuário/senha inválido");
            FacesContext.getCurrentInstance().addMessage(null, message);
        	//se houver erro no Login Module vai cair aqui... 
            //Você pode fazer log por exemplo!
        } finally {
            //tratar aqui mensagens de segurança que possam ter vindo 
            //do Login Module exibindo-as na forma de FacesMessage
	}

        return PAGINA_LOGIN;
    }
    
    public String verificaSeUsuarioJaLogado(){
    	System.out.println("[LoginMB] metodo verificaSeUsuarioJaLogado");
    	HttpSession session = getSession();
    	if(session != null){
    		System.out.println("[LoginMB] tem sessao devolve para index.jsf");
    		return PAGINA_INDEX;
    	}
    	System.out.println("[LoginMB] não tem sessao vai para tela de login.jsf");
    	return PAGINA_LOGIN;
    }
    
    public String logout(){    	
    	try {
    		System.out.println("[LoginMB] fazendo logout");
    		HttpServletRequest request = (HttpServletRequest) FacesContext.
                getCurrentInstance().getExternalContext().getRequest();
				request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		HttpSession session = getSession();
    	session.invalidate();
    	return PAGINA_LOGIN;
    }    
    
    private HttpSession getSession(){
    	FacesContext fc = FacesContext.getCurrentInstance();
    	ExternalContext ec = fc.getExternalContext();
    	return (HttpSession) ec.getSession(false);    	
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}