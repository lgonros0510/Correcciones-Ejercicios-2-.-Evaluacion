/* ---EJERCICIO 5A---
Modifica la tabla empleados, sin borrarla:
+ Añade una columna oficina, que se refiere a un registro de la tabla oficinas (FK).
+ Añade una columna departamento, que se refiere a un registro de la tabla departamentos (FK).
+ Modifica la columna superior, para que se refiera a otro registro de la tabla empleados (FK).
empleados(dni, nombre, edad, fecha_contrato, movil)
*/

ALTER TABLE empleados ADD COLUMN oficina VARCHAR(10) REFERENCES oficinas(codigo),
ADD COLUMN departamento VARCHAR(100) REFERENCES departamentos(nombre), DROP COLUMN superior,
ADD CONSTRAINT fk_superior FOREIGN KEY (superior) REFERENCES empleados(dni) ON DELETE SET NULL;

/* ---EJERCICIO 5B---
Añade una tabla que almacene la distancia que hay entre dos oficinas (hasta 999km).
Inserta 2 registros, y otros 2 que fallen por restricciones diferentes.
*/

CREATE TABLE distancia_oficinas (
oficina_origen VARCHAR(10),
oficina_destino VARCHAR(10),
distancia_km INT CHECK (distancia_km > 0 AND distancia_km <= 999),
PRIMARY KEY (oficina_origen, oficina_destino),
FOREIGN KEY (oficina_origen) REFERENCES oficinas(codigo),
FOREIGN KEY (oficina_destino) REFERENCES oficinas(codigo)
);