CREATE TABLE sgpSetor(
	cdSetor decimal (2,0) NOT NULL,
	deSetor varchar (100) NOT NULL,	
	sgSetor varchar (15)  NULL,	
	CONSTRAINT XPKsgpSetor PRIMARY KEY (cdSetor)
);

insert into sgpSetor values(1,'Saúde',null);
