public class SMortal extends Sello {

       private static SMortal instancia;

    private SMortal(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SMortal ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SMortal("mortal",Etapa.ATACAR,false);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta esta,int posicion,Turno turno){}
    
}
