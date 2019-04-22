# Casino spring boot
Casino realizado con spring boot..

Realizado aplicando TDD

## Como se ha realizado
La parte de configuración de juego se ha creado una interfaz para poder modelar todas las configuraciones que sean necesarias a futuro.
A nivel de modelo se ha creado un atributo tipo object para después en cada servicio aplicar el cast al objecto que per toque ( en los test se puede ver ).

A la hora de transiciones se ha creado dos servicios para concretar la función de cada uno (SDP).

En el servicio PlayerCheckGameTime se podía separar en dos clases, pero veo que es importante en este caso tenerla en la misma clase ya que el contexto de los dos métodos es buscando la misma finalidad.

De base de datos se ha usando H2 de spring guardado en memoria y JPA para el manejo de la información.

Clase CasinoGame junta todas las acciones para juntar todas las piezas.
Esta parte se podria mejorar realizando una abstracion de las clases por controladores. Pero por falta de tiempo es plasmado así.

## Como se ejecuta

```
mvn package && java -jar target/CasinoZitro-1.0-SNAPSHOT.jar
```
Se ejecutan los test y ejecuta la aplicación modo consola-
