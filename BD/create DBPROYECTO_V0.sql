CONECTAR BD CONSOLA
psql -U postgres
--psql -d mydb -U myuser


CREATE DATABASE scooters;

salir > 
\q > enter


en scheme "public" >>>>>


CREATE TABLE parametro( 
	id                   serial  NOT NULL,
	nombre                 varchar(100)  NOT NULL,
	valor             varchar(100)  NOT NULL,
	CONSTRAINT pk_parameter_id PRIMARY KEY ( id )
 );
 
 CREATE TABLE scooter( 
	id                   serial  NOT NULL,
	latitud                 varchar(30),
	longitud             	varchar(30),
	bateria             	integer,	
	encendido              bool DEFAULT false NOT NULL,
	CONSTRAINT pk_scooter_id PRIMARY KEY ( id )
 );
 
 CREATE TABLE cliente( 
	id                   serial  NOT NULL,
	email                 varchar(30) NOT NULL,
	CONSTRAINT pk_cliente_id PRIMARY KEY ( id )
 );
 
 
 CREATE TABLE notificacion( 
	id                   serial  NOT NULL,
	cabezal                 varchar(100),
	cuerpo             		varchar(500),
	status                 varchar(100),
	leido              		bool DEFAULT false NOT NULL,
	idcliente				serial  NOT NULL,
	CONSTRAINT pk_notificacion_id PRIMARY KEY ( id )
 );
 
ALTER TABLE notificacion ADD CONSTRAINT fk_notificacion_cliente FOREIGN KEY ( idcliente ) REFERENCES cliente( id );

 CREATE TABLE registro( 
	id                   serial  NOT NULL,
	fecha              timestamp DEFAULT current_timestamp ,
	idscooter				serial  NOT NULL,
	idcliente				serial  NOT NULL,
	CONSTRAINT pk_registro_id PRIMARY KEY ( id )
 );
 
ALTER TABLE registro ADD CONSTRAINT fk_registro_cliente FOREIGN KEY ( idcliente ) REFERENCES cliente( id );

ALTER TABLE registro ADD CONSTRAINT fk_registro_scooter FOREIGN KEY ( idscooter ) REFERENCES scooter( id );
 
 
 CREATE TABLE scooterhistorico( 
	idscooter                   serial  NOT NULL,
	fecha              			timestamp DEFAULT current_timestamp ,
	latitud                 varchar(30),
	longitud             	varchar(30),
	bateria             	integer,	
	CONSTRAINT pk_scooterhistorico_id PRIMARY KEY ( idscooter, fecha )
 );
 
ALTER TABLE registro ADD CONSTRAINT fk_scooterhistorico_scooter FOREIGN KEY ( idscooter ) REFERENCES scooter( id );

CREATE TABLE movimientos( 
	id                   serial  NOT NULL,
	idviaje               integer,
	monto               integer,
	fecha              			timestamp DEFAULT current_timestamp ,	
	CONSTRAINT pk_movimientos_id PRIMARY KEY ( id )
);
 
