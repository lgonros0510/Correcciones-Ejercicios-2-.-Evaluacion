-- --->>> LUCÍA GONZÁLEZ ROSAS <<<---
-- --->>> 1º. DE DAW (BASES DE DATOS; TEMA 4) <<<---
-- --->>> EJERCICIOS CORREGIDOS EL 29 DE MARZO DEL 2024 <<<---

-- ===========================================================

/*
Subconsultas
*/

/*
 Con operadores básicos de comparación
*/
-- 1º.) Devuelve el nombre del cliente con mayor límite de crédito =
SELECT nombre_cliente FROM cliente WHERE limite_credito = (SELECT MAX(limite_credito) FROM cliente);

-- 2º.) Devuelve el nombre del producto que tenga el precio de venta más caro =
SELECT nombre FROM producto WHERE precio_venta = (SELECT MAX(precio_venta) FROM producto);

-- 3º.) Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado (Sin utilizar INNER JOIN) =
SELECT nombre_cliente FROM cliente WHERE limite_credito > (SELECT SUM(total) FROM pago WHERE pago.codigo_cliente = cliente.codigo_cliente);

-- 4º.) Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria =
SELECT nombre, apellido1, email FROM empleado WHERE codigo_jefe = (SELECT codigo_empleado FROM empleado WHERE nombre = 'Alberto' AND apellido1 = 'Soria');

/*
 Subconsultas con ALL y ANY
*/

-- 5º.) Devuelve el nombre del cliente con mayor límite de crédito =
SELECT nombre_cliente FROM cliente WHERE limite_credito >= ALL (SELECT limite_credito FROM cliente);

-- 6º.) Devuelve el nombre del producto que tenga el precio de venta más caro =
SELECT nombre FROM producto WHERE precio_venta >= ALL (SELECT precio_venta FROM producto);

-- 7º.) Devuelve el producto que menos unidades tiene en stock =
SELECT nombre FROM producto WHERE cantidad_en_stock <= ANY (SELECT cantidad_en_stock FROM producto);

/*
 Subconsultas con IN y NOT IN
*/

-- 8º.) Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente =
SELECT nombre, apellido1, puesto FROM empleado
WHERE codigo_empleado NOT IN (SELECT codigo_empleado_rep_ventas FROM cliente WHERE codigo_empleado_rep_ventas IS NOT NULL);

-- 9º.) Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales =
SELECT codigo_oficina, ciudad FROM oficina
WHERE codigo_oficina NOT IN (SELECT codigo_oficina FROM empleado WHERE codigo_empleado IN 
    (SELECT codigo_empleado_rep_ventas FROM cliente WHERE codigo_cliente IN 
        (SELECT codigo_cliente FROM pedido WHERE codigo_pedido IN 
            (SELECT codigo_pedido FROM detalle_pedido WHERE codigo_producto IN 
                (SELECT codigo_producto FROM producto WHERE gama = 'Frutales')
            )
        )
    )
);

-- 10º.) Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago =
SELECT nombre_cliente FROM cliente
WHERE codigo_cliente IN (SELECT codigo_cliente FROM pedido) AND codigo_cliente NOT IN (SELECT codigo_cliente FROM pago);

/*
 Subconsultas con EXISTS y NOT EXISTS
*/

-- 11º.) Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago =
SELECT nombre_cliente FROM cliente c WHERE EXISTS (SELECT 1 FROM pago p WHERE p.codigo_cliente = c.codigo_cliente);

-- 12º.) Devuelve un listado de los productos que nunca han aparecido en un pedido =
SELECT nombre FROM producto p WHERE NOT EXISTS (SELECT 1 FROM detalle_pedido dp WHERE dp.codigo_producto = p.codigo_producto);