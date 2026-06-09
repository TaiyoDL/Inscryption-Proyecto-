import java.util.ArrayList;

public class SColmena extends Sello {

    private static SColmena instancia;

    private SColmena(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SColmena ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SColmena("colmena",Etapa.RECIBIR,false);
        }
        return instancia;
    }

@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

if(turno==Turno.JUGADOR){

ArrayList<Sello> s = (ArrayList<Sello>) esta.getSellos().clone();
    s.remove(Sellos_in_game.buscarSello("colmena"));

    CartaSangre a = new CartaSangre("Abeja", 1, 1,s,0);



    if(!esta.esVolador()){a.getSellos().add(Sellos_in_game.buscarSello("volador"));}
        Jugador.getMano().add(a);
        System.out.println("Has recibido una abeja");
}
    }
    
}
