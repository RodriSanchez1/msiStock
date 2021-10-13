create database easyStock

use easyStock
 
 create table rol (
 idRol int identity(1,1),
 nombre varchar(50)
 constraint pkRol primary key (idRol) 
 )
 create table usuario (
 legajo int identity (1,1), 
 nombre varchar(60),
 contrasenia varchar(40),
 idRol int
 constraint pkusuario primary key (legajo)
  constraint fkusuario foreign key (idRol) references rol (idRol)
 )

create table lugarAlmacenamiento(
codAlmacenamiento int identity(1,1),
nombre varchar (50),
constraint pk_lugarAlmacenamiento primary key (codAlmacenamiento)
)

create table sector(
idSector int identity (1,1),
nombre varchar (40), 
lugarAlmacenamiento int ,
constraint pkSector primary key (idSector),
constraint fkAlmacenamiento foreign key (lugarAlmacenamiento) references  lugarAlmacenamiento (codAlmacenamiento)
)

create table Estanteria(
idEstanteria int identity (1,1),
descripcion varchar (40), 
idSector int ,
constraint pkEstanteria primary key (idEstanteria),
constraint fkSector foreign key (idSector) references  sector (idSector)
)


create table ubicacion(
idUbicacion int identity (1,1),
idEstanteria int ,
constraint pkUbicacion primary key (idUbicacion),
constraint fkEstanteria foreign key (idEstanteria) references  estanteria (idEstanteria)
)
 
 create table formatoVenta(
codFormato int identity (1,1),
descripcion varchar (50) ,
constraint pkFormato primary key (codFormato),
)

 create table rubro(
idRubro int identity (1,1),
descripcion varchar (50) ,
constraint pkRubro primary key (idRubro)
)
 create table marca(
idMarca int identity (1,1),
nombre varchar (60) ,
constraint pkMarca primary key (idMarca)
)

create table producto(
codProducto int identity (1,1),
nombre varchar (70),
idMarca int,
idRubro int,
volumen varchar (10),
idFormato int, 
stockMinimo int
constraint pkProd primary key (codProducto),
constraint fkmarca foreign key (idMarca) references  marca (idMarca),
constraint fkrubro foreign key (idRubro) references  rubro (idRubro),
constraint fkformato foreign key (idFormato) references  formatoVenta (codFormato)
)


create table formaVenta (
idFormaVenta int identity (1,1),
descripcion varchar(50),
constraint pkFormaVenta primary key (idFormaVenta)
)

create table tipoMovimiento (
idTipoMovimiento int identity (1,1),
nombre varchar(50),
constraint pkmovimiento primary key (idTipoMovimiento)
)

create table stock(
idStock int identity (1,1),
codProducto int,
cantidad int,
idUbicacion int,
idFormaVenta int
constraint pkstock primary key (idStock),
constraint fkformaVenta foreign key (idFormaVenta) references formaVenta (idFormaVenta),
constraint fkubicacion foreign key (idUbicacion) references ubicacion (idUbicacion),
constraint fkproducto foreign key (codProducto) references producto (codProducto)
)

create table remito (
nroRemito int identity (1,1),
fecha date,
idTipoMovimiento int,
legajo int
constraint pkremito primary key (nroRemito),
constraint fkusuar foreign key (legajo) references usuario (legajo),
constraint fktipomov foreign key (idTipoMovimiento) references tipoMovimiento (idTipoMovimiento)
)

create table detalle_remito (
id_detalle int identity (1,1),
nroRemito int,
idStock int, 
cantidad int,

constraint pkdetalle primary key (id_detalle),
constraint fkremito foreign key (nroRemito) references remito (nroRemito),
constraint fkstock foreign key (idStock) references stock (idStock)

)

insert into lugarAlmacenamiento (nombre) values('Depósito 1'), ('Depósito 2'),  ('Sucursal 1'),  ('Sucursal 2')

insert into sector (nombre, lugarAlmacenamiento) values ('A', 1), ('B', 1), ('C', 1) ,('A', 2), ('B', 2), ('C', 2), 
('A', 3), ('B', 3), ('C', 3), ('A', 4), ('B', 4), ('C', 4)

insert into Estanteria (descripcion, idSector) values ('A', 1), ('B', 1), ('C', 1), ('D', 1),
('A', 2), ('B', 2), ('C', 2), ('D', 2),('A', 3), ('B', 3), ('C', 3), ('D', 3),
('A', 4), ('B', 4), ('C', 4), ('D', 4),('A', 5), ('B', 5), ('C', 5), ('D', 5),
('A', 6), ('B', 6), ('C', 6), ('D', 6),
('A', 7), ('B', 7), ('C', 7), ('D', 7),
('A', 8), ('B', 8), ('C', 8), ('D', 8),
('A', 9), ('B', 9), ('C', 9), ('D', 9),
('A', 10), ('B', 10), ('C', 10), ('D', 10),
('A', 11), ('B', 11), ('C', 11), ('D', 11),
('A', 12), ('B', 12), ('C', 12), ('D', 12)




insert into formaVenta(descripcion) values ('online'), ('presencial')

insert into marca(nombre) values ('black and decker'), ('Bosch'), ('garín'), ('redLine'), ('Hilti'), ('DeWalt'), ('Dremel')

insert into rubro(descripcion) values ('pinturería'), ('herramientas'),('plomería'), ('electricidad') , ('construcción')

insert into formatoVenta(descripcion) values ('lote'), ('unidad'), ('pack'), ('caja completa')

insert into tipoMovimiento (nombre) values ('entrada'), ('salida')
insert into rol (nombre) values ('administrador'), ('vendedor online'), ('vendedor') ,('repositor'),
('encargado de compras'), ('encargado de almacenamiento'), ('encargado de depósito')

insert into usuario (nombre, contrasenia, idRol)values ('admin@easy.com', 'admin1',1) 

insert into producto(nombre,idFormato,idMarca, idRubro, volumen,stockMinimo)
values ('Motosierra Electrica Electrosierra 1850W', 2, 1, 2,' 2.6kg', 7)
, ('Taladro 2000W', 2, 1, 2, '1.2kg', 10)

insert into producto(nombre,idFormato,idMarca, idRubro, volumen,stockMinimo)
values ('pintura blanca', 2, 3, 1, '10Lts', 10)



