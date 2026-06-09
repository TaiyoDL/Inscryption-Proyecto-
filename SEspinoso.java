public class SEspinoso extends Sello {

    private static SEspinoso instancia;

    private SEspinoso(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SEspinoso ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SEspinoso("espinoso",Etapa.RECIBIR,false);
        }
        return instancia;
    }

@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

        
    }
    
}
