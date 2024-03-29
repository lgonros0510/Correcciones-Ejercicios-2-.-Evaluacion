/* ---EJERCICIO 4A---

Modifica la tabla empleados, sin borrarla:
- elimina la columna sexo, no es relevante.
+ Añade una columna móvil, que debe tener 9 números entre el 600000000 y 799999999, pero no es obligatoria.
+ Añade una columna superior, con el mismo tipo que el dni.
empleados(dni, nombre, edad, fecha_contrato, movil, superior)
*/

ALTER TABLE empleados DROP COLUMN sexo, ADD movil VARCHAR(9) CHECK (movil = '^[6-7]{1}[0-9]{8}$'), ADD superior VARCHAR(10);

/* Prueba: Debe añadir 1 registro (total 3) y 2 errores */
INSERT INTO empleados VALUES ('22222222B','Bárbara',26,'2021-02-13',666666666, 11111111A);
INSERT INTO empleados VALUES ('33333333C','Carlos',15,'2022-03-12',666666667, 11111111A);
INSERT INTO empleados VALUES ('77777777G','Gonzalo',48,'2020-07-08',555555555, 11111111A);
SELECT * FROM empleados;

-----------------------------------------------------------------------------------------------------

/* ---EJERCICIO 4B---
Añade una tabla departamentos:
departamentos (nombre, sede, presupuesto, director)
Con las siguientes restricciones: 
- nombre es PRIMARY KEY.
- sede se refiere a una oficina.
- presupuesto no es obligatorio, pero no puede alcanzar 1 millón (2 decimales).
- director (o directora) se refiere a un registro de la tabla empleados.

*/

CREATE TABLE departamentos (
nombre VARCHAR(100) PRIMARY KEY,
sede VARCHAR(10) REFERENCES oficinas(codigo),
presupuesto DECIMAL(12, 2),
director VARCHAR(10) REFERENCES empleados(dni) ON DELETE SET NULL ON UPDATE CASCADE
);

ALTER TABLE departamentos ADD CONSTRAINT limite_presupuesto CHECK (presupuesto IS NULL OR presupuesto < 1000000);

/* Prueba: Debe añadir 2 registros y 3 errores */
DESCRIBE departamentos;
INSERT INTO departamentos VALUES ('Dirección', 1, 600000.00, '11111111A');
INSERT INTO departamentos VALUES ('Informática', 2, 1000.00, '22222222B');
INSERT INTO departamentos VALUES ('Ventas', 1, 15000000.00, '11111111A');
INSERT INTO departamentos VALUES ('Marketing', 45, 200000.00, '11111111A');
INSERT INTO departamentos VALUES ('Marketing', 2, 200000.00, '99999999I');
SELECT * FROM empleados;