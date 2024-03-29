/** @author Lucía González Rosas */

/* 7º.) Escribe un programa que lee tres números y nos dice para cada uno si es el mayor de los
3 o no (en 3 preguntas a las que se responde, true o false). Sin usar IF (1 punto) = */

import java.util.Scanner;

public class Ejercicio7_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el primer número: ");
        int numero1 = scanner.nextInt();

        System.out.print("Introduzca el segundo número: ");
        int numero2 = scanner.nextInt();

        System.out.print("Introduzca el tercer número: ");
        int numero3 = scanner.nextInt();

        boolean mayor1 = numero1 > numero2 && numero1 > numero3;
        boolean mayor2 = numero2 > numero1 && numero2 > numero3;
        boolean mayor3 = numero3 > numero1 && numero3 > numero2;

        System.out.println("¿El primer número es el mayor de los tres existentes? " + mayor1);
        System.out.println("¿El segundo número es el mayor de los tres existentes? " + mayor2);
        System.out.println("¿El tercer número es el mayor de los tres existentes? " + mayor3);

    }
}