/**
 * 
 */
package br.com.empresa.sgpbid.dto;

import java.io.Serializable;

/**
 * 14 de set de 2016
 * @author roberto.conceicao
 *
 */
public class ComponenteDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer cdComponente;
    private Integer cdPrograma;
    private Integer cdComponentesuperior;
    private String  cdAuxiliar;
    private String  deComponente;
    private Integer cdNivel;
    private Integer flUltimonivel;
    private Integer flConcluido;
    private Integer flAnalitico;
    private Double  vlTotal;
    private Double  peFinanciamento;
    
    //BID
    private Integer cdOrigembid;
    private String  sgOrigembid;
    private String  deOrigembid;
    private Integer flContrapartidabid;
    private Double  vlInicialbid;
    private Double  vlAtualbid;
    
    //LOCAL
    private Integer cdOrigemlocal;
    private String  sgOrigemlocal;
    private String  deOrigemlocal;
    private Integer flContrapartidalocal;
    private Double  vlIniciallocal;
    private Double  vlAtuallocal;
    
    public Integer getCdComponente() {
        return cdComponente;
    }
    public void setCdComponente(Integer cdComponente) {
        this.cdComponente = cdComponente;
    }
    public Integer getCdPrograma() {
        return cdPrograma;
    }
    public void setCdPrograma(Integer cdPrograma) {
        this.cdPrograma = cdPrograma;
    }
    public Integer getCdComponentesuperior() {
        return cdComponentesuperior;
    }
    public void setCdComponentesuperior(Integer cdComponentesuperior) {
        this.cdComponentesuperior = cdComponentesuperior;
    }
    public String getCdAuxiliar() {
        return cdAuxiliar;
    }
    public void setCdAuxiliar(String cdAuxiliar) {
        this.cdAuxiliar = cdAuxiliar;
    }
    public String getDeComponente() {
        return deComponente;
    }
    public void setDeComponente(String deComponente) {
        this.deComponente = deComponente;
    }    
    public Integer getCdNivel() {
        return cdNivel;
    }
    public void setCdNivel(Integer cdNivel) {
        this.cdNivel = cdNivel;
    }
    public Integer getFlUltimonivel() {
        return flUltimonivel;
    }
    public void setFlUltimonivel(Integer flUltimonivel) {
        this.flUltimonivel = flUltimonivel;
    }
    public Integer getFlConcluido() {
        return flConcluido;
    }
    public void setFlConcluido(Integer flConcluido) {
        this.flConcluido = flConcluido;
    }
    public Integer getFlAnalitico() {
        return flAnalitico;
    }
    public void setFlAnalitico(Integer flAnalitico) {
        this.flAnalitico = flAnalitico;
    }
    public Integer getCdOrigembid() {
        return cdOrigembid;
    }
    public void setCdOrigembid(Integer cdOrigembid) {
        this.cdOrigembid = cdOrigembid;
    }
    public String getSgOrigembid() {
        return sgOrigembid;
    }
    public void setSgOrigembid(String sgOrigembid) {
        this.sgOrigembid = sgOrigembid;
    }
    public String getDeOrigembid() {
        return deOrigembid;
    }
    public void setDeOrigembid(String deOrigembid) {
        this.deOrigembid = deOrigembid;
    }
    public Integer getFlContrapartidabid() {
        return flContrapartidabid;
    }
    public void setFlContrapartidabid(Integer flContrapartidabid) {
        this.flContrapartidabid = flContrapartidabid;
    }
    public Integer getCdOrigemlocal() {
        return cdOrigemlocal;
    }
    public void setCdOrigemlocal(Integer cdOrigemlocal) {
        this.cdOrigemlocal = cdOrigemlocal;
    }
    public String getSgOrigemlocal() {
        return sgOrigemlocal;
    }
    public void setSgOrigemlocal(String sgOrigemlocal) {
        this.sgOrigemlocal = sgOrigemlocal;
    }
    public String getDeOrigemlocal() {
        return deOrigemlocal;
    }
    public void setDeOrigemlocal(String deOrigemlocal) {
        this.deOrigemlocal = deOrigemlocal;
    }
    public Integer getFlContrapartidalocal() {
        return flContrapartidalocal;
    }
    public void setFlContrapartidalocal(Integer flContrapartidalocal) {
        this.flContrapartidalocal = flContrapartidalocal;
    }
    public Double getPeFinanciamento() {
        return peFinanciamento;
    }
    public void setPeFinanciamento(Double peFinanciamento) {
        this.peFinanciamento = peFinanciamento;
    }
    public Double getVlInicialbid() {
        return vlInicialbid;
    }
    public void setVlInicialbid(Double vlInicialbid) {
        this.vlInicialbid = vlInicialbid;
    }
    public Double getVlAtualbid() {
        return vlAtualbid;
    }
    public void setVlAtualbid(Double vlAtualbid) {
        this.vlAtualbid = vlAtualbid;
    }
    public Double getVlIniciallocal() {
        return vlIniciallocal;
    }
    public void setVlIniciallocal(Double vlIniciallocal) {
        this.vlIniciallocal = vlIniciallocal;
    }
    public Double getVlAtuallocal() {
        return vlAtuallocal;
    }
    public void setVlAtuallocal(Double vlAtuallocal) {
        this.vlAtuallocal = vlAtuallocal;
    }
    public Double getVlTotal() {
        setVlTotal(vlAtualbid + vlAtuallocal);
        return vlTotal;
    }
    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }
}