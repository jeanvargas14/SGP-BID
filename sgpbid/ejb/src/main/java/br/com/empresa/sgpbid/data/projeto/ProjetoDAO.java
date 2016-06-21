package br.com.empresa.sgpbid.data.projeto;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.empresa.sgpbid.model.projeto.Projeto;

@ApplicationScoped
public class ProjetoDAO {

	@PersistenceContext
	private EntityManager em;
	
//	@Resource
//	private UserTransaction tx;
	
	public void save(Projeto projeto){
		if(projeto == null){
			throw new IllegalArgumentException("Um projeto v�lido � obrigat�rio");
		}
		Long id = projeto.getCdProjeto();
		try {
//			tx.begin();
			if(id == null){
				em.persist(projeto);				
			} else {
				projeto = em.merge(projeto);
			}
	//		tx.commit();
		} catch (Exception e) {
//			try {
//				tx.setRollbackOnly();
//			} catch (SystemException e1) {
//				e1.printStackTrace();
//			}
			throw new RuntimeException("Erro ao persistir o projeto: "+projeto.toString(), e);
		}
	}
	
	public void remove(Projeto projeto){
		if(projeto == null){
			throw new IllegalArgumentException("Um projeto v�lido � obrigat�rio.");
		}
		Long id = projeto.getCdProjeto();
		if(id == null){
			throw new IllegalStateException("O projeto deve ter um id v�lido.");
		}	
		try {
			if(em.contains(projeto)){
				em.remove(projeto);
			} else {
				em.remove(em.merge(projeto));
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao remover o projeto: "+projeto.toString(), e);
		}
	}
	
	public Projeto findById(Long id){
		if(id == null){
			throw new IllegalArgumentException("Um id v�lido � obrigat�rio.");
		}
		Projeto projeto;	
		try {
			projeto = em.find(Projeto.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar projeto por id: "+id, e);
		}
		return projeto;
	}
	
	public List<Projeto> findAll(){
		List<Projeto> projetos;
		try {
			TypedQuery<Projeto> query = em.createQuery("select p from Projeto p",Projeto.class);
			projetos = query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar todos os projetos ", e);
		}
		return projetos;
	}

	public List<Projeto> findProjetos(Projeto filtro) {
		List<Projeto> projetos;
		try {
			StringBuilder hql = new StringBuilder();
			hql.append(" select p from Projeto p ");
			hql.append(" where 1 = 1 ");
			if(filtro.getCdProjeto()!=null && filtro.getCdProjeto() != 0){
				hql.append(" and p.cdProjeto = :cdprojeto ");
			}
			if(filtro.getNmProjeto()!=null && !filtro.getNmProjeto().isEmpty()){
				hql.append(" and upper(p.nmProjeto) like :nmprojeto ");
			}
			
			TypedQuery<Projeto> query = em.createQuery(hql.toString(),Projeto.class);
			
			if(filtro.getCdProjeto()!=null && filtro.getCdProjeto() != 0){
				query.setParameter("cdprojeto", filtro.getCdProjeto());
			}
			if(filtro.getNmProjeto()!=null && !filtro.getNmProjeto().isEmpty()){
				query.setParameter("nmprojeto", "%"+filtro.getNmProjeto().toUpperCase()+"%");
			}
			
			projetos = query.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar todos os findProjetos ", e);
		}
		return projetos;
	}	
}