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
        try {
	    HttpServletRequest request = (HttpServletRequest) FacesContext.
                getCurrentInstance().getExternalContext().getRequest();
            request.login(this.usuario, this.senha);
            return PAGINA_INDEX;
        } catch (ServletException e) {
        	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuário/senha inválido", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        	//se houver erro no Login Module vai cair aqui... 
            //Você pode fazer log por exemplo!
        } finally {
            //tratar aqui mensagens de segurança que possam ter vindo 
            //do Login Module exibindo-as na forma de FacesMessage
	}

        return null;
    }
    
    public String verificaSeUsuarioJaLogado(){
    	HttpSession session = getSession();
    	if(session != null){
    		return PAGINA_INDEX;
    	}
    	return PAGINA_LOGIN;
    }
    
    public String logout(){    	
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