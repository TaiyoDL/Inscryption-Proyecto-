import java.util.ArrayList;
import java.util.Collections;

public class Jugador {

    private static int dientes=0;
   private static ArrayList<Objeto> mochila = new ArrayList<>();
private static ArrayList<Carta> mano = new ArrayList<>();
private static ArrayList<Carta> mazo = new ArrayList<>();
private static ArrayList<Carta> mazoActual = new ArrayList<>();
private static ArrayList<Carta> ardillas = new ArrayList<>();
private static int huesos=0;

public static void aumentarDientes(int c){

Jugador.dientes+=c;
}



public static int getHuesos() {
    return huesos;
}



public static void setHuesos(int huesos) {
    Jugador.huesos = huesos;
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
    Jugador.getMazoActual().remove(Jugador.getMazoActual().get(i));
}

}

public static void cargarArdillas(){

for(int i=0;i<12;i++){

    Jugador.getArdillas().add(CartaSangre.crearArdilla());
}

}

public static ArrayList<Carta> getArdillas() {
    return ardillas;
}

public static void cogerCarta(Carta c){
Jugador.mano.add(c);
Jugador.mazoActual.remove(c);
}

public static void quitarDeMano(Carta c){

Jugador.mano.remove(c);
}

public static void mostrarMano(){

    for(Carta c : Jugador.getMano()){

        System.out.println((Jugador.getMano().indexOf(c)+1)+":"+c+" coste: "+c.nCoste()+" "+c.getTipo());
    }
    System.out.println();
}
public static void cogerArdilla(){

    Jugador.mano.add(Jugador.getArdillas().get(0));
Jugador.ardillas.remove(Jugador.getArdillas().get(0));
}

public static void inicioPartida(){

Jugador.cargarMazo();
Jugador.cargarArdillas();
Jugador.setHuesos(0);
Balanza.inicio();
Jugador.manoInicial();

}
    
}
