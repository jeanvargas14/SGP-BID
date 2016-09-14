/**
 * 
 */
package br.com.empresa.sgpbid.dto;

import br.com.empresa.sgpbid.componente.Componente;
import br.com.empresa.sgpbid.origem.Origem;

/**
 * 14 de set de 2016
 * @author roberto.conceicao
 *
 */
public class ComponenteDTO {

    private Componente componente;
    private Origem  bid;
    private Origem  local;
    private Double  vlInicial;
    private Double  vlAtual;
    private Double  peFinanciamento;
    
    public ComponenteDTO(Componente componente, Origem bid, Origem local, Double vlInicial, Double vlAtual, Double peFinanciamento){
        this.componente = componente;
        this.bid = bid;
        this.local = local;
        this.vlInicial = vlInicial;
        this.vlAtual = vlAtual;
        this.peFinanciamento = peFinanciamento;
    }
    
    public Componente getComponente() {
        return componente;
    }
    public void setComponente(Componente componente) {
        this.componente = componente;
    }
    public Origem getBid() {
        return bid;
    }
    public void setBid(Origem bid) {
        this.bid = bid;
    }
    public Origem getLocal() {
        return local;
    }
    public void setLocal(Origem local) {
        this.local = local;
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