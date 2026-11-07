# Inscryption-Proyecto

Juego de cartas por turnos en **consola**, desarrollado en **Java**, inspirado en el juego *Inscryption*. Es un proyecto personal de aprendizaje y no tiene relación con sus creadores.

> **Estado:** versión beta (v2.0). Es jugable de principio a fin en una pelea, pero aún faltan por probar casos poco habituales.

## ¿De qué trata?

El jugador se enfrenta a un rival (Leshy) en un tablero de cartas. Cada carta tiene ataque y vida, un coste (sangre o huesos) y, opcionalmente, uno o varios **sellos** con habilidades especiales. Gana quien rompe el equilibrio de la balanza de daño.

## Qué incluye

- Combate por turnos con tablero de varias líneas (jugador, rival y línea trasera del rival).
- Mazo del jugador, mano, ardillas como recurso y fase de robo.
- Cartas con distintos costes: `CartaSangre` y `CartaHueso`.
- Más de 15 sellos con efectos que se activan en distintos momentos del turno (inicio, ataque, recibir daño, fin de turno, muerte o al lanzarlos).
- 8 objetos de un solo uso (tijeras, daga, alicates, anzuelo, botellas, hucha…).
- Catálogo de unas 59 cartas definido en un fichero de texto (`Cartas.txt`), cargado al iniciar.

## Cómo está construido

| Aspecto | Solución |
|---|---|
| Lenguaje | Java (solo librería estándar) |
| Interfaz | Consola (`Scanner` / `System.out`) |
| Herencia | `Carta` → `CartaSangre`, `CartaHueso`, `CartaSeca` · `Objeto` → `ObjetoGeneral`, `ObjetoCarta` |
| Habilidades | Clase base `Sello`; cada habilidad es una subclase (`SVolador`, `SEspinoso`, `SDobleGolpe`…) |
| Momentos del turno | Enumerados `Etapa` y `Turno` |
| Tablero | Patrón Singleton (`Tablero`) |
| Datos de las cartas | Fichero de texto con campos separados por `#` (nombre, ataque, vida, coste, tipo de coste, sellos) |

Ejemplo de línea de `Cartas.txt`:

```text
Lobo Tullido#2#2#3#sangre#
```

## Estructura del código

```text
Juego.java            Punto de entrada (main)
Partida.java          Carga de cartas desde Cartas.txt
Pelea.java            Bucle del combate
Tablero.java / Linea  Estado del tablero
Jugador.java          Mazo, mano, objetos y ardillas
Carta*.java           Tipos de carta
S*.java / Sello*.java Sellos y su registro
O*.java / Objeto*.java Objetos y su registro
Balanza.java          Marcador de daño
Cartas.txt            Catálogo de cartas
```

## Cómo ejecutarlo

Requisitos: JDK instalado (Java 17 o superior, ya que usa `Random.nextInt(min, max)`).

```bash
javac *.java
java Juego
```

Ejecuta el programa desde la carpeta del proyecto: el fichero `Cartas.txt` se busca con una ruta relativa de estilo Windows (`.\Cartas.txt`).

## Lo que he practicado

- Programación orientada a objetos: herencia, clases abstractas, polimorfismo y enumerados.
- Diseño de un sistema extensible (añadir un sello nuevo es crear una clase y registrarla).
- Lectura de ficheros de texto y parseo de datos.
- Control de versiones con Git (20 commits entre mayo y junio de 2026).

## Pendiente / ideas

- Probar más casos del combate y corregir errores que aparezcan.
- Ruta de `Cartas.txt` independiente del sistema operativo.
- Añadir más sellos y objetos.
