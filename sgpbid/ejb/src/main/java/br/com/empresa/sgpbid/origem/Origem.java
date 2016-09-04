package br.com.empresa.sgpbid.origem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.empresa.sgpbid.programa.Programa;

@Entity
@Table(name="SGPORIGEM")
public class Origem {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cdOrigem;
    
	@ManyToOne
	@JoinColumn(name = "cdPrograma", unique = true, nullable = false, insertable=false, updatable=false)
	private Programa programa;
	
	private Integer cdPrograma;
	private String  sgOrigem;
	private String  deOrigem;
	private Integer flContrapartida;
	
	public Integer getCdOrigem() {
		return cdOrigem;
	}
	public void setCdOrigem(Integer cdOrigem) {
		this.cdOrigem = cdOrigem;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public Integer getCdPrograma() {
		return cdPrograma;
	}
	public void setCdPrograma(Integer cdPrograma) {
		this.cdPrograma = cdPrograma;
	}
	public String getSgOrigem() {
		return sgOrigem;
	}
	public void setSgOrigem(String sgOrigem) {
		this.sgOrigem = sgOrigem;
	}
	public String getDeOrigem() {
		return deOrigem;
	}
	public void setDeOrigem(String deOrigem) {
		this.deOrigem = deOrigem;
	}
	public Integer getFlContrapartida() {
		return flContrapartida;
	}
	public void setFlContrapartida(Integer flContrapartida) {
		this.flContrapartida = flContrapartida;
	}	
}