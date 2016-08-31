package br.com.empresa.sgpbid.banco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SGPBANCO")
public class Banco {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cdBanco;	
	private String cdAuxiliar;
	private String nmBanco;
	private String sgBanco;
	public Integer getCdBanco() {
		return cdBanco;
	}
	public void setCdBanco(Integer cdBanco) {
		this.cdBanco = cdBanco;
	}
	public String getCdAuxiliar() {
		return cdAuxiliar;
	}
	public void setCdAuxiliar(String cdAuxiliar) {
		this.cdAuxiliar = cdAuxiliar;
	}
	public String getNmBanco() {
		return nmBanco;
	}
	public void setNmBanco(String nmBanco) {
		this.nmBanco = nmBanco;
	}
	public String getSgBanco() {
		return sgBanco;
	}
	public void setSgBanco(String sgBanco) {
		this.sgBanco = sgBanco;
	}
}