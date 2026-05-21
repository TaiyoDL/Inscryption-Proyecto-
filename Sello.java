public  class Sello{

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

@Override
public boolean equals(Object o){
if(o==null){return false;}

if(this==o){return true;}

Sello otro = (Sello) o;

return this.getNombre().equals(otro.getNombre());
}



}