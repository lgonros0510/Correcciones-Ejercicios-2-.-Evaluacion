-- 1º.) Pasa el Modelo Entidad-Relación a Tablas =

CREATE TABLE TRAMOS (
    distancia DECIMAL(3,2) PRIMARY KEY NOT NULL
);

CREATE TABLE LOCALIDADES (
    id_Localidad CHAR(3) PRIMARY KEY NOT NULL,
    nombre VARCHAR(30),
    censo INTEGER,
    habitantes INTEGER
);

CREATE TABLE PROVINCIAS (
    id_Provincia CHAR(3) PRIMARY KEY NOT NULL,
    nombre VARCHAR(30),
    comunidad VARCHAR(20)
);

-- 2º.) Utilizando la sentencia CREATE TABLE, crea las 3 tablas. Teniendo en cuenta =

-- a) El censo ha de ser menor que el número de habitantes.
-- b) La distancia entre localidades nunca puede ser mayor que 300.
-- c) Las localidades deben de escribirse en mayúsculas.

CREATE TABLE TRAMOS (
    distancia DECIMAL(3,2) PRIMARY KEY NOT NULL CHECK (distancia <= 300)
);

CREATE TABLE LOCALIDADES (
    id_Localidad CHAR(3) PRIMARY KEY NOT NULL,
    nombre VARCHAR(30) CHECK (nombre = UPPER(nombre)),
    censo INTEGER CHECK (censo < habitantes),
    habitantes INTEGER
);

CREATE TABLE PROVINCIAS (
    id_Provincia CHAR(3),
    nombre VARCHAR(30),
    comunidad VARCHAR(20),
    PRIMARY KEY (id_Provincia)
);

-- 3º.) Utilizando sentencias SQL =

-- a) Inserta 3 tuplas para cada una de las tablas resultantes.

INSERT INTO LOCALIDADES (id_Localidad, nombre, censo, habitantes)
VALUES ('001', 'Madrid', 5000000, 6000000),
       ('002', 'Barcelona', 3000000, 3500000),
       ('003', 'Valencia', 700000, 800000);

INSERT INTO PROVINCIAS (id_Provincia, nombre, comunidad)
VALUES ('101', 'Madrid', 'Comunidad de Madrid'),
	   ('102', 'Barcelona', 'Cataluña'),
	   ('103', 'Valencia', 'Comunidad Valenciana');

INSERT INTO TRAMOS (distancia)
VALUES (250.0),
       (198.0),
       (176.0);

-- b) Modifica la distancia de las tuplas de la tabla Tramos, aumentando la distancia en un 20%, si la distancia es mayor que 50.

UPDATE TRAMOS SET distancia = distancia * 1.20 WHERE distancia > 50.0;