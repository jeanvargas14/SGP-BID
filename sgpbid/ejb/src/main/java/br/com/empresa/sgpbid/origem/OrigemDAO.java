/**
 * 
 */
package br.com.empresa.sgpbid.origem;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * 15 de set de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
public class OrigemDAO {

    @PersistenceContext
    private EntityManager em;
    
    public Origem findById(Integer id){
        if(id == null){
            throw new IllegalArgumentException("Um id eh obrigatorio.");
        }
        Origem origem;  
        try {
            origem = em.find(Origem.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Origem por id: "+id, e);
        }
        return origem;
    }
    
    public List<Origem> findAll(){
        List<Origem> origens;
        try {
            TypedQuery<Origem> query = em.createQuery("select p from Origem p",Origem.class);
            origens = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar todos os Origens ", e);
        }
        return origens;
    }
}
