public class SDefenderVolador extends Sello {

     private static SDefenderVolador instancia;

    private SDefenderVolador(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SDefenderVolador ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SDefenderVolador("defendervolador",Etapa.RECIBIR,false);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta esta,int posicion,Turno turno){}
    
}
    

