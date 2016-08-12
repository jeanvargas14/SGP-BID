/**
 * 
 */
package br.com.empresa.sgpbid.programa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 21 de jul de 2016
 * @author roberto.conceicao
 *
 */
@Entity
@Table(name="SGPDETALHEPROGRAMA")
public class DetalhePrograma {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer cdDetalheprograma;
    
	@ManyToOne
	@JoinColumn(name = "cdPrograma", unique = true, nullable = false, insertable=false, updatable=false)
	private Programa programa;
	
	private Integer cdPrograma;
	
	//Unidade de Coodernacao do Projeto
	private String deAtoCriacaoUnidade;
	private String deDesignacaoEquipe;
	
	
	private String sgDivisao;
	private Integer cdEspSetorial;
	private Integer cdEspAlternativo;
	private Integer cdEspFinanceiro;
	private Double vlOriginalAprovado;
	private Double vlVigente;
	
	@Temporal(TemporalType.DATE)
	private Date dtAprovacao;
	@Temporal(TemporalType.DATE)
	private Date dtAssinatura;
	@Temporal(TemporalType.DATE)
	private Date dtElegibilidade;
	@Temporal(TemporalType.DATE)
	private Date dtConclusao;
	@Temporal(TemporalType.DATE)
	private Date dtPrazoUltimoDesembOriginal;
	@Temporal(TemporalType.DATE)
	private Date dtPrazoUltimoDesembVigente;
	@Temporal(TemporalType.DATE)
	private Date dtPrimeiraAmortizacao;
	@Temporal(TemporalType.DATE)
	private Date dtUltimaAmortizacao;
	@Temporal(TemporalType.DATE)
	private Date dtApresentacaoPCR;
	@Temporal(TemporalType.DATE)
	private Date dtApresentacaoLRR;
	@Temporal(TemporalType.DATE)
	private Date dtAnaliseRiscoInicial;
	@Temporal(TemporalType.DATE)
	private Date dtRevisaoAnaliseRisco;
	@Temporal(TemporalType.DATE)
	private Date dtUltimaVisitaSupervisao;
	
	public Integer getCdDetalheprograma() {
        return cdDetalheprograma;
    }
    public void setCdDetalheprograma(Integer cdDetalheprograma) {
        this.cdDetalheprograma = cdDetalheprograma;
    }
    public Integer getCdPrograma() {
		return cdPrograma;
	}
	public void setCdPrograma(Integer cdPrograma) {
		this.cdPrograma = cdPrograma;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}	
	public String getDeAtoCriacaoUnidade() {
		return deAtoCriacaoUnidade;
	}
	public void setDeAtoCriacaoUnidade(String deAtoCriacaoUnidade) {
		this.deAtoCriacaoUnidade = deAtoCriacaoUnidade;
	}
	public String getDeDesignacaoEquipe() {
		return deDesignacaoEquipe;
	}
	public void setDeDesignacaoEquipe(String deDesignacaoEquipe) {
		this.deDesignacaoEquipe = deDesignacaoEquipe;
	}
	public String getSgDivisao() {
		return sgDivisao;
	}
	public void setSgDivisao(String sgDivisao) {
		this.sgDivisao = sgDivisao;
	}
	public Integer getCdEspSetorial() {
		return cdEspSetorial;
	}
	public void setCdEspSetorial(Integer cdEspSetorial) {
		this.cdEspSetorial = cdEspSetorial;
	}
	public Integer getCdEspAlternativo() {
		return cdEspAlternativo;
	}
	public void setCdEspAlternativo(Integer cdEspAlternativo) {
		this.cdEspAlternativo = cdEspAlternativo;
	}
	public Integer getCdEspFinanceiro() {
		return cdEspFinanceiro;
	}
	public void setCdEspFinanceiro(Integer cdEspFinanceiro) {
		this.cdEspFinanceiro = cdEspFinanceiro;
	}
	public Double getVlOriginalAprovado() {
		return vlOriginalAprovado;
	}
	public void setVlOriginalAprovado(Double vlOriginalAprovado) {
		this.vlOriginalAprovado = vlOriginalAprovado;
	}
	public Double getVlVigente() {
		return vlVigente;
	}
	public void setVlVigente(Double vlVigente) {
		this.vlVigente = vlVigente;
	}
	public Date getDtAprovacao() {
		return dtAprovacao;
	}
	public void setDtAprovacao(Date dtAprovacao) {
		this.dtAprovacao = dtAprovacao;
	}
	public Date getDtAssinatura() {
		return dtAssinatura;
	}
	public void setDtAssinatura(Date dtAssinatura) {
		this.dtAssinatura = dtAssinatura;
	}
	public Date getDtElegibilidade() {
		return dtElegibilidade;
	}
	public void setDtElegibilidade(Date dtElegibilidade) {
		this.dtElegibilidade = dtElegibilidade;
	}
	public Date getDtConclusao() {
		return dtConclusao;
	}
	public void setDtConclusao(Date dtConclusao) {
		this.dtConclusao = dtConclusao;
	}
	public Date getDtPrazoUltimoDesembOriginal() {
		return dtPrazoUltimoDesembOriginal;
	}
	public void setDtPrazoUltimoDesembOriginal(Date dtPrazoUltimoDesembOriginal) {
		this.dtPrazoUltimoDesembOriginal = dtPrazoUltimoDesembOriginal;
	}
	public Date getDtPrazoUltimoDesembVigente() {
		return dtPrazoUltimoDesembVigente;
	}
	public void setDtPrazoUltimoDesembVigente(Date dtPrazoUltimoDesembVigente) {
		this.dtPrazoUltimoDesembVigente = dtPrazoUltimoDesembVigente;
	}
	public Date getDtPrimeiraAmortizacao() {
		return dtPrimeiraAmortizacao;
	}
	public void setDtPrimeiraAmortizacao(Date dtPrimeiraAmortizacao) {
		this.dtPrimeiraAmortizacao = dtPrimeiraAmortizacao;
	}
	public Date getDtUltimaAmortizacao() {
		return dtUltimaAmortizacao;
	}
	public void setDtUltimaAmortizacao(Date dtUltimaAmortizacao) {
		this.dtUltimaAmortizacao = dtUltimaAmortizacao;
	}
	public Date getDtApresentacaoPCR() {
		return dtApresentacaoPCR;
	}
	public void setDtApresentacaoPCR(Date dtApresentacaoPCR) {
		this.dtApresentacaoPCR = dtApresentacaoPCR;
	}
	public Date getDtApresentacaoLRR() {
		return dtApresentacaoLRR;
	}
	public void setDtApresentacaoLRR(Date dtApresentacaoLRR) {
		this.dtApresentacaoLRR = dtApresentacaoLRR;
	}
	public Date getDtAnaliseRiscoInicial() {
		return dtAnaliseRiscoInicial;
	}
	public void setDtAnaliseRiscoInicial(Date dtAnaliseRiscoInicial) {
		this.dtAnaliseRiscoInicial = dtAnaliseRiscoInicial;
	}
	public Date getDtRevisaoAnaliseRisco() {
		return dtRevisaoAnaliseRisco;
	}
	public void setDtRevisaoAnaliseRisco(Date dtRevisaoAnaliseRisco) {
		this.dtRevisaoAnaliseRisco = dtRevisaoAnaliseRisco;
	}
	public Date getDtUltimaVisitaSupervisao() {
		return dtUltimaVisitaSupervisao;
	}
	public void setDtUltimaVisitaSupervisao(Date dtUltimaVisitaSupervisao) {
		this.dtUltimaVisitaSupervisao = dtUltimaVisitaSupervisao;
	}
}