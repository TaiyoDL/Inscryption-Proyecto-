import java.util.ArrayList;

public class Carta implements Cloneable {

    private String nombre;
    private int atk;
    private int hp;
    private ArrayList<Sello> sellos;
    private int cantidad_Sangre;
    private int cantidad_Huesos;

    public Carta(String nombre, int atk, int hp, ArrayList<Sello> sellos) {
        this.nombre = nombre;
        this.atk = atk;
        this.hp = hp;
        this.sellos = sellos;
        this.cantidad_Sangre = 1;
        this.cantidad_Huesos=1;
    }

    public Carta(String nombre, int atk, int hp) {
        this.nombre = nombre;
        this.atk = atk;
        this.hp = hp;
        this.sellos = new ArrayList<Sello>();
        this.cantidad_Sangre = 1;
         this.cantidad_Huesos=1;
    }

    

    public Carta() {
        this.nombre = "";
        this.atk = 0;
        this.hp = 0;
        this.sellos = null;
        this.cantidad_Sangre = 1;
         this.cantidad_Huesos=1;
    }

    public void activarRecibir(int posicion,Turno t){

        for(Sello s : this.getSellos()){

if(s.getEtapa()==Etapa.RECIBIR){
    s.usarSello(this, posicion, t);
}
        }
    }

    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int nCoste(){

        return 0;
    }

    public String getTipo(){

        return "";
    }

    

    public ArrayList<Sello> getSellos() {
        return sellos;
    }

    public void setSellos(ArrayList<Sello> sellos) {
        this.sellos = sellos;
    }

   public Carta clone() {
        try {
            // super.clone() de Object mantiene de forma mágica el tipo real (CartaSangre, etc.)
            Carta clon = (Carta) super.clone(); 
            
            // Copias los atributos mutables
            clon.sellos = new ArrayList<>(this.sellos); 
            
            return clon;
        } catch (CloneNotSupportedException e) {
            // Esto no debería pasar ya que implementamos Cloneable
            throw new RuntimeException(e);
        }
    }

    public boolean atacaNormal() {

        for (Sello s : this.getSellos()) {

            if (s.isAtaca() && s.getClass()!=SVolador.class) {
                return false;
            }

        }
        return true;

    }

    public boolean esEspinoso(){

        
        for(Sello s : this.sellos){if(s.getClass()==SEspinoso.class){return true;}}
        return false;
    }

    public void activarSellosAtaque(int i,Turno turno){

        for(Sello s : this.sellos){

            if(s.getEtapa()==Etapa.ATACAR){

                s.usarSello(this, i, turno);
            }
        }
    }

    public void activarSellosLanzar(int i,Turno turno){

        for(Sello s : this.sellos){

            if(s.getEtapa()==Etapa.LANZAR){

                s.usarSello(this, i, turno);
            }
        }
    }


     public void activarSellosMorir(int i,Turno turno){

        for(Sello s : this.sellos){

            if(s.getEtapa()==Etapa.MORIR){

                s.usarSello(this, i, turno);
            }
        }
    }

    public void mostrarSellos(){

        for(Sello s : this.sellos){

            System.out.println(s.getNombre());
        }
    }

    public boolean sePuedeMeterSello() {

        return this.sellos.size() < 3;

    }

    public void anadirSello(Sello s) {

        this.sellos.add(s);
    }

    public boolean lanzarCarta() {

        boolean hayHueco=false;

        for(int i=0;i<4;i++){

           if( Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[i]==null){
            hayHueco=true;
           }
        }
        return hayHueco;
    }

    public boolean contieneToqueMortal(){

        for(Sello s : this.sellos){if(s.getClass()==SMortal.class){return true;}}
        return false;
    }

