import java.util.ArrayList;

public class SVelocista extends Sello{

    
     private static SVelocista instancia;

    private SVelocista(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SVelocista ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SVelocista("velocista",Etapa.FIN_TURNO,false);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

        if(turno==Turno.JUGADOR){

            Linea linea = Tablero.ObtenerInstancia().ObtenerLineaJugador();
        }

        else{Linea linea = Tablero.ObtenerInstancia().ObtenerLineaLeshy();}

        if(!contieneMovimiento(esta)){

            esta.getSellos().add(new SVelocistaD());
        }

        

        

        

        if(posicion==3 && !izquierda(esta)){

            eliminarMovimiento(esta);
            esta.getSellos().add(new SVelocistaI());


        }

         if(posicion==0 && !derecha(esta)){

            eliminarMovimiento(esta);
            esta.getSellos().add(new SVelocistaD());


        }


        


    }

    public static void eliminarMovimiento(Carta c){

        ArrayList<Sello> s = new ArrayList<>();

        for(Sello a : c.getSellos()){

            if(a.getClass()==SVelocistaD.class || a.getClass()==SVelocistaI.class){s.add(a);}
        }
        c.getSellos().removeAll(s);
        s.clear();
    }

     public static boolean contieneMovimiento(Carta c){

    

        for(Sello a : c.getSellos()){

            if(a.getClass()==SVelocistaD.class || a.getClass()==SVelocistaI.class){return true;}
        }
        return false;
       
    }

    public static boolean derecha(Carta c){

    

        for(Sello a : c.getSellos()){

            if(a.getClass()==SVelocistaD.class ){return true;}
        }
        return false;
       
    }

    public static boolean izquierda(Carta c){

    

        for(Sello a : c.getSellos()){

            if(a.getClass()==SVelocistaI.class ){return true;}
        }
        return false;
       
    }
    
}
