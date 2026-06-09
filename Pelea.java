import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pelea {

    public static boolean batalla(ArrayList<Carta> mazoLeshy) {
        Tablero tablero = Tablero.ObtenerInstancia();
        Jugador.inicioPartida();
        boolean resultado = true;
        boolean pelea = true;
        Scanner n = new Scanner(System.in);
        Random m = new Random();
        boolean turno = true;
        int nturno = 0;

        // Cartas iniciales de Leshy

        for (int i = 0; i < m.nextInt(1, 3); i++) {
            int c = m.nextInt(0, mazoLeshy.size());

            int p = m.nextInt(0, 4);

            while (tablero.ObtenerLineaLeshy().getHuecos()[p] != null) {
                p = m.nextInt(0, 4);
            }

            tablero.ObtenerLineaLeshy().getHuecos()[p] = mazoLeshy.get(c);
            mazoLeshy.get(c).activarSellosLanzar(p,Turno.LESHY);
            mazoLeshy.remove(mazoLeshy.get(c));

        }
        while (pelea) {
            switch (Balanza.resultado()) {
                case 1:

                    System.out.println("Has ganado!");
                    resultado = true;
                    pelea = false;

                    break;

                case -1:
                    System.out.println("Has perdido!");
                    resultado = false;
                    pelea = false;

                    break;

                default:

            }
            System.out.println("Turno "+(nturno+1)+"\n");

            if (!Jugador.getMazoActual().isEmpty() && !Jugador.getArdillas().isEmpty()) {

                System.out.println("\n=================================");
                System.out.println("    FASE DE ROBO: ELIGE TU DESTINO ");
                System.out.println("=================================");
                System.out.println("1. Coger carta del mazo");
                System.out.println("[Cualquier otro número]. Coger una ardilla");
                System.out.print("Elige tu opción: ");

                int robo = n.nextInt();
                n.nextLine();

                if (robo == 1) {
                    System.out.println(
                            "\n[Leshy]: Robas una criatura de tu mazo principal... ¿Te servirá para sobrevivir?");
                    System.out.println("Robas un " + Jugador.getMazoActual().get(0));
                    Jugador.cogerCarta(Jugador.getMazoActual().get(0));
                } else {
                    System.out.println("\n[Leshy]: Tomas una dócil ardilla. Ideal para ser sacrificada.");
                    Jugador.cogerArdilla();
                }

            }

            else if (Jugador.getMazoActual().isEmpty() && !Jugador.getArdillas().isEmpty())

            {
                System.out.println("\n[Leshy]: Tomas una dócil ardilla. Ideal para ser sacrificada.");
                Jugador.cogerArdilla();
            }

            else if (!Jugador.getMazoActual().isEmpty() && Jugador.getArdillas().isEmpty()) {
                System.out.println("Robas un " + Jugador.getMazoActual().get(0));
                Jugador.cogerCarta(Jugador.getMazoActual().get(0));
            }

            else {

                System.out.println("No te quedan cartas en el mazo ni ardillas para robar!");
            }

            turno = true;
            tablero.activarSellosInicio(Turno.JUGADOR);
            while (turno) {
                System.out.println(tablero);
                System.out.println("\n=======================");
                System.out.println("    TURNO DEL JUGADOR   ");
                System.out.println("=======================");
                System.out.println("1. Ver mano");
                System.out.println("2. Lanzar carta");
                System.out.println("3. Ver Huesos");
                System.out.println("4. Ver Balanza");
                System.out.println("5. Ver Tablero");
                System.out.println("6. Acabar turno");
                 System.out.println("7. Ver sellos de una de tus cartas");
                System.out.print("Elige una opción: ");

                int opcion = n.nextInt();
                n.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n[Serafín del juego]: Mostrando las cartas de tu mano...");
                        Jugador.mostrarMano();
                        break;
                    case 2:
                        System.out.println("\n[Serafín del juego]: Elige la carta que vas a poner en el tablero...");
                        int l = n.nextInt();
                        n.nextLine();
                        l--;
                        if (l < 0) {
                            l = 0;
                        }
                        if (l > Jugador.getMano().size() - 1) {
                            l = Jugador.getMano().size() - 1;
                        }
                        Jugador.getMano().get(l).lanzarCarta();
                        Jugador.getMano().get(l).activarSellosLanzar(l,Turno.JUGADOR);
                        break;

                    case 3:

                        System.out.println("Cantidad de huesos: " + Jugador.getHuesos());

                        break;
                    case 5:
                        System.out.println(tablero);
                        break;

                    case 4:
                        Balanza.imprimirBalanza();

                        break;

                    case 6:
                        System.out.println("\n[Serafín del juego]: Has finalizado tu turno. Leshy mueve ficha.");
                        turno = false;

                        break;

                        case 7:

                        System.out.println("Ingrese el numero de la posición de la carta(1-4)");

                        int s=n.nextInt();
                        n.nextLine();
                        s--;
                        if(s<0 || s>3 || tablero.ObtenerLineaJugador().getHuecos()[s]==null){}
                        else{tablero.ObtenerLineaJugador().getHuecos()[s].mostrarSellos();}

                        break;
                    default:
                        System.out.println("\n[!] Opción inválida. Elige un número del 1 al 7.");
                }

            }
            tablero.ObtenerLineaJugador().activarLinea(Turno.JUGADOR);
            tablero.activarSellosFinal(Turno.JUGADOR);

 switch (Balanza.resultado()) {
                case 1:

                    System.out.println("Has ganado!");
                    resultado = true;
                    pelea = false;

                    break;

                case -1:
                    System.out.println("Has perdido!");
                    resultado = false;
                    pelea = false;

                    break;

                default:

            }
            if (mazoLeshy.isEmpty() && !Tablero.ObtenerInstancia().hayCartasDeLeshy()) {
                System.out.println("Leshy se ha quedado sin cartas en todos lados! \n Has ganado!");
                resultado = true;
                pelea = false;
            }




            tablero.activarLineaTrasera();

            tablero.activarSellosInicio(Turno.LESHY);

            tablero.ObtenerLineaLeshy().activarLinea(Turno.LESHY);

            if (nturno%2== 0 && nturno != 0 && !mazoLeshy.isEmpty()) {

                int c = m.nextInt(0, mazoLeshy.size());

                int p = m.nextInt(0, 4);

                while (tablero.ObtenerLineaLeshy().getHuecos()[p] != null) {
                    p = m.nextInt(0, 4);
                }

                tablero.ObtenerLineaTraseraLeshy().getHuecos()[p] = mazoLeshy.get(c);
                mazoLeshy.get(c).activarSellosLanzar(p,Turno.LESHY);
                mazoLeshy.remove(mazoLeshy.get(c));

            }

            switch (Balanza.resultado()) {
                case 1:

                    System.out.println("Has ganado!");
                    resultado = true;
                    pelea = false;

                    break;

                case -1:
                    System.out.println("Has perdido!");
                    resultado = false;
                    pelea = false;

                    break;

                default:

            }
            if (mazoLeshy.isEmpty() && !Tablero.ObtenerInstancia().hayCartasDeLeshy()) {
                System.out.println("Leshy se ha quedado sin cartas en todos lados! \n Has ganado!");
                resultado = true;
                pelea = false;
            }
            tablero.activarSellosFinal(Turno.LESHY);
            nturno++;
        }

        return resultado;
    }

}
