public class ODaga extends ObjetoGeneral {

    private static ODaga Instancia;

    private ODaga(String nombre,String descripcion) {
         super( nombre, descripcion);
    }

    
    public static ODaga ObtenerInstancia(){

if(Instancia==null){Instancia=new ODaga("daga","Colocará un peso en la báscula. El dolor es temporal.");}

return Instancia;

    }

    @Override
    public void usarObjeto(){

        System.out.println("Te quitas 1 ojo y empujas la balanza!");

        Balanza.empujar(4);



        super.usarObjeto();

        
    }




    
}

    

