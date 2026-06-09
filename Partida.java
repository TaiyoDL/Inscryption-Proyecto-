import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Partida {

    private static ArrayList<Carta> cartasJuego = new ArrayList<>();

    public static void cargarCartas() throws IOException{
        Sellos_in_game.cargarSellos();

try (BufferedReader bf = new BufferedReader(new FileReader(".\\Cartas.txt"))) {
    String linea = bf.readLine();
    
    while(linea!=null){
        ArrayList<Sello> sellos = new ArrayList<>();
    
    String[] formar=linea.split("#",-1);
    if(formar[5]!=null && !formar[5].isEmpty()){
    String[] formarSellos=formar[5].split(",");
    sellos=anadirSellos(formarSellos);

    }
    if(formar[4].toLowerCase().trim().equals("hueso")){
    
        Partida.cartasJuego.add(new CartaHueso(formar[0],Integer.parseInt(formar[1]),Integer.parseInt(formar[2]),(ArrayList<Sello>)sellos.clone(),Integer.parseInt(formar[3])));
    }
    else{
    
        Partida.cartasJuego.add(new CartaSangre(formar[0],Integer.parseInt(formar[1]),Integer.parseInt(formar[2]),(ArrayList<Sello>)sellos.clone(),Integer.parseInt(formar[3])));
    }
    sellos.clear();
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

    

    public static ArrayList<Sello> anadirSellos(String[] nSellos){
        ArrayList<Sello> s = new ArrayList<>();

        for(int i=0;i<nSellos.length;i++){

            s.add(Sellos_in_game.buscarSello(nSellos[i].toLowerCase()));


        }
        return s;
    }
    
}
