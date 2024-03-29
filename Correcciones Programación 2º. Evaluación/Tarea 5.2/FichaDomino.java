/** @author Lucía González Rosas */

/* En esta parte del juego, se creará una clase donde se maneje las fichas del dominó; tanto sus lados
 * como sus números introducidos y si encajan en otras fichas.
 * 
 * Esta es la corrección de la tarea 5.2 de Programación (27 de marzo del 2024).
 */

class FichaDomino {

    int lado1;
    int lado2;

    public FichaDomino(int lado1, int lado2) {

        this.lado1 = lado1;
        this.lado2 = lado2;

    }

    /** @return Devuelve el número de la ficha */
    public int getNumero() {

        return lado1 * 10 + lado2;

    }

    /** @return Devuelve si encaja la ficha en la parte izquierda del tablero o no. */
    public boolean encajaIzquierda(FichaDomino otra) {

        return this.lado1 == otra.lado2;

    }

    /** @return Devuelve si encaja la ficha en la parte derecha del tablero o no. */
    public boolean encajaDerecha(FichaDomino otra) {

        return this.lado2 == otra.lado1;

    }

    /** @return Devuelve la ficha entera. */
    @Override
    public String toString() {

        return "[" + lado1 + "|" + lado2 + "]";

    }
}