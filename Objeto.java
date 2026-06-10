public abstract class Objeto {
    private String nombre;
    private String descripcion;

    



    public Objeto(String nombre,String descripcion) {
        this.descripcion=descripcion;
        this.nombre = nombre;
    }





    public void usarObjeto(){


        Jugador.getMochila().remove(this);
    }

    public void usarObjeto(int p){


        Jugador.getMochila().remove(this);
    }





    public String getNombre() {
        return nombre;
    }





    public String getDescripcion() {
        return descripcion;
    }

    
    
}
