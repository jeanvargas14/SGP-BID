/**
 * 
 */
package br.com.empresa.sgpbid.programa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import br.com.empresa.sgpbid.setor.Setor;

/**
 * 20 de jul de 2016
 * @author roberto.conceicao
 *
 */
@Entity 
@Table(name="SGPPROGRAMA")
public class Programa {

	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer cdPrograma;
	
	@NotNull
	@Size(min=1, max=150)
	private String 	nmPrograma;
	
	@Null
	@Size(min=0, max=150)
	private String 	nmProgramaIngles;
	@NotNull
	@Size(min=1, max=15)
	private String 	nuPrograma;
	@NotNull
	@Size(min=1, max=15)
	private String 	nuOperacao;
	@NotNull
	@Size(min=1, max=2000)
	private String 	dePrograma;
	@NotNull	
	@Size(min=1, max=100)
	private String 	nmMutuario;
	@NotNull
	@Size(min=1, max=15)
	private String 	sgMutuario;
	@NotNull	
	private Integer nuAnoInicio;
	@NotNull
	private Integer nuAnoFim;
	@NotNull
	private String sgTipoOperacao;	
	@NotNull
	private char tpfonte;	
	@Size(max=10)
	private String deClassificacao;	
	@NotNull(message="Mensagem de teste ao nao informar o cdSetor")
	private Integer cdSetor;
	
	@ManyToOne
	@JoinColumn(name="cdSetor", insertable=false, updatable=false)
	private Setor setor;
	
	public Programa() {
					
	}
	public Integer getCdPrograma() {
		return cdPrograma;
	}
	public void setCdPrograma(Integer cdPrograma) {
		this.cdPrograma = cdPrograma;
	}
	public String getNmPrograma() {
		return nmPrograma;
	}
	public void setNmPrograma(String nmPrograma) {
		this.nmPrograma = nmPrograma;
	}
	public String getNmProgramaIngles() {
		return nmProgramaIngles;
	}
	public void setNmProgramaIngles(String nmProgramaIngles) {
		this.nmProgramaIngles = nmProgramaIngles;
	}
	public String getNuPrograma() {
		return nuPrograma;
	}
	public void setNuPrograma(String nuPrograma) {
		this.nuPrograma = nuPrograma;
	}
	public String getNuOperacao() {
		return nuOperacao;
	}
	public void setNuOperacao(String nuOperacao) {
		this.nuOperacao = nuOperacao;
	}
	public String getDePrograma() {
		return dePrograma;
	}
	public void setDePrograma(String dePrograma) {
		this.dePrograma = dePrograma;
	}
	public String getNmMutuario() {
		return nmMutuario;
	}
	public void setNmMutuario(String nmMutuario) {
		this.nmMutuario = nmMutuario;
	}
	public String getSgMutuario() {
		return sgMutuario;
	}
	public void setSgMutuario(String sgMutuario) {
		this.sgMutuario = sgMutuario;
	}
	public Integer getNuAnoInicio() {
		return nuAnoInicio;
	}
	public void setNuAnoInicio(Integer nuAnoInicio) {
		this.nuAnoInicio = nuAnoInicio;
	}
	public Integer getNuAnoFim() {
		return nuAnoFim;
	}
	public void setNuAnoFim(Integer nuAnoFim) {
		this.nuAnoFim = nuAnoFim;
	}
	public String getSgTipoOperacao() {
		return sgTipoOperacao;
	}
	public void setSgTipoOperacao(String sgTipoOperacao) {
		this.sgTipoOperacao = sgTipoOperacao;
	}
	public char getTpfonte() {
		return tpfonte;
	}
	public void setTpfonte(char tpfonte) {
		this.tpfonte = tpfonte;
	}
	public String getDeClassificacao() {
		return deClassificacao;
	}
	public void setDeClassificacao(String deClassificacao) {
		this.deClassificacao = deClassificacao;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public Integer getCdSetor() {
		return cdSetor;
	}
	public void setCdSetor(Integer cdSetor) {
		this.cdSetor = cdSetor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdPrograma == null) ? 0 : cdPrograma.hashCode());
		result = prime * result + ((nuOperacao == null) ? 0 : nuOperacao.hashCode());
		result = prime * result + ((nuPrograma == null) ? 0 : nuPrograma.hashCode());
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
		Programa other = (Programa) obj;
		if (cdPrograma == null) {
			if (other.cdPrograma != null)
				return false;
		} else if (!cdPrograma.equals(other.cdPrograma))
			return false;
		if (nuOperacao == null) {
			if (other.nuOperacao != null)
				return false;
		} else if (!nuOperacao.equals(other.nuOperacao))
			return false;
		if (nuPrograma == null) {
			if (other.nuPrograma != null)
				return false;
		} else if (!nuPrograma.equals(other.nuPrograma))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Programa [cdPrograma=" + cdPrograma + ", nmPrograma=" + nmPrograma + ", nmProgramaIngles="
				+ nmProgramaIngles + ", nuPrograma=" + nuPrograma + ", nuOperacao=" + nuOperacao + ", dePrograma="
				+ dePrograma + ", nmMutuario=" + nmMutuario + ", sgMutuario=" + sgMutuario + ", nuAnoInicio="
				+ nuAnoInicio + ", nuAnoFim=" + nuAnoFim + ", sgTipoOperacao=" + sgTipoOperacao + ", tpfonte=" + tpfonte
				+ ", deClassificacao=" + deClassificacao + ", setor=" + setor
				+ "]";
	}	
}