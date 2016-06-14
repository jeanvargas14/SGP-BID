package br.com.exemplojsf.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.exemplojsf.entity.Finalidade;
import br.com.exemplojsf.entity.Projeto;

public class CadastraJPA {

	public static void main(String[] args) {
		//new CadastraJPA().findProjeto();
		new CadastraJPA().cadastraFinalidade();
	}
	
	public void cadastraProjeto(){
		Projeto projeto = new Projeto("Meu Primeiro projeto");
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(projeto);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		
		PersistenceUtil.close(em);
		PersistenceUtil.close();
	}
	
	public Projeto findProjeto(){
		EntityManager em = PersistenceUtil.getEntityManager();
		Projeto projeto = em.find(Projeto.class, 1L);
		
		System.out.println(projeto);
		
	//	PersistenceUtil.close(em);
	//	PersistenceUtil.close();
		return projeto;
	}
	
	public void cadastraFinalidade(){
		Finalidade finalidade = new Finalidade("Teste de finalidade");
		Projeto projeto = findProjeto();
		finalidade.setProjeto(projeto);
		finalidade.setCdProjeto(projeto.getCdProjeto());
		
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(finalidade);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		
		PersistenceUtil.close(em);
		PersistenceUtil.close();
	}
	
}
