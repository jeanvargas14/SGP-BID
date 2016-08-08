/**
 * 
 */
package br.com.empresa.sgpbid.setor;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.empresa.sgpbid.setor.Setor;

/**
 * 8 de ago de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
public class SetorDAO {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 */
	public SetorDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void save(Setor setor){
		if(setor == null){
			throw new IllegalArgumentException("Um setor eh obrigatorio");
		}
		Integer id = setor.getCdSetor();
		try {
			if(id == null){
				em.persist(setor);
			} else {
				setor = em.merge(setor);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao persistir o setor: "+setor.toString(), e);
		}
	}
	
	public void remove(Setor setor){
		if(setor == null){
			throw new IllegalArgumentException("Um setor eh obrigatorio.");
		}
		Integer id = setor.getCdSetor();
		if(id == null){
			throw new IllegalStateException("O setor deve ser valido.");
		}	
		try {
			if(em.contains(setor)){
				em.remove(setor);
			} else {
				em.remove(em.merge(setor));
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao remover o setor: "+setor.toString(), e);
		}
	}
	
	public Setor findById(Integer id){
		if(id == null){
			throw new IllegalArgumentException("Um id eh obrigatorio.");
		}
		Setor setor;	
		try {
			setor = em.find(Setor.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar setor por id: "+id, e);
		}
		return setor;
	}
	
	public List<Setor> findAll(){
		List<Setor> setors;
		try {
			TypedQuery<Setor> query = em.createQuery("select p from Setor p",Setor.class);
			setors = query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar todos os setors ", e);
		}
		return setors;
	}
}
