public class Tablero {
    private static Tablero instancia; 
    public Carta[] huecos = new Carta[8]; 

    private Tablero() { } 

    public static Tablero ObtenerInstancia()
    {
        if (instancia == null) 
        {
            instancia = new Tablero(); 
        }
        return instancia; 
    }

    public static Tablero get_instancia() {
        return instancia;
    }

    public static void set_instancia(Tablero instancia) {
        Tablero.instancia = instancia;
    }

   

    
}
