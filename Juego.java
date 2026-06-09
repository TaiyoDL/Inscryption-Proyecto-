import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {

    public static void main(String[] args) throws IOException {
        
        Partida.cargarCartas();
        Random m = new Random();
        ArrayList<Carta> rival = new ArrayList<>();

        for(int i=0;i<11;i++){

Jugador.getMazo().add(Partida.getCartasJuego().get(m.nextInt(0,Partida.getCartasJuego().size())));
rival.add(Partida.getCartasJuego().get(m.nextInt(0,Partida.getCartasJuego().size())));

        }
        


        Pelea.batalla(rival);

        
    }
    
}
