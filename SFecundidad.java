import java.util.ArrayList;

public class SFecundidad extends Sello {

    private static SFecundidad instancia;

    private SFecundidad(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SFecundidad ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SFecundidad("fecundidad",Etapa.LANZAR,false);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

if(turno==Turno.JUGADOR){

    
    
        Jugador.getMano().add(esta.clone());
         System.out.println("Vuelves a tener la carta en tu mano!");
}
    }
    
}
