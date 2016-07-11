package br.com.empresa.sgpbid.controller;
 
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.empresa.sgpbid.model.usuario.Grupo;
import br.com.empresa.sgpbid.model.usuario.Usuario;
import br.com.empresa.sgpbid.model.usuario.Usuariogrupo;
import br.com.empresa.sgpbid.service.IUsuarioService;
import br.com.empresa.sgpbid.util.CriptografiaUtil;
 
@ManagedBean
public class UsuarioMB {
	
	private static final String USUARIOS_JSF = "/jsf/usuario/sgpUsuarios";
	
	private Usuario usuario; 

	private List<String> nomesDosGrupos;
	
	private List<Usuario> usuarios;
	
	private List<Grupo> grupos;
	
	@Inject
	private IUsuarioService usuarioService;
	
	public UsuarioMB() {
		System.out.println("Criando uma instancia do manager bean UsuarioMB");
	}
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
		nomesDosGrupos = new ArrayList<String>();
		usuarios = getUsuarios();
		grupos = getGrupos();
	}
	
	public String abrirUsuarios(){
		return USUARIOS_JSF;
	}
	   
	public void adiciona() throws NoSuchAlgorithmException {
		// Associa os Grupos ao novo Usuario
		for(String nomeDoGrupo : this.nomesDosGrupos){
			Usuariogrupo ug = new Usuariogrupo();
			ug.setGrupo(new Grupo(nomeDoGrupo));			
			ug.setUsuario(this.usuario);
			
			this.usuario.getUsuariogrupos().add(ug);
		}
		
		// Criptografando a senha do novo Usuário		
		this.usuario.setSenha(CriptografiaUtil.md5_Base64(this.usuario.getSenha()));
		usuarioService.adicionaUsuario(usuario);
		
		usuario = new Usuario();
		usuarios=null;
	}
	
	public List<Grupo> getGrupos() {
		if(grupos == null){
			grupos = usuarioService.buscaTodosGrupos();
		}
		return grupos;
	}
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null){
			usuarios = usuarioService.buscaTodosUsuarios();
		}
		return usuarios;
	}
	
	public List<String> getNomesDosGrupos(){
		return nomesDosGrupos;
	}
	
	public void setNomesDosGrupos(List<String> nomesDosGrupos){
		this.nomesDosGrupos = nomesDosGrupos;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}