/** @author Lucía González Rosas */

/* 16º.) Realiza un programa en java que pida un número entero positivo y nos diga si es primo o no = */

import java.util.Scanner;

public class Ejercicio16_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número entero positivo cualquiera: ");
        int numero = scanner.nextInt();

        boolean esPrimo = true;

        if (numero <= 1) {
            esPrimo = false;

        } else {
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    esPrimo = false;
                    break;

                }
            }
        }

        if (esPrimo) {
            System.out.println("El número " + numero + " es un número primo.");

        } else {
            System.out.println("El número " + numero + " no es un número primo.");

        }
    }
}