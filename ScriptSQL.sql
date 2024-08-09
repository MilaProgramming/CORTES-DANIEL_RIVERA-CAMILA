-- Crear la base de datos
CREATE DATABASE backendPrueba;

-- Usar la base de datos recién creada
USE backendPrueba;

-- Crear la tabla Odontologos
CREATE TABLE Odontologos (
    numeroMatricula INT PRIMARY KEY AUTO_INCREMENT, 
    nombre VARCHAR(50) NOT NULL, 
    apellido VARCHAR(50) NOT NULL 
);

