-- --->>> LUCÍA GONZÁLEZ ROSAS <<<---
-- --->>> 1º. DE DAW (BASES DE DATOS; TEMA 4) <<<---
-- --->>> EXAMEN CORREGIDO EL 29 DE MARZO DEL 2024 <<<---

-- ===========================================================

-- CONSULTAS DE UNA TABLA (5 puntos)

-- 1º.) Devuelve un listado con todos los pedidos que se han realizado. Los pedidos deben estar ordenados por la fecha de realización, mostrando en primer lugar los pedidos más recientes =
SELECT * FROM pedido ORDER BY fecha DESC;

-- 2º.) Devuelve todos los datos de los dos pedidos de mayor valor =
SELECT * FROM pedido ORDER BY total DESC LIMIT 2;

-- 3º.) Devuelve un listado con los identificadores de los clientes que han realizado algún pedido. Tenga en cuenta que no debe mostrar identificadores que estén repetidos =
SELECT DISTINCT id_cliente FROM pedido;

-- 4º.) Devuelve un listado de todos los pedidos que se realizaron durante el año 2017, cuya cantidad total sea superior a 500€ =
SELECT * FROM pedido WHERE YEAR(fecha) = 2017 AND total > 500;

-- 5º.) Devuelve un listado con el nombre y los apellidos de los comerciales que tienen una comisión entre 0.05 y 0.11 =
SELECT nombre, apellido1, apellido2 FROM comercial WHERE comisión BETWEEN 0.05 AND 0.11;

-- 6º.) Devuelve el identificador, nombre y primer apellido de aquellos clientes cuyo segundo apellido no es NULL. El listado deberá estar ordenado alfabéticamente por apellidos y nombre =
SELECT id, nombre, apellido1 FROM cliente WHERE apellido2 IS NOT NULL ORDER BY apellido1, nombre;

-- 7º.) Devuelve un listado de los nombres de los clientes que no empiezan por "A". El listado deberá estar ordenado alfabéticamente =
SELECT nombre FROM cliente WHERE nombre NOT LIKE 'A%' ORDER BY nombre;

-- 8º.= Devuelve un listado con los nombres de los comerciales que terminan por "el" o "o". Tenga en cuenta que se deberán eliminar los nombres repetidos =
SELECT DISTINCT nombre FROM comercial
WHERE apellido1 LIKE '%el' OR apellido1 LIKE '%o' OR apellido2 LIKE '%el' OR apellido2 LIKE '%o';

-- CONSULTAS MULTITABLA (COMPOSICIÓN INTERNA) (1 punto)

-- 9º.) Devuelve un listado con el identificador, nombre y los apellidos de todos los clientes que han realizado algún pedido. El listado debe estar ordenado alfabéticamente y se deben eliminar los elementos repetidos =
SELECT DISTINCT c.id, c.nombre, c.apellido1, c.apellido2 FROM cliente c
INNER JOIN pedido p ON c.id = p.id_cliente ORDER BY c.apellido1, c.apellido2, c.nombre;

-- 10º.) Devuelve el nombre de todos los clientes que han realizado algún pedido con el comercial Daniel Sáez Vega =
SELECT DISTINCT c.nombre FROM cliente c
INNER JOIN pedido p ON c.id = p.id_cliente INNER JOIN comercial cm ON p.id_comercial = cm.id
WHERE cm.nombre = 'Daniel' AND cm.apellido1 = 'Sáez' AND cm.apellido2 = 'Vega';

-- CONSULTAS MULTITABLA (COMPOSICIÓN EXTERNA) (1 punto)

-- 11º.) Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado. Este listado también debe incluir los clientes que no han realizado ningún pedido. El listado debe estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes =
SELECT c.*, p.id AS pedido_id, p.total, p.fecha FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente ORDER BY c.apellido1, c.apellido2, c.nombre;

-- 12º.) Devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido =
SELECT cm.* FROM comercial cm LEFT JOIN pedido p ON cm.id = p.id_comercial WHERE p.id_comercial IS NULL;

-- CONSULTAS RESUMEN (1 punto)

-- 13º.) Calcula el máximo valor de los pedidos realizados para cada uno de los comerciales durante la fecha 2016-08-17. Muestra el identificador del comercial, nombre, apellidos y total =
SELECT p.id_comercial, cm.nombre, cm.apellido1, cm.apellido2, MAX(p.total) AS max_total
FROM pedido p INNER JOIN comercial cm ON p.id_comercial = cm.id WHERE p.fecha = '2016-08-17' GROUP BY p.id_comercial;

-- 14º.) Devuelve un listado con el identificador de cliente, nombre y apellidos y el número total de pedidos que ha realizado cada uno de clientes durante el año 2017 =
SELECT c.id, c.nombre, c.apellido1, c.apellido2, COUNT(p.id) AS total_pedidos FROM cliente c
LEFT JOIN pedido p ON c.id = p.id_cliente AND YEAR(p.fecha) = 2017 GROUP BY c.id;

-- SUBCONSULTAS (2 puntos)

-- 15º.) Devuelve un listado con todos los pedidos que ha realizado Adela Salas Díaz (Sin utilizar INNER JOIN) =
SELECT * FROM pedido
WHERE id_cliente = (SELECT id FROM cliente WHERE nombre = 'Adela' AND apellido1 = 'Salas' AND apellido2 = 'Díaz');

-- 16º.) Devuelve el pedido más caro que existe en la tabla pedido (Sin hacer uso de MAX, ORDER BY ni LIMIT) =
SELECT * FROM pedido p1 WHERE NOT EXISTS (SELECT 1 FROM pedido p2 WHERE p2.total > p1.total);

-- 17º.) Devuelve un listado de los clientes que no han realizado ningún pedido (Utilizando IN o NOT IN) =
SELECT c.* FROM cliente c LEFT JOIN pedido p ON c.id = p.id_cliente WHERE p.id IS NULL;

-- 18º.) Devuelve un listado de los clientes que no han realizado ningún pedido (Utilizando EXISTS o NOT EXISTS) =
SELECT c.* FROM cliente c LEFT JOIN pedido p ON c.id = p.id_cliente WHERE p.id_cliente IS NULL;