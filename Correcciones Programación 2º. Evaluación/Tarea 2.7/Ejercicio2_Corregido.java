/** @author Lucía González Rosas */

/* 2º.) Escribe un programa que lea cinco notas de exámenes (con un decimal) y nos devuelva la nota del
curso, que será el promedio de las 5 (1 punto) = */

import java.util.Scanner;

public class Ejercicio2_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        double sumaNotas = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Introduzca la nota del " + i + "º. examen: ");
            double nota = Double.parseDouble(scanner.nextLine());

            sumaNotas += nota;
        
        }
        
        double promedio = sumaNotas / 5;
        System.out.println("El promedio de las cinco notas notas es de un " + promedio);
        
    }
}