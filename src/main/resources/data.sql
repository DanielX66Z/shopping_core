create table clientes (id_cliente integer not null AUTO_INCREMENT, direccion varchar(150), nombre varchar(150), primary key (id_cliente));
create table ordenes (id_ordenes integer not null AUTO_INCREMENT, cantidad integer, total double, clientes_id_cliente integer,
 productos_id_producto integer, primary key (id_ordenes));
create table productos (id_producto integer not null AUTO_INCREMENT, descripcion varchar(255), existencia integer, nombre varchar(255),
 precio double, primary key (id_producto));
alter table ordenes add constraint FK_CLIENTE foreign key (clientes_id_cliente) references clientes;
alter table ordenes add constraint FK_PRODUCTOS foreign key (productos_id_producto) references productos;

INSERT INTO clientes VALUES(1,'juan perez','mejicanos san salvador');
INSERT INTO clientes VALUES(2,'Sara sutano','soyapango san salvador');
INSERT INTO clientes VALUES(3,'Zelda Adams','Santa Tecla La libertad');
INSERT INTO productos VALUES(1,'consola portatil',30,'nintendo swich',350.00);
INSERT INTO productos VALUES(2,'rtx 3060',10,'nvdia rtx',450.00);
INSERT INTO productos VALUES(3,'memoria ddrr5',10,'ram ddrr5 16gb',90.00);
INSERT INTO ordenes VALUES(1,2,700.00,1,1);
INSERT INTO ordenes VALUES(2,1,450.00,3,2);
INSERT INTO ordenes VALUES(3,1,350.00,1,2);
