INSERT INTO categorias(id, nombre) VALUES(1, 'Alimentación');
INSERT INTO categorias(id, nombre) VALUES(2, 'Electrónica');
INSERT INTO categorias(id, nombre) VALUES(3, 'Smartphones');
ALTER SEQUENCE categorias_seq RESTART WITH 53;

INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (1, 'Patatas', 'Bolsa de patatas', 2.22, 1);
INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (2, 'Ordenador', 'ordenador para trabajar', 1500, 2);
INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (3, 'Iphone 14', 'descripcion Iphone', 1000, 3);
ALTER SEQUENCE productos_seq RESTART WITH 53;


INSERT INTO bibliotecas(id, direccion) VALUES(1, 'Condes de Bustillo');
ALTER SEQUENCE bibliotecas_seq RESTART WITH 53;

INSERT INTO libros(id, titulo, descripcion, biblioteca_id) VALUES(1, 'Harry Potter', 'Libro escrito por JK ROWLING', 1);
ALTER SEQUENCE libros_seq RESTART WITH 53;