public class STripleGolpe extends Sello {

    private static STripleGolpe instancia;

    public STripleGolpe(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static STripleGolpe ObtenerInstancia(){

        if (instancia == null) {
            instancia = new STripleGolpe("triplegolpe",Etapa.ATACAR,true);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta c,int posicion,Turno turno){

        switch (posicion) {
            case 0:

            c.atacarSinCondiciones(posicion+1, turno);
             c.atacarSinCondiciones(posicion, turno);
                
                break;

                case 1,2:
                    c.atacarSinCondiciones(posicion+1, turno);
                     c.atacarSinCondiciones(posicion-1, turno);
                     c.atacarSinCondiciones(posicion, turno);

                break;

                case 3:
                     c.atacarSinCondiciones(posicion-1, turno);
                     c.atacarSinCondiciones(posicion, turno);

                break;
        
            default:
                break;
        }


    }
    
}
