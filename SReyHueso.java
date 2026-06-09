public class SReyHueso extends Sello{

    private static SReyHueso instancia;

    private SReyHueso(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SReyHueso ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SReyHueso("reyhueso",Etapa.LANZAR,false);
        }
        return instancia;
    }

@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

        esta.setCantidad_Huesos(esta.getCantidad_Huesos()+3);
    }
    
}
