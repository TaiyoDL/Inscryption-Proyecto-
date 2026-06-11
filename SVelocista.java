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
        

       Linea linea; 
        if (turno == Turno.JUGADOR) {
            linea = Tablero.ObtenerInstancia().ObtenerLineaJugador();
        } else {
            linea = Tablero.ObtenerInstancia().ObtenerLineaLeshy();
        }

        
        if (!contieneMovimiento(esta)) {
         
            esta.getSellos().add(new SVelocistaD());

            for(Sello s : esta.getSellos()){

                if(s instanceof SVelocistaD){

                    s.usarSello(esta, posicion, turno);
                }
            }
        }

        
        if (posicion == 3 && derecha(esta)) {
            eliminarMovimiento(esta);
            esta.getSellos().add(new SVelocistaI());
             for(Sello s : esta.getSellos()){

                if(s instanceof SVelocistaI){

                    s.usarSello(esta, posicion, turno);
                }
            }
        }

        else if (posicion == 0 && izquierda(esta)) {
            eliminarMovimiento(esta);
            esta.getSellos().add(new SVelocistaD());
             for(Sello s : esta.getSellos()){

                if(s instanceof SVelocistaD){

                    s.usarSello(esta, posicion, turno);
                }
            }
        }
        


    }

    public static void eliminarMovimiento(Carta c){

        ArrayList<Sello> s = new ArrayList<>();

        for(Sello a : c.getSellos()){

            if(a instanceof SVelocistaD || a instanceof SVelocistaI){s.add(a);}
        }
        c.getSellos().removeAll(s);
        s.clear();
    }

     public static boolean contieneMovimiento(Carta c){

    

        for(Sello a : c.getSellos()){

            if(a instanceof SVelocistaD || a instanceof SVelocistaI){return true;}
        }
        return false;
       
    }

    public static boolean derecha(Carta c){

    

        for(Sello a : c.getSellos()){

            if(a instanceof SVelocistaD ){return true;}
        }
        return false;
       
    }

    public static boolean izquierda(Carta c){

    

        for(Sello a : c.getSellos()){

            if(a instanceof SVelocistaI ){return true;}
        }
        return false;
       
    }
    
}
