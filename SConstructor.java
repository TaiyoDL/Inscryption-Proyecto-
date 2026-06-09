import java.util.ArrayList;

public class SConstructor extends Sello {

     private static SConstructor instancia;

    private SConstructor(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SConstructor ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SConstructor("constructor",Etapa.LANZAR,false);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

Linea linea;

        if(turno==Turno.JUGADOR){

             linea = Tablero.ObtenerInstancia().ObtenerLineaJugador();
        }

        else{ linea = Tablero.ObtenerInstancia().ObtenerLineaLeshy();}



    ArrayList<Sello> s = (ArrayList<Sello>) esta.getSellos().clone();
    s.remove(Sellos_in_game.buscarSello("constructor"));

if(linea.getHuecos()[posicion-1]==null){

    linea.getHuecos()[posicion-1]= (new CartaSeca("Presa", 0, 2,s));
}

if(linea.getHuecos()[posicion+1]==null){

    linea.getHuecos()[posicion+1]= (new CartaSeca("Presa", 0, 2,s));
}

      
         

    }
    
}
