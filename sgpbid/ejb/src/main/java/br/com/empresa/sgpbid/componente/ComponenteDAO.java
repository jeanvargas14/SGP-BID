package br.com.empresa.sgpbid.componente;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * 31 de ago de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
public class ComponenteDAO {

    @PersistenceContext
    private EntityManager em;
    
    public List<Componente> findAllComponentesSuperiores(Integer cdPrograma) {
        List<Componente> componentes;
        try {
            StringBuilder hql = new StringBuilder();
            hql.append(" select c from Componente c ");
            hql.append(" where c.flAnalitico = 0 ");            
            hql.append(" and c.componentePK.cdPrograma = :cdprograma ");
            
            TypedQuery<Componente> query = em.createQuery(hql.toString(),Componente.class);            
            
            query.setParameter("cdprograma", cdPrograma);
            
            componentes = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar todos os componentes superiores ", e);
        }
        return componentes;
    }
}