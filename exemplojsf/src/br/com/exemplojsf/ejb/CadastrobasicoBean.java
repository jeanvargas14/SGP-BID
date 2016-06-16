/**
 * 
 */
package br.com.exemplojsf.ejb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.exemplojsf.dao.ProjetoDAO;
import br.com.exemplojsf.entity.Projeto;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
@Stateless
public class CadastrobasicoBean implements CadastrobasicoLocal, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
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
}