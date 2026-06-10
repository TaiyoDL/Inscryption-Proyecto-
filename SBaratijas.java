import java.util.ArrayList;
import java.util.Random;

public class SBaratijas extends Sello {

    private static SBaratijas instancia;

    private SBaratijas(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SBaratijas ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SBaratijas("baratijas",Etapa.LANZAR,false);
        }
        return instancia;
    }

@Override
    public void usarSello(Carta esta,int posicion,Turno turno){
        Random m = new Random();

if(turno==Turno.JUGADOR){

    Objeto o = Objetos_In_Game.getObjetos().get(m.nextInt(0,Objetos_In_Game.getObjetos().size()));
    System.out.println("Has recibido un "+o.getNombre());
Jugador.anadirObjeto(o);

}
    }
    
}
