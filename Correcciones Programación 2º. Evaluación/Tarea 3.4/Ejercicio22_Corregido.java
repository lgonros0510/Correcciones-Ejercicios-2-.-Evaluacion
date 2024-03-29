/** @author Lucía González Rosas */

/* 22º.) Realiza un programa que pida un número y construya por pantalla su pirámide = */

import java.util.Scanner;

public class Ejercicio22_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número entero cualquiera: ");
        int numero = scanner.nextInt();

        for (int i = 1; i <= numero; i++) {
            for (int j = 1; j <= numero - i; j++) {
                System.out.print(" ");

            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");

            }

            System.out.println();

        }
    }
}