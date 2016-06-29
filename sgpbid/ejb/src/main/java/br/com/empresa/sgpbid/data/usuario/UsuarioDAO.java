package br.com.empresa.sgpbid.data.usuario;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.empresa.sgpbid.model.usuario.Usuario;

//@ApplicationScoped
@ManagedBean
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;
	
	public UsuarioDAO() {
		System.out.println("Criando uma instancia do [UsuarioDAO]");
	}

	public Usuario getUsuario(String nomeUsuario, String senha) {
		try {
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
					.setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void adiciona(Usuario u){
		em.persist(u);
		//TODO para cada grupo add na tabela de relacionamento usuariogrupo
	}
	
	public List<Usuario> buscaTodos(){
		TypedQuery<Usuario> query = em.createQuery("select x from Usuario x ",Usuario.class);
		return query.getResultList();
	} 
	
	public boolean inserirUsuario(Usuario usuario) {
		try {
			em.persist(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarUsuario(Usuario usuario) {
		try {
			em.remove(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}