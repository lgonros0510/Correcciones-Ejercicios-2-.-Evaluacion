/** @author Lucía González Rosas */

/* 4º.) Escribe un programa que pide el nombre, primer apellido y segunda apellido y año de nacimiento
de una persona. Deberá escribir el nombre completo, en una sola línea y la edad calculada a partir del
año, en otra línea (1 punto) = */

import java.util.Scanner;

public class Ejercicio4_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduzca el nombre de dicha persona: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduzca el primer apellido de dicha persona: ");
        String apellido1 = scanner.nextLine();

        System.out.print("Introduzca el segundo apellido de dicha persona: ");
        String apellido2 = scanner.nextLine();

        System.out.print("Introduzca el año de nacimiento de dicha persona: ");
        int añoNacimiento = scanner.nextInt();

        int añoActual = 2024;
        int edad = añoActual - añoNacimiento;
        
        System.out.println("El nombre completo de dicha persona es " + nombre + " " + apellido1 + " " + apellido2);
        System.out.println("La edad actual de dicha persona es de " + edad + " años.");
        
    }
}