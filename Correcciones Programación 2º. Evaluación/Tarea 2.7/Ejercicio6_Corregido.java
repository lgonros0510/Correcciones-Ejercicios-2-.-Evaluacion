/** @author Lucía González Rosas */

/* 6º.) Escribe un programa que lee 2 números y nos dice si el primero es mayor que el segundo y si son iguales. 
Sin usar IF, solamente respondiendo a las 2 preguntas, por ejemplo "¿El primero es mayor? true" ¿Son iguales? false"
(1 punto) = */

import java.util.Scanner;

public class Ejercicio6_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduzca un número cualquiera: ");
        int numero1 = scanner.nextInt();

        System.out.print("Introduzca otro número cualquiera: ");
        int numero2 = scanner.nextInt();

        boolean esMayor = (numero1 > numero2);
        boolean sonIguales = (numero1 == numero2);
        
        System.out.println("¿Es el primer número mayor que el segundo? " + esMayor);
        System.out.println("¿Son los dos números iguales? " + sonIguales);
        
    }
}