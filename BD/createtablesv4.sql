CREATE TABLE "admin" ( 
	id                   serial  NOT NULL ,
	usuario              varchar(20)  NOT NULL ,
	"password"           varchar(500)  NOT NULL ,
	CONSTRAINT pk_admin_id PRIMARY KEY ( id )
 );

CREATE TABLE cliente ( 
	id                   serial  NOT NULL ,
	nombre               varchar(20)  NOT NULL ,
	apellido             varchar(20)  NOT NULL ,
	email                varchar(50)  NOT NULL ,
	saldo                integer DEFAULT 0 NOT NULL ,
	CONSTRAINT pk_cliente_id PRIMARY KEY ( id ),
	CONSTRAINT idx_scooter_unq_email UNIQUE ( email ) 
 );

CREATE TABLE notificacion ( 
	id                   serial  NOT NULL ,
	cabezal              varchar(20)  NOT NULL ,
	cuerpo               varchar(500)  NOT NULL ,
	estado               varchar(15) DEFAULT 'Pendiente' NOT NULL ,
	masiva               bool DEFAULT true NOT NULL ,
	CONSTRAINT pk_notificacion_id PRIMARY KEY ( id )
 );

CREATE TABLE notificacioncliente ( 
	id                   serial  NOT NULL ,
	idnotificacion       serial  NOT NULL ,
	idcliente            serial  NOT NULL ,
	leido                bool DEFAULT false NOT NULL ,
	CONSTRAINT pk_notificacioncliente_id PRIMARY KEY ( id )
 );

CREATE TABLE parametro ( 
	id                   serial  NOT NULL ,
	nombre               varchar(20)  NOT NULL ,
	valor                varchar(500)  NOT NULL ,
	CONSTRAINT pk_parametro_id PRIMARY KEY ( id )
 );

CREATE TABLE scooter ( 
	id                   serial  NOT NULL ,
	numeroserial         varchar(20)  NOT NULL ,
	encendido            bool DEFAULT true NOT NULL ,
	enuso                bool DEFAULT false NOT NULL ,
	eliminado            bool DEFAULT false NOT NULL ,
	CONSTRAINT pk_scooter_id PRIMARY KEY ( id ),
	CONSTRAINT idx_scooter_unq_numeroserial UNIQUE ( numeroserial ) 
 );

CREATE TABLE scooterhistorico ( 
	id                   serial  NOT NULL ,
	idscooter            serial  NOT NULL ,
	fecha                timestamp DEFAULT current_timestamp NOT NULL ,
	latitud              varchar(50)  NOT NULL ,
	longitud             varchar(50)  NOT NULL ,
	bateria              integer  NOT NULL ,
	CONSTRAINT pk_scooterhistorico_id PRIMARY KEY ( id )
 );

CREATE TABLE viaje ( 
	id                   serial  NOT NULL ,
	fechainicio          timestamp DEFAULT current_timestamp NOT NULL ,
	idscooter            serial  NOT NULL ,
	idcliente            serial  NOT NULL ,
	fechafin             timestamp   ,
	estado               varchar(15) DEFAULT 'Iniciado' NOT NULL ,
	minutospermitidossaldo integer  NOT NULL ,
	CONSTRAINT pk_viaje_id PRIMARY KEY ( id )
 );

CREATE TABLE factura ( 
	id                   serial  NOT NULL ,
	idviaje              serial  NOT NULL ,
	fecha                timestamp DEFAULT current_timestamp NOT NULL ,
	monto                float8  NOT NULL ,
	estado               varchar(15) DEFAULT 'Generado' NOT NULL ,
	CONSTRAINT pk_factura_id PRIMARY KEY ( id ),
	CONSTRAINT idx_factura_idviaje UNIQUE ( idviaje ) 
 );

CREATE TABLE monederohistorico ( 
	id                   serial  NOT NULL ,
	idcliente            serial  NOT NULL ,
	fecha                timestamp DEFAULT current_timestamp NOT NULL ,
	saldoanterior        integer  NOT NULL ,
	motivo               char(10)  NOT NULL ,
	monto                integer  NOT NULL ,
	idtransaccion        varchar(200)   ,
	CONSTRAINT pk_monederohistorico_id PRIMARY KEY ( id )
 );
 
 
ALTER TABLE factura ADD CONSTRAINT fk_factura_viaje FOREIGN KEY ( idviaje ) REFERENCES viaje( id );

ALTER TABLE notificacioncliente ADD CONSTRAINT fk_notificacioncliente_notificacion FOREIGN KEY ( idnotificacion ) REFERENCES notificacion( id );

ALTER TABLE notificacioncliente ADD CONSTRAINT fk_notificacioncliente_cliente FOREIGN KEY ( idcliente ) REFERENCES cliente( id );

ALTER TABLE scooterhistorico ADD CONSTRAINT fk_scooterhistorico_scooter FOREIGN KEY ( idscooter ) REFERENCES scooter( id );

ALTER TABLE viaje ADD CONSTRAINT fk_viaje_scooter FOREIGN KEY ( idscooter ) REFERENCES scooter( id );

ALTER TABLE viaje ADD CONSTRAINT fk_viaje_cliente FOREIGN KEY ( idcliente ) REFERENCES cliente( id );

ALTER TABLE monederohistorico ADD CONSTRAINT fk_monederohistorico_cliente FOREIGN KEY ( idcliente ) REFERENCES cliente( id );
