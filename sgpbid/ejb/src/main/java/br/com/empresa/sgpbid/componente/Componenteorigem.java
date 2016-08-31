package br.com.empresa.sgpbid.componente;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SGPCOMPONENTEORIGEM")
public class Componenteorigem {

	@EmbeddedId
	private ComponenteorigemPK componenteorigemPK;
	private Double	vlInicial;
	private Double	vlAtual;
	private Double 	peFinanciamento;
	public Componenteorigem() {
		setComponenteorigemPK(new ComponenteorigemPK());
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
}