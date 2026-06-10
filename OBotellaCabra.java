import java.util.ArrayList;

public class OBotellaCabra extends ObjetoGeneral{

    private static OBotellaCabra Instancia;

    private OBotellaCabra(String nombre,String descripcion) {
         super( nombre, descripcion);
    }

    
    public static OBotellaCabra ObtenerInstancia(){

if(Instancia==null){Instancia=new OBotellaCabra("cabraembotellada","Se crea una Cabra Negra en tu mano.");}

return Instancia;

    }

    @Override
    public void usarObjeto(){

ArrayList<Sello> a = new ArrayList<>();
a.add(Sellos_in_game.buscarSello("sacrificiodigno"));

Jugador.getMano().add(new CartaSangre("Cabra negra", 0, 1,a,1));


    System.out.println("Obtienes una Cabra negra en tu mano!");
    super.usarObjeto();



    }
    
}
