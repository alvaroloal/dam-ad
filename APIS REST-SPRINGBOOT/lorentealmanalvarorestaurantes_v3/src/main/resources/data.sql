


INSERT INTO tag (nombre) VALUES ('Italiano');
INSERT INTO tag (nombre) VALUES ('Chino');
INSERT INTO tag (nombre) VALUES ('Vegetariano');
INSERT INTO tag (nombre) VALUES ('Mexicano');

-- Insertar algunos datos de ejemplo en la tabla Restaurante
INSERT INTO restaurante (nombre, direccion, latitud, longitud, descripcion, foto_url) 
VALUES 
('Restaurante Italiano', 'Calle Roma 10', 40.416775, -3.703790, 'Un restaurante con los mejores platos italianos', 'http://example.com/foto1.jpg'),
('Restaurante Chino', 'Calle Beijing 20', 39.904202, 116.407394, 'Deliciosa comida china con un toque moderno', 'http://example.com/foto2.jpg'),
('Restaurante Vegetariano', 'Calle Verde 30', 37.774929, -122.419416, 'Opciones vegetarianas para todos los gustos', 'http://example.com/foto3.jpg');

-- Asociar los restaurantes con tags
INSERT INTO restaurante_tag (restaurante_id, tag_id) VALUES (1, 1);  -- Restaurante Italiano tiene el tag Italiano
INSERT INTO restaurante_tag (restaurante_id, tag_id) VALUES (2, 2);  -- Restaurante Chino tiene el tag Chino
INSERT INTO restaurante_tag (restaurante_id, tag_id) VALUES (3, 3);  -- Restaurante Vegetariano tiene el tag Vegetariano
INSERT INTO restaurante_tag (restaurante_id, tag_id) VALUES (3, 4);  -- Restaurante Vegetariano también tiene el tag Mexicano
