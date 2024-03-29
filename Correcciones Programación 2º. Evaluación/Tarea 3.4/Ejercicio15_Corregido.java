/** @author Lucía González Rosas */

/* 15º.) Realiza un programa que cuente los múltiplos de 3 desde el 1 hasta un número que
introducimos por teclado = */

import java.util.Scanner;

public class Ejercicio15_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número entero cualquiera: ");
        int numero = scanner.nextInt();

        int contador = 0;
        int actual = 1;

        while (actual <= numero) {
            if (actual % 3 == 0) {
                contador++;

            }

            actual++;

        }

        System.out.println("El número de múltiplos de 3 que hay desde el 1 hasta el " + numero + " es de "
        + contador + " múltiplos.");

    }
}