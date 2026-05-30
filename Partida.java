import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Partida {

    private static ArrayList<Carta> cartasJuego = new ArrayList<>();

    public static void cargarCartas() throws IOException{

try (BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\Proyecto_Inscryption\\Inscryption-Proyecto-\\Cartas.txt"))) {
    String linea = bf.readLine();
    
    while(linea!=null){
    
    String[] formar=linea.split("#");
    if(formar[4].toLowerCase().trim().equals("hueso")){
    
        Partida.cartasJuego.add(new CartaHueso(formar[0],Integer.parseInt(formar[1]),Integer.parseInt(formar[2]),Integer.parseInt(formar[3])));
    }
    else{
    
        Partida.cartasJuego.add(new CartaSangre(formar[0],Integer.parseInt(formar[1]),Integer.parseInt(formar[2]),Integer.parseInt(formar[3])));
    }
    linea=bf.readLine();
    }
    
    bf.close();
} catch (NumberFormatException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
    }

    public static ArrayList<Carta> getCartasJuego() {
        return cartasJuego;
    }

    
    
}
