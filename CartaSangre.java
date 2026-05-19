import java.util.ArrayList;

public class CartaSangre extends Carta implements Cloneable {

    private int coste_Sangre;

    public CartaSangre(String nombre, int atk, int hp, ArrayList<Sello> sellos, int coste_Sangre) {
        super(nombre, atk, hp, sellos);
        this.coste_Sangre = coste_Sangre;
    }

    public CartaSangre(String nombre, int atk, int hp, int coste_Sangre) {
        super(nombre, atk, hp);
        this.coste_Sangre = coste_Sangre;
    }

    public CartaSangre() {
        super();
        this.coste_Sangre =0;
    }

    public int getCoste_Sangre() {
        return coste_Sangre;
    }

    public void setCoste_Sangre(int coste_Sangre) {
        this.coste_Sangre = coste_Sangre;
    }

public CartaSangre clone(){

CartaSangre clon = (CartaSangre) super.clone();
clon.coste_Sangre=this.coste_Sangre;

return clon;
}
    
    
}
