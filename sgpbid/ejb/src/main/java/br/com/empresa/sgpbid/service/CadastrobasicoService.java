/**
 * 
 */
package br.com.empresa.sgpbid.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.empresa.sgpbid.componente.Componente;
import br.com.empresa.sgpbid.componente.ComponenteDAO;
import br.com.empresa.sgpbid.data.projeto.ProjetoDAO;
import br.com.empresa.sgpbid.model.projeto.Projeto;
import br.com.empresa.sgpbid.programa.DetalhePrograma;
import br.com.empresa.sgpbid.programa.Programa;
import br.com.empresa.sgpbid.programa.ProgramaDAO;
import br.com.empresa.sgpbid.setor.Setor;
import br.com.empresa.sgpbid.setor.SetorDAO;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Stateless
public class CadastrobasicoService implements ICadastrobasico, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProjetoDAO projetoDAO;
	
	@Inject
	private ProgramaDAO programaDAO;
		
	@Inject
	private SetorDAO setorDAO;
	
	@Inject
	private ComponenteDAO componenteDAO;
	
	public CadastrobasicoService() {
		System.out.println("Criando uma instancia do [CadastrobasicoService]");
	}
	
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

	@Override
	public List<Programa> findProgramas(Programa filtro) {
		return programaDAO.findProgramas(filtro);
	}

	@Override
	public void salvarPrograma(Programa programa) {
		programaDAO.save(programa);
	}

	@Override
	public void salvarDetalheprograma(DetalhePrograma detalhePrograma) {
		programaDAO.salvarDetalheprograma(detalhePrograma);
	}

	@Override
	public DetalhePrograma findDetalheprograma(Integer cdPrograma) {
		return programaDAO.findDetalheprograma(cdPrograma);
	}

	@Override
	public List<Setor> findAllSetor() {
		return setorDAO.findAll();
	}

    @Override
    public List<Componente> findAllComponentesSuperiores(Integer cdPrograma) {
        return componenteDAO.findAllComponentesSuperiores(cdPrograma);
    }
}
