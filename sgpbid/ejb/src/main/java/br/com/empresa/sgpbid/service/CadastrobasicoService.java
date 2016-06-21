/**
 * 
 */
package br.com.empresa.sgpbid.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;

import br.com.empresa.sgpbid.data.projeto.ProjetoDAO;
import br.com.empresa.sgpbid.model.projeto.Projeto;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Stateless
public class CadastrobasicoService implements ICadastrobasico, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private ProjetoDAO projetoDAO;
	
	public void salvarProjeto(Projeto projeto){
		projetoDAO.save(projeto);
	}
	
	public List<Projeto> findAllProjeto(){
		return projetoDAO.findAll();
	}

	public void removeProjeto(Projeto projeto) {
		projetoDAO.remove(projeto);	
	}

	public Projeto findById(Long id) {
		return projetoDAO.findById(id);
	}

	@Override
	public List<Projeto> findProjetos(Projeto filtro) {
		return projetoDAO.findProjetos(filtro);
	}
}