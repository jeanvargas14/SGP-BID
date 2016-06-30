package br.com.empresa.sgpbid.model.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sgpUsuario")
public class Usuario {

	@Id
	private String cdUsuario;

	private String senha;
	
	/*
	 *  referencia: http://uaihebert.com/jpa-onetomany-e-manytoone-unidirecional-e-bidirecional/
	 *  A anotação @JoinTable é bem simples e seu uso bem prático:		
		“name” – indica qual será a tabela que realizará a junção entre Customer e Dog (Por padrão colocamos o lado dominante como primeiro nome na tabela).
		“joinColumns” – informa ao JPA um conjunto de chaves (um array separado por vírgulas) a ser utilizado para se identificar um registro. Poderia ser, por exemplo, o ID e o nome (“name”).
		“@JoinColumn” – aponta uma coluna que servirá de chave primária na tabela de relacionamento. “name” é o nome que a coluna da tabela terá, 
		e “referencedColumnName” é a chave primária da tabela dona do relacionamento; em nosso caso utilizamos id da tabela Customer. 
		(Ao final do post veremos o real lado dominante desse relacionamento. 
		Utilizo o Customer apenas para ficar didaticamente mais fácil)
		“inverseJoinColumns” – faz o mapeamento das colunas da tabela do lado “dominado/fraco”.
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="SGPUSUARIOGRUPO", 
    		   joinColumns = @JoinColumn(name="cdusuario", referencedColumnName="cdusuario"), 
    		   inverseJoinColumns= @JoinColumn(name="cdgrupo", referencedColumnName="cdgrupo", insertable=false, updatable=false)
    		  )    
	private List<Grupo> grupos = new ArrayList<Grupo>();
	
	public String getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}	
}