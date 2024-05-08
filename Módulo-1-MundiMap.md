# P2-MundiMap

| Documento: | Módulo-1: MundiMap                                      |
| ---------- | ------------------------------------------------------- |
| Curso:     | SISTEMAS DISTRIBUIDOS - Grado en Ingeniería Informática |
| Libro:     | Enunciado Proyecto 2: Mapa del Mundo                    |
| Autor:     | LLAMAS BELLO, CESAR                                     |
| Fecha:     | lunes, 15 de abril de 2024                              |
| Versión:   | 1.0 - original - 04-15                                  |

## Descripción:

Este documento describe el primer módulo del proyecto 2 de la Asignatura de Sistemas Distribuidos del Curso 2023-2024. En este primer módulo se muestran las capacidades básicas de un Mapa de un Mundo que se describe mediante objetos remotos que describen lugares que se conectan unos con otros. En primer lugar disponemos de herramientas de administración que nos permiten crear las "estancias" y conectarlas unas con otras, además de añadir elementos pueden ser estáticos o con los que podemos interactuar de modo elemental. En segundo lugar podemos interactuar mediante clientes con las estancias.

El primer módulo consiste en un sistema multijugador de mundos separados. En el siguiente módulo utilizaremos una aproximación de "mundo único".

## Tabla de contenidos

[TOC]

## Breve descripción de la funcionalidad del Módulo 1

Este Módulo nos va a permitir implementar los componentes fundamentales de la interacción con objetos que vamos a requerir para programar este Mapa de Mundo. El objetivo es producir un sistema con el que podamos jugar con personajes moviéndose por una red de lugares (o estancias) donde encuentran objetos o incluso interactúan con ellos. Las estancias están conectadas entre sí por puertas que pueden traspasarse para llegar a otras estancias. En la siguiente figura tienes un sencillo diagrama con este escenario:

![VisionGeneral](imagenes\VisionGeneral.png)

Los personajes pueden ser de varios tipos predefinidos que podrán hacer cosas muy sencillas como:

* ver el estatus de una estancia o de un objeto (mensaje)
* accionar una puerta (traspasar el umbral).
* apropiarse de un objeto.

Los objetos que vamos a encontrar por el camino son muy sencillos, y en primer lugar van a constar de

* alimento, que les va a permite ganar HP (puntos de salud) para moverse y
* magia que les permite ganar MP (puntos de magia) para abrir puertas.
* monedas, que dan cuenta del cumplimiento de un desafío.

## Las estancias

Vamos a simplificar mucho el juego, y las estancias sólo van a poder contener puertas y cofres, de momento. También suponemos que cada jugador se enfrenta a una estancia que es independiente de lo que estén haciendo el resto de jugadores. En otras palabras, el juego es monojugador.

Las estancias son sencillos objetos remotos, que permiten el siguiente conjunto de acciones:

* `info()`: que proporciona un mensaje de texto que puede tener varias líneas y que es como un cartel de información con el que el personaje se informa de qué es la estancia. Por ejemplo:

  * `Pasillo tenebroso donde algunos restos de huesos humanos delatan...`
  * `Sala con tres cofres...`
  * ...

* `contenido()`: devuelve un HasMap con nombres y referencias a objetos del siguiente tipo:

  * `Puerta`: que requiere un desafío y que conduce a otra estancia. Tiene dos operaciones:

    * `info()`: que nos dice algo sobre el tipo de puerta y el desafío.

      En el caso de un pasillo, el desafío de una puerta puede ser cero, pero a veces puede requerir un cierto nivel de monedas, HP o MP, que tenemos que reunir de alguna forma.

      Cuidado porque el juego podría ser injugable si la puerta es de un solo sentido y quedamos atrapados por los desafíos de las puertas.

    * `abre()`: que intenta abrir la puerta y cuyo resultado depende del desafío. Si tenemos éxito al abrir, traspasaremos la puerta.

  * `Cofre`: que tiene dos operaciones:

    * `info()`: que nos dice algo sobre el cofre, y
    * `abre()`: que acciona el cofre y nos devuelve el contenido que puede ser:
      * `Comida`: para incrementar nuestro HP
      * `PociónMagica`: para incrementar nuestro MP
      * `Moneda`: el objetivo del juego es reunir la mayor cantidad de monedas y es distinta en función del número de cofres.

## Los Personajes

Los personajes son entidades que residen en un servidor, por lo que sólo podemos interactuar con ellos mediante uno o varios clientes externos, pero el estado del cliente está centralizado en un proceso que vigila que se cumplan las reglas que rigen a los jugadores.

![GestionPersonajes](imagenes\GestionPersonajes.png)

## El modo de juego

El juego debe permitir varios jugadores, y `ContenedorPersonajes` debe ser justo y permitir una `acción` por personaje por turno. Como una acción podría ser compuesta en el futuro, debemos contemplar la posibilidad de acumular dos acciones y cometerjas (`commit()`) en una sola jugada.

* Cada personaje tiene un MP, un HP y un tipo. HP y MP tienen un nivel máximo por tipo de personaje.

Los tipos de personajes pueden ser diversos y reflejan las habilidades de cada uno, por ejemplo:

* Ladrón,
  * tiene más habilidad para abrir puertas, de modo que el desafío de puertas puede ser más bajo.
* Explorador,
  * su maxLevel de HP es alto.
  * tiene un uso de MP bajo por lo que su máxLevel de MP es bajo.
* Mago,
  * su maxLevel de HP es bajo
  * su habilidad con MP es mayor, por lo que su maxLevel de MP es alto

### Conclusión

Seguramente te parecerá un poco complicado realizar esto de buenas a primeras, pero sois tres o cuatro compañeros/as, y seguro que entre todos podréis resolver la tarea fácilmente. Os siguiero la siguiente secuencia de pruebas y de pasos intermedios hasta construir el sistema completo:
