/**
 * 
 */
package br.com.exemplojsf.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.SecurityDomain;

import br.com.exemplojsf.entity.Projeto;

/**
 * 14 de jun de 2016
 * @author roberto.conceicao
 *
 */
@Stateless
public class CadastrobasicoBean implements CadastrobasicoLocal, Serializable{

	private static final long serialVersionUID = 1L;

	public void salvarProjeto(Projeto projeto){
		
	}
	
	public List<Projeto> findAllProjeto(){
		return null;
	}
}
