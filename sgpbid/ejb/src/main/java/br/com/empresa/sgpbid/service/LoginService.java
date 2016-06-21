/**
 * 
 */
package br.com.empresa.sgpbid.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;

import br.com.empresa.sgpbid.data.usuario.UsuarioDAO;
import br.com.empresa.sgpbid.model.usuario.Usuario;

/**
 * 21 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Stateless
public class LoginService implements ILogin {

	@Resource
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario logar(String nome, String senha) {
		return usuarioDAO.getUsuario(nome, senha);
	}

}
