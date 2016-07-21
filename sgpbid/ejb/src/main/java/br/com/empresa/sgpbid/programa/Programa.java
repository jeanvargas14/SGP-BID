/**
 * 
 */
package br.com.empresa.sgpbid.programa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	private Integer cdPrograma;
	
	@NotNull
	@Size(min=1, max=150)
	private String 	nmPrograma;
	@NotNull
	@Size(min=1, max=150)
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
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="programa", optional=true)
	private DetalhePrograma detalhePrograma;
	
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
}