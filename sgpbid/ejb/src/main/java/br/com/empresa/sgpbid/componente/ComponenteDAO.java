package br.com.empresa.sgpbid.componente;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.empresa.sgpbid.programa.Programa;

/**
 * 31 de ago de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
public class ComponenteDAO {

    @PersistenceContext
    private EntityManager em;
    
    public void save(Componente componente){
        if(componente == null){
            throw new IllegalArgumentException("Um componente eh obrigatorio");  
        }
        Integer id = componente.getCdComponente();
        try{
            if(id == null){
                em.persist(componente);
            } else {
                componente = em.merge(componente);
            }            
        } catch (Exception e){
            throw new RuntimeException("Erro ao persistir o componente: "+componente.toString(), e);
        }
    }
    
    public void remove(Componente componente){
        if(componente == null){
            throw new IllegalArgumentException("Um componente eh obrigatorio");  
        }
        Integer id = componente.getCdComponente();
        if(id == null){
            throw new IllegalArgumentException("O componente deve ser valido");  
        }
        try{
            if(em.contains(componente)){
                em.remove(componente);
            } else {
                em.remove(em.merge(componente));
            }            
        } catch (Exception e){
            throw new RuntimeException("Erro ao remover o componente: "+componente.toString(), e);
        }
    }
    
    public Componente findById(Integer id){        
        if(id == null){
            throw new IllegalArgumentException("O componente deve ser valido");  
        }
        Componente componente;
        try{
            componente = em.find(Componente.class, id);                        
        } catch (Exception e){
            throw new RuntimeException("Erro ao buscar o componente: "+id, e);
        }
        return componente;
    }
    
    public List<Componente> findAll(Programa programa){
        List<Componente> componentes;
        try {
            StringBuilder hql = new StringBuilder();
            hql.append(" select c from Componente c ");
            hql.append(" where ");            
            hql.append(" c.cdPrograma = :cdprograma ");            
            TypedQuery<Componente> query = em.createQuery(hql.toString(),Componente.class);
            query.setParameter("cdprograma", programa.getCdPrograma());
            
            componentes = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos componente, do programa: "+programa.getCdPrograma(), e);
        }
        return componentes;
    }
    
    public List<Componente> findAllComponentesSuperiores(Integer cdPrograma) {
        List<Componente> componentes;
        try {
            StringBuilder hql = new StringBuilder();
            hql.append(" select c from Componente c ");
            hql.append(" where c.flAnalitico = 0 ");            
            hql.append(" and c.cdPrograma = :cdprograma ");
            
            TypedQuery<Componente> query = em.createQuery(hql.toString(),Componente.class);            
            
            query.setParameter("cdprograma", cdPrograma);
            
            componentes = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar todos os componentes superiores ", e);
        }
        return componentes;
    }

    /**
     * @param programa
     * @return
     */
    public List<Componenteorigem> findAllComponenteorigem(Programa programa) {        
        try {
            StringBuilder hql = new StringBuilder();
            hql.append(" from Componenteorigem co ");
            hql.append(" INNER JOIN FETCH co.componente c ");
            hql.append(" INNER JOIN FETCH co.origem o ");
            hql.append(" where ");            
            hql.append(" co.componenteorigemPK.cdPrograma = :cdprograma ");
            
            TypedQuery<Componenteorigem> query = em.createQuery(hql.toString(),Componenteorigem.class);            
            
            query.setParameter("cdprograma", programa.getCdPrograma());
            
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar todos os componentes superiores ", e);
        }
    }
}