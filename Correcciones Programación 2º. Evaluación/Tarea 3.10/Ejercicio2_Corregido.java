/** @author Lucía González Rosas */

/* 2º.) Implementa un programa que pida dos valores int A y B utilizando un nextInt() (de Scanner),
calcule A/B y muestre el resultado por pantalla. Se deberán tratar de forma independiente las dos
posibles excepciones, InputMismatchException y ArithmeticException, mostrando en cada caso un
mensaje de error diferente en cada caso = */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduzca un valor entero cualquiera: ");
            int numero1 = scanner.nextInt();

            System.out.print("Introduzca otro valor entero cualquiera: ");
            int numero2 = scanner.nextInt();

            int resultado = numero1 / numero2;

            System.out.println("El resultado de la división entre el primer y el segundo número introducidos es " + resultado);

        } catch (InputMismatchException e) {
            System.out.println("ERROR. El valor introducido es incorrecto. Se esperaba que se insertase un número entero.");
            e.printStackTrace();

        } catch (ArithmeticException e) {
            System.out.println("ERROR. No es posible dividir por 0 en una división.");
            e.printStackTrace();

        }
    }
}