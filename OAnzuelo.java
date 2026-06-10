public class OAnzuelo extends ObjetoCarta {

    private static OAnzuelo Instancia;

    private OAnzuelo(String nombre,String descripcion) {
       super( nombre, descripcion);
    }

    
    public static OAnzuelo ObtenerInstancia(){

if(Instancia==null){Instancia=new OAnzuelo("anzuelo"," Engancha una de mis tarjetas y tómala como tuya. Debes tener un espacio libre a tu lado para recibirla.");}

return Instancia;

    }

    @Override
    public void usarObjeto(int posicion){

Linea linea = Tablero.ObtenerInstancia().ObtenerLineaLeshy();

if(linea.getHuecos()[posicion]==null){System.out.println("No hay carta en esta posicion");}

else{
    
    if(Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[posicion]!=null){System.out.println("Ya hay una carta ocupando esta posición!");}
    else{
        Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[posicion]=linea.getHuecos()[posicion].clone();
    linea.getHuecos()[posicion]=null;
    System.out.println("Carta Robada!");
    super.usarObjeto(posicion);
    }
}


    }
    
}
