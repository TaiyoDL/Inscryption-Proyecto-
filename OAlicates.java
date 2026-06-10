public class OAlicates extends ObjetoGeneral {

    private static OAlicates Instancia;

    private OAlicates(String nombre,String descripcion) {
         super( nombre, descripcion);
    }

    
    public static OAlicates ObtenerInstancia(){

if(Instancia==null){Instancia=new OAlicates("alicates","Colocará un peso en la báscula. El dolor es temporal.");}

return Instancia;

    }

    @Override
    public void usarObjeto(){

        System.out.println("Te quitas 1 diente y empujas la balanza!");

        Balanza.empujar(1);



        super.usarObjeto();

        
    }




    
}
