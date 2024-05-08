# Personajes de MundiMap: facultades, tipos y dinámica.

| Documento: | Módulo-1: MundiMap-Personajes                                |
| ---------- | ------------------------------------------------------------ |
| Curso:     | SISTEMAS DISTRIBUIDOS - Grado en Ingeniería Informática      |
| Libro:     | Enunciado Proyecto 2: Mapa del Mundo - Personajes            |
| Autor:     | LLAMAS BELLO, CESAR                                          |
| Fecha:     | lunes, 26 de abril de 2024                                   |
| Versión:   | 1.0 - original - 04-23<br />1.1 - corregido error de cartel de **Fighter** y nota al final. - 04-26 |

#### Descripción

El juego MundiMap se describe en torno a _estancias_, _objetos_ (como cofres y puertas) y _personajes_. En este documento se describen con mayor detalle las facultades de los personajes de MundiMap, los parámetros que lo describen  (incluyendo sus valores iniciales) y los tipos básicos de personajes del juego. Se describen también cómo cambian estos parámetros cuando interactúan con los objetos del juego. Es recomendable una lectura atenta a este contenido para poder programar el sistema y poder jugar con éxito después.

#### Tabla de contenidos

[TOC]

## Facultades de los personajes

Los personajes disfrutan de las siguientes cualidades:

* un título (`Title`) que les da nombre y que es _inmutable_. Más adelante se muestran rótulos en tamaño grande y pequeño para cada uno de los títulos, en Java, de forma que sea sencillo añadirlos al juego:  `xxx_Title` en tamaño grande para el principio del juego, y `xxx_TitleSmall` en tamaño pequeño, que es muy útil cuando se pregunta por el estatus del juego.[^fn1];
* una energía física (`HealthPower`, abreviado por `HP`) que también puede traducirse por _resistencia física_ y que puede subir o bajar a lo largo del juego según interactúan con los elementos. Sube con la ingesta de unidades de comida (`Food`) no envenenada en un factor que depende del personaje, y baja al abrir puertas o cofres en una cantidad prefijada.
* una energía mágica (`MagicPower`, abreviado por `MP`)  que puede subir o bajar a lo largo del juego según interactúan con los elementos. Sube con la ingesta de unidades de pociones (`Potion`) no envenenada en un factor que depende del personaje.
* una habilidad (destreza) en el acceso (`AccessHability`) que multiplica su fuerza o magia a la hora de superar una puerta o un cofre.

