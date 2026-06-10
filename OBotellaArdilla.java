import java.util.ArrayList;

public class OBotellaArdilla extends ObjetoGeneral {

    private static OBotellaArdilla Instancia;

    private OBotellaArdilla(String nombre,String descripcion) {
         super( nombre, descripcion);
    }

    
    public static OBotellaArdilla ObtenerInstancia(){

if(Instancia==null){Instancia=new OBotellaArdilla("ardillaembotellada"," Se crea una ardilla en tu mano.");}

return Instancia;

    }

    @Override
    public void usarObjeto(){



Jugador.getMano().add(new CartaSangre("Ardilla", 0, 1,0));


    System.out.println("Obtienes una ardilla en tu mano!");
    super.usarObjeto();



    }
    
}
