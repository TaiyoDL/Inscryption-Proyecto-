import java.util.ArrayList;

public class Objetos_In_Game {
    private static  ArrayList<Objeto> objetos = new ArrayList<>();

  public static ArrayList<Objeto> getObjetos() {
    return objetos;
  }

  public static void setObjetos(ArrayList<Objeto> objetos) {
    Objetos_In_Game.objetos = objetos;
  }



  public static Objeto buscarObjeto(String nombre){

for(Objeto s : objetos){

    if(s.getNombre().equals(nombre) ) {return s;}
}
return null;

  }

  public static void cargarObjetos(){

    objetos.add(OTijeras.ObtenerInstancia());
    objetos.add(OBotellaRoca.ObtenerInstancia());
     objetos.add(OBotellaArdilla.ObtenerInstancia());
     objetos.add(OAlicates.ObtenerInstancia());
     objetos.add(ODaga.ObtenerInstancia());
     objetos.add(OBotellaCabra.ObtenerInstancia());
     objetos.add(OHucha.ObtenerInstancia());
     objetos.add(OAnzuelo.ObtenerInstancia());

  }
}
