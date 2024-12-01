INSERT INTO alumno (cod_alumno, nombre, apellidos, direccion, telefono, email, fecha_nac) VALUES (1, 'Manolo', 'López Martín', 'C/Los Remedios, 12, Sevilla', '660869574', 'manolitox89@gmail.com', '2005-12-15');
INSERT INTO alumno (cod_alumno, nombre, apellidos, direccion, telefono, email, fecha_nac) VALUES (2, 'Guillermo', 'López Martín', 'C/Los Remedios, 12, Sevilla', '660769574', 'guille786@gmail.com', '2005-05-25');

ALTER SEQUENCE alumno_seq RESTART WITH 52;

INSERT INTO curso (id, nombre, tipo) VALUES (1, '2ºDAM', 'SUPERIOR');
INSERT INTO curso (id, nombre, tipo) VALUES (2, '2ºElectricidad', 'MEDIO');

ALTER SEQUENCE curso_seq RESTART WITH 52;

INSERT INTO asignatura (id, nombre, num_horas, contenidos, curso_id) VALUES (1, 'Acceso a Datos', 85, 'Yoksetio', 1);
INSERT INTO asignatura (id, nombre, num_horas, contenidos, curso_id) VALUES (2, 'Diseño de Interfaces', 85, 'Ira, el frontend', 1);
INSERT INTO asignatura (id, nombre, num_horas, contenidos, curso_id) VALUES (3, 'Instalaciones electricas', 85, 'Yoksepiumpium', 2);
INSERT INTO asignatura (id, nombre, num_horas, contenidos, curso_id) VALUES (4, 'Automatismo', 85, 'Puerta goes brrrr', 2);

ALTER SEQUENCE asignatura_seq RESTART WITH 54;

INSERT INTO matricula_notas (alumno_id, asignatura_id, anio, nota) VALUES (1, 1, 2024, 8.5);
INSERT INTO matricula_notas (alumno_id, asignatura_id, anio, nota) VALUES (1, 2, 2024, 10);
INSERT INTO matricula_notas (alumno_id, asignatura_id, anio, nota) VALUES (2, 3, 2024, 7.75);
INSERT INTO matricula_notas (alumno_id, asignatura_id, anio, nota) VALUES (2, 4, 2024, 9.43);
