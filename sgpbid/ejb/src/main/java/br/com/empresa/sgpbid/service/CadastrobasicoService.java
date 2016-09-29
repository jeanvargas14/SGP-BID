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
import br.com.empresa.sgpbid.componente.Componenteorigem;
import br.com.empresa.sgpbid.data.projeto.ProjetoDAO;
import br.com.empresa.sgpbid.dto.ComponenteDTO;
import br.com.empresa.sgpbid.enums.NivelEnum;
import br.com.empresa.sgpbid.model.projeto.Projeto;
import br.com.empresa.sgpbid.origem.Origem;
import br.com.empresa.sgpbid.origem.OrigemDAO;
import br.com.empresa.sgpbid.programa.DetalhePrograma;
import br.com.empresa.sgpbid.programa.Programa;
import br.com.empresa.sgpbid.programa.ProgramaDAO;
import br.com.empresa.sgpbid.setor.Setor;
import br.com.empresa.sgpbid.setor.SetorDAO;
import br.com.empresa.sgpbid.util.Utils;

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
	
	@Inject
	private OrigemDAO origemDAO;
	
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

    @Override
    public List<Componente> findAllComponentes(Programa programa) {
        return componenteDAO.findAll(programa);
    }

    @Override
    public void salvarComponente(Componente componente) {
    	String cdAuxiliar = "";
    	if(Utils.isNullOrZero(componente.getCdComponentesuperior())){
    		componente.setCdNivel(NivelEnum.COMPONENTE.getValor());
    		componente.setFlUltimonivel(0);
    		componente.setFlAnalitico(0);
    	} else {
    		componente.setCdNivel(NivelEnum.SUBCOMPONENTE.getValor());
    		componente.setFlUltimonivel(1);
    		componente.setFlAnalitico(1);
    		Componente componenteSuperior = componenteDAO.findById(componente.getCdComponentesuperior());
    		cdAuxiliar = componenteSuperior.getCdAuxiliar()+".";
    	}
    	cdAuxiliar +=  componenteDAO.findMaxCdAuxiliar(componente);
    	componente.setCdAuxiliar(cdAuxiliar);
		componente.setFlConcluido(0);
        componenteDAO.save(componente);        
    }

    @Override
    public List<Componenteorigem> findAllComponenteorigem(Componente componente) {
        return componenteDAO.findAllComponenteorigem(componente);
    }
    
    @Override
    public List<ComponenteDTO> findAllComponentesDTO(Programa programa) {
        return componenteDAO.findAllComponentesDTO(programa);
    }
    
    @Override
    public List<Origem> findAllOrigem() {
        return origemDAO.findAll();
    }

    @Override
    public Programa findByProgramaId(Integer cdProgramaSession) {
        return programaDAO.findById(cdProgramaSession);
    }    
}