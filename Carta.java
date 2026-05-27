import java.util.ArrayList;

public class Carta implements Cloneable {

    private String nombre;
    private int atk;
    private int hp;
    private ArrayList<Sello> sellos;
    private int cantidad_Sangre;

    public Carta(String nombre, int atk, int hp, ArrayList<Sello> sellos) {
        this.nombre = nombre;
        this.atk = atk;
        this.hp = hp;
        this.sellos = sellos;
        this.cantidad_Sangre = 1;
    }

    public Carta(String nombre, int atk, int hp) {
        this.nombre = nombre;
        this.atk = atk;
        this.hp = hp;
        this.sellos = new ArrayList<Sello>();
        this.cantidad_Sangre = 1;
    }

    

    public Carta() {
        this.nombre = "";
        this.atk = 0;
        this.hp = 0;
        this.sellos = null;
        this.cantidad_Sangre = 1;
    }

    public static Carta crearArdilla(){

      Carta a =  new Carta("Ardilla", 0, 1);
      a.setCantidad_Sangre(0);
      return a;
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

    public ArrayList<Sello> getSellos() {
        return sellos;
    }

    public void setSellos(ArrayList<Sello> sellos) {
        this.sellos = sellos;
    }

    public Carta clone() {

        Carta clon = new Carta();

        clon.nombre = this.nombre;
        clon.atk = this.atk;
        clon.hp = this.hp;
        clon.sellos = new ArrayList<>(this.sellos);

        return clon;

    }

    public boolean atacaNormal() {

        for (Sello s : this.getSellos()) {

            if (s.getEtapa() == Etapa.ATACAR) {
                return false;
            }

        }
        return true;

    }

    public boolean sePuedeMeterSello() {

        return this.sellos.size() < 3;

    }

    public void anadirSello(Sello s) {

        this.sellos.add(s);
    }

    public boolean lanzarCarta() {

        return true;
    }

    public void atacar(int posicionCarta, Turno turno) {

        Linea lineaEnemiga;

        if (turno == Turno.JUGADOR) {
            lineaEnemiga = Tablero.ObtenerLineaLeshy();
        }

        else {
            lineaEnemiga = Tablero.ObtenerLineaJugador();
        }

        if (atacaNormal()) {

            Carta enemigo = lineaEnemiga.getHuecos()[posicionCarta];
            if (enemigo != null) {

                if (this.esVolador()) {

                    if (enemigo.getSellos().contains(Sellos_in_game.buscarSello("defenderVolador"))) {

                        enemigo.setHp(enemigo.getHp() - this.getAtk());
                    }

                    else {
                        Balanza.empujar(this.getAtk());
                    }

                }

                else {
                    enemigo.setHp(enemigo.getHp() - this.getAtk());
                }
            }

            else {

                Balanza.empujar(this.getAtk());
            }

        }

    }

    public void recorrerSellos(Etapa e) {

        for (Sello s : this.getSellos()) {

            if (s.getEtapa() == e) {

                s.usarSello();
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

}