    public void atacar(int posicionCarta, Turno turno) {

        int n=1;

        Linea lineaEnemiga;

        if (turno == Turno.JUGADOR) {
            lineaEnemiga = Tablero.ObtenerLineaLeshy();
        }

        else {
            lineaEnemiga = Tablero.ObtenerLineaJugador();
            n=-1;
        }

        if (atacaNormal()) {

            Carta enemigo = lineaEnemiga.getHuecos()[posicionCarta];
            if (enemigo != null) {

                if (this.esVolador()) {

                    if (enemigo.getSellos().contains(Sellos_in_game.buscarSello("defendervolador"))) {

                        if(this.contieneToqueMortal()){enemigo.setHp(enemigo.getHp() - 99999);}

                        else{

                        enemigo.setHp(enemigo.getHp() - this.getAtk());
                        }

                        if(enemigo.esEspinoso()){this.setHp(this.getHp()-1);}
                        enemigo.activarRecibir(posicionCarta, turno);
                        
                    }

                    else {
                        Balanza.empujar(this.getAtk()*n);
                    }

                }

                else {
                    if(this.contieneToqueMortal()){enemigo.setHp(enemigo.getHp() - 99999);}

                        else{

                        enemigo.setHp(enemigo.getHp() - this.getAtk());
                        }
                        if(enemigo.esEspinoso()){this.setHp(this.getHp()-1);}
                    enemigo.activarRecibir(posicionCarta, turno);
                    
                }
                if(enemigo.getHp()<=0){

                    if(turno==Turno.LESHY){

                        Jugador.setHuesos(Jugador.getHuesos()+enemigo.getCantidad_Huesos());



                    }
                    
                    System.out.println(lineaEnemiga.getHuecos()[posicionCarta].getNombre()+" debilitado");
                    lineaEnemiga.getHuecos()[posicionCarta].activarSellosMorir(posicionCarta,turno);
                    lineaEnemiga.getHuecos()[posicionCarta]=null;
                }
            }

            else {

                Balanza.empujar(this.getAtk()*n);
            }

        }

        
        

    }

 public void atacarSinCondiciones(int posicionCarta, Turno turno) {

        int n=1;

        Linea lineaEnemiga;

        if (turno == Turno.JUGADOR) {
            lineaEnemiga = Tablero.ObtenerLineaLeshy();
        }

        else {
            lineaEnemiga = Tablero.ObtenerLineaJugador();
            n=-1;
        }

        

            Carta enemigo = lineaEnemiga.getHuecos()[posicionCarta];
            if (enemigo != null) {

                if (this.esVolador()) {

                    if (enemigo.getSellos().contains(Sellos_in_game.buscarSello("defenderVolador"))) {

                        if(this.contieneToqueMortal()){enemigo.setHp(enemigo.getHp() - 99999);}

                        else{

                        enemigo.setHp(enemigo.getHp() - this.getAtk());
                        }
                        if(enemigo.esEspinoso()){this.setHp(this.getHp()-1);}
                        enemigo.activarRecibir(posicionCarta, turno);
                        
                    }

                    else {
                        Balanza.empujar(this.getAtk()*n);
                    }

                }

                else {
                    if(this.contieneToqueMortal()){enemigo.setHp(enemigo.getHp() - 99999);}

                        else{

                        enemigo.setHp(enemigo.getHp() - this.getAtk());
                        }
                        if(enemigo.esEspinoso()){this.setHp(this.getHp()-1);}
                    enemigo.activarRecibir(posicionCarta, turno);
                    
                }
                if(enemigo.getHp()<=0){

                    if(turno==Turno.LESHY){

                        Jugador.setHuesos(Jugador.getHuesos()+enemigo.getCantidad_Huesos());



                    }
                    
                    System.out.println(lineaEnemiga.getHuecos()[posicionCarta].getNombre()+" debilitado");
                    lineaEnemiga.getHuecos()[posicionCarta].activarSellosMorir(posicionCarta,turno);
                    lineaEnemiga.getHuecos()[posicionCarta]=null;
                }
            }

            else {

                Balanza.empujar(this.getAtk()*n);
            }

        
        

    }


    public int sacrificar(){

        int sangre=this.getCantidad_Sangre();
        Carta c = this;

       for(int i=0;i<4;i++){

if(Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[i]==c){
 Jugador.setHuesos(Jugador.getHuesos()+c.getCantidad_Huesos());
Tablero.ObtenerInstancia().ObtenerLineaJugador().getHuecos()[i]=null;
}

       }
       return sangre;
    }

    public void recorrerSellos(Etapa e) {

        for (Sello s : this.getSellos()) {

            if (s.getEtapa() == e) {

                s.usarSello(this);
            }
        }

    }

    public boolean esVolador() {

        if (this.getSellos().contains(Sellos_in_game.buscarSello("volador"))) {
            return true;

        }
        return false;
    }

    public int getCantidad_Sangre() {
        return cantidad_Sangre;
    }

    public void setCantidad_Sangre(int cantidad_Sangre) {
        this.cantidad_Sangre = cantidad_Sangre;
    }
@Override
    public String toString(){

        return this.getNombre()+"("+this.getAtk()+"\\"+this.getHp()+")";
    }

public int getCantidad_Huesos() {
    return cantidad_Huesos;
}

public void setCantidad_Huesos(int cantidad_Huesos) {
    this.cantidad_Huesos = cantidad_Huesos;
}

}