/**
 * 
 */
package br.com.empresa.sgpbid.model.usuario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 23 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Entity
@Table(name="sgpGrupo")
public class Grupo {

	@Id
	private String cdGrupo;
	
//	@OneToMany(cascade=CascadeType.ALL)  
//    @JoinTable(name="SGPUSUARIOGRUPO",  
//              joinColumns={@JoinColumn(name="cdgrupo", referencedColumnName="cdgrupo")},  
//              inverseJoinColumns={@JoinColumn(name="cdusuario", referencedColumnName="cdusuario", insertable=false, updatable=false)})	
//	private List<Usuario> usuarios;	
	
	public Grupo() {
	}
	
	public Grupo(String cdGrupo){
		setCdGrupo(cdGrupo);
	}
	
	public String getCdGrupo() {
		return cdGrupo;
	}

	public void setCdGrupo(String cdGrupo) {
		this.cdGrupo = cdGrupo;
	}
	
//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}

	@Override
	public String toString() {
		return "Grupo [cdGrupo=" + cdGrupo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdGrupo == null) ? 0 : cdGrupo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (cdGrupo == null) {
			if (other.cdGrupo != null)
				return false;
		} else if (!cdGrupo.equals(other.cdGrupo))
			return false;
		return true;
	}
}