CREATE TABLE sgpProjeto(
  cdProjeto   decimal (2, 0) NOT NULL,
  nmProjeto   varchar (150) NOT NULL
) 

ALTER TABLE sgpProjeto ADD CONSTRAINT  XPKsgpProjeto  PRIMARY KEY 
(
  cdProjeto 
)
 
CREATE TABLE sgpFinalidade(
  cdProjeto   decimal (2, 0) NOT NULL,
  cdFinalidade   decimal (3, 0) NOT NULL,
  deFinalidade   varchar (70) NULL
)

ALTER TABLE sgpFinalidade ADD CONSTRAINT  XPKsgpFinalidade  PRIMARY KEY 
(
  cdProjeto ,
  cdFinalidade 
)