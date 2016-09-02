/**
 * 
 */
package br.com.empresa.sgpbid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import br.com.empresa.sgpbid.componente.Componente;
import br.com.empresa.sgpbid.componente.Componenteorigem;
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

    public static final String CADASTRO_JSF = "/restrito/jsf/componente/sgpCadComponente.xhtml";
    public static final String CONSULTA_JSF = "/restrito/jsf/componente/sgpConComponente.xhtml";
    
    @Inject
    private ICadastrobasico cadastrobasicoService;
    private Componente componente;
    private List<Componenteorigem> componenteOrigemList;
    private List<SelectItem> componentesSuperiores;
    private Programa programa;
    
    @PostConstruct
    public void init(){
        System.out.println("[ProgramaMB] init ...");
        componenteOrigemList = new ArrayList<Componenteorigem>();
        carregacomponentesSuperiores();
    }
    
    private void carregacomponentesSuperiores() {
        componentesSuperiores = new ArrayList<SelectItem>();
        List<Componente> lista = cadastrobasicoService.findAllComponentesSuperiores(programa.getCdPrograma());
        for(Componente componente : lista){
            componentesSuperiores.add(new SelectItem(componente.getCdComponente(), componente.getCdAuxiliar() +" - "+componente.getDeComponente(), componente.getCdAuxiliar()));
        }
    }
    
    public String abrirConComponente(){
        componenteOrigemList = cadastrobasicoService.findAllComponenteorigem(programa);
        return CONSULTA_JSF;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public List<SelectItem> getComponentesSuperiores() {
        return componentesSuperiores;
    }

    public void setComponentesSuperiores(List<SelectItem> componentesSuperiores) {
        this.componentesSuperiores = componentesSuperiores;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public List<Componenteorigem> getComponenteOrigemList() {
        return componenteOrigemList;
    }

    public void setComponenteOrigemList(List<Componenteorigem> componenteOrigemList) {
        this.componenteOrigemList = componenteOrigemList;
    }       
}