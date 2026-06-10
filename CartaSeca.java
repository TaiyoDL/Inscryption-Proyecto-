import java.util.ArrayList;
import java.util.Scanner;

public class CartaSeca extends Carta implements Cloneable {

    public CartaSeca(String nombre, int atk, int hp, ArrayList<Sello> sellos) {
        super(nombre, atk, hp, sellos);
        this.setCantidad_Huesos(0);
        this.setCantidad_Sangre(0);
    }

     public int lanzarCarta(){
        int posicion=-1;
Scanner n = new Scanner(System.in);
System.out.println("Quiere cancelar la accion? (s/n) \n");
String d = n.nextLine();

if(d.toLowerCase().equals("s")){

    return -1;
}






int sangre=0;

System.out.println("Sacrifica!(Pon el numero de la posicion) ("+sangre+"\\"+0+")");

int p = n.nextInt()-1;
if(p>3){p=3;}
if(p<0){p=0;}
n.nextLine();
if(Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[p]==null){
    System.out.println("No hay carta en esta posición");
}
else{

    sangre+=Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[p].sacrificar();
}
    


if(super.lanzarCarta()==0){

    System.out.println("No hay huecos para lanzar la carta!");
    return -1;
}

boolean comprobar=true;
while(comprobar){
System.out.println("Donde quieres colocar la carta?");
 posicion=n.nextInt()-1;
if(posicion>3){posicion=3;}
if(posicion<0){posicion=0;}
n.nextLine();

if(Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[posicion]!=null){

    
}
else{

Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[posicion]=this.clone();
    Jugador.quitarDeMano(this);
    comprobar=false;
}
}
return posicion;
    }

    public int sacrificar(){

        
       return this.getCantidad_Sangre();
    }

   

    
    
}
