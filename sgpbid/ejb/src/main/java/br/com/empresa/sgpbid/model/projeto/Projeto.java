package br.com.empresa.sgpbid.model.projeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="SGPPROJETO")
public class Projeto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cdProjeto;
	
	private String nmProjeto;
	
	public Projeto() {
		super();
	}
	
	public Projeto(String nmProjeto){
		super();
		this.nmProjeto = nmProjeto;
	}

	public Long getCdProjeto() {
		return cdProjeto;
	}

	public void setCdProjeto(Long cdProjeto) {
		this.cdProjeto = cdProjeto;
	}

	public String getNmProjeto() {
		return nmProjeto;
	}

	public void setNmProjeto(String nmProjeto) {
		this.nmProjeto = nmProjeto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cdProjeto == null) ? 0 : cdProjeto.hashCode());
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
		Projeto other = (Projeto) obj;
		if (cdProjeto == null) {
			if (other.cdProjeto != null)
				return false;
		} else if (!cdProjeto.equals(other.cdProjeto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projeto [cdProjeto=" + cdProjeto + ", nmProjeto=" + nmProjeto
				+ "]";
	}
}
