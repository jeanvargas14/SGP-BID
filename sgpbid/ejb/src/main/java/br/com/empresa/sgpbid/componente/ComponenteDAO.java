package br.com.empresa.sgpbid.componente;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import br.com.empresa.sgpbid.dto.ComponenteDTO;
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
            hql.append(" where c.flAnalitico = '0' ");            
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
    public List<Componenteorigem> findAllComponenteorigem(Componente componente) {        
        try {
            StringBuilder hql = new StringBuilder();
            hql.append(" from Componenteorigem co ");
            hql.append(" INNER JOIN FETCH co.origem o ");
            hql.append(" where ");            
            hql.append(" co.componenteorigemPK.cdComponente = :cdcomponente ");
            hql.append(" and co.componenteorigemPK.cdPrograma = :cdprograma ");
            
            TypedQuery<Componenteorigem> query = em.createQuery(hql.toString(),Componenteorigem.class);            
            query.setParameter("cdcomponente", componente.getCdComponente());
            query.setParameter("cdprograma", componente.getCdPrograma());
            
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar todos os componentes superiores ", e);
        }
    }

    /**
     * references: http://in.relation.to/2006/03/17/hibernate-32-transformers-for-hql-and-sql/
     * @param programa
     * @return
     * select c.*, bid.*, local.*  from sgpComponente c
     * join sgpComponenteorigem bid on bid.cdorigem = 1 and bid.cdcomponente = c.cdcomponente
     * join sgpComponenteorigem local on local.cdorigem = 2 and local.cdcomponente = c.cdcomponente
     * 
     * List resultWithAliasedBean = s.createSQLQuery(
      "SELECT st.name as studentName, co.description as courseDescription " +
      "FROM Enrolment e " +
      "INNER JOIN Student st on e.studentId=st.studentId " +
      "INNER JOIN Course co on e.courseCode=co.courseCode")
      .addScalar("studentName")
      .addScalar("courseDescription")
      .setResultTransformer( Transformers.aliasToBean(StudentDTO.class))
      .list();    
      StudentDTO dto =(StudentDTO) resultWithAliasedBean.get(0);
     * 
     */
    public List<ComponenteDTO> findAllComponentesDTO(Programa programa) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select  ");            
            sql.append(" c.cdcomponente as cdComponente, c.cdcomponentesuperior as cdComponentesuperior, c.cdauxiliar as cdAuxiliar, c.decomponente as deComponente, c.cdnivel as cdNivel, c.flanalitico as flAnalitico, c.flultimonivel as flUltimonivel, ");            
            sql.append(" bid.cdorigem as cdOrigembid, bid.vlinicial as vlInicialbid, bid.vlatual as vlAtualbid, bid.pefinanciamento  as peFinanciamentobid, ");            
            sql.append(" local.cdorigem as cdOrigemlocal, local.vlinicial as vlIniciallocal, local.vlatual as vlAtuallocal, local.pefinanciamento as peFinanciamentolocal  ");            
            sql.append(" from sgpComponente c ");            
            sql.append(" left join sgpComponenteorigem bid on bid.cdorigem = 1 and bid.cdcomponente = c.cdcomponente ");            
            sql.append(" left join sgpComponenteorigem local on local.cdorigem = 2 and local.cdcomponente = c.cdcomponente ");            
            sql.append(" where c.cdprograma = :cdPrograma ");            
            
            Session session = em.unwrap(Session.class);
            
            return session.createSQLQuery(sql.toString())                        
            .setInteger("cdPrograma", programa.getCdPrograma())
            .setResultTransformer(Transformers.aliasToBean(ComponenteDTO.class))
            .list();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar todos os componentes superiores ", e);
        }
    }
}