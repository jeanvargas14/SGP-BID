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