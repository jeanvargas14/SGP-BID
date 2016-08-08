/**
 * 
 */
package br.com.empresa.sgpbid.service;

import java.util.List;

import javax.ejb.Local;

import br.com.empresa.sgpbid.model.projeto.Projeto;
import br.com.empresa.sgpbid.programa.DetalhePrograma;
import br.com.empresa.sgpbid.programa.Programa;
import br.com.empresa.sgpbid.setor.Setor;

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
	List<Setor> findAllSetor();
	List<Projeto> findProjetos(Projeto filtro);
	
	List<Programa> findProgramas(Programa filtro);
	void salvarPrograma(Programa programa);
	
	void salvarDetalheprograma(DetalhePrograma detalhePrograma);
	
	DetalhePrograma findDetalheprograma(Integer cdPrograma);
}