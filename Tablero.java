import java.util.ArrayList;

public class Tablero {
    private static Tablero instancia;
    private static Linea jugador;
    private static Linea leshy;
    private static Linea leshyTrasera;

    private Tablero() {
    }

    public static Tablero ObtenerInstancia() {
        if (instancia == null) {
            instancia = new Tablero();
        }
        return instancia;
    }

    public static Linea ObtenerLineaJugador() {
        if (jugador == null) {
            jugador = new Linea();
        }
        return jugador;
    }

    public static Linea ObtenerLineaLeshy() {
        if (leshy == null) {
            leshy = new Linea();
        }
        return leshy;
    }

    public static Linea ObtenerLineaTraseraLeshy() {
        if (leshyTrasera == null) {
            leshyTrasera = new Linea();
        }
        return leshyTrasera;
    }

    public void activarSellosInicio(Turno turno) {
        Linea activar;
        if (turno == Turno.JUGADOR) {
            activar = Tablero.ObtenerLineaJugador();
        }

        else {
            activar = Tablero.ObtenerLineaLeshy();
        }

        for (int i=0;i<4;i++) {

            if (activar.getHuecos()[i] == null) {
            }

            else {

                for (Sello s : new ArrayList<>(activar.getHuecos()[i].getSellos())) {

    if (s != null && s.getEtapa() == Etapa.INICIO_TURNO) {
        
        s.usarSello(activar.getHuecos()[i], i, turno);
    }
}
            }

        }

    }

    public void activarSellosFinal(Turno turno) {
        System.out.println("Usando sellosss!");
        Linea activar;
        if (turno == Turno.JUGADOR) {
            activar = Tablero.ObtenerLineaJugador();
        }

        else {
            activar = Tablero.ObtenerLineaLeshy();
        }

        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0;i<4;i++){

             if (activar.getHuecos()[i] != null) {a.add(i);
            }
        }

        for (int j : a) {

            if (activar.getHuecos()[j] == null) {
            }

            else {

               for (Sello s : new ArrayList<>(activar.getHuecos()[j].getSellos())) {

    if (s != null && s.getEtapa() == Etapa.FIN_TURNO) {
        
        s.usarSello(activar.getHuecos()[j], j, turno);
    }
}
            }

        }

    }

    public int contarSangreLinea() {

        int sangre = 0;

        for (Carta c : Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()) {

            if (c == null) {
            } else {
                sangre += c.getCantidad_Sangre();
            }
        }
        return sangre;

    }

    public void activarLineaTrasera() {

        for (int i = 0; i < 4; i++) {
            if (Tablero.ObtenerInstancia().ObtenerLineaTraseraLeshy().getHuecos()[i] != null) {

                if (Tablero.ObtenerInstancia().ObtenerLineaLeshy().getHuecos()[i] == null) {
                    Tablero.ObtenerInstancia().ObtenerLineaLeshy().getHuecos()[i] = Tablero.ObtenerInstancia()
                            .ObtenerLineaTraseraLeshy().getHuecos()[i];
                    Tablero.ObtenerInstancia().ObtenerLineaTraseraLeshy().getHuecos()[i] = null;
                }

            }

        }
    }

    public boolean hayCartasDeLeshy(){

        boolean devolver=false;

        for(int i=0;i<4;i++){

            if(Tablero.ObtenerInstancia().ObtenerLineaLeshy().getHuecos()[i]!=null || Tablero.ObtenerInstancia().ObtenerLineaTraseraLeshy().getHuecos()[i]!=null){

                devolver=true;
            }
        }
        return devolver;
    }

    public String toString() {

        return "Balanza: "+Balanza.getPuntos()+"\\"+"5 \n"+this.ObtenerLineaTraseraLeshy().toString() + this.ObtenerLineaLeshy().toString() + "-".repeat(107) + "\n"
                + this.ObtenerLineaJugador().toString();

    }
}
