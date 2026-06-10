import java.util.Scanner;

public class SAcumulador extends Sello {

    private static SAcumulador instancia;

    private SAcumulador(String nombre, Etapa etapa, boolean ataca) {
        super(nombre, etapa, ataca);
    }

    public static SAcumulador ObtenerInstancia(){

        if (instancia == null) {
            instancia = new SAcumulador("acumulador",Etapa.LANZAR,false);
        }
        return instancia;
    }
@Override
    public void usarSello(Carta esta,int posicion,Turno turno){

        if(turno==Turno.JUGADOR){

        if(!Jugador.getMazoActual().isEmpty()){

        Jugador.mostrarMazoActual();

        Scanner n = new Scanner(System.in);

        System.out.println("Que carta quieres agregar a tu mano?(Pon el número)");
        int e=n.nextInt();
        e--;
        n.nextLine();
        if(e<0){e=0;}
        if(e>=Jugador.getMazoActual().size()){e=Jugador.getMazoActual().size()-1;}

         System.out.println("Robas un " + Jugador.getMazoActual().get(e));
                Jugador.cogerCarta(Jugador.getMazoActual().get(e));
        }
    }
    }
    
}
