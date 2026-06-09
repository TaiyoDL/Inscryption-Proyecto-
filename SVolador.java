public class SVolador extends Sello {

    private static SVolador instancia;

    private SVolador(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SVolador ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SVolador("volador",Etapa.ATACAR,true);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta esta,int posicion,Turno turno){}
    
}
