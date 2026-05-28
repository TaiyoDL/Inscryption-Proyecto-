import java.util.ArrayList;
import java.util.Scanner;
public class CartaSangre extends Carta implements Cloneable {

    private int coste_Sangre;

    public CartaSangre(String nombre, int atk, int hp, ArrayList<Sello> sellos, int coste_Sangre) {
        super(nombre, atk, hp, sellos);
        this.coste_Sangre = coste_Sangre;
    }

    public CartaSangre(String nombre, int atk, int hp, int coste_Sangre) {
        super(nombre, atk, hp);
        this.coste_Sangre = coste_Sangre;
    }

    public CartaSangre() {
        super();
        this.coste_Sangre =0;
    }

    public int getCoste_Sangre() {
        return coste_Sangre;
    }

    public void setCoste_Sangre(int coste_Sangre) {
        this.coste_Sangre = coste_Sangre;
    }

    public boolean lanzarCarta(){
Scanner n = new Scanner(System.in);
System.out.println("Quiere cancelar la accion? (s/n) \n");
String d = n.nextLine();

if(d.toLowerCase().equals("s")){

    return false;
}




if (this.getCoste_Sangre()>Tablero.ObtenerInstancia().contarSangreLinea()){
System.out.println("Sangre en campo insuficiente \n");
    return false;
}

int sangre=0;
while(sangre<this.getCoste_Sangre()){
System.out.println("Sacrifica!(Pon el numero de la posicion) ("+sangre+"\\"+this.getCoste_Sangre()+")");

int p = n.nextInt();
if(p>3){p=3;}
if(p<0){p=0;}
n.nextLine();
if(Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[p]==null){
    System.out.println("No hay carta en esta posición");
}
else{

    sangre+=Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[p].sacrificar();
}
    
}

boolean comprobar=true;
while(comprobar){
System.out.println("Donde quieres colocar la carta?");
int posicion=n.nextInt();
if(posicion>3){posicion=3;}
if(posicion<0){posicion=0;}
n.nextLine();

if(Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[posicion]!=null){

    
}
else{

Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[posicion]=this.clone();
    Jugador.quitarDelMazo(this);
    comprobar=false;
}
}
return true;
    }
@Override
public CartaSangre clone() {
    // Ahora esto SÍ funcionará porque el padre usará el mecanismo de Object
    CartaSangre clon = (CartaSangre) super.clone();
    clon.coste_Sangre = this.coste_Sangre;
    return clon;
}
    
}
