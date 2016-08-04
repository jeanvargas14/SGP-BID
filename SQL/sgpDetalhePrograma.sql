CREATE TABLE sgpDetalhePrograma(
	cdPrograma decimal (2,0) NOT NULL REFERENCES sgpPrograma (cdPrograma),
	dtAprovacao date NULL,
  	dtAssinatura date NULL,
	dtElegibilidade date NULL,
	dtConclusao date NULL,
	dtPrazoUltimoDesembOriginal date NULL,
	dtPrazoUltimoDesembVigente date NULL,
	dtPrimeiraAmortizacao date NULL,
	dtUltimaAmortizacao date NULL,
	dtApresentacaoPCR date NULL,
	dtApresentacaoLRR date NULL,
	dtAnaliseRiscoInicial date NULL,
	dtRevisaoAnaliseRisco date NULL,
	dtUltimaVisitaSupervisao date NULL,	
	deAtoCriacaoUnidade varchar (200) NULL,
	deDesignacaoEquipe varchar (200) NULL,
	sgDivisao varchar (30) NULL,
	cdEspSetorial decimal (3,0) NULL,
	cdEspAlternativo decimal (3,0) NULL,
	cdEspFinanceiro decimal (3,0) NULL,
	vlOriginalAprovado decimal (12,2) NULL,
	vlVigente decimal (12,2) NULL,
  CONSTRAINT XPKsgpDetalhePrograma PRIMARY KEY 

  (cdPrograma)

  );