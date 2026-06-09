public class SDobleGolpe extends Sello {

     private static SDobleGolpe instancia;

    private SDobleGolpe(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SDobleGolpe ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SDobleGolpe("doblegolpe",Etapa.ATACAR,true);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta c,int posicion,Turno turno){

        switch (posicion) {
            case 0:

             c.atacarSinCondiciones(posicion+1, turno);
                
                break;

                case 1,2:
                     c.atacarSinCondiciones(posicion+1, turno);
                     c.atacarSinCondiciones(posicion-1, turno);

                break;

                case 3:
                    c.atacarSinCondiciones(posicion-1, turno);

                break;
        
            default:
                break;
        }


    }
    
}
    

