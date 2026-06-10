import java.util.ArrayList;
import java.util.Scanner;

public class CartaHueso extends Carta implements Cloneable {

    private int coste_Hueso;


    public CartaHueso(String nombre, int atk, int hp, ArrayList<Sello> sellos, int coste_Hueso) {
        super(nombre, atk, hp, sellos);
        this.coste_Hueso = coste_Hueso;
    }

    public CartaHueso(String nombre, int atk, int hp, int coste_Hueso) {
        super(nombre, atk, hp);
        this.coste_Hueso = coste_Hueso;
    }

    public CartaHueso() {
        super();
        this.coste_Hueso =0;
    }

    public int getCoste_Hueso() {
        return coste_Hueso;
    }

    public void setCoste_Hueso(int coste_Hueso) {
        this.coste_Hueso = coste_Hueso;
    }

public CartaHueso clone(){

CartaHueso clon = (CartaHueso) super.clone();
clon.coste_Hueso=this.coste_Hueso;

return clon;
}

public String toString(){

    return super.toString();
}

 public int lanzarCarta(){
    int posicion=-1;

if(super.lanzarCarta()==0){

    System.out.println("No hay huecos en tu linea!");
    return -1;
}

Scanner n = new Scanner(System.in);
System.out.println("Quiere cancelar la accion? (s/n) \n");
String d = n.nextLine();

if(d.toLowerCase().equals("s")){

    return -1;
}


if(Jugador.getHuesos()<this.getCoste_Hueso()){

    System.out.println("Huesos insuficientes!");
    return -1;
}

Jugador.setHuesos(Jugador.getHuesos()-this.getCoste_Hueso());

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

Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[posicion]=this;
    Jugador.quitarDeMano(this);
    comprobar=false;
}
}
return posicion;
    }
@Override
     public int nCoste(){

        return this.getCoste_Hueso();
    }

    public String getTipo(){

        return "hueso";
    }
    
}
