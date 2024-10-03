CREATE SEQUENCE RESTAURANTE_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE TAG_SEQ START WITH 1 INCREMENT BY 1;


INSERT INTO RESTAURANTE (ID, NOMBRE, CALLE, CIUDAD, LATITUD, LONGITUD, DESCRIPCION, FOTO_URL) VALUES (NEXTVAL('RESTAURANTE_SEQ'),'Casa Manolo','Calle San Jorge','Sevilla', 20.2, 22.4, 'El mejor bar de Triana aunque ya no existe', 'https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG');
INSERT INTO RESTAURANTE (ID, NOMBRE, CALLE, CIUDAD, LATITUD, LONGITUD, DESCRIPCION, FOTO_URL) VALUES (NEXTVAL('RESTAURANTE_SEQ'),'Las Golondrinas','Pagés del corro','Sevilla', 20.2, 22.4, 'Bar ubicado en el centro de Triana, junto a la iglesia de la Estrella', 'https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG');
INSERT INTO RESTAURANTE (ID, NOMBRE, CALLE, CIUDAD, LATITUD, LONGITUD, DESCRIPCION, FOTO_URL) VALUES (NEXTVAL('RESTAURANTE_SEQ'),'Bar La Estrellita','Calle San Jacinto','Sevilla', 20.2, 22.4, 'Es el bar donde me tomo el café todos los dias con el Ale y el Carlos', 'https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG');
INSERT INTO RESTAURANTE (ID, NOMBRE, CALLE, CIUDAD, LATITUD, LONGITUD, DESCRIPCION, FOTO_URL) VALUES (NEXTVAL('RESTAURANTE_SEQ'),'Casa Ruperto','Santa Cecilia','Sevilla', 20.2, 22.4, 'Todo el mundo ha comido pajaritos fritos ahí, menos yo', 'https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG');

INSERT INTO TAG (ID, NOMBRE) VALUES (NEXTVAL('TAG_SEQ'),'Cocina local');
INSERT INTO TAG (ID, NOMBRE) VALUES (NEXTVAL('TAG_SEQ'),'Café');
INSERT INTO TAG (ID, NOMBRE) VALUES (NEXTVAL('TAG_SEQ'),'Sin niños');
INSERT INTO TAG (ID, NOMBRE) VALUES (NEXTVAL('TAG_SEQ'),'Comida japonesa');

INSERT INTO RESTAURANTE_TAGS(RESTAURANTE_ID, TAG_ID)VALUES(1,1);
INSERT INTO RESTAURANTE_TAGS(RESTAURANTE_ID, TAG_ID)VALUES(3,1);


ALTER SEQUENCE RESTAURANTE_SEQ RESTART WITH 100 INCREMENT BY 1;
ALTER SEQUENCE TAG_SEQ RESTART WITH 100 INCREMENT BY 1;

