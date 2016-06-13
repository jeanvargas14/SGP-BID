/**
 * 
 */
package br.com.exemplojsf.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.dialect.lock.PessimisticReadSelectLockingStrategy;

/**
 * 13 de jun de 2016
 * @author roberto.conceicao
 *
 */
public class PersistenceUtil {

	private static EntityManagerFactory emf;
	
	private PersistenceUtil() {
		super();
	}
	
	public static EntityManager getEntityManager(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("exemploPU");
		}
		return emf.createEntityManager();
	}
	
	public static void close(EntityManager em ){
		if(em != null){
			em.close();
		}
	}
	
	public static void close(){
		if(emf != null){
			emf.close();
		}
	}
}
