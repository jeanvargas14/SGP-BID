package br.com.empresa.sgpbid.componente;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.empresa.sgpbid.origem.Origem;

@Entity
@Table(name="SGPCOMPONENTEORIGEM")
public class Componenteorigem {

	@EmbeddedId
	private ComponenteorigemPK componenteorigemPK;
	private Double	vlInicial;
	private Double	vlAtual;
	private Double 	peFinanciamento;
	
	@ManyToOne
	@JoinColumn(name="cdOrigem", insertable=false, updatable=false)
	private Origem origem;
	
	@ManyToOne
	@JoinColumn(name="cdComponente", insertable=false, updatable=false)
	private Componente componente;
	
	public Componenteorigem() {
		setComponenteorigemPK(new ComponenteorigemPK());
		setOrigem(new Origem());		
	}
	public ComponenteorigemPK getComponenteorigemPK() {
		return componenteorigemPK;
	}
	public void setComponenteorigemPK(ComponenteorigemPK componenteorigemPK) {
		this.componenteorigemPK = componenteorigemPK;
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
	public Double getPeFinanciamento() {
		return peFinanciamento;
	}
	public void setPeFinanciamento(Double peFinanciamento) {
		this.peFinanciamento = peFinanciamento;
	}
    public Origem getOrigem() {
        return origem;
    }
    public void setOrigem(Origem origem) {
        this.origem = origem;
    }
    public Componente getComponente() {
        return componente;
    }
    public void setComponente(Componente componente) {
        this.componente = componente;
    }
}