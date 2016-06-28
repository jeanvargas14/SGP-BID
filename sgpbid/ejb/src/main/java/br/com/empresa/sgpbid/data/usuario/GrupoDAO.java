/**
 * 
 */
package br.com.empresa.sgpbid.data.usuario;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.empresa.sgpbid.model.usuario.Grupo;

/**
 * 23 de jun de 2016
 * @author roberto.conceicao
 *
 */
//@ApplicationScoped
@ManagedBean
public class GrupoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public GrupoDAO() {
		System.out.println("Criando uma instancia do [GrupoDAO]");
	}
	public void adiciona(Grupo g){
		em.persist(g);
	}
	
	public List<Grupo> buscaTodos(){
		TypedQuery<Grupo> query = em.createQuery("select x from Grupo x", Grupo.class);
		return query.getResultList();
	}
}
