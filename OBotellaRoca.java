import java.util.ArrayList;

public class OBotellaRoca extends ObjetoGeneral {

     private static OBotellaRoca Instancia;

    private OBotellaRoca(String nombre,String descripcion) {
         super( nombre, descripcion);
    }

    
    public static OBotellaRoca ObtenerInstancia(){

if(Instancia==null){Instancia=new OBotellaRoca("rocaembotellada"," Se crea una Roca en tu mano.");}

return Instancia;

    }

    @Override
    public void usarObjeto(){



Jugador.getMano().add(new CartaSeca("Roca", 0, 5, new ArrayList<Sello>()));


    System.out.println("Obtienes una roca en tu mano!");
    super.usarObjeto();



    }
    
}
