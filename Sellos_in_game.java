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
    
}
