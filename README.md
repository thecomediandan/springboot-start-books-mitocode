# Ejemplo básico de uso de Springboot
Este proyecto muestra simples rasgos la creación de un proyecto CRUD básico con Springboot, usando docker, Spring Security y Spring JPA.

## Instalación
- Luego de clonar el repositorio, en el directorio raíz en una terminal ejecutar Docker Compose <b>docker compose up -d</b>.
- Levantar el proyecto de Spring que se conectará con la base de datos y creará las tablas
- Crear datos en la tabla de Categorias y despues para Libros.

## Pasos para empezar
- De primeras usaremos la página de Spring Initializr para crear un proyecto de Springboot, seleccionaremos las opciones de un Proyecto en Maven, Lenguaje Java, Springboot 3.5.3, Empaquetado JAR con Java 17. Además de Unas dependencias para empezar: Spring Web y Lombok. Al correr la aplicación con el archivo principal se abrirá la aplicación en eñ navegador en el puerto 8080 del localhost.

- Por defecto en Springboot al retornar una instancia de un objeto POJO devuelve un JSON del mismo al retornar el valor en un RestController.

- Para hacer que se usen formatos como el XML se debría usar librerías externas como:

```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml -->
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
    <version>2.19.1</version>
</dependency>
```
Para usarlo, en una modelo se debería usar la notación @JacksonXmlRootElement

- Inyección de dependencias:
    - Se le dice a Spring que genere estereotipos mediante notaciones a clases, para que se genere Beans que son los que se usa para la inyección de dependencias, es decir que Spring que mediante estos Beans generados guarda refrencias de instancias que serán usados donde se los necesite, sea por atributo (Autowired), constructor o por método.

- El archivo application.properties es muy importante, es el encargado de vincular la aplicación con la base de datos.
    - spring.jpa.hibernate.ddl-auto=update, tiene varias configuraciones, update es la más usual porque su comportamiento implica que cuando se modifique clases como tablas estas generen tablas en la base de datos, si estas se modifican tambien se modifican en la base de datos, create solo crea las clases marcadas como tablas en la base de datos, create-drop, crea las tablas pero al terminar o cerrar la sesión del servidor se borrará el contenido de la base de datos, none no hará ninguna acción, validate simplemente comparará las clases marcadas como tabla con la base de datos si no estan en sincronia no se levantará el servicio.

    - Para que Spring JPA funcione necesita de conectarse a una base de datos y manejar una especificación que use JPA como Hibernate por ejemplo. Necesitaremos utilizar una librería conocida en Spring como:

    ```xml
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
        <version>3.5.3</version>
    </dependency>
    ```
    - Tambien necesitaremos un conector a un tipo de base de datos como PostgreSQL, MySQL, etc. Necesitaremos otra dependencia para instalar este conector:

    ```xml
    <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.7</version>
    </dependency>
    ```

    Ahora si nuestas configuraciones en el archivo de application.properties surtirán efecto en cuanto se cree una base de datos y se configure clases con referencia a tablas en este caso a Entidades mediante JPA.

    - Vamos a crear algunas Categorias para empezar dado la relacion de las tablas creada entre Book y Category (N:1):

    ```json
    {
        "name": "Drama"
    }
    {
        "name": "Terror"
    }
    {
        "name": "Accion"
    }
    {
        "name": "Ficcion"
    }
    {
        "name": "Novela"
    }
    ```

    - Luego podemos agregar libros:

    ```json
    {
    	"id": 1,
    	"title": "Libro 1",
    	"author": "Autor 1",
    	"category": {
    		"id": 1
    	}
    }
        {
    	"id": 2,
    	"title": "Libro 2",
    	"author": "Autor 2",
    	"category": {
    		"id": 2
    	}
    }
        {
    	"id": 3,
    	"title": "Libro 3",
    	"author": "Autor 3",
    	"category": {
    		"id": 3
    	}
    }
        {
    	"id": 4,
    	"title": "Libro 4",
    	"author": "Autor 4",
    	"category": {
    		"id": 4
    	}
    }
    ```

- Para el tema de seguridad necesitaremos una dependencia para bloquear los endpoints con un usuario y contraseña:

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    <version>3.5.3</version>
</dependency>
```

Por defecto se nos aplica una seguridad basica, donde el usuario es 'user' y la contraseña se nos envia en la consola cuando se levanta el proyecto.
Podemos crear usuarios en memoria y base de datos, para la base de datos agregaremos los siguientes usuarios en la base de datos:

```sql
-- Para consultar los empleados
select * from employee e;  
-- Para eliminar usuarios
delete from employee e where e.id = 1; 
-- El password por defecto es ardadev
-- Pagina para generar hash con bcrypt: https://bcrypt-generator.com/
insert into employee(username, password, rol) values ('user', '$2a$12$KgyCphgV1ofw9Fyps6Hm.eSlZRGwJ1sAhPICv3yhJQQ7.1zXelnkK', 'USER');
insert into employee(username, password, rol) values ('admin', '$2a$12$KgyCphgV1ofw9Fyps6Hm.eSlZRGwJ1sAhPICv3yhJQQ7.1zXelnkK', 'ADMIN');
```
## Cosas siguientes que probar:
- Seguridad de sesiones mediante JWT
- Despliegue en la nube
- Consultas mas avanzadas con procedimientos almacenados, vistas, paginación en PostgreSQL