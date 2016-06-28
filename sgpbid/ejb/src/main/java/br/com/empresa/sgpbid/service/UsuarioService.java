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
 * 28 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Stateless
public class UsuarioService implements IUsuarioService {

	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private GrupoDAO grupoDAO;
	
	public UsuarioService() {
		System.out.println("Criando uma instancia do [UsuarioService]");
	}

	@Override
	public void adicionaUsuario(Usuario u) {
		usuarioDAO.adiciona(u);
	}

	@Override
	public void adicionaGrupo(Grupo g) {
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