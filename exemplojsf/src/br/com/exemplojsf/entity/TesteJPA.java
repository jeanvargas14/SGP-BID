/**
 * 
 */
package br.com.exemplojsf.entity;

import javax.persistence.EntityManager;

import br.com.exemplojsf.jpa.PersistenceUtil;

/**
 * 13 de jun de 2016
 * @author roberto.conceicao
 *
 */
public class TesteJPA {

	public static void main(String[] args) {
		EntityManager em = PersistenceUtil.getEntityManager();
		// realizar as operacoes de persistencia apartir desse ponto
		

		PersistenceUtil.close(em);
		PersistenceUtil.close();
	}
}