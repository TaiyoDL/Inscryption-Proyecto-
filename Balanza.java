public class Balanza {

    private static int puntos = 0;

    private Balanza() {
    }

    public static int getPuntos() {
        return puntos;
    }

    public static void empujar(int peso) {

        Balanza.puntos += peso;
    }

    public static int resultado() {

        if (puntos >= 5) {
            Jugador.aumentarDientes(puntos - 5);
            return 1;
        }

        else if (puntos <= -5) {
            return -1;
        }

        return 0;
    }

}
