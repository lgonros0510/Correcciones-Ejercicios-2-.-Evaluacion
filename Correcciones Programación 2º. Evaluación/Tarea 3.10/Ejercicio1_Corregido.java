/** @author Lucía González Rosas */

/* 1º.) Implementa un programa que pida al usuario un valor entero A utilizando un nextInt() (de
Scanner) y luego muestre por pantalla el mensaje “Valor introducido: …”. Se deberá tratar la
excepción InputMismatchException que lanza nextInt() cuando no se introduce un entero válido.
En tal caso se mostrará el mensaje “Valor introducido incorrecto” = */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduzca un valor entero cualquiera: ");
            int numero = scanner.nextInt();

            System.out.println("El valor que se ha introducido es " + numero);

        } catch (InputMismatchException e) {
            System.out.println("El valor que se ha introducido es incorrecto.");
            e.printStackTrace();

        }
    }
}