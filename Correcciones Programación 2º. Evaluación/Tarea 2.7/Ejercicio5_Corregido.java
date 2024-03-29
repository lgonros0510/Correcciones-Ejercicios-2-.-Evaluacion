/** @author Lucía González Rosas */

/* 5º.) Escribe un programa que lee un número y me dice si es positivo (true) o negativo (false),
consideraremos el cero como positivo. Sin usar IF (1 punto) = */

import java.util.Scanner;

public class Ejercicio5_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduzca un número cualquiera: ");
        int numero = scanner.nextInt();

        boolean esPositivo = (numero >= 0);
        
        System.out.println("¿Dicho número es positivo? " + esPositivo);

    }
}