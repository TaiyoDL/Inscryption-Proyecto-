public class OTijeras extends ObjetoCarta {

    private static OTijeras Instancia;

    private OTijeras(String nombre,String descripcion) {
         super( nombre, descripcion);
    }

    
    public static OTijeras ObtenerInstancia(){

if(Instancia==null){Instancia=new OTijeras("tijeras","Puedes cortar una de las cartas de tu adversario");}

return Instancia;

    }

    @Override
    public void usarObjeto(int posicion){

Linea linea = Tablero.ObtenerInstancia().ObtenerLineaLeshy();

if(linea.getHuecos()[posicion]==null){System.out.println("No hay carta en esta posicion");}

else{linea.getHuecos()[posicion]=null;
    System.out.println("Carta cortada!");
    super.usarObjeto(posicion);
}


    }
}
