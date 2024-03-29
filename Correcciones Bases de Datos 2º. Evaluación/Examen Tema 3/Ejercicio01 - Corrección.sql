/* ---EJERCICIO 1A--- 

Crea la siguiente tabla, con el tipo de dato que te parezca más apropiado
empleados(dni, nombre, edad, fecha_contrato)

Inserta tu script después de los comentarios
\/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/     */

CREATE TABLE empleados (
dni VARCHAR(10) PRIMARY KEY,
nombre VARCHAR(100),
edad INT,
fecha_contrato DATE
);

/* Prueba: Debe añadir 2 registros */
DESCRIBE empleados;
INSERT INTO empleados VALUES ('11111111A','Alberto',38,'2020-01-14');
INSERT INTO empleados VALUES ('22222222B','Bárbara',26,'2021-02-13');
SELECT * FROM empleados;

-----------------------------------------------------------------------------------------------------

/* ---EJERCICIO 1B---

Crea la siguiente tabla, con el tipo de dato que te parezca más apropiado
oficinas(codigo, direccion, localidad, telefono, num_empleados)

Inserta tu script después de los comentarios
\/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/ \/      */

CREATE TABLE oficinas (
codigo VARCHAR(10) PRIMARY KEY,
direccion VARCHAR(255),
localidad VARCHAR(100),
telefono VARCHAR(15),
num_empleados INT
);

/* Prueba: Debe añadir 2 registros */
DESCRIBE oficinas;
INSERT INTO oficinas VALUES (001, 'Miguel Ángel','Coín',952111111,10);
INSERT INTO oficinas VALUES (002, 'Leonardo','Málaga',952222222,50);
SELECT * FROM empleados;