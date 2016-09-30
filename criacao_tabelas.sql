CREATE TABLE sgpSetor(
	cdSetor decimal (2,0) NOT NULL,
	deSetor varchar (100) NOT NULL,	
	sgSetor varchar (15)  NULL,	
	CONSTRAINT XPKsgpSetor PRIMARY KEY (cdSetor)
);

insert into sgpSetor values(1,'Saúde',null);

insert into sgpPrograma values(1,'Teste Programa','Program Test','PR01','OP01','Descrição do programa','Fulano da Silva','FS',2010,2016,1,'1',1, 'descricao');

CREATE TABLE sgpPrograma(
  cdPrograma   decimal (2,0) NOT NULL,
  nmPrograma   varchar (150) NOT NULL,
  nmProgramaIngles varchar (150) NULL,
  nuPrograma varchar(15) NOT NULL,
  nuOperacao varchar(15) NOT NULL,
  dePrograma varchar(2000) NOT NULL,
  nmMutuario varchar (100) NOT NULL,
  sgMutuario varchar (15) NOT NULL,
  nuAnoInicio decimal(4,0) NOT NULL,
  nuAnoFim decimal(4,0) NOT NULL,
  sgTipoOperacao varchar (50) NOT NULL,
  tpfonte char (1) NOT NULL,
  cdSetor decimal(2,0) NOT NULL REFERENCES sgpSetor (cdSetor),
  deClassificacao varchar (10) NULL,
  CONSTRAINT XPKsgpPrograma PRIMARY KEY (cdPrograma),
  UNIQUE (cdPrograma,nuPrograma,nuOperacao));


CREATE TABLE sgpDetalhePrograma(
	cdDetalheprograma decimal (2,0) NOT NULL,
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
  CONSTRAINT XPKsgpDetalhePrograma PRIMARY KEY (cdDetalheprograma),
  UNIQUE (cdPrograma)
  );

CREATE TABLE sgpBanco (
	cdBanco decimal(3,0) NOT NULL,
	cdAuxiliar varchar(10) NOT NULL,
	nmBanco varchar(50) NOT NULL,
	sgBanco varchar(15) NULL,
	CONSTRAINT XPKsgpBanco PRIMARY KEY (cdBanco)
)
  
CREATE TABLE sgpFinalidade(
  cdProjeto   decimal (2, 0) NOT NULL,
  cdFinalidade   decimal (3, 0) NOT NULL,
  deFinalidade   varchar (70) NULL
);

ALTER TABLE sgpFinalidade ADD CONSTRAINT  XPKsgpFinalidade  PRIMARY KEY 
(
  cdProjeto ,
  cdFinalidade 
);

CREATE TABLE sgpOrigem(
	cdPrograma decimal(2,0) NOT NULL REFERENCES sgpPrograma (cdPrograma),
	cdOrigem decimal(2,0) NOT NULL,
	sgOrigem varchar(15) NOT NULL,
	deOrigem varchar(100) NOT NULL,
	flContrapartida decimal(1,0) NOT NULL,
	CONSTRAINT XPKsgpOrigem PRIMARY KEY (cdOrigem),
	UNIQUE (cdPrograma, cdOrigem));

INSERT INTO sgpOrigem VALUES (1,1,'BID','Banco Interamericano de Desenvolvimento',0)
INSERT INTO sgpOrigem VALUES (1,2,'CNTP','Contrapartida',0)

CREATE TABLE sgpComponente(
	cdPrograma decimal(2,0) NOT NULL REFERENCES sgpPrograma (cdPrograma),
	cdComponente decimal(3, 0) NOT NULL,
	cdComponenteSuperior decimal(3,0) NULL,
	cdAuxiliar varchar(20) NOT NULL,
	deComponente varchar(150) NOT NULL,
	vlInicial decimal(11,2) NULL,
	vlAtual decimal(11,2) NULL,
	cdNivel decimal(2,0) NOT NULL,
	flUltimoNivel decimal(1,0) NOT NULL,
	flConcluido decimal(1, 0) NOT NULL,
	flAnalitico decimal(1, 0) NOT NULL,
	CONSTRAINT XPKsgpComponente PRIMARY KEY (cdComponente),
	UNIQUE (cdPrograma, cdComponente));
	
