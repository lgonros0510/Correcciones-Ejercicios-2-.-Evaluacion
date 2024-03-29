/** @author Lucía González Rosas */

/* 19. Realiza un programa que lea un número y a continuación escriba el carácter “*” tantas veces
igual al valor numérico leído. En aquellos casos en que el valor leído no sea positivo se deberá
escribir un único asterisco = */

import java.util.Scanner;

public class Ejercicio19_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número cualquiera: ");
        int numero = scanner.nextInt();

        if (numero > 0) {
            for (int i = 0; i < numero; i++) {
                System.out.print("*");

            }

        } else {
            System.out.print("*");

        }
    }
}