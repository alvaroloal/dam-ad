INSERT INTO categorias(id, nombre) VALUES(1, 'Bebidas');
INSERT INTO categorias(id, nombre) VALUES(2, 'Tecnología');
INSERT INTO categorias(id, nombre) VALUES(3, 'Muebles');
ALTER SEQUENCE categorias_seq RESTART WITH 53;

<<<<<<< HEAD
INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (1, 'Alcaparras', 'Illo unas alcaparras qué más quieres churra????', 3.12, 1);
INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (2, 'Ordenador', 'Illo un ordenador to wapo pa jugar al counter estraik ese tío', 800, 2);
INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (3, 'Mesa', 'Illo una mesa to wapa del carajo colega', 800, 3);
ALTER SEQUENCE productos_seq RESTART WITH 53;

INSERT INTO tag(id, nombre) VALUES(nextval('tag_seq'), 'Refrigerio');
INSERT INTO tag(id, nombre) VALUES(nextval('tag_seq'), 'Cositas');
INSERT INTO tag(id, nombre) VALUES(nextval('tag_seq'), 'Ke Weno')
=======
INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (1, 'Cerveza Artesanal', 'Una cerveza artesanal premium con sabor excepcional.', 4.50, 1);
INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (2, 'Tablet', 'Una tablet moderna ideal para trabajar y entretenerse.', 250, 2);
INSERT INTO productos(id, nombre_producto, descripcion, precio, categoria_id) VALUES (3, 'Silla Ergonómica', 'Silla diseñada para la máxima comodidad en largas jornadas.', 150, 3);
ALTER SEQUENCE productos_seq RESTART WITH 53;

INSERT INTO tag(id, nombre) VALUES(nextval('tag_seq'), 'Premium');
INSERT INTO tag(id, nombre) VALUES(nextval('tag_seq'), 'Oferta');
INSERT INTO tag(id, nombre) VALUES(nextval('tag_seq'), 'Popular');
>>>>>>> f01bcd5b429a8f7d9bfd55817d27647b88d69c03
