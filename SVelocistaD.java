public class SVelocistaD extends Sello{

     

    public SVelocistaD() {
        super("velocistaD",Etapa.FIN_TURNO,false);
        
    }

    

    @Override
    public void usarSello(Carta esta,int posicion,Turno turno){
        Linea linea;

        if(turno==Turno.JUGADOR){

             linea = Tablero.ObtenerInstancia().ObtenerLineaJugador();
        }

        else{ linea = Tablero.ObtenerInstancia().ObtenerLineaLeshy();}
        

if(posicion==3){}

else{
if(linea.getHuecos()[posicion+1]==null){

    

    linea.getHuecos()[posicion+1]=esta.clone();
    linea.getHuecos()[posicion]=null;
}
    
}

    }
    
}
