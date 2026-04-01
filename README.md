# Sistema de Login y Registro de Usuarios

Este proyecto fue desarrollado en Java como parte de una tarea académica. Consiste en una aplicación de escritorio con interfaz gráfica que permite registrar usuarios, iniciar sesión y administrar la información de los usuarios guardados en una base de datos.

La aplicación fue construida con Java Swing para la parte visual y MySQL para el almacenamiento de los datos.

## Funcionalidades

El sistema permite:

- Iniciar sesión con nombre de usuario y contraseña
- Registrar nuevos usuarios
- Validar que todos los campos obligatorios estén completos
- Verificar que la contraseña y su confirmación coincidan
- Ocultar la contraseña al escribirla
- Mostrar una tabla con todos los usuarios registrados
- Actualizar la información de un usuario
- Eliminar usuarios
- Cerrar sesión y volver a la ventana de login

## Tecnologías utilizadas

- Java
- Java Swing
- MySQL
- JDBC
- Eclipse
- Git y GitHub

## Estructura del proyecto

El proyecto está organizado por paquetes para mantener mejor el orden del código:

- `Tarea4.modelo`  
  Contiene las clases del modelo, como `Persona` y `Usuario`.

- `Tarea4.logica`  
  Contiene la conexión a la base de datos y la lógica de acceso a datos, como `ConexionBD` y `UsuarioDAO`.

- `Tarea4.vistas`  
  Contiene las ventanas del sistema:
  - `VentanaLogin`
  - `VentanaRegistro`
  - `VentanaPrincipal`
  - `VentanaActualizarUsuario`

- `Tarea4`  
  Contiene la clase `Main`, que inicia la aplicación y todos los demas paquetes, el proyecto completo esta aqui.

## Base de datos

Para este proyecto se utilizó una base de datos MySQL con una tabla llamada `usuarios`.

### Script base 

```sql
CREATE DATABASE tarea4_login;

USE tarea4_login;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    contrasena VARCHAR(100) NOT NULL
);
