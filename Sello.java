public abstract class Sello{

private String nombre;
private Etapa etapa;
private boolean ataca;

public Sello(String nombre, Etapa etapa,boolean ataca) {
    this.nombre = nombre;
    this.etapa = etapa;
    this.ataca=ataca;
}


public void usarSello(){}


public String getNombre() {
    return nombre;
}


public Etapa getEtapa() {
    return etapa;
}


public boolean isAtaca() {
    return ataca;
}



}