package br.com.empresa.sgpbid.componente;

import javax.persistence.Embeddable;

@Embeddable
public class ComponenteorigemPK {
	private Integer cdPrograma;
	private Integer cdComponente;
	private Integer cdOrigem;
	public Integer getCdPrograma() {
		return cdPrograma;
	}
	public void setCdPrograma(Integer cdPrograma) {
		this.cdPrograma = cdPrograma;
	}
	public Integer getCdComponente() {
		return cdComponente;
	}
	public void setCdComponente(Integer cdComponente) {
		this.cdComponente = cdComponente;
	}
	public Integer getCdOrigem() {
		return cdOrigem;
	}
	public void setCdOrigem(Integer cdOrigem) {
		this.cdOrigem = cdOrigem;
	}
}