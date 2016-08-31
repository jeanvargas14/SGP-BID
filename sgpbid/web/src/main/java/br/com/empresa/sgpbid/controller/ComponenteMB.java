/**
 * 
 */
package br.com.empresa.sgpbid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import br.com.empresa.sgpbid.componente.Componente;
import br.com.empresa.sgpbid.programa.Programa;
import br.com.empresa.sgpbid.service.ICadastrobasico;

/**
 * 31 de ago de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
@SessionScoped
public class ComponenteMB {

    public static final String CADASTRO_JSF = "/restrito/jsf/programa/sgpCadComponente.xhtml";
    public static final String CONSULTA_JSF = "/restrito/jsf/programa/sgpConComponente.xhtml";
    
    @Inject
    private ICadastrobasico cadastrobasicoService;
    private Componente componente;
    private List<SelectItem> componentesSuperiores;
    private Programa programa;
    
    private void carregacomponentesSuperiores() {
        componentesSuperiores = new ArrayList<SelectItem>();
        List<Componente> lista = cadastrobasicoService.findAllComponentesSuperiores(programa.getCdPrograma());
        for(Componente componente : lista){
            componentesSuperiores.add(new SelectItem(componente.getCdComponente(), componente.getCdAuxiliar() +" - "+componente.getDeComponente(), componente.getCdAuxiliar()));
        }
    }    
}