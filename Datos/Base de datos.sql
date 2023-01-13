create database banca_ciclo3;
use banca_ciclo3;
create table cliente(
id_cliente varchar(15) not null,
nombre_cliente varchar(80) not null,
clave_cliente varchar(50) not null,
constraint cliente_pk primary key(id_cliente));
create table cuenta(
id_cuenta varchar(15) not null,
fecha_apertura date not null,
saldo_cuenta double not null,
id_cliente varchar(15) not null,
constraint cuenta_pk primary key(id_cuenta),
constraint cuenta_id_cliente_fk foreign key(id_cliente) references cliente(id_cliente));
create table transaccion(
id_transaccion int auto_increment not null,
fecha_transaccion date not null,
valor_transaccion double not null,
tipo_transaccion varchar(01) not null,
id_cuenta varchar(15) not null,
constraint transaccion_pk primary key(id_transaccion),
constraint transaccion_id_cuenta_fk foreign key(id_cuenta) references cuenta(id_cuenta),
constraint transaccion_tipo_transaccion_ck check(tipo_transaccion='D' or tipo_transaccion='R'));
create table administrador(
id_administrador varchar(15) not null,
nombre_administrador varchar(80) not null,
clave_administrador varchar(50) not null,
constraint administrador_pk primary key(id_administrador));
insert into cliente(id_cliente,nombre_cliente,clave_cliente) values('1','Sergio Medina','123456');
insert into cliente(id_cliente,nombre_cliente,clave_cliente) values('2','Luisa Lane','654321');
insert into cuenta(id_cuenta,fecha_apertura,saldo_cuenta,id_cliente) values('01-01','2021-06-10',100000,'1');
insert into cuenta(id_cuenta,fecha_apertura,saldo_cuenta,id_cliente) values('02-02','2022-05-15',500000,'1');
insert into cuenta(id_cuenta,fecha_apertura,saldo_cuenta,id_cliente) values('03-03','2022-01-25',750000,'2');
insert into transaccion(fecha_transaccion,valor_transaccion,tipo_transaccion,id_cuenta) values('2022-02-20',100000,'D','01-01');
insert into administrador(id_administrador,nombre_administrador,clave_administrador) values('1','Administrador General','123456');