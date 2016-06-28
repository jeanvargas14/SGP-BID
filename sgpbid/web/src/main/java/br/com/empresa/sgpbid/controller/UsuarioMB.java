package br.com.empresa.sgpbid.controller;
 
import java.math.BigInteger;
import java.security.MessageDigest;
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
import br.com.empresa.sgpbid.service.IUsuarioService;
 
@ManagedBean
public class UsuarioMB {
	
	private static final String MAIN_JSF = "/jsf/projeto/sgpCadProjeto";
	
	private Usuario usuario; 

	private List<String> nomesDosGrupos;
	
	private List<Usuario> usuarios;
	
	private List<Grupo> grupos;
	
	@Inject
	private IUsuarioService usuarioService;
	
	public UsuarioMB() {
		System.out.println("Criando uma instancia do manager bean LoginMB");
	}
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
		nomesDosGrupos = new ArrayList<String>();
		usuarios = new ArrayList<Usuario>();
		grupos = new ArrayList<Grupo>();
	}
	   
	public void adiciona() throws NoSuchAlgorithmException {
		// Associa os Grupos ao novo Usuario
		for(String nomeDoGrupo : this.nomesDosGrupos){
			Grupo g = new Grupo();
			g.setCdGrupo(nomeDoGrupo);
			this.usuario.getGrupos().add(g);
		}
		
		// Criptografando a senha do novo Usuário
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(this.usuario.getSenha().getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String senhaCriptografada = hash.toString (16);
		while ( senhaCriptografada.length()<32){
			senhaCriptografada = "0" + senhaCriptografada ;
		}
		this.usuario.setSenha(senhaCriptografada);
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
	

	public String sair() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.invalidate();
		System.out.println("LoginMB executando metodo sair.");
		return "/login" ;
	}
}