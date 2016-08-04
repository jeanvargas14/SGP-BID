/**
 * 
 */
package br.com.empresa.sgpbid.setor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 4 de ago de 2016
 * @author roberto.conceicao
 *
 */
@Entity 
@Table(name="SGPSETOR")
public class Setor {
	
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer cdSetor;
	
	@NotNull
	@Size(min=1, max=100)
	private String deSetor;
	
	@Size(min=0, max=100)
	private String sgSetor;

	public Integer getCdSetor() {
		return cdSetor;
	}

	public void setCdSetor(Integer cdSetor) {
		this.cdSetor = cdSetor;
	}

	public String getDeSetor() {
		return deSetor;
	}

	public void setDeSetor(String deSetor) {
		this.deSetor = deSetor;
	}

	public String getSgSetor() {
		return sgSetor;
	}

	public void setSgSetor(String sgSetor) {
		this.sgSetor = sgSetor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdSetor == null) ? 0 : cdSetor.hashCode());
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
		Setor other = (Setor) obj;
		if (cdSetor == null) {
			if (other.cdSetor != null)
				return false;
		} else if (!cdSetor.equals(other.cdSetor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Setor [cdSetor=" + cdSetor + ", deSetor=" + deSetor + ", sgSetor=" + sgSetor + "]";
	}	
}
