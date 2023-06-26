# API - Facturacion Entrega final

## Funcionalidad

La aplicación consiste en un sistema de ABM de clientes, productos y facturas. Para el mismo se disponibilizan distintas APIs que 
permiten la administración de los mismos. Además cuenta con un sistema de manejo de errores, el cual permite mostrar con claridad cualquier
error al usuario. 

## Requerimientos

- [ ] Maven (https://maven.apache.org/install.html)
- [ ] JDK 11 (https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html)

## Compilar el proyecto

- [ ] Abrir el CMD y ejecutar los siguientes comandos:

```
cd <carpeta del proyecto>
mvn clean install
```

## Ejecutar la aplicación

- [ ] Abrir el CMD y ejecutar los siguientes comandos para correr la aplicación localmente:

```
cd <carpeta del proyecto>
mvn spring-boot:run
```

## Dependencias utilizadas

- [ ]  **Spring Data JPA**: Ayuda a persistir datos en aplicaciones Java al ofrecer una capa de abstracción que facilita el mapeo objeto-relacional, así como hacer operaciones CRUD.
- [ ]  **Spring Web**: Proporciona herramientas para la creación de controladores, manejo de peticiones y respuestas HTTP, inyección de dependencias, entre otros.
- [ ]  **H2 Database**: Es una base de datos ligera, rápida y fácil de configurar, que se puede ejecutar en memoria o como un servidor independiente.