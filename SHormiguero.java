import java.util.ArrayList;

public class SHormiguero extends Sello{


    private static SHormiguero instancia;

    private SHormiguero(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SHormiguero ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SHormiguero("hormiguero",Etapa.LANZAR,false);
        }
        return instancia;
    }

@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

if(turno==Turno.JUGADOR){



    Jugador.getMano().add(new CartaSangre("Hormiga", 1, 2,1));



    
       
        System.out.println("Has recibido una Hormiga");
}
    }
    


    
}