CREATE TABLE sgpComponenteOrigem(
	cdPrograma decimal(2,0) NOT NULL REFERENCES sgpPrograma (cdPrograma),
	cdComponente decimal(3, 0) NOT NULL REFERENCES sgpComponente (cdComponente),
	cdOrigem decimal(2,0) NOT NULL REFERENCES sgpOrigem (cdOrigem),
	vlInicial decimal(11,2) NOT NULL,
	vlAtual decimal(11,2) NOT NULL,
	peFinanciamento decimal(5,2) NOT NULL,
	CONSTRAINT XPKsgpComponenteOrigem PRIMARY KEY (cdPrograma, cdComponente, cdOrigem));

----------------Nível código----------------
CREATE TABLE sgpNivel(
	cdPrograma decimal(2,0) NOT NULL REFERENCES sgpPrograma (cdPrograma),
	cdNivel decimal(2,0) NOT NULL,
	deNivel varchar(20) NOT NULL,
	tmNivel decimal(1,0) NOT NULL,
	tpNivel char(1) NOT NULL,
CONSTRAINT [XPKsgpNivel] PRIMARY KEY (cdNivel)
UNIQUE (cdPrograma,cdNivel))
 
ALTER TABLE sgpNivel ADD CONSTRAINT flag_C_N CHECK  (([tpNivel] = 'N' or [tpNivel] = 'C'))

ALTER TABLE sgpNivel CHECK CONSTRAINT flag_C_N

------- PARTE DOS USUARIOS DO SISTEMA AINDA FALTA MELHORAR ----
CREATE TABLE sgpUsuario( 
	cdUsuario varchar (255) NOT NULL,
	senha varchar (255) NOT NULL	
);

ALTER TABLE sgpUsuario ADD CONSTRAINT  XPKsgpUsuario  PRIMARY KEY 
(
  cdUsuario
);

CREATE TABLE sgpgrupo
(
  cdgrupo character varying(255) NOT NULL,
  CONSTRAINT xpksgpgrupo PRIMARY KEY (cdgrupo)
);

CREATE TABLE sgpusuariogrupo
(
  id integer NOT NULL,
  cdusuario character varying(255) NOT NULL,
  cdgrupo character varying(255) NOT NULL,
  CONSTRAINT xpksgpusuariogrupo PRIMARY KEY (id),
  FOREIGN KEY (cdusuario) REFERENCES sgpUsuario(cdusuario),
  FOREIGN KEY (cdgrupo) REFERENCES sgpGrupo(cdgrupo),
  UNIQUE(cdusuario, cdgrupo)
);

-- Inserindo usuarios para testes os proximos podem ser inseridos via interface
INSERT INTO sgpUsuario (cdUsuario, senha ) VALUES ( 'sgp' , 'C5nCRry4A+tK/BB0Gc15uQ=='); --senha sgp
INSERT INTO sgpUsuario (cdUsuario, senha ) VALUES ( 'bob' , 'C5nCRry4A+tK/BB0Gc15uQ==');
INSERT INTO sgpUsuario (cdUsuario, senha ) VALUES ( 'jean', 'C5nCRry4A+tK/BB0Gc15uQ==');

INSERT INTO sgpGrupo (cdGrupo) VALUES ( 'admin' );
INSERT INTO sgpGrupo (cdGrupo) VALUES ( 'users' );

INSERT INTO sgpUsuarioGrupo (id, cdUsuario, cdGrupo) VALUES ( 1, 'sgp', 'users');
INSERT INTO sgpUsuarioGrupo (id, cdUsuario, cdGrupo) VALUES ( 2, 'bob', 'admin');
INSERT INTO sgpUsuarioGrupo (id, cdUsuario, cdGrupo) VALUES ( 3, 'jean', 'admin');
