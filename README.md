# 🥖 Sistemas Para Panadería - BackEnd

Un sistema integral de gestión para panaderías desarrollado en **Java** con **Spring Boot**.

## 📋 Descripción

Plataforma backend completa para la administración y control de operaciones en panaderías, incluyendo gestión de productos, ventas, generación de reportes y manejo de pagos.

## 🛠️ Tecnologías Utilizadas

- **Java 21** - Lenguaje de programación principal
- **Spring Boot 4.0.6** - Framework web
- **Spring Data JPA** - Persistencia de datos
- **Spring Security** - Autenticación y autorización
- **MySQL** - Base de datos relacional
- **JWT (0.12.5)** - Autenticación segura con tokens
- **Lombok** - Reducción de código boilerplate
- **Apache POI (5.2.5)** - Generación de reportes Excel
- **OpenPDF (1.3.36)** - Generación de boletas/facturas en PDF
- **Cloudinary** - Gestión y almacenamiento de imágenes
- **Spring Mail** - Envío de correos (OTP)
- **Swagger/OpenAPI (2.8.5)** - Documentación interactiva de APIs
- **Maven** - Gestor de dependencias y construcción

## 🚀 Características Principales

✅ **Autenticación y Seguridad**
- Autenticación mediante JWT
- Autorización basada en roles
- Contraseñas seguras con Spring Security

✅ **Gestión de Operaciones**
- Administración de productos
- Control de ventas y transacciones
- Generación de reportes en Excel
- Creación de boletas y facturas en PDF

✅ **Integración de Imágenes**
- Almacenamiento de imágenes en Cloudinary
- Gestión de recursos multimedia

✅ **Comunicación**
- Envío de correos electrónicos
- Sistema OTP para verificación

✅ **Documentación de APIs**
- Documentación interactiva con Swagger/OpenAPI
- Facilita la integración con frontends

## 📦 Estructura del Proyecto

    src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── [Clases y controladores de la aplicación]
    │   └── resources/
    └── test/

## 🔧 Requisitos Previos

- Java 21 o superior
- Maven 3.6+
- MySQL 8.0+

## ⚡ Instalación y Configuración

### 1. Clonar el repositorio

    git clone https://github.com/MartelAlexis/Sistemas-Para-Panaderia-BackEnd.git
    cd Sistemas-Para-Panaderia-BackEnd

### 2. Configurar variables de entorno

Crear un archivo `application.properties` o `application.yml` con:

    # Base de datos
    spring.datasource.url=jdbc:mysql://localhost:3306/panaderia
    spring.datasource.username=root
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update

    # JWT
    jwt.secret=tu_clave_secreta
    jwt.expiration=86400000

    # Email
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=tu_email@gmail.com
    spring.mail.password=tu_contraseña_app

    # Cloudinary
    cloudinary.name=tu_nombre_cloudinary
    cloudinary.api_key=tu_api_key
    cloudinary.api_secret=tu_api_secret

### 3. Ejecutar la aplicación

Con Maven:

    ./mvnw spring-boot:run

O en Windows:

    mvnw.cmd spring-boot:run

### 4. Acceder a la documentación API

Una vez que la aplicación esté corriendo, accede a:

    http://localhost:8080/swagger-ui.html

## 📚 Documentación de APIs

La documentación completa de los endpoints está disponible a través de Swagger/OpenAPI. Todos los endpoints están documentados y pueden ser probados directamente desde la interfaz web.

## 🔐 Autenticación

El sistema utiliza JWT para autenticación. Incluye el token en el header de tus peticiones:

    Authorization: Bearer <tu_token_jwt>

## 🗄️ Base de Datos

El proyecto utiliza **Spring Data JPA** para la persistencia. Las entidades se sincronizan automáticamente con MySQL mediante Hibernate.

### Configuración de Hibernate

- `ddl-auto=update` - Actualiza el esquema automáticamente
- Compatible con MySQL 8.0+

## 📄 Reportes y Documentos

- **Excel**: Generados mediante Apache POI
- **PDF**: Boletas y facturas con OpenPDF
- **Imágenes**: Almacenadas en Cloudinary

## 🌿 Ramas Principales

- **main** - Código en producción
- **dev** - Rama de desarrollo

## 💡 Dependencias Principales

### Spring Framework
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-webmvc
- spring-boot-starter-mail

### Librerías de Terceros
- jjwt-api, jjwt-impl, jjwt-jackson (JWT)
- poi-ooxml (Reportes Excel)
- openpdf (Generación de PDFs)
- cloudinary-http5 (Almacenamiento de imágenes)
- springdoc-openapi-starter-webmvc-ui (Swagger)
- lombok (Generación de código)

### Base de Datos
- mysql-connector-j

## 🔗 Variables de Entorno
-SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/panaderia
-SPRING_DATASOURCE_USERNAME=root SPRING_DATASOURCE_PASSWORD=contraseña
-JWT_SECRET=tu_clave_secreta_segura JWT_EXPIRATION=86400000 SPRING_MAIL_HOST=smtp.gmail.com 
-SPRING_MAIL_PORT=587 SPRING_MAIL_USERNAME=tu_email@gmail.com 
-SPRING_MAIL_PASSWORD=contraseña_app CLOUDINARY_NAME=tu_nombre 
-CLOUDINARY_API_KEY=tu_api_key CLOUDINARY_API_SECRET=tu_api_secret
## 🚀 Deployment

### Con Docker

    docker build -t panaderia-backend .
    docker run -p 8080:8080 panaderia-backend

### En servidor tradicional

1. Compilar el proyecto: `./mvnw clean package`
2. Se generará un JAR en `target/`
3. Ejecutar: `java -jar target/Sistemas-Para-Panaderia-BackEnd-0.0.1-SNAPSHOT.jar`

### v0.0.1 - Inicial
- Configuración inicial del proyecto
- Integración de Spring Boot 4.0.6
- Configuración de JWT
- Integración con MySQL
- Documentación con Swagger

---
