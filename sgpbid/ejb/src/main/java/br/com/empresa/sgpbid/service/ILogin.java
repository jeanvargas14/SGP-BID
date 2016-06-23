/**
 * 
 */
package br.com.empresa.sgpbid.service;

import java.util.List;

import br.com.empresa.sgpbid.model.usuario.Grupo;
import br.com.empresa.sgpbid.model.usuario.Usuario;

/**
 * 21 de jun de 2016
 * @author roberto.conceicao
 *
 */
public interface ILogin {

	Usuario logar(String nome, String senha);
	void adiciona(Usuario u);
	void adiciona(Grupo g);
	List<Usuario> buscaTodosUsuarios();
	List<Grupo> buscaTodosGrupos();
}
