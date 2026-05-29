import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class pruebas {

    public static void main(String[] args) throws IOException {
        Tablero tablero = Tablero.ObtenerInstancia();

        tablero.ObtenerLineaJugador();


        Carta loboJoven = new CartaSangre("Lobo Joven", 2, 1, 1);
Carta armadillo = new CartaSangre("Armadillo", 1, 4, 1);
Carta vibora     = new CartaSangre("Víbora", 1, 1, 1);
Carta gato       = new CartaSangre("Gato", 0, 1, 1);

// Coste 2 Sangre
Carta lobo      = new CartaSangre("Lobo", 3, 2, 2);
Carta osoPardo  = new CartaSangre("Oso Pardo", 4, 6, 2);
Carta alce      = new CartaSangre("Alce", 3, 7, 2);

// Coste 3 Sangre
Carta granBlanco = new CartaSangre("Gran Blanco", 4, 2, 3);
Carta zopilote  = new CartaHueso("Zopilote", 1, 1, 1);
Carta cucaracha = new CartaHueso("Cucaracha", 1, 1, 4);
Carta oposum    = new CartaHueso("Oposum", 1, 1, 2);

// Coste medio de Huesos
Carta loboHueso  = new CartaHueso("Lobo Hueso", 2, 2, 5);
Carta murcielago = new CartaHueso("Murciélago", 2, 1, 4);
Carta coyote     = new CartaHueso("Coyote", 2, 1, 4);

// Coste alto de Huesos
Carta gigaEsqueleto = new CartaHueso("Giga-Esqueleto", 4, 1, 7);
Carta reyDeHuesos   = new CartaHueso("Rey de Huesos", 2, 6, 8);

tablero.ObtenerLineaJugador().getHuecos()[0]=lobo;
tablero.ObtenerLineaJugador().getHuecos()[1]=alce;
tablero.ObtenerLineaJugador().getHuecos()[2]=osoPardo;
tablero.ObtenerLineaLeshy().getHuecos()[0]=oposum;
tablero.ObtenerLineaLeshy().getHuecos()[2]=reyDeHuesos;
tablero.ObtenerLineaLeshy().getHuecos()[3]=gigaEsqueleto;
tablero.ObtenerLineaTraseraLeshy().getHuecos()[1]=murcielago;
tablero.ObtenerLineaTraseraLeshy().getHuecos()[3]=coyote;
Balanza.imprimirBalanza();
System.out.println(tablero);
tablero.ObtenerLineaJugador().activarLinea(Turno.JUGADOR);
Balanza.imprimirBalanza();
tablero.ObtenerLineaLeshy().activarLinea(Turno.LESHY);
ArrayList<Carta> mazo = Jugador.getMazoActual();
Balanza.imprimirBalanza();

// 2. Añadimos la carta al principio (o al final, según tu juego)
mazo.add(0, granBlanco);
mazo.get(0);
Carta cartaALanzar = mazo.get(0);
cartaALanzar.lanzarCarta();
System.out.println(tablero);
tablero.ObtenerLineaJugador().activarLinea(Turno.JUGADOR);
Balanza.imprimirBalanza();
System.out.println(tablero);
    }
    
}
