/**
 * 
 */
package br.com.empresa.sgpbid.service;

import java.util.List;

import javax.ejb.Local;

import br.com.empresa.sgpbid.model.usuario.Grupo;
import br.com.empresa.sgpbid.model.usuario.Usuario;

/**
 * 28 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Local
public interface IUsuarioService {
	void adicionaUsuario(Usuario u);
	void adicionaGrupo(Grupo g);
	List<Usuario> buscaTodosUsuarios();
	List<Grupo> buscaTodosGrupos();
}
