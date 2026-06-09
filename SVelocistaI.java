public class SVelocistaI extends Sello{

     public SVelocistaI(){super();}

    @Override
    public void usarSello(Carta esta,int posicion,Turno turno){
        Linea linea;

        if(turno==Turno.JUGADOR){

             linea = Tablero.ObtenerInstancia().ObtenerLineaJugador();
        }

        else{ linea = Tablero.ObtenerInstancia().ObtenerLineaLeshy();}
        

if(posicion==0){}

else{
if(linea.getHuecos()[posicion-1]==null){

    linea.getHuecos()[posicion-1]=esta.clone();
    linea.getHuecos()[posicion]=null;
}
    
}

    }
    
}
