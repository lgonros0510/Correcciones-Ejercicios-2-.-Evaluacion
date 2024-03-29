-- --->>> LUCÍA GONZÁLEZ ROSAS <<<---
-- --->>> 1º. DE DAW (BASES DE DATOS; TEMA 4) <<<---
-- --->>> EJERCICIOS CORREGIDOS EL 28 DE MARZO DEL 2024 <<<---

-- ===========================================================

-- 1º.) Devuelve un listado con el código de oficina y la ciudad donde hay oficinas =
SELECT codigo_oficina, ciudad FROM oficina;

-- 2º.) Devuelve un listado con la ciudad y el teléfono de las oficinas de España =
SELECT ciudad, telefono FROM oficina WHERE pais = 'España';

-- 3º.) Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7 =
SELECT nombre, apellido1, apellido2, email FROM empleado WHERE codigo_jefe = 7;

-- 4º.) Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa =
SELECT puesto, nombre, apellido1, apellido2, email FROM empleado WHERE codigo_empleado = (SELECT codigo_jefe FROM empleado WHERE codigo_jefe IS NULL);

-- 5º.) Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas =
SELECT nombre, apellido1, apellido2, puesto FROM empleado WHERE codigo_empleado_rep_ventas IS NULL;

-- 6º.) Devuelve un listado con el nombre de los todos los clientes españoles =
SELECT nombre_cliente FROM cliente WHERE pais = 'España';

-- 7º.) Devuelve un listado con los distintos estados por los que puede pasar un pedido =
SELECT DISTINCT estado FROM pedido;

-- 8º.) Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta =

-- a) Utilizando la función YEAR de MySQL =
SELECT DISTINCT codigo_cliente FROM pago WHERE YEAR(fecha_pago) = 2008;

-- b) Utilizando la función DATE_FORMAT de MySQL =
SELECT DISTINCT codigo_cliente FROM pago WHERE DATE_FORMAT(fecha_pago, '%Y') = '2008';

-- c) Sin utilizar ninguna de las funciones anteriores =
SELECT DISTINCT codigo_cliente FROM pago WHERE fecha_pago >= '2008-01-01' AND fecha_pago < '2009-01-01';

-- 9º.) Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo =
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido WHERE fecha_entrega > fecha_esperada;

-- 10º.) Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada =

-- a) Utilizando la función ADDDATE de MySQL =
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido WHERE fecha_entrega <= ADDDATE(fecha_esperada, -2);

-- b) Utilizando la función DATEDIFF de MySQL =
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega FROM pedido WHERE DATEDIFF(fecha_esperada, fecha_entrega) >= 2;

-- c) ¿Sería posible resolver esta consulta utilizando el operador de suma + o resta -?
-- No, porque no se puede restar directamente días a una fecha en MySQL sin usar funciones como DATE_SUB.

-- 11º.) Devuelve un listado de todos los pedidos que fueron rechazados en 2009 =
SELECT * FROM pedido WHERE estado = 'Rechazado' AND YEAR(fecha_pedido) = 2009;

-- 12º.) Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año =
SELECT * FROM pedido WHERE MONTH(fecha_entrega) = 1;

-- 13º.) Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. Ordene el resultado de mayor a menor =
SELECT * FROM pago WHERE YEAR(fecha_pago) = 2008 AND forma_pago = 'Paypal' ORDER BY total DESC;

-- 14º.) Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas =
SELECT DISTINCT forma_pago FROM pago;

-- 15º.) Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio =
SELECT * FROM producto WHERE gama = 'Ornamentales' AND cantidad_en_stock > 100 ORDER BY precio_venta DESC;

-- 16º.) Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 11 o 30 =
SELECT * FROM cliente WHERE ciudad = 'Madrid' AND codigo_empleado_rep_ventas IN (11, 30);