/**
 * 
 */
package br.com.exemplojsf.ejb;

import java.util.List;

import javax.ejb.Local;

import br.com.exemplojsf.entity.Projeto;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Local
public interface CadastrobasicoLocal {

	void salvarProjeto(Projeto projeto);
	void removeProjeto(Projeto projeto);
	Projeto findById(Long id);
	List<Projeto> findAllProjeto();
}
