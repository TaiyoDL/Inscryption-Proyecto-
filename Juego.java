import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Juego {

    public static void main(String[] args) throws IOException {
        
        Partida.cargarJuego();
        Random m = new Random();
        ArrayList<Carta> rival = new ArrayList<>();

        for(int i=0;i<11;i++){

Jugador.getMazo().add(Partida.getCartasJuego().get(m.nextInt(0,Partida.getCartasJuego().size())));
rival.add(Partida.getCartasJuego().get(m.nextInt(0,Partida.getCartasJuego().size())));

        }
        
Jugador.anadirObjeto(Objetos_In_Game.getObjetos().get(m.nextInt(0,Objetos_In_Game.getObjetos().size())));




        Pelea.batalla(rival);

        
    }
    
}
