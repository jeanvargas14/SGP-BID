package br.com.empresa.sgpbid.model.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sgpUsuario")
public class Usuario {

	@Id
	private String cdUsuario;

	private String senha;

//	@Column(name = "lastAccess", unique = true)
//	@Temporal(TemporalType.DATE)
//	private Date ultimoAcesso;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	public String getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}	
}