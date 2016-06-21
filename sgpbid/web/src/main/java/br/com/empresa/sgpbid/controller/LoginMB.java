package br.com.empresa.sgpbid.controller;
 
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import br.com.empresa.sgpbid.model.usuario.Usuario;
import br.com.empresa.sgpbid.service.ILogin;
 
@Model
@ManagedBean
public class LoginMB {
	
	private static final String MAIN_JSF = "/jsf/projeto/sgpCadProjeto";
	
	private Usuario usuario = new Usuario(); 
    
	@Inject
	private ILogin loginService;
	
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        
        usuario = loginService.logar(usuario.getNomeUsuario(), usuario.getSenha());
        if(usuario == null) {
        	loggedIn = false;
        	message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        	FacesContext.getCurrentInstance().addMessage(null, message);
        	context.addCallbackParam("loggedIn", loggedIn);
        	return null;
        } else {
        	loggedIn = true;
        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo "+usuario.getNomeUsuario(), "");
        	FacesContext.getCurrentInstance().addMessage(null, message);
        	context.addCallbackParam("loggedIn", loggedIn);
        	return MAIN_JSF;
        }
         
    }   
}