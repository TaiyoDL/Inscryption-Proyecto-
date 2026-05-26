import java.util.ArrayList;
import java.util.Collections;

public class Jugador {

    private static int dientes=0;
    private static ArrayList<Objeto> mochila;
    private static ArrayList<Carta> mano;
    private static ArrayList<Carta> mazo;
    private static ArrayList<Carta> mazoActual;

public static void aumentarDientes(int c){

Jugador.dientes+=c;
}

public static void gastarDientes(int c){

if(c<=Jugador.dientes){Jugador.dientes-=c;}
}

public static int getDientes() {
    return dientes;
}

public static boolean anadirObjeto(Objeto o){

if(Jugador.getMochila().size()>=3){

    return false;
}

Jugador.getMochila().add(o);
return true;

}

public static ArrayList<Objeto> getMochila() {
    return mochila;
}

public static ArrayList<Carta> getMano() {
    return mano;
}

public static ArrayList<Carta> getMazo() {
    return mazo;
}

public static ArrayList<Carta> getMazoActual() {
    return mazoActual;
}

public static void cargarMazo(){

for(Carta c :Jugador.getMazo()){
Jugador.getMazoActual().add(c.clone());

}

Collections.shuffle(Jugador.getMazoActual());

}

public static void manoInicial(){

for(int i=0;i<3;i++){

    Jugador.getMano().add(Jugador.getMazoActual().get(i));
}

}
    
}
