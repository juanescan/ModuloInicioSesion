# Sistema de Gestión de Usuarios y Autenticación con JWT

Este proyecto implementa un sistema de gestión de usuarios en una institución educativa, permitiendo la autenticación segura de estudiantes y bibliotecarios mediante **JSON Web Tokens (JWT)**. Utilizando **Spring Boot** para el backend, MongoDB para la persistencia de datos y un sistema basado en roles, el proyecto ofrece una solución eficiente y segura para el control de acceso y manejo de usuarios.

## Características Principales:

- **Autenticación JWT**: Los usuarios (Estudiantes y Bibliotecarios) pueden autenticar su identidad mediante un token JWT. Este token se incluye en las solicitudes subsecuentes para validar su sesión y acceder a recursos protegidos.
  
- **Manejo de Roles**: El sistema distingue entre diferentes tipos de usuarios, como **Estudiantes** y **Bibliotecarios**, asignando roles y permisos específicos que permiten controlar el acceso a diferentes áreas del sistema.

- **Persistencia en MongoDB**: Los usuarios, sus credenciales y roles se almacenan de forma segura en una base de datos MongoDB. La estructura de los documentos permite la fácil extensión para otros tipos de usuarios o entidades.

- **Seguridad Mejorada**: La implementación de JWT asegura que la autenticación y autorización sean realizadas de manera eficiente y escalable sin necesidad de manejar sesiones tradicionales en el servidor.

## Estructura del Proyecto:

- **Backend en Spring Boot**: El backend está construido con **Spring Boot**, utilizando **Spring Security** para la gestión de la seguridad y autenticación. Los tokens JWT se generan y validan en el servidor.

- **MongoDB**: Se utiliza **MongoDB** como base de datos para almacenar los detalles de los usuarios, incluyendo sus roles y estados de la cuenta.

- **Usuarios Estudiantes y Bibliotecarios**: El sistema gestiona dos tipos principales de usuarios:
  - **Estudiantes**: Con atributos como nombre, código de estudiante, curso y año académico(este tambien tiene una relacion con **Responsable academico** por medio del correo del responsable).
  - **Bibliotecarios**: Con roles y detalles específicos para el manejo de las operaciones administrativas.

## Tecnologías Usadas:

- **Spring Boot**: Framework principal para el desarrollo del backend.
- **MongoDB**: Base de datos NoSQL para la persistencia de usuarios.
- **JWT**: Tecnología para la autenticación y validación de tokens de usuario.
- **Spring Security**: Framework para manejar la seguridad y protección de rutas en la aplicación.

## Cómo Usar:

1. **Configuración de la Base de Datos:**
   Asegúrese de tener **MongoDB** configurado y corriendo en su entorno.
   
2. **Generación de Token JWT:**
   Al iniciar sesión, se generará un token JWT que deberá ser incluido en el encabezado `Authorization` de todas las solicitudes subsecuentes.

3. **Rutas Protegidas:**
   Las rutas que requieren autenticación están protegidas mediante validación del token JWT en el encabezado de la solicitud.

4. **Configuración de Seguridad:**
   El sistema garantiza que solo los usuarios con un token válido y el rol adecuado puedan acceder a las rutas protegidas.
