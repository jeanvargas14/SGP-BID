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

CREATE TABLE sgpGrupo (
	cdGrupo varchar (255) NOT NULL
);
ALTER TABLE sgpGrupo ADD CONSTRAINT  XPKsgpGrupo  PRIMARY KEY 
(
  cdGrupo
);

CREATE TABLE sgpUsuarioGrupo (
 cdUsuario varchar (255) NOT NULL,
 cdGrupo varchar (255) NOT NULL
);

ALTER TABLE sgpUsuarioGrupo ADD CONSTRAINT  XPKsgpUsuarioGrupo  PRIMARY KEY 
(
  cdUsuario,
  cdGrupo
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