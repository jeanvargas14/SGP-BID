package br.com.empresa.sgpbid.data.finalidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.empresa.sgpbid.model.projeto.Projeto;

@Entity
@Table(name="SGPFINALIDADE")
public class Finalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cdFinalidade;	
	private Long cdProjeto;
	
	private String deFinalidade;
	
	@JoinColumn(name="cdProjeto", insertable=false, updatable=false)
	@ManyToOne
	private Projeto projeto;

	public Finalidade() {
		super();
		setProjeto(new Projeto());
	}
	
	public Finalidade(String deFinalidade) {
		this();
		setDeFinalidade(deFinalidade);
	}	
	
	public Long getCdFinalidade() {
		return cdFinalidade;
	}

	public void setCdFinalidade(Long cdFinalidade) {
		this.cdFinalidade = cdFinalidade;
	}

	public Long getCdProjeto() {
		return cdProjeto;
	}

	public void setCdProjeto(Long cdProjeto) {
		this.cdProjeto = cdProjeto;
	}

	public String getDeFinalidade() {
		return deFinalidade;
	}

	public void setDeFinalidade(String deFinalidade) {
		this.deFinalidade = deFinalidade;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cdFinalidade == null) ? 0 : cdFinalidade.hashCode());
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
		Finalidade other = (Finalidade) obj;
		if (cdFinalidade == null) {
			if (other.cdFinalidade != null)
				return false;
		} else if (!cdFinalidade.equals(other.cdFinalidade))
			return false;
		if (cdProjeto == null) {
			if (other.cdProjeto != null)
				return false;
		} else if (!cdProjeto.equals(other.cdProjeto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Finalidade [cdFinalidade=" + cdFinalidade + ", cdProjeto="
				+ cdProjeto + ", deFinalidade=" + deFinalidade + ", projeto="
				+ projeto + "]";
	}
}