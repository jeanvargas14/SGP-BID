/**
 * 
 */
package br.com.empresa.sgpbid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import br.com.empresa.sgpbid.programa.DetalhePrograma;
import br.com.empresa.sgpbid.programa.Programa;
import br.com.empresa.sgpbid.service.ICadastrobasico;
import br.com.empresa.sgpbid.setor.Setor;

/**
 * 26 de jul de 2016
 * @author roberto.conceicao
 *
 */
@ManagedBean
@SessionScoped
public class ProgramaMB {

	public static final String CADASTRO_JSF = "/restrito/jsf/programa/sgpCadPrograma.xhtml";
	public static final String CONSULTA_JSF = "/restrito/jsf/programa/sgpConPrograma.xhtml";
	public static final String DETALHE_PROGRAMA_JSF = "/restrito/jsf/programa/sgpCadDetalhePrograma.xhtml";
	
	@Inject
	private ICadastrobasico cadastrobasicoService;
	
	private List<Programa> lista;
	private List<String> equipeAprovacao;
	private List<String> equipeAtual;
	
	private Programa programa;	
	private Programa filtro;
	
	private List<SelectItem> fontes;
	private List<SelectItem> setores;
	
	private DetalhePrograma detalhePrograma;
	
	private boolean disabled;
	
	public ProgramaMB() {
		System.out.println("[ProgramaMB] instanciando ...");
	}

	@PostConstruct
	public void init(){
		System.out.println("[ProgramaMB] init ...");
		programa = new Programa();
		filtro = new Programa();
		lista = new ArrayList<Programa>();
		detalhePrograma = new DetalhePrograma();
		disabled = false;
		carregaFontes();
		carregaSetores();
		carregaEquipeAprovacao();
		carregaEquipeAtual();
	}
	
	private void carregaEquipeAtual() {
		//TODO
		equipeAtual = new ArrayList<String>();
		equipeAtual.add("Marcia Silva Casseb");
		equipeAtual.add("Pollyane Moreira Alves");
		equipeAtual.add("Vicente J. Moles");
	}
	
	private void carregaEquipeAprovacao() {		
		//TODO
		equipeAprovacao = new ArrayList<String>();		
		equipeAprovacao.add("Jason Anthony Hobbs");
	}

	private void carregaSetores() {
		setores = new ArrayList<SelectItem>();
		List<Setor> lista = cadastrobasicoService.findAllSetor();
		for(Setor setor : lista){
			setores.add(new SelectItem(setor.getCdSetor(), setor.getDeSetor(), setor.getSgSetor()));
		}
	}

	private void carregaFontes() {
		fontes = new ArrayList<SelectItem>();
		fontes.add(new SelectItem('1', "CO", "CO"));
		fontes.add(new SelectItem('2', "FOE", "FOE"));
	}

	public String abrirConPrograma(){
		programa = new Programa();
		filtro = new Programa();
		lista = new ArrayList<Programa>();
		return CONSULTA_JSF;
	}
	
	public void consultarPrograma(){
		setLista(cadastrobasicoService.findProgramas(filtro));
	}
	
	public String novo(){
		programa = new Programa();
		disabled = false;
		return CADASTRO_JSF;
	}
	
	public String editar(){	
		disabled = true;
		return CADASTRO_JSF;
	}
	
	public String detalhePrograma(){
		detalhePrograma = cadastrobasicoService.findDetalheprograma(programa.getCdPrograma()); 
		return DETALHE_PROGRAMA_JSF;
	}
	
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Programa Selected", ""+((Programa) event.getObject()).getCdPrograma());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void save(){
		try {
			System.out.println("Executando metodo salvar programa ...");
			cadastrobasicoService.salvarPrograma(programa);
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Sucesso",  "Operação realizada com sucesso"));
	        disabled = true;
		} catch(Exception e ){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Erro ao realizar a operação"));
		}		
	}

	public void salvarDetalheprograma(){
		try {
			System.out.println("Executando metodo salvar detalhe programa ...");
			detalhePrograma.setPrograma(programa);
			cadastrobasicoService.salvarDetalheprograma(detalhePrograma);
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Sucesso",  "Operação realizada com sucesso"));			
		} catch(Exception e ){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Erro ao realizar a operação"));
		}		
	}
	
	public List<Programa> getLista() {
		return lista;
	}
	public void setLista(List<Programa> lista) {
		this.lista = lista;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public Programa getFiltro() {
		return filtro;
	}
	public void setFiltro(Programa filtro) {
		this.filtro = filtro;
	}
	public DetalhePrograma getDetalhePrograma() {
		return detalhePrograma;
	}
	public void setDetalhePrograma(DetalhePrograma detalhePrograma) {
		this.detalhePrograma = detalhePrograma;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public List<SelectItem> getFontes() {
		return fontes;
	}

	public void setFontes(List<SelectItem> fontes) {
		this.fontes = fontes;
	}

	public List<SelectItem> getSetores() {
		return setores;
	}

	public void setSetores(List<SelectItem> setores) {
		this.setores = setores;
	}

	public List<String> getEquipeAprovacao() {
		return equipeAprovacao;
	}

	public void setEquipeAprovacao(List<String> equipeAprovacao) {
		this.equipeAprovacao = equipeAprovacao;
	}

	public List<String> getEquipeAtual() {
		return equipeAtual;
	}

	public void setEquipeAtual(List<String> equipeAtual) {
		this.equipeAtual = equipeAtual;
	}	
}