[^fn1]: Los rótulos grandes se han creado con la web [Text to ASCII Art Generator (TAAG)](https://patorjk.com) y las fuentes `Epic` y `Small`, y los parámetros por defecto.

### Valores iniciales de cada personaje

Al comenzar el juego, una vez decidido el tipo de personaje, el sistema sortea aleatoriamente un valor de `HealthPower` y de `MagicPower` dentro de los límites de cada tipo de personaje que son:

* `xxx_MaxHealthPower` y `xxx_MinHealthPower` para la energía física, y
* `xxx_MaxMagicPower` y `xxx_MinMagicPower` para la energía magica.

El sistema puede compensar (o no) los valores iniciales de  magia y energía para no producir casos extremos de cualidades. La aproximación inicial es no compensar si los límites son razonables, pues aunque puede ser importante, sólo lo es al principio del juego; al discurrir el juego, si el escenario está bien diseñado, pierde importancia, jugando un papel más importante los "factores" (`Fac`) y la habilidad de acceso (`AccessHability`) que se verán más adelante en este documento.

## Tipos de personajes

Los personajes del juego, son inicialmente tres (3), equilibrados en magia y energía física:

* `Wizard`, con más magia pero menos fuerza;
* `Fighter`, con más fierza (resistencia) pero menos magia; y
* `Thief` con magia y fuerza menor que los anteriores pero equilibrada.

Según ingieren unidades de comida (`Food`) o de magia (`Potion`) pueden recuperar energía o magia. También pueden perderla si ingieren comida o pociones trampa que se suponen envenenados. La magia y la energía son necesarias para poder abrir cofres y puertas, que restan algo de magia o energía al personaje según se usan. La magia y la energía son necesarias pues si no tienen suficente, no podran abrir cofres ni puertas.

* La energía y la magia se recuperan proporcionalmente a los factores `xxx_FacHealthPower` y `xxx_FacMagicPower`  según encuentran unidades de comida (`Food`) o pociones (`Potion`), respectivamente.
* El término `xxx_AccessAbility` multiplica las facultades del personaje al enfrentarse a una puerta o a un cofre.

## Dinámica de cada personaje

### (a)`Thief` (Ladrón/a)

El/la **ladrón**/a (`Thief`) es un personaje con un equilibrio de fuerza y de magia, con un nivel aproximadamente de la mitad con respecto a los personajes extremos de la escala. Su magia y su poder físico suben linealmente con respecto a las pociones o comida que se encuentran en los cofres.

Es habil para abrir las puertas, lo que quiere decir que requiere menos potencia o magia para abrir una puerta o un cofre que los personajes extremos. Se consigue multiplicando su energía física o magia por una  habilidad de acceso superior a los otros personajes (`xxx_AccessAbility`) y es de 1.5 (3/2).

```java
Thief_Títle = "_________         _________ _______  _______ \n"
            + "\__   __/|\     /|\__   __/(  ____ \(  ____ \\n"
            + "   ) (   | )   ( |   ) (   | (    \/| (    \/\n"
            + "   | |   | (___) |   | |   | (__    | (__    \n"
            + "   | |   |  ___  |   | |   |  __)   |  __)   \n"
            + "   | |   | (   ) |   | |   | (      | (      \n"
            + "   | |   | )   ( |___) (___| (____/\| )      \n"
            + "   )_(   |/     \|\_______/(_______/|/       \n"
            + "                                             ";

Thief_TítleSmall = "  _____ _    _      __ \n"
                 + " |_   _| |_ (_)___ / _|\n"
                 + "   | | | ' \| / -_)  _|\n"
                 + "   |_| |_||_|_\___|_|  \n"
                 + "                       \n";

Thief_MaxHealthPower =  60;
Thief_MinHealthPower =  40;
Thief_FacHealthPower = 100; /* factor 1.0 */
Thief_MaxMagicPower  =  60;
Thief_MinMagicPower  =  40;
Thief_FacMagicPower  = 100; /* factor 1.0 */
Thief_AccessAbility  = 150; /* su HP o MP se multiplica por 3/2 en cofres y puertas */
```

### (b) `Wizard` (Mago/a)

El/la **mago/a** (`Wizard`) es un personaje extremo en la escala de magia con mayor capacidad inicial de magia, pero menos energía física. Según toma pociones, su energía física se repone con un factor de 1.5 (3/2), pero al comer su magia se repone sólo con un factor 0.5 (1/2).

Es habil para abrir las puertas, lo que quiere decir que requiere menos potencia o magia para abrir una puerta o un cofre que los personajes extremos.

```java
Wizard_Títle = "         _________ _______  _______  _______  ______  \n"
             + "|\     /|\__   __// ___   )(  ___  )(  ____ )(  __  \ \n"
             + "| )   ( |   ) (   \/   )  || (   ) || (    )|| (  \  )\n"
             + "| | _ | |   | |       /   )| (___) || (____)|| |   ) |\n"
             + "| |( )| |   | |      /   / |  ___  ||     __)| |   | |\n"
             + "| || || |   | |     /   /  | (   ) || (\ (   | |   ) |\n"
             + "| () () |___) (___ /   (_/\| )   ( || ) \ \__| (__/  )\n"
             + "(_______)\_______/(_______/|/     \||/   \__/(______/ \n"
             + "                                                      ";

Wizard_TítleSmall = " __      ___                _ \n"
                  + " \ \    / (_)_____ _ _ _ __| |\n"
                  + "  \ \/\/ /| |_ / _` | '_/ _` |\n"
                  + "   \_/\_/ |_/__\__,_|_| \__,_|\n"
                  + "                              \n";

Wizard_MaxHealthPower =  40;
Wizard_MinHealthPower =  20;
Wizard_FacHealthPower =  50;  /* factor 1/2 */
wizard_MaxMagicPower  = 100;
wizard_MaxMagicPower  =  85;
Wizard_FacMagicPower  = 150; /* factor 3/2 */
Wizard_AccessAbility  = 100; /* necesita todo el nivel para acceder */
```

###  (c)`Fighter` (Luchador/a)

El/la **luchador/a** (`Fighter`) es un personaje extremo en la escala de energía física con mayor capacidad inicial de energía física, pero menos energía mágica. Según come, su energía física se repone con un factor de 1.5 (3/2), pero al tomar pociones su magia se repone sólo con un factor 0.5 (1/2).

```java
Fighter_Títle = " _______ _________ _______          _________ _______  _______ "
              + "(  ____ \\__   __/(  ____ \|\     /|\__   __/(  ____ \(  ____ )"
              + "| (    \/   ) (   | (    \/| )   ( |   ) (   | (    \/| (    )|"
              + "| (__       | |   | |      | (___) |   | |   | (__    | (____)|"
              + "|  __)      | |   | | ____ |  ___  |   | |   |  __)   |     __)"
              + "| (         | |   | | \_  )| (   ) |   | |   | (      | (\ (   "
              + "| )      ___) (___| (___) || )   ( |   | |   | (____/\| ) \ \__"
              + "|/       \_______/(_______)|/     \|   )_(   (_______/|/   \__/";
                                                               

Fighter_TítleSmall = "  ___ _      _   _           \n"
                   + " | __(_)__ _| |_| |_ ___ _ _ \n"
                   + " | _|| / _` | ' \  _/ -_) '_|\n"
                   + " |_| |_\__, |_||_\__\___|_|  \n"
                   + "       |___/                 ";

Fighter_MaxHealthPower = 100;
Fighter_MinHealthPower =  85;
Fighter_FacHealthPower = 150; /* factor 3/2 */
Fighter_MaxMagicPower  =  20;
Fighter_MinMagicPower  =  10;
Fighter_FacMacicPower  =  50; /* factor 1/2 */
Fighter_AccessAbility  = 100; /* necesita todo el nivel para acceder */
```

**Nota: ** Los bloques anteriores no son código válido. Os daré código de verdad, funcionando en Java.
