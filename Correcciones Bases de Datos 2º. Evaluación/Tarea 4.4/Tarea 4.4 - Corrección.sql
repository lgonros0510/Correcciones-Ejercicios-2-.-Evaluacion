-- --->>> LUCÍA GONZÁLEZ ROSAS <<<---
-- --->>> 1º. DE DAW (BASES DE DATOS; TEMA 4) <<<---
-- --->>> EJERCICIOS CORREGIDOS EL 29 DE MARZO DEL 2024 <<<---

-- ===========================================================

/*
Consultas multitabla (Composición interna)
Las consultas se deben resolver con INNER JOIN y NATURAL JOIN.
*/

-- 1º.) Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas =
SELECT c.nombre_cliente, e.nombre, e.apellido1 FROM cliente INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado;

-- 2º.) Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas =
SELECT c.nombre_cliente, e.nombre, e.apellido1 FROM cliente c
INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente WHERE p.codigo_cliente IS NULL;

-- 3º.) Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante =
SELECT c.nombre_cliente, e.nombre, e.apellido1, o.ciudad
FROM cliente c INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
INNER JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente WHERE p.codigo_cliente IS NULL;

-- 4º.) Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante =
SELECT c.nombre_cliente, e.nombre, e.apellido1, o.ciudad FROM cliente c
INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
INNER JOIN oficina o ON e.codigo_oficina = o.codigo_oficina;

-- 5º.) Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe =
SELECT e1.nombre AS empleado, e2.nombre AS jefe, e3.nombre AS jefe_del_jefe
FROM empleado e1 LEFT JOIN empleado e2 ON e1.codigo_jefe = e2.codigo_empleado
LEFT JOIN empleado e3 ON e2.codigo_jefe = e3.codigo_empleado;

-- 6º.) Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente =
SELECT DISTINCT c.nombre_cliente, gp.gama FROM cliente c
INNER JOIN pedido p ON c.codigo_cliente = p.codigo_cliente
INNER JOIN detalle_pedido dp ON p.codigo_pedido = dp.codigo_pedido
INNER JOIN producto pr ON dp.codigo_producto = pr.codigo_producto
INNER JOIN gama_producto gp ON pr.gama = gp.gama;

/*
Consultas multitabla (Composición externa)
Resuelva todas las consultas utilizando las cláusulas LEFT JOIN, RIGHT JOIN, NATURAL LEFT JOIN y NATURAL RIGHT JOIN.
*/

-- 7º.) Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago =
SELECT c.nombre_cliente, e.nombre, e.apellido1 FROM cliente c
INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente WHERE p.codigo_cliente IS NULL;

-- 8º.) Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido =
SELECT c.nombre_cliente, e.nombre, e.apellido1 FROM cliente c
INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
LEFT JOIN pedido pd ON c.codigo_cliente = pd.codigo_cliente
WHERE p.codigo_cliente IS NULL AND pd.codigo_pedido IS NULL;

-- 9º.) Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado =
SELECT e.nombre, e.apellido1 FROM empleado e
LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
WHERE c.codigo_empleado_rep_ventas IS NULL;

-- 10º.) Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado =
SELECT e.nombre, e.apellido1 FROM empleado e
LEFT JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
WHERE o.codigo_oficina IS NULL OR c.codigo_empleado_rep_ventas IS NULL;

-- 11º.) Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto =
SELECT pr.nombre, pr.descripcion, pr.imagen FROM producto pr
LEFT JOIN detalle_pedido dp ON pr.codigo_producto = dp.codigo_producto
WHERE dp.codigo_pedido IS NULL;

-- 12º.) Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago =
SELECT c.nombre_cliente, e.nombre, e.apellido1 FROM cliente c
INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
LEFT JOIN pedido p ON c.codigo_cliente = p.codigo_cliente
LEFT JOIN pago pg ON c.codigo_cliente = pg.codigo_cliente
WHERE p.codigo_cliente IS NOT NULL AND pg.codigo_cliente IS NULL;

/*
 Consultas resumen
*/

-- 13º.) ¿Cuántos empleados hay en la compañía?
SELECT COUNT(*) AS total_empleados FROM empleado;

-- 14º.) ¿Cuántos clientes tiene cada país?
SELECT pais, COUNT(*) AS total_clientes FROM cliente GROUP BY pais;

-- 15º.) ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos =
SELECT estado, COUNT(*) AS total_pedidos FROM pedido GROUP BY estado ORDER BY total_pedidos DESC;

-- 16º.) ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
SELECT COUNT(*) AS total_clientes_madrid FROM cliente WHERE ciudad = 'Madrid';

-- 17º.) Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno =
SELECT e.nombre, e.apellido1, COUNT(c.codigo_cliente) AS num_clientes FROM empleado e
LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas GROUP BY e.codigo_empleado;

-- 18º.) Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente =
SELECT c.nombre_cliente, c.nombre_contacto, c.apellido_contacto, MIN(fecha_pago) AS primer_pago, MAX(fecha_pago) AS ultimo_pago
FROM cliente c LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente GROUP BY c.codigo_cliente;

-- 19º.) Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos =
SELECT codigo_pedido, SUM(cantidad) AS cantidad_total_productos FROM detalle_pedido GROUP BY codigo_pedido;

-- 20º.) La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total facturado. La base imponible se calcula sumando el coste del producto por el número de unidades vendidas de la tabla detalle_pedido. El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores =
SELECT SUM(d.precio_unidad * d.cantidad) AS base_imponible, SUM(d.precio_unidad * d.cantidad) * 0.21 AS iva,
SUM(d.precio_unidad * d.cantidad) + SUM(d.precio_unidad * d.cantidad) * 0.21 AS total_facturado FROM detalle_pedido d;