public class Linea {
    public Carta[] huecos = new Carta[4];


    public Linea(){}


    public Carta[] getHuecos() {
        return huecos;
    }


    public void setHuecos(Carta[] huecos) {
        this.huecos = huecos;
    }

    public void activarLinea(Turno turno){

for(int i=0;i<4;i++){

if(this.getHuecos()[i]!=null){

    this.getHuecos()[i].atacar(i, turno);
}

}

    }

@Override
public String toString() {
    int anchoCelda = 26; // Ancho de cada carta
    int totalCartas = 4;
    
    // Formateador interno estricto para el contenido de la carta (le restamos los 2 bordes laterales)
    String formatoContenido = "%-" + (anchoCelda - 2) + "s";
    
    // Estructuras horizontales de las cartas
    String techoIndividual = "┌" + "─".repeat(anchoCelda - 2) + "┐";
    String sueloIndividual = "└" + "─".repeat(anchoCelda - 2) + "┘";

    StringBuilder resultado = new StringBuilder();
    Carta[] cartas = this.getHuecos();

    // PISO 1: Techos de las 4 cartas separados por un espacio limpio
    for (int i = 0; i < totalCartas; i++) {
        resultado.append(techoIndividual);
        if (i < totalCartas - 1) resultado.append(" "); // Espacio de separación entre cartas
    }
    resultado.append("\n");

    // PISO 2: Contenido / Nombres de las cartas
    for (int i = 0; i < totalCartas; i++) {
        String textoInterno = "";
        if (cartas[i] != null) {
            textoInterno = cartas[i].toString();
            // Control de seguridad por si el texto supera el tamaño
            if (textoInterno.length() > anchoCelda - 4) {
                textoInterno = textoInterno.substring(0, anchoCelda - 5) + "...";
            }
        }
        
        // Formateamos el texto y le clavamos los bordes laterales '│' de forma manual y limpia
        String celdaFormateada = String.format(formatoContenido, textoInterno);
        resultado.append("│").append(celdaFormateada).append("│");
        
        if (i < totalCartas - 1) resultado.append(" "); // Espacio de separación entre cartas
    }
    resultado.append("\n");

    // PISO 3: Línea de alto / Relleno vacío para dar forma cuadrada
    for (int i = 0; i < totalCartas; i++) {
        String vacioFormateado = String.format(formatoContenido, "");
        resultado.append("│").append(vacioFormateado).append("│");
        if (i < totalCartas - 1) resultado.append(" ");
    }
    resultado.append("\n");

    // PISO 4: Suelos de las 4 cartas
    for (int i = 0; i < totalCartas; i++) {
        resultado.append(sueloIndividual);
        if (i < totalCartas - 1) resultado.append(" ");
    }
    resultado.append("\n");

    return resultado.toString();
}
}
