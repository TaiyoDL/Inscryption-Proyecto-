import java.util.ArrayList;

public class CartaHueso extends Carta implements Cloneable {

    private int coste_Hueso;


    public CartaHueso(String nombre, int atk, int hp, ArrayList<Sello> sellos, int coste_Hueso) {
        super(nombre, atk, hp, sellos);
        this.coste_Hueso = coste_Hueso;
    }

    public CartaHueso(String nombre, int atk, int hp, int coste_Hueso) {
        super(nombre, atk, hp);
        this.coste_Hueso = coste_Hueso;
    }

    public CartaHueso() {
        super();
        this.coste_Hueso =0;
    }

    public int getCoste_Hueso() {
        return coste_Hueso;
    }

    public void setCoste_Hueso(int coste_Hueso) {
        this.coste_Hueso = coste_Hueso;
    }

public CartaHueso clone(){

CartaHueso clon = (CartaHueso) super.clone();
clon.coste_Hueso=this.coste_Hueso;

return clon;
}

public String toString(){

    return super.toString();
}
    
}
