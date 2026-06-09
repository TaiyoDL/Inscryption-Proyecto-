public class SSacrificioDigno extends Sello {

    private static SSacrificioDigno instancia;

    private SSacrificioDigno(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SSacrificioDigno ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SSacrificioDigno("sacrificiodigno",Etapa.LANZAR,false);
        }
        return instancia;
    }

@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

        esta.setCantidad_Sangre(esta.getCantidad_Sangre()+2);
    }
    
}
