package br.com.empresa.sgpbid.componente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.empresa.sgpbid.programa.Programa;

@Entity
@Table(name="SGPCOMPONENTE")
public class Componente {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cdComponente;
    
	@ManyToOne
	@JoinColumn(name = "cdPrograma", unique = true, nullable = false, insertable=false, updatable=false)
	private Programa programa;
	
	private Integer cdPrograma;
	private Integer cdComponentesuperior;
	private String 	cdAuxiliar;
	private String 	deComponente;
	private Double	vlInicial;
	private Double	vlAtual;
	private Integer cdNivel;
	private Integer flUltimonivel;
	private Integer flConcluido;
	private Integer flAnalitico;
	
	public Integer getCdComponente() {
		return cdComponente;
	}
	public void setCdComponente(Integer cdComponente) {
		this.cdComponente = cdComponente;
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
	public Integer getCdComponentesuperior() {
		return cdComponentesuperior;
	}
	public void setCdComponentesuperior(Integer cdComponentesuperior) {
		this.cdComponentesuperior = cdComponentesuperior;
	}
	public String getCdAuxiliar() {
		return cdAuxiliar;
	}
	public void setCdAuxiliar(String cdAuxiliar) {
		this.cdAuxiliar = cdAuxiliar;
	}	
	public String getDeComponente() {
        return deComponente;
    }
    public void setDeComponente(String deComponente) {
        this.deComponente = deComponente;
    }
    public Double getVlInicial() {
		return vlInicial;
	}
	public void setVlInicial(Double vlInicial) {
		this.vlInicial = vlInicial;
	}
	public Double getVlAtual() {
		return vlAtual;
	}
	public void setVlAtual(Double vlAtual) {
		this.vlAtual = vlAtual;
	}
	public Integer getCdNivel() {
		return cdNivel;
	}
	public void setCdNivel(Integer cdNivel) {
		this.cdNivel = cdNivel;
	}
	public Integer getFlUltimonivel() {
		return flUltimonivel;
	}
	public void setFlUltimonivel(Integer flUltimonivel) {
		this.flUltimonivel = flUltimonivel;
	}
	public Integer getFlConcluido() {
		return flConcluido;
	}
	public void setFlConcluido(Integer flConcluido) {
		this.flConcluido = flConcluido;
	}
    public Integer getFlAnalitico() {
        return flAnalitico;
    }
    public void setFlAnalitico(Integer flAnalitico) {
        this.flAnalitico = flAnalitico;
    }
    public String getDeComponenteFmt(){
        return cdAuxiliar + " - " + deComponente;
    }
}