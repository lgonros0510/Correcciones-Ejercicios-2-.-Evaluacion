-- --->>> LUCÍA GONZÁLEZ ROSAS <<<---
-- --->>> 1º. DE DAW (BASES DE DATOS; TEMA 5) <<<---
-- --->>> EXAMEN CORREGIDO EL 29 DE MARZO DEL 2024 <<<---

-- ===========================================================

DROP DATABASE IF EXISTS empleados;
CREATE DATABASE empleados CHARACTER SET utf8mb4;
USE empleados;

CREATE TABLE departamento (
 id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(100) NOT NULL,
 presupuesto DOUBLE UNSIGNED NOT NULL,
 gastos DOUBLE UNSIGNED NOT NULL
);

CREATE TABLE empleado (
 id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 nif VARCHAR(9) NOT NULL UNIQUE,
 nombre VARCHAR(100) NOT NULL,
 apellido1 VARCHAR(100) NOT NULL,
 apellido2 VARCHAR(100),
 id_departamento INT UNSIGNED,
 FOREIGN KEY (id_departamento) REFERENCES departamento(id)
);

INSERT INTO departamento VALUES(1, 'Desarrollo', 120000, 6000);
INSERT INTO departamento VALUES(2, 'Sistemas', 150000, 21000);
INSERT INTO departamento VALUES(3, 'Recursos Humanos', 280000, 25000);
INSERT INTO departamento VALUES(4, 'Contabilidad', 110000, 3000);
INSERT INTO departamento VALUES(5, 'I+D', 375000, 380000);
INSERT INTO departamento VALUES(6, 'Proyectos', 0, 0);
INSERT INTO departamento VALUES(7, 'Publicidad', 0, 1000);

INSERT INTO empleado VALUES(1, '32481596F', 'Aarón', 'Rivero', 'Gómez', 1);
INSERT INTO empleado VALUES(2, 'Y5575632D', 'Adela', 'Salas', 'Díaz', 2);
INSERT INTO empleado VALUES(3, 'R6970642B', 'Adolfo', 'Rubio', 'Flores', 3);
INSERT INTO empleado VALUES(4, '77705545E', 'Adrián', 'Suárez', NULL, 4);
INSERT INTO empleado VALUES(5, '17087203C', 'Marcos', 'Loyola', 'Méndez', 5);
INSERT INTO empleado VALUES(6, '38382980M', 'María', 'Santana', 'Moreno', 1);
INSERT INTO empleado VALUES(7, '80576669X', 'Pilar', 'Ruiz', NULL, 2);
INSERT INTO empleado VALUES(8, '71651431Z', 'Pepe', 'Ruiz', 'Santana', 3);
INSERT INTO empleado VALUES(9, '56399183D', 'Juan', 'Gómez', 'López', 2);
INSERT INTO empleado VALUES(10, '46384486H', 'Juan Diego','Flores', 'Salas', 5);
INSERT INTO empleado VALUES(11, '67389283A', 'Marta','Herrera', 'Gil', 1);
INSERT INTO empleado VALUES(12, '41234836R', 'Irene','Salas', 'Flores', NULL);
INSERT INTO empleado VALUES(13, '82635162B', 'Juan Antonio','Sáez', 'Guerrero', NULL);

-- 1º.) Inserta un nuevo departamento "Ventas" con los campos necesarios =
INSERT INTO departamento (nombre, presupuesto, gastos) VALUES ('Ventas', 0, 0);

-- 2º.) Añade un nuevo empleado con NIF '98765432J', llamado Laura Martínez García, al departamento de Recursos Humanos =
INSERT INTO empleado (nif, nombre, apellido1, apellido2, id_departamento) VALUES ('98765432J', 'Laura', 'Martínez', 'García', 3);

-- 3º.) Actualiza el Presupuesto del departamento "I+D" incrementándolo en un 25% € =
UPDATE departamento SET presupuesto = presupuesto * 1.25 WHERE nombre = 'I+D';

-- 4º.) Incrementa en un 20% el presupuesto de aquellos departamentos cuyos gastos superan el 75% de su presupuesto =
UPDATE departamento SET presupuesto = presupuesto * 1.20 WHERE gastos > 0.75 * presupuesto;

-- 5º.) Elimina todos los departamentos que no tienen empleados =
DELETE FROM departamento WHERE id NOT IN (SELECT DISTINCT id_departamento FROM empleado);

-- 6º.) Elimina todos los empleados que no tienen un departamento asociado =
DELETE FROM empleado WHERE id_departamento IS NULL;

-- 7º.) Elimina el departamento Desarrollo. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?
DELETE FROM departamento WHERE nombre = 'Desarrollo';

-- Sí es posible eliminarlo porque no existe ninguna restricción que lo impida.

-- 8º.) Actualiza el código del departamento Recursos Humanos y asígnale el valor 30. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
UPDATE departamento SET id = 30 WHERE nombre = 'Recursos Humanos';

-- Actualizar las claves primarias no es algo recomendable y, en este caso, no es algo que resulte necesario. La clave primaria "id"
-- se usa como un identificador interno y no necesita ser modificado.

-- 9º.) Hoy celebramos San Juan. Suma 1000€ a cada departamento, por cada empleado que tenga que contenga "Juan" en su nombre =
UPDATE departamento SET presupuesto = presupuesto + 1000 WHERE id IN (SELECT id_departamento FROM empleado WHERE nombre LIKE '%Juan%');

-- 10º.) En una sola transacción, mueve todos los empleados del departamento de nombre "Sistemas" al departamento "Desarrollo", luego elimina el departamento "Sistemas" =
START TRANSACTION;
UPDATE empleado SET id_departamento = (SELECT id FROM departamento WHERE nombre = 'Desarrollo') WHERE id_departamento = (SELECT id FROM departamento WHERE nombre = 'Sistemas');
DELETE FROM departamento WHERE nombre = 'Sistemas';
COMMIT;