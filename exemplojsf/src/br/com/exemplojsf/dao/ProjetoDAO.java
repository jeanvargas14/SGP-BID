package br.com.exemplojsf.dao;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import br.com.exemplojsf.entity.Projeto;

@ManagedBean
public class ProjetoDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction tx;
	
	public void save(Projeto projeto){
		if(projeto == null){
			throw new IllegalArgumentException("Um projeto válido é obrigatório");
		}
		Long id = projeto.getCdProjeto();
		try {
			tx.begin();
			if(id == null){
				em.persist(projeto);				
			} else {
				projeto = em.merge(projeto);
			}
			tx.commit();
		} catch (Exception e) {
			try {
				tx.setRollbackOnly();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("Erro ao persistir o projeto: "+projeto.toString(), e);
		}
	}
	
	public void remove(Projeto projeto){
		if(projeto == null){
			throw new IllegalArgumentException("Um projeto válido é obrigatório.");
		}
		Long id = projeto.getCdProjeto();
		if(id == null){
			throw new IllegalStateException("O projeto deve ter um id válido.");
		}	
		try {
			tx.begin();
			if(em.contains(projeto)){
				em.remove(projeto);
			} else {
				em.remove(em.merge(projeto));
			}
			tx.commit();
		} catch (Exception e) {
			try {
				tx.setRollbackOnly();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("Erro ao remover o projeto: "+projeto.toString(), e);
		}
	}
	
	public Projeto findById(Long id){
		if(id == null){
			throw new IllegalArgumentException("Um id válido é obrigatório.");
		}
		Projeto projeto;	
		try {
			tx.begin();			
			projeto = em.find(Projeto.class, id);
			tx.commit();
		} catch (Exception e) {
			try {
				tx.setRollbackOnly();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("Erro ao buscar projeto por id: "+id, e);
		}
		return projeto;
	}
	
	public List<Projeto> findAll(){
		List<Projeto> projetos;
		try {
			tx.begin();
			TypedQuery<Projeto> query = em.createQuery("select p from Projeto p",Projeto.class);
			projetos = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			try {
				tx.setRollbackOnly();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException("Erro ao carregar todos os projetos ", e);
		}
		return projetos;
	}	
}