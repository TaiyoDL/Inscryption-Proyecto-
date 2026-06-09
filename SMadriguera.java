import java.util.ArrayList;

public class SMadriguera extends Sello{

     private static SMadriguera instancia;

    private SMadriguera(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SMadriguera ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SMadriguera("madriguera",Etapa.LANZAR,false);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

if(turno==Turno.JUGADOR){

    ArrayList<Sello> s = (ArrayList<Sello>) esta.getSellos().clone();
    s.remove(Sellos_in_game.buscarSello("madriguera"));
        Jugador.getMano().add(new CartaSangre("Conejo", 0, 1,s,0));
         System.out.println("Has recibido un conejo");
}
    }
    
}
