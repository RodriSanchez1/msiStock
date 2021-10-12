create database Easy

use Easy
 
 create table usuario (
 id_usuario int identity (1,1), 
 nombre varchar(60),
 contraseña varchar(40),
 rol varchar (50)
 constraint pkusuario primary key (id_usuario)

 )

create table lugar_almacenamiento(
cod_almacenamiento int identity(1,1),
nombre varchar (50),
constraint pk_lugarAlmacenamiento primary key (cod_almacenamiento)
)

create table sector(
id_sector int identity (1,1),
nombre varchar (40), 
lugar_almacenamiento int ,
constraint pkSector primary key (id_sector),
constraint fkAlmacenamiento foreign key (lugar_almacenamiento) references  lugar_almacenamiento (cod_almacenamiento)
)

create table Estanteria(
id_estanteria int identity (1,1),
descripcion varchar (40), 
id_sector int ,
constraint pkEstanteria primary key (id_estanteria),
constraint fkSector foreign key (id_sector) references  sector (id_sector)
)


create table ubicacion(
id_ubicacion int identity (1,1),
id_estanteria int ,
constraint pkUbicacion primary key (id_ubicacion),
constraint fkEstanteria foreign key (id_estanteria) references  estanteria (id_estanteria)
)
 
 create table formato_venta(
cod_formato int identity (1,1),
descripcion varchar (50) ,
constraint pkFormato primary key (cod_formato),
)

 create table rubro(
id_rubro int identity (1,1),
descripcion varchar (50) ,
constraint pkRubro primary key (id_rubro)
)
 create table marca(
id_marca int identity (1,1),
nombre varchar (60) ,
constraint pkMarca primary key (id_marca)
)

create table producto(
cod_producto int identity (1,1),
nombre varchar (70),
id_marca int,
id_rubro int,
volumen varchar (10),
id_formato int, 
stock_minimo int
constraint pkProd primary key (cod_producto),
constraint fkmarca foreign key (id_marca) references  marca (id_marca),
constraint fkrubro foreign key (id_rubro) references  rubro (id_rubro),
constraint fkformato foreign key (id_formato) references  formato_venta (cod_formato)
)


create table forma_venta (
id_forma_venta int identity (1,1),
descripcion varchar(50),
constraint pkFormaVenta primary key (id_forma_venta)
)

create table tipo_movimiento (
id_tipo_movimiento int identity (1,1),
nombre varchar(50),
constraint pkmovimiento primary key (id_tipo_movimiento)
)

create table stock(
id_stock int identity (1,1),
cod_producto int,
cantidad int,
id_ubicacion int,
id_forma_venta int
constraint pkstock primary key (id_stock),
constraint fkforma_venta foreign key (id_forma_venta) references forma_venta (id_forma_venta),
constraint fkubicacion foreign key (id_ubicacion) references ubicacion (id_ubicacion),
constraint fkproducto foreign key (cod_producto) references producto (cod_producto)
)

create table remito (
nro_remito int identity (1,1),
fecha date,
id_tipo_movimiento int,
id_usuario int
constraint pkremito primary key (nro_remito),
constraint fkUsuario foreign key (id_usuario) references usuario (id_usuario),
constraint fktipomov foreign key (id_tipo_movimiento) references tipo_movimiento (id_tipo_movimiento)
)

create table detalle_remito (
id_detalle int identity (1,1),
nro_remito int,
id_stock int, 
cantidad int,

constraint pkdetalle primary key (id_detalle),
constraint fkremito foreign key (nro_remito) references remito (nro_remito),
constraint fkstock foreign key (id_stock) references stock (id_stock)

)

insert into lugar_almacenamiento (nombre) values('Depósito 1'), ('Depósito 2'),  ('Sucursal 1'),  ('Sucursal 2')

insert into sector (nombre, lugar_almacenamiento) values ('A', 1), ('B', 1), ('C', 1) ,('A', 2), ('B', 2), ('C', 2), 
('A', 3), ('B', 3), ('C', 3), ('A', 4), ('B', 4), ('C', 4)

insert into Estanteria (descripcion, id_sector) values ('A', 1), ('B', 1), ('C', 1), ('D', 1),
('A', 2), ('B', 2), ('C', 2), ('D', 2),('A', 3), ('B', 3), ('C', 3), ('D', 3),
('A', 4), ('B', 4), ('C', 4), ('D', 4),('A', 5), ('B', 5), ('C', 5), ('D', 5),
('A', 6), ('B', 6), ('C', 6), ('D', 6),
('A', 7), ('B', 7), ('C', 7), ('D', 7),
('A', 8), ('B', 8), ('C', 8), ('D', 8),
('A', 9), ('B', 9), ('C', 9), ('D', 9),
('A', 10), ('B', 10), ('C', 10), ('D', 10),
('A', 11), ('B', 11), ('C', 11), ('D', 11),
('A', 12), ('B', 12), ('C', 12), ('D', 12)




insert into forma_venta(descripcion) values ('online'), ('presencial')

insert into marca(nombre) values ('black and decker'), ('Bosch'), ('garín'), ('redLine'), ('Hilti'), ('DeWalt'), ('Dremel')

insert into rubro(descripcion) values ('pinturería'), ('herramientas'),('plomería'), ('electricidad') , ('construcción')

insert into formato_venta(descripcion) values ('lote'), ('unidad'), ('pack'), ('caja completa')

insert into tipo_movimiento (nombre) values ('entrada'), ('salida')

insert into usuario (nombre, contraseña, rol)values ('admin@easy.com', '5555AE!', 'administrador') 

insert into producto(nombre,id_formato,id_marca, id_rubro, volumen,stock_minimo)
values ('Motosierra Electrica Electrosierra 1850W', 2, 1, 2,' 2.6kg', 7)
, ('Taladro 2000W', 2, 1, 2, '1.2kg', 10)

insert into producto(nombre,id_formato,id_marca, id_rubro, volumen,stock_minimo)
values ('pintura blanca', 2, 3, 1, '10Lts', 10)



