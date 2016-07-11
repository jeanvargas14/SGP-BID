package br.com.empresa.sgpbid.data.usuario;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.empresa.sgpbid.model.usuario.Usuario;
import br.com.empresa.sgpbid.model.usuario.Usuariogrupo;

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
	}
	
	public List<Usuario> buscaTodos(){
		TypedQuery<Usuario> query = em.createQuery("select x from Usuario x "
				+ " join fetch x.usuariogrupos ug "
				+ " join fetch ug.grupo ",Usuario.class);
		return query.getResultList();
	} 
	
	public void inserirUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	public void deletarUsuario(Usuario usuario) {
		em.remove(usuario);
	}

	/**
	 * @param usuariogrupos
	 */
	public void adicionaUsuariogrupo(List<Usuariogrupo> usuariogrupos) {
		for (Usuariogrupo usuariogrupo : usuariogrupos) {
			System.out.println(usuariogrupo);
			em.persist(usuariogrupo);
		}
	}
}