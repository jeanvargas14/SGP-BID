/**
 * 
 */
package br.com.empresa.sgpbid.service;

import java.util.List;

import javax.ejb.Local;

import br.com.empresa.sgpbid.model.projeto.Projeto;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Local
public interface ICadastrobasico {

	void salvarProjeto(Projeto projeto);
	void removeProjeto(Projeto projeto);
	Projeto findById(Long id);
	List<Projeto> findAllProjeto();
	List<Projeto> findProjetos(Projeto filtro);
}
