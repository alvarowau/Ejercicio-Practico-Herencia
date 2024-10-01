# Proyecto de Gestión de Empleados

Este proyecto implementa una jerarquía de clases para representar empleados utilizando JPA (Java Persistence API). A través de este proyecto, se exploran conceptos de herencia, clases embebidas y la interfaz `CommandLineRunner` para manejar operaciones básicas en la base de datos.

## Contenido

1. [Herencia](#herencia)
   - [Clases](#clases)
   - [Estrategia de Herencia](#estrategia-de-herencia)
2. [Embeddable](#embeddable)
3. [CommandLineRunner](#commandlinerunner)
   - [Operaciones](#operaciones)

## Herencia

### Clases

Se crea una jerarquía de clases que representa empleados:

- **Employee**: Clase base que contiene los atributos comunes de los empleados.
- **Manager**: Subclase que extiende de `Employee`, con atributos específicos para gerentes.
- **Engineer**: Subclase que extiende de `Employee`, con atributos específicos para ingenieros.

### Estrategia de Herencia

Se implementa la estrategia de herencia `SINGLE_TABLE` para el almacenamiento de las clases en la base de datos. Luego, se cambia la estrategia a `TABLE_PER_CLASS` y después a `JOINED` para observar cómo afecta la estructura de la base de datos.

## Embeddable

Se crea una clase `Address` que contiene los atributos de dirección:

- `calle`
- `ciudad`
- `código postal`

Esta clase se inserta como un objeto embebido dentro de la clase `Employee`, permitiendo una mejor organización de los datos de dirección.

## CommandLineRunner

Se implementa un `CommandLineRunner` para probar las siguientes operaciones:

### Operaciones

1. **Guardar (`save()`)**: Crea instancias de `Manager` y `Engineer` con direcciones embebidas y las guarda en la base de datos.
   
2. **Buscar todos (`findAll()`)**: Recupera y muestra todos los empleados en la base de datos.

3. **Buscar por ID (`findById()`)**: Busca un empleado por su ID y muestra su información.

4. **Eliminar por ID (`deleteById()`)**: Elimina un empleado de la base de datos utilizando su ID.

5. **Mostrar los empleados restantes**: Después de eliminar, muestra todos los empleados que quedan en la base de datos.

