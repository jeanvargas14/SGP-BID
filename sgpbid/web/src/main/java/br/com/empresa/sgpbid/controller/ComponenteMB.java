/**
 * 
 */
package br.com.empresa.sgpbid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.CellEditEvent;

import br.com.empresa.sgpbid.componente.Componente;
import br.com.empresa.sgpbid.componente.Componenteorigem;
import br.com.empresa.sgpbid.dto.ComponenteDTO;
import br.com.empresa.sgpbid.origem.Origem;
import br.com.empresa.sgpbid.programa.Programa;
import br.com.empresa.sgpbid.service.ICadastrobasico;
import br.com.empresa.sgpbid.util.Constantes;

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
    private List<ComponenteDTO> componentes;
    private List<SelectItem> componentesSuperiores;
    private Programa programa;
    
    private List<Componenteorigem> componenteorigens;
    private Double vlTotal;
    private boolean analitico;
    
    @PostConstruct
    public void init(){
        System.out.println("[ComponenteMB] init ...");
        componente = new Componente();        
        componentes = new ArrayList<ComponenteDTO>();
        vlTotal = 0D;
        analitico = false;
    }
    
    private void carregacomponentesSuperiores() {
        getProgramaSessao();
        componentesSuperiores = new ArrayList<SelectItem>();
        List<Componente> lista = cadastrobasicoService.findAllComponentesSuperiores(programa.getCdPrograma());
        for(Componente componente : lista){
            componentesSuperiores.add(new SelectItem(componente.getCdComponente(), componente.getCdAuxiliar() +" - "+componente.getDeComponente(), componente.getCdAuxiliar()));
        }
    }    
    public String abrirConComponente(){
        getProgramaSessao();
        componentes = cadastrobasicoService.findAllComponentesDTO(programa);                
        return CONSULTA_JSF;
    }
    
    public String novo(){                
        carregacomponentesSuperiores();
        criaListaComponenteorigem();
        componente = new Componente();
        componente.setFlAnalitico("0");
    	return CADASTRO_JSF;
    }
    
    private void criaListaComponenteorigem(){
        componenteorigens = new ArrayList<Componenteorigem>();
        List<Origem> origens = cadastrobasicoService.findAllOrigem();
        for(Origem o : origens){            
            Componenteorigem c = new Componenteorigem();
            c.setOrigem(o);
            componenteorigens.add(c);
        }
    }
    public String editar(){
    	return CADASTRO_JSF;
    }
    public String save(){
    	return CADASTRO_JSF;
    }
    public String concluir(){
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

    public List<ComponenteDTO> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<ComponenteDTO> componentes) {
        this.componentes = componentes;
    }

    public List<Componenteorigem> getComponenteorigens() {
        return componenteorigens;
    }

    public void setComponenteorigens(List<Componenteorigem> componenteorigens) {
        this.componenteorigens = componenteorigens;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }
    public void onChangeVlAtual(CellEditEvent event) {        
        for(Componenteorigem co : componenteorigens) {
           vlTotal += co.getVlAtual();
        }
    }
    public void getProgramaSessao(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = (HttpSession) request.getSession();
        Integer cdProgramaSession = (Integer) session.getAttribute(Constantes.CD_PROGRAMA);
        programa = cadastrobasicoService.findByProgramaId(cdProgramaSession);
    }
    public void setAnalitico(boolean analitico){
        this.analitico = analitico;
    }
    public boolean isAnalitico(){
        if(componente == null) {
            return false;
        }
        return componente.getFlAnalitico().equals("1");
    }
}