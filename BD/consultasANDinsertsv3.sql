SELECT * FROM  "admin";
--insert into "admin"(usuario,password) values('admin','admin')

SELECT * FROM  cliente;
--insert into cliente(nombre,apellido,email,saldo) values('martin','olivera','martin@urudin.uy',2000),('agustin','ape','agustin@urudin.uy',2000),('sofia','ape','sofia@urudin.uy',2000),('facundo','ape','facundo@urudin.uy',2000);

SELECT * FROM  monederohistorico;
--insert into monederohistorico(idcliente,saldoanterior,motivo,monto,idtransaccion) values(1,0,'Paypal',2000,'PaypaltransacctionId');

SELECT * FROM  notificacion;--5
--insert into notificacion( cabezal,cuerpo,estado ,masiva) values('cuerpo mensaje','este es un mensaje de la app','Enviado',true);

SELECT count(*) FROM  notificacioncliente;
SELECT * FROM  notificacioncliente;
--insert into notificacioncliente(idnotificacion ,idcliente ,leido) values(1,1,true),(1,2,true),(1,3,true),(1,4,false);

SELECT count(*) FROM  Notificacioncliente where idcliente = 1 and leido = false ;


SELECT * FROM  parametro;
--insert into parametro(nombre ,valor) values('ONESIGNALRESTAPIKEY','ZDA5ZWRlYmQtZThjNC00ZjJjLTk1N2MtZjI2OWQzNjUxMzU2'),('ONESIGNALAPPID','71fe70d6-b9a4-49fd-a4ca-38491795a8b9');
--insert into parametro(nombre ,valor) values('TARIFABASE','20'),('PRECIOXMINUTO','4'),('UPDSCOOTER','5'),('BATERIABAJA','5'),('BATMULTI','0.1'),('BATMINUTOS','6'),('MINIMOPAYPAL','300'),('MINIMOVIAJE','100'),('RANGOCERCA','1000');
--insert into parametro(nombre ,valor) values('URLBUSES','http://www.montevideo.gub.uy/buses/rest/stm-online'),('BODYBUSES','{ \"empresa\":\"50\", \"lineas\": [\"149\"] }')

/*
	TARIFABASE	20
	PRECIOXMINUTO	4
	UPDSCOOTER		5
	BATERIABAJA		5
BATMULTI  0.1 (valor parametrizable con la relación batería en kilómetros)
BATMINUTOS 6 (valor parametrizable con la relación 1% batería y uso en minutos)
MINIMOPAYPAL (minimo dinero que puede acreditar el usuario atravez de paypal)
MINIMOVIAJE (saldo minimo necesario para realizar un viaje??)*/

SELECT * FROM  scooter;
--insert into scooter(numeroserial,encendido,enuso,eliminado) values('1',true,false,false),('2',true,false,false),('3',true,false,false);

SELECT * FROM  scooterhistorico where idscooter = 1 order by 2 desc, 3 DESC;

SELECT * FROM  scooterhistorico where idscooter = 56 order by 2 desc, 3 DESC;
--insert into scooterhistorico(idscooter,latitud,longitud,bateria) values(1,'-34.9178703','-56.1663739',100),(2,'-34.9181758','-56.1665929',100),(3,'-34.9181750','-56.1665920',100);
--insert into scooterhistorico(idscooter,latitud,longitud,bateria) values(1,'-34.9178702','-56.1663734',99),(2,'-34.9181754','-56.1665932',98),(3,'-34.9181748','-56.1665918',97);

--1
---34.9178703,-56.1663739
---34.9178702,-56.1663734
--
--2
---34.9181758,-56.1665929
---34.9181754,-56.1665932
--
--3
---34.9181750,-56.1665920
---34.9181748,-56.1665918

SELECT * FROM  viaje;
--insert into viaje(fechainicio,idscooter,idcliente,fechafin,estado,minutospermitidossaldo) values('2019-05-13 22:20:24',1,1,'2019-05-13 22:30:24','Finalizado',20),('2019-05-13 22:10:24',2,2,'2019-05-13 22:20:24','Finalizado',19),('2019-05-13 22:00:24',3,3,'2019-05-13 22:10:24','Finalizado',18),('2019-05-13 22:50:24',1,4,'2019-05-13 22:55:24','Finalizado',10)

SELECT * FROM factura;
--insert into factura(idviaje,fecha,monto,estado) values(1,'2019-05-13 22:30:24',100,'Pagado'),(2,'2019-05-13 22:10:24',99,'Pagado'),(3,'2019-05-13 22:00:24',98,'Pagado'),(4,'2019-05-13 22:55:24',50,'Pagado')

