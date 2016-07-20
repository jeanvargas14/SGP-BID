CREATE TABLE sgpPrograma(
  cdPrograma   decimal (2,0) NOT NULL,
  nmPrograma   varchar (150) NOT NULL,
  nmProgramaIngles varchar (150) NOT NULL,
  nuPrograma varchar(15) NOT NULL,
  nuOperacao varchar(15) NOT NULL,
  dePrograma varchar(2000) NOT NULL,
  nmMutuario varchar (100) NOT NULL,
  sgMutuario varchar (15) NOT NULL,
  nuAnoInicio decimal(4,0) NOT NULL,
  nuAnoFim decimal(4,0) NOT NULL,
  CONSTRAINT XPKsgpPrograma PRIMARY KEY (cdPrograma));