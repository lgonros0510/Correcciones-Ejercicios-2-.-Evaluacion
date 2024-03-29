/** @author Lucía González Rosas */

/* 17º.) Realiza un programa que lea y acepte únicamente aquellos que sean mayores que el último
dado. La introducción de números finaliza con la introducción de un 0. Al final se mostrará el
total de números introducidos (excluyendo el 0) y el total de números fallados = */

import java.util.Scanner;

public class Ejercicio17_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ultimoNumero = Integer.MIN_VALUE;
        int totalNumeros = 0;
        int totalFallados = 0;

        System.out.println("Introduzca varios números mayores que el último que se haya introducido. Introduzca 0 para finalizar: ");

        while (true) {
            System.out.print("Introduzca un número: ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                break;

            }

            totalNumeros++;

            if (numero <= ultimoNumero) {
                System.out.println("Lo sentimos. Ese número que acabas de introducir no es válido. Prueba con otro diferente, por favor: ");
                totalFallados++;
                continue;

            }

            ultimoNumero = numero;

        }

        System.out.println("El total de números que se han introducido es de " + totalNumeros + " números.");
        System.out.println("El total de números que se han fallado es de " + totalFallados + " números.");

    }
}