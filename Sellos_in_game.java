import java.util.ArrayList;

public class Sellos_in_game {
  private static  ArrayList<Sello> sellos = new ArrayList<>();

  public static ArrayList<Sello> getSellos() {
    return sellos;
  }

  public static void setSellos(ArrayList<Sello> sellos) {
    Sellos_in_game.sellos = sellos;
  }



  public static Sello buscarSello(String nombre){

for(Sello s : sellos){

    if(s.getNombre().equals(nombre) ) {return s;}
}
return null;

  }

  public static void cargarSellos(){

    sellos.add(SDefenderVolador.ObtenerInstancia());
    sellos.add(SDobleGolpe.ObtenerInstancia());
    sellos.add(STripleGolpe.ObtenerInstancia());
    sellos.add(SVolador.ObtenerInstancia());
    sellos.add(SColmena.ObtenerInstancia());
    sellos.add(SMadriguera.ObtenerInstancia());
    sellos.add(SMortal.ObtenerInstancia());
    sellos.add(SVelocista.ObtenerInstancia());
    sellos.add(SConstructor.ObtenerInstancia());
    sellos.add(SAcumulador.ObtenerInstancia());
    sellos.add(SFecundidad.ObtenerInstancia());
    sellos.add(SReyHueso.ObtenerInstancia());
    sellos.add(SSacrificioDigno.ObtenerInstancia());
    sellos.add(SEspinoso.ObtenerInstancia());
    sellos.add(SHormiguero.ObtenerInstancia());
  }
    
}
