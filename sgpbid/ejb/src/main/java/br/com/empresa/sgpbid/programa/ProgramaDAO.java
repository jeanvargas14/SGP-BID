/**
 * 
 */
package br.com.empresa.sgpbid.programa;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * 26 de jul de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
public class ProgramaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public ProgramaDAO() {
	}
	
	public void save(Programa programa){
		if(programa == null){
			throw new IllegalArgumentException("Um programa eh obrigatorio");
		}
		Integer id = programa.getCdPrograma();
		try {
			if(id == null){
				em.persist(programa);
			} else {
				programa = em.merge(programa);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao persistir o programa: "+programa.toString(), e);
		}
	}
	
	public void remove(Programa programa){
		if(programa == null){
			throw new IllegalArgumentException("Um programa eh obrigatorio.");
		}
		Integer id = programa.getCdPrograma();
		if(id == null){
			throw new IllegalStateException("O programa deve ser valido.");
		}	
		try {
			if(em.contains(programa)){
				em.remove(programa);
			} else {
				em.remove(em.merge(programa));
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao remover o programa: "+programa.toString(), e);
		}
	}
	
	public Programa findById(Integer id){
		if(id == null){
			throw new IllegalArgumentException("Um id eh obrigatorio.");
		}
		Programa programa;	
		try {
			programa = em.find(Programa.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar programa por id: "+id, e);
		}
		return programa;
	}
	
	public List<Programa> findAll(){
		List<Programa> programas;
		try {
			TypedQuery<Programa> query = em.createQuery("select p from Programa p",Programa.class);
			programas = query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar todos os programas ", e);
		}
		return programas;
	}

	public List<Programa> findProgramas(Programa filtro) {
		List<Programa> programas;
		try {
			StringBuilder hql = new StringBuilder();
			hql.append(" select p from Programa p ");
			hql.append(" where 1 = 1 ");
			if(filtro.getCdPrograma()!=null && filtro.getCdPrograma() != 0){
				hql.append(" and p.cdPrograma = :cdprograma ");
			}
			if(filtro.getNmPrograma()!=null && !filtro.getNmPrograma().isEmpty()){
				hql.append(" and upper(p.nmPrograma) like :nmprograma ");
			}			
			if(filtro.getNuPrograma()!=null && !filtro.getNuPrograma().isEmpty()){
				hql.append(" and upper(p.nuPrograma) like :nuprograma ");
			}
			
			TypedQuery<Programa> query = em.createQuery(hql.toString(),Programa.class);
			
			if(filtro.getCdPrograma()!=null && filtro.getCdPrograma() != 0){
				query.setParameter("cdprograma", filtro.getCdPrograma());
			}
			if(filtro.getNmPrograma()!=null && !filtro.getNmPrograma().isEmpty()){
				query.setParameter("nmprograma", "%"+filtro.getNmPrograma().toUpperCase()+"%");
			}
			if(filtro.getNuPrograma()!=null && !filtro.getNuPrograma().isEmpty()){
				query.setParameter("nuprograma", "%"+filtro.getNuPrograma().toUpperCase()+"%");
			}
			
			programas = query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar todos os findProgramas ", e);
		}
		return programas;
	}	
	
}
