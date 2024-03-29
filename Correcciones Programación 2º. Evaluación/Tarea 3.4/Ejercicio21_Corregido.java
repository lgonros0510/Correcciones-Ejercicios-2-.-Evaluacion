/** @author Lucía González Rosas */

/* 21º.) Realiza un programa que pida dos número enteros A y B, siendo B mayor que A. Luego visualiza
los números desde A hasta B e indicar cuantos hay que sean pares = */

import java.util.Scanner;

public class Ejercicio21_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número entero cualquiera: ");
        int numero1 = scanner.nextInt();

        System.out.print("Introduzca otro número entero cualquiera (debe ser mayor que el primero que hayas introducido): ");
        int numero2 = scanner.nextInt();

        if (numero2 <= numero1) {
            System.out.println("Error: B debe ser mayor que A.");
            return;

        }

        int pares = 0;

        System.out.println("Los números que están comprendidos entre el " + numero1 + " hasta el " + numero2 + " son ");

        for (int i = numero1; i <= numero2; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0) {
                pares++;

            }
        }

        System.out.println("\nEl total de números pares que se han podido encontrar son " + pares);

    }
}