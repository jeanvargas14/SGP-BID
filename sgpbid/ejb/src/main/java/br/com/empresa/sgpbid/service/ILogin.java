/**
 * 
 */
package br.com.empresa.sgpbid.service;

import br.com.empresa.sgpbid.model.usuario.Usuario;

/**
 * 21 de jun de 2016
 * @author roberto.conceicao
 *
 */
public interface ILogin {

	Usuario logar(String nome, String senha);
}
