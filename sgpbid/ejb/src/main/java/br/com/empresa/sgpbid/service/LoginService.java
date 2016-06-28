/**
 * 
 */
package br.com.empresa.sgpbid.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.empresa.sgpbid.data.usuario.GrupoDAO;
import br.com.empresa.sgpbid.data.usuario.UsuarioDAO;
import br.com.empresa.sgpbid.model.usuario.Grupo;
import br.com.empresa.sgpbid.model.usuario.Usuario;

/**
 * 21 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Stateless
public class LoginService implements ILogin {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private GrupoDAO grupoDAO;
	
	public LoginService() {
		System.out.println("Criando uma instancia do [LoginService]");
		//usuarioDAO = new UsuarioDAO();
		//grupoDAO = new GrupoDAO();
	}
	
	@Override
	public Usuario logar(String nome, String senha) {
		return usuarioDAO.getUsuario(nome, senha);
	}

	@Override
	public void adiciona(Usuario u) {
		usuarioDAO.adiciona(u);
	}

	@Override
	public void adiciona(Grupo g) {
		grupoDAO.adiciona(g);
	}

	@Override
	public List<Usuario> buscaTodosUsuarios() {
		return usuarioDAO.buscaTodos();
	}

	@Override
	public List<Grupo> buscaTodosGrupos() {
		return grupoDAO.buscaTodos();
	}
}