public class Tablero {
    private static Tablero instancia; 
    private static Linea jugador; 
     private static Linea leshy;

    private Tablero() { } 

    public static Tablero ObtenerInstancia()
    {
        if (instancia == null) 
        {
            instancia = new Tablero(); 
        }
        return instancia; 
    }

    public static Tablero get_instancia() {
        return instancia;
    }

    public static void set_instancia(Tablero instancia) {
        Tablero.instancia = instancia;
    }

    public static Linea ObtenerLineaJugador()
    {
        if (jugador == null) 
        {
            jugador = new Linea(); 
        }
        return jugador; 
    }

   public static Linea ObtenerLineaLeshy()
    {
        if (leshy == null) 
        {
            leshy = new Linea(); 
        }
        return leshy; 
    }

    public void activarSellosInicio(Turno turno){
Linea activar;
        if(turno==Turno.JUGADOR){activar=Tablero.ObtenerLineaJugador();}

        else{activar=Tablero.ObtenerLineaLeshy();}

        for(Carta c: activar.getHuecos()) {

if(c==null){}

else{

    for(Sello s : c.getSellos()){

        if(s!=null && s.getEtapa()==Etapa.INICIO_TURNO){

            s.usarSello();
        }
    }
}

        }



    }

     public void activarSellosFinal(Turno turno){
Linea activar;
        if(turno==Turno.JUGADOR){activar=Tablero.ObtenerLineaJugador();}

        else{activar=Tablero.ObtenerLineaLeshy();}

        for(Carta c: activar.getHuecos()) {

if(c==null){}

else{

    for(Sello s : c.getSellos()){

        if(s!=null && s.getEtapa()==Etapa.FIN_TURNO){

            s.usarSello();
        }
    }
}

        }



    }

    
}
