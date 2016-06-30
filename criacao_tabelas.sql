CREATE TABLE sgpProjeto(
  cdProjeto   decimal (2, 0) NOT NULL,
  nmProjeto   varchar (150) NOT NULL
); 

ALTER TABLE sgpProjeto ADD CONSTRAINT  XPKsgpProjeto  PRIMARY KEY 
(
  cdProjeto 
);
 
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
  cdusuario character varying(255) NOT NULL,
  cdgrupo character varying(255) NOT NULL,
  CONSTRAINT xpksgpusuariogrupo PRIMARY KEY (cdusuario, cdgrupo),
  FOREIGN KEY (cdusuario) REFERENCES sgpUsuario(cdusuario),
  FOREIGN KEY (cdgrupo) REFERENCES sgpGrupo(cdgrupo)
);

-- Inserindo usuarios para testes os proximos podem ser inseridos via interface
INSERT INTO sgpUsuario (cdUsuario, senha ) VALUES ( 'sgp' , 'C5nCRry4A+tK/BB0Gc15uQ=='); --senha sgp
INSERT INTO sgpUsuario (cdUsuario, senha ) VALUES ( 'bob' , 'C5nCRry4A+tK/BB0Gc15uQ==');
INSERT INTO sgpUsuario (cdUsuario, senha ) VALUES ( 'jean', 'C5nCRry4A+tK/BB0Gc15uQ==');

INSERT INTO sgpGrupo (cdGrupo) VALUES ( 'admin' );
INSERT INTO sgpGrupo (cdGrupo) VALUES ( 'users' );

INSERT INTO sgpUsuarioGrupo (cdUsuario, cdGrupo) VALUES ( 'sgp', 'users');
INSERT INTO sgpUsuarioGrupo (cdUsuario, cdGrupo) VALUES ( 'bob', 'admin');
INSERT INTO sgpUsuarioGrupo (cdUsuario, cdGrupo) VALUES ( 'jean', 'admin');