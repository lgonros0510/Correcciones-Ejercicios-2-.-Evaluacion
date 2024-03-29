/** @author Lucía González Rosas */

/* En esta parte del juego, se creará todo el código necesario para terminar el juego del dominó:
 * mostrar tanto el tablero como las fichas que tengamos (al introducir una ficha, se mostrará
 * posteriormente en el tablero si se puede jugarla), actualizar el estado del juego, inicializar
 * el juego, los turnos entre el jugador y el ordenador, etc...
 * 
 * Esta es la corrección de la tarea 5.2 de Programación (27 de marzo del 2024).
 */

import java.util.Random;
import java.util.Scanner;

public class JuegoDomino {

    private FichaDomino[] fichas;
    private FichaDomino fichaMesa;
    private int[][] tablero;

    public JuegoDomino() {

        fichas = new FichaDomino[20];
        tablero = new int[5][5];

        inicializarFichas();
        inicializarTablero();
        repartirFichas(20);
        comenzarJuego();

    }

    private void inicializarFichas() {

        int index = 0;

        for (int lado1 = 0; lado1 <= 4; lado1++) {
            for (int lado2 = lado1; lado2 <= 4; lado2++) {
                fichas[index++] = new FichaDomino(lado1, lado2);

            }
        }
    }

    private void inicializarTablero() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = -1;

            }
        }
    }

    private void mostrarTablero() {

        System.out.println("Estado actual del tablero:");

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != -1) {
                    System.out.print("[" + tablero[i][j] + "]");

                } else {
                    System.out.print("[ ]");

                }
            }

            System.out.println();

        }

        System.out.println();

    }

    private void mostrarFichasEnMano() {

        System.out.println("Las fichas que están en posesión del jugador:");

        for (FichaDomino ficha : fichas) {
            if (ficha != null) {
                System.out.print(ficha + " ");

            }
        }

        System.out.println();

    }

    private void actualizarTablero(FichaDomino ficha, String posicion) {

        int valorFicha = ficha.getNumero();

        int fila = -1;
        int columna = -1;

        if ("izquierda".equalsIgnoreCase(posicion)) {
            fila = 2;
            columna = 0;

        } else if ("derecha".equalsIgnoreCase(posicion)) {
            fila = 2;
            columna = 4;

        }

        tablero[fila][columna] = valorFicha;

    }

    private void repartirFichas(int cantidadFichas) {

        Random random = new Random();
    
        for (int i = 0; i < cantidadFichas; i++) {
            int index = random.nextInt(fichas.length);
    
            FichaDomino temp = fichas[i];
            fichas[i] = fichas[index];
            fichas[index] = temp;

        }
    }

    private void comenzarJuego() {

        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            turnoJugador(scanner);
            mostrarEstadoJuego();
    
            if (fichas.length == 0) {
                System.out.println("¡Felicidades, ganaste!");
                break;

            }
    
            turnoOrdenador();
            mostrarEstadoJuego();
    
            if (fichas.length == 0) {
                System.out.println("¡El ordenador te ha ganado!");
                break;

            }
        }
    }

    /** @return Devuelve al jugador la oportunidad de volver a introducir una ficha existente. */
    private void turnoJugador(Scanner scanner) {

        mostrarFichasEnMano();

        System.out.print("Ingresa el número de la ficha a colocar (ingresa dos cifras): ");
        int numeroFicha = scanner.nextInt();

        FichaDomino fichaSeleccionada = buscarFichaPorNumero(numeroFicha);

        if (fichaSeleccionada == null) {
            System.out.println("La ficha no existe o no puedes colocarla. Inténtalo de nuevo.");
            turnoJugador(scanner);
            return;

        }

        if (fichaMesa == null) {
            fichaMesa = fichaSeleccionada;
            quitarFicha(fichaSeleccionada);

        } else {
            System.out.print("Elige una posición para colocar la ficha (sea 'izquierda' o 'derecha'): ");
            String posicion = scanner.next();

            colocarFichaIzquierda(fichaSeleccionada);
            colocarFichaDerecha(fichaSeleccionada);

        }
    }

    private void turnoOrdenador() {

        if (fichas.length == 0) {
            System.out.println("El ordenador no tiene más fichas para jugar.");
            return;

        }
    
        FichaDomino mejorFicha = null;
        int mejorPuntuacion = Integer.MIN_VALUE;
    
        for (FichaDomino ficha : fichas) {
            if (ficha == null) continue;
    
            for (String posicion : new String[]{"izquierda", "derecha"}) {
                FichaDomino copiaFichaMesa = new FichaDomino(fichaMesa.lado1, fichaMesa.lado2);

                if (posicion.equals("izquierda") && copiaFichaMesa.encajaIzquierda(ficha)) {
                    copiaFichaMesa.lado1 = ficha.lado2;

                    System.out.println("El ordenador acaba de jugar su ficha.");

                } else if (posicion.equals("derecha") && copiaFichaMesa.encajaDerecha(ficha)) {
                    copiaFichaMesa.lado2 = ficha.lado1;

                    System.out.println("El ordenador acaba de jugar su ficha.");

                } else {
                    continue;
                    
                }
    
                int puntuacion = evaluarJugada(ficha, posicion);
    
                if (puntuacion > mejorPuntuacion) {
                    mejorPuntuacion = puntuacion;
                    mejorFicha = ficha;

                }
            }
        }
        
        if (mejorFicha != null) {
            colocarMejorFicha(mejorFicha);

        } else {
            System.out.println("El ordenador no puede hacer ninguna jugada, roba una ficha.");
            repartirFichas(1);

        }
    }

    /** @return Devuelve la excepción de que dicha ficha no existe o no se puede colocarla. */
    private FichaDomino buscarFichaPorNumero(int numero) {

        for (FichaDomino ficha : fichas) {
            if (ficha != null && ficha.getNumero() == numero) {
                return ficha;

            }
        }

        return null;
    
    }

    private void quitarFicha(FichaDomino ficha) {

        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i] == ficha) {
                fichas[i] = null;
                break;

            }
        }
    }

    private void colocarFichaIzquierda(FichaDomino ficha) {

        if (fichaMesa.encajaIzquierda(ficha)) {
            fichaMesa = ficha;

            quitarFicha(ficha);
            actualizarTablero(ficha, "izquierda");

        } else {
            System.out.println("La ficha no encaja en la posición izquierda.");

        }
    }
    
    private void colocarFichaDerecha(FichaDomino ficha) {

        if (fichaMesa.encajaDerecha(ficha)) {
            fichaMesa = ficha;
            
            quitarFicha(ficha);
            actualizarTablero(ficha, "derecha");

        } else {
            System.out.println("La ficha no encaja en la posición derecha.");
        
        }
    }

    private int evaluarJugada(FichaDomino ficha, String posicion) {

        int puntaje = ficha.lado1 + ficha.lado2;
    
        if (posicion.equalsIgnoreCase("izquierda")) {
            puntaje += 10;

        } else {
            puntaje += 5;

        }
    
        puntaje -= fichas.length;
        return puntaje;

    }
    
    private void colocarMejorFicha(FichaDomino ficha) {

        if (fichaMesa.encajaIzquierda(ficha)) {
            colocarFichaIzquierda(ficha);

        } else if (fichaMesa.encajaDerecha(ficha)) {
            colocarFichaDerecha(ficha);

        }
    }

    private void mostrarEstadoJuego() {

        mostrarTablero();

        int fichasRestantes = contarFichasRestantes();

        System.out.println("Las fichas restantes que quedan en el juego son " + fichasRestantes);
        System.out.println();

    }

    /** @return Devuelve el número de fichas que existan todavía por jugar. */
    private int contarFichasRestantes() {

        int contador = 0;

        for (FichaDomino ficha : fichas) {
            if (ficha != null) {
                contador++;

            }
        }

        return contador;

    }

    public static void main(String[] args) {

        new JuegoDomino();
        
    }
}