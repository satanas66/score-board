# Football World Cup Score Board

## Proyecto score-board

El siguiente proyecto se realiza siguiendo los requerimientos del documento **Coding Exercise v1.6.pdf** que se
encuentra localizado en el directorio de recursos.

### Breve análisis sobre el documento de requisitos

Una vez revisado y analizado el documento expongo la siguiente propuesta para la implementación que llevaré a cabo.

#### 1.Como primera instancia se reconocen dos entes de dominio:

Clase Team

Clase que identifica a un equipo y estará compuesta por dos atributos (name y score) y su representación (toString)
será:

* name score

Clase Game

Clase que identifica a un juego entre dos equipos y estará compuesta por atributos (idGame, Team1, Team2, tie) y se
podrá representar (toString) de dos formas:

* a. teamName1 - teamName2: teamScore1 teamScore2 => Será usada tanto para el inicio como para la actualización de las
  puntuaciones

* b. teamName1 teamScore1 - teamName2 teamScore2 => Será usada para proporcionar el resumen de partidos cuando vayan
  finalizando

#### 2.Como segunda instancia se reconocen cuatro casos de uso:

* StartGame: Será implementado mediante la función startGame(name1, name2) que recibirá por parámetro dos nombres de
  equipos. Esta función no devolverá nada.

* FinishGame: Será implementado mediante la función finishGame(idGame) que recibirá como parámetro el identificador del
  juego a eliminar. Esta función no devolverá nada.

* UpdateGame: Será implementado mediante la función updateGame(idGame, score1, score2) que recibirá como parámetros el
  identificador del juego y las puntuaciones de los dos equipos. Esta función no devolverá nada.

* summaryGame(): Será implementado mediante la función summaryGames() y su resultado final será un listado de equipos
  formateados mediante la segunda representación de la clase Game.

#### 3. Interfaz y Clase de Servicio

Interfaz ScoreBoard: Interfaz en la que se definen los casos de uso descritos en el punto 2.

Clase ScoreBoardImpl que implementa a la interfaz ScoreBoard. Esta clase será la encargada de hacer el tratamiento de
datos y servir las respuestas solicitadas en el documento de requisitos.

### Tecnología usada

* IDE Intellij Ultimate 2020.3
* maven 3.6.3
* jdk 11: Kit de desarrollo
* junit 5.8.2
* assertj 2.22.2
* jacoco 0.8.5
* SonarLint
* Git

### Pruebas e implementación de código

#### 1. Durante la construcción en implementación de código:

* Uso la metodología de diseño software Test Driven Development **TDD** siguiendo los pasos **RED-GREEN-REFACTOR**.
* Uso la herramienta de cobertura de pruebas **jacoco**.
* Antes de subir el código al uso la herramienta SonarLint.
* Cada clase tiene su respectiva clase de test.

#### 2. Generación de librería

* Para la generación de la librería basta con ejecutar el comando **mvn clean install**

#### 3. Notas

* Creo que todas las funciones deberían devolver una lista para saber qué está sucediendo en cada momento.
* Para solventar el inconveniente del punto 1 proporciono un mapa (initialScoreBoard) que se irá modificando mientras se
  van añadiendo juegos o actualizando puntuaciones y de esta forma los usuarios podrán consultar el estado de los juegos
  en cada momento.
* En la implementación que proporciono no se admiten juegos repetidos.
* Para identificar un juego se usarán las 4 primeras letras del nombre de cada equipo unidas por un guion bajo.
* Para finalizar o actualizar un juego se necesita del identificador del juego, este identificador se podrá recuperar
  del mapa initialScoreBoard.
* Cuando se finalice un juego este desaparecerá del mapa initialScoreBoard pero se generará una copia en un mapa final
  que se usará para consultar el resumen de juegos.
* Como no queda claro en el documento qué pasa cuando finaliza un juego. ¿Se puede modificar un juego una vez
  finalizado?. En esta implementación no se actualizan juegos finalizados.

### Author
* *****Edwin Patricio Arévalo Angulo*****
* *edwinarevaloangulo@gmail.com*
 


