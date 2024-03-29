/** @author Lucía González Rosas */

/* 1º.) Escribe un programa que lea dos números enteros, calcule y muestre el valor de su suma, resta,
producto, división, módulo y el primero elevado al segundo. Prueba a dividir por cero, a ver qué pasa.
Prueba a poner números grande para provocar un error en la última operación de exponente (1 punto) = */

import java.util.Scanner;

public class Ejercicio1_Corregido {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número cualquiera: ");
        int numero1 = scanner.nextInt();

        System.out.print("Introduzca otro número cualquiera: ");
        int numero2 = scanner.nextInt();

        System.out.println("La suma de ambos números es igual a " + (numero1 + numero2));
        System.out.println("La resta de ambos números es igual a " + (numero1 - numero2));
        System.out.println("El producto de ambos números es igual a " + (numero1 * numero2));

        if (numero2 != 0) {
            System.out.println("La división entre ambos números es igual a " + (numero1 / numero2));
            System.out.println("El módulo entre ambos números es igual a " + (numero1 % numero2));

        } else {
            System.out.println("ERROR. No se puede dividir entre cero.");
            System.out.println("ERROR. No se puede calcular el módulo con un divisor igual a cero.");

        }
    }
}