-- Ejercicio 1º.) Crea las siguientes tablas =

-- a) COCHES:
-- mat (matricula del coche, 8 caracteres y llave primaria) 
-- marca (15 caracteres)
-- an_fab (año de fabricacion, número de 2 dígitos)
-- ---------------------------------------------------------------
-- b) MECANICOS:
-- dni (9 caracteres, llave primaria) 
-- nombre (15 caracteres)
-- puesto (15 caracteres)
-- parcial (1 caracter)
-- ---------------------------------------------------------------
-- c) TRABAJOS:
-- mat (la matrícula del coche, llave externa respecto de COCHES), 
-- dni (el dni del mecánico),
-- horas (número de 3 cifras con 1 decimal, debe ser mayor de 0.5) 
-- fecha_rep (tipo fecha)

CREATE TABLE COCHES (
mat VARCHAR(8) PRIMARY KEY,
marca VARCHAR(15),
an_fab VARCHAR(3)
);

CREATE TABLE MECANICOS (
dni VARCHAR(9) PRIMARY KEY,
nombre VARCHAR(15),
puesto VARCHAR(15),
parcial CHAR(1)
);

CREATE TABLE TRABAJOS (
mat VARCHAR(8),
dni VARCHAR(9),
horas DECIMAL(3,1) CHECK (horas > 0.5),
fecha_rep DATE,
FOREIGN KEY (mat) REFERENCES COCHES(mat)
);

-- Ejercicio 2º.) Modificación de las tablas anteriores =

-- a) Añadir a la tabla COCHES el atributo modelo (15 caracteres)
-- b) Establecer los atributos mat y dni como la llave primaria de TRABAJOS.
-- c) Establecer el atributo dni de TRABAJOS como llave externa respecto a MECANICOS.
-- d) Ampliar a 4 la longitud del atributo an_fab de la tabla COCHES.

-- a)
ALTER TABLE COCHES ADD modelo VARCHAR(15);

-- b)
ALTER TABLE TRABAJOS ADD PRIMARY KEY (mat, dni);

-- c)
ALTER TABLE TRABAJOS ADD FOREIGN KEY (dni) REFERENCES MECANICOS(dni);

-- d)
ALTER TABLE coches MODIFY COLUMN an_fab VARCHAR(4);

-- Ejercicio 3º.) Dadas las siguientes tablas =

-- Libro(código,autor,titulo,editor,clase,prestado)
-- Usuario(secuencia,nombre,dirección,fecha_ingreso)
-- Clase(clave,tiempo_de_prestamo)
-- Préstamo(código, secuencia, fecha_inicio)

-- Con las siguientes claves foráneas:

-- Libro.clase -> Clase
-- Prestamo.codigo -> Libro
-- Prestamo.secuencia -> Usuario

-- Y las siguientes restricciones:

-- Prestado debe tomar por defecto el valor 1
-- fecha_ingreso es un campo obligatorio

-- Realizar en SQL los siguientes ejercicios =

-- a) Crea las tablas tal y como se haría en MySQL.
-- b) Una vez creadas: Agrega a la tabla “Usuario” el campo “sexo “ de un solo carácter.
-- c) Agrega a la tabla “Libro” el campo índice de tipo entero.

-- a)
CREATE TABLE Libro (
codigo INT PRIMARY KEY,
autor VARCHAR(50),
titulo VARCHAR(100),
editor VARCHAR(50),
clase VARCHAR(10),
prestado INT DEFAULT 1,
FOREIGN KEY (clase) REFERENCES Clase(clave)
);

CREATE TABLE Usuario (
secuencia INT PRIMARY KEY,
nombre VARCHAR(50),
dirección VARCHAR(100),
fecha_ingreso DATE NOT NULL
);

CREATE TABLE Clase (
clave VARCHAR(10) PRIMARY KEY,
tiempo_de_prestamo INT
);

CREATE TABLE Préstamo (
código INT,
secuencia INT,
fecha_inicio DATE,
FOREIGN KEY (código) REFERENCES Libro(codigo),
FOREIGN KEY (secuencia) REFERENCES Usuario(secuencia)
);

-- b)
ALTER TABLE Usuario ADD sexo CHAR(1);

-- c)
ALTER TABLE Libro ADD índice INT;