public class OHucha extends ObjetoGeneral {

     private static OHucha Instancia;

    private OHucha(String nombre,String descripcion) {
         super( nombre, descripcion);
    }

    
    public static OHucha ObtenerInstancia(){

if(Instancia==null){Instancia=new OHucha("hucha","Ganarás inmediatamente 4 huesos .");}

return Instancia;

    }

    @Override
    public void usarObjeto(){



Jugador.setHuesos(Jugador.getHuesos()+4);


    System.out.println("Obtienes 4 huesos!");
    super.usarObjeto();



    }
    
}
