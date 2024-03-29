-- --->>> LUCÍA GONZÁLEZ ROSAS <<<---
-- --->>> 1º. DE DAW (BASES DE DATOS; TEMA 5) <<<---
-- --->>> EJERCICIOS CORREGIDOS EL 29 DE MARZO DEL 2024 <<<---

-- ===========================================================

-- 1º.) Inserta un nuevo fabricante indicando su código y su nombre =
INSERT INTO fabricante (id, nombre) VALUES (10, 'Acer');

-- 2º.) Inserta un nuevo fabricante indicando solamente su nombre =
INSERT INTO fabricante (nombre) VALUES ('Apple');

-- 3º.) Inserta un nuevo producto asociado a uno de los nuevos fabricantes. La sentencia de inserción debe incluir: código, nombre, precio y código_fabricante =
INSERT INTO producto (id, nombre, precio, id_fabricante) VALUES (12, 'iPhone 13', 799.99, 11);

-- 4º.) Inserta un nuevo producto asociado a uno de los nuevos fabricantes. La sentencia de inserción debe incluir: nombre, precio y código_fabricante =
INSERT INTO producto (nombre, precio, id_fabricante) VALUES ('Portátil Nitro 5', 699.99, 10);

-- 5º.) Crea una nueva tabla con el nombre fabricante_productos que tenga las siguientes columnas: nombre_fabricante, nombre_producto y precio. Una vez creada la tabla inserta todos los registros de la base de datos tienda en esta tabla haciendo uso de única operación de inserción =
CREATE TABLE fabricante_productos (
nombre_fabricante VARCHAR(100),
nombre_producto VARCHAR(100),
precio DOUBLE
);

INSERT INTO fabricante_productos (nombre_fabricante, nombre_producto, precio)
SELECT f.nombre, p.nombre, p.precio FROM fabricante f JOIN producto p ON f.id = p.id_fabricante;

-- 6º.) Crea una vista con el nombre vista_fabricante_productosque tenga las siguientes columnas: nombre_fabricante, nombre_producto y precio =
CREATE VIEW vista_fabricante_productos AS
SELECT f.nombre AS nombre_fabricante, p.nombre AS nombre_producto, p.precio
FROM fabricante f JOIN producto p ON f.id = p.id_fabricante;

-- 7º.) Elimina el fabricante Asus. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?
DELETE FROM fabricante WHERE id = 1;

-- Eliminar el fabricante Asus no es posible debido a la existencia de productos asociados a este fabricante.
-- Para eliminarlo, primero deberían eliminarse los productos asociados a Asus o reasignar esos productos a otro fabricante.

-- 8º.) Elimina el fabricante Xiaomi. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?
DELETE FROM fabricante WHERE nombre = 'Xiaomi';

-- Eliminar el fabricante Xiaomi no es posible debido a la existencia de productos asociados a este fabricante.
-- Para eliminarlo, primero deberían eliminarse los productos asociados a Xiaomi o reasignar esos productos a otro fabricante.

-- 9º.) Actualiza el código del fabricante Lenovo y asígnale el valor 20. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
UPDATE fabricante SET id = 20 WHERE nombre = 'Lenovo';

-- No es recomendable actualizar claves primarias en una tabla ya que esto puede generar inconsistencias en otras tablas que hacen
-- referencia a esa clave primaria. En lugar de actualizar el código del fabricante, se puede considerar agregar una nueva entrada
-- con el código 20 y luego actualizar los productos relacionados si es necesario.

-- 10º.) Actualiza el código del fabricante Huawei y asígnale el valor 30. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
UPDATE fabricante SET id = 30 WHERE nombre = 'Huawei';

-- De nuevo, actualizar claves primarias no es recomendable. Sería mejor agregar una nueva entrada con el código 30 y luego actualizar
-- los productos relacionados si es necesario.

-- 11º.) Actualiza el precio de todos los productos sumándole 5 € al precio actual =
UPDATE producto SET precio = precio + 5;

-- 12º.) Elimina todas las impresoras que tienen un precio menor de 200 € =
DELETE FROM producto WHERE nombre LIKE '%Impresora%' AND precio < 200;