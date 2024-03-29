/** @author Lucía González Rosas */

/* 20º.) Realiza un programa que pida un número entero N entre 0 y 20 y luego muestre por pantalla
los números desde 1 hasta N, uno en cada línea, repitiendo cada número tantas veces como su valor = */

import java.util.Scanner;

public class Ejercicio20_Corregido {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número entero comprendido entre el 0 y el 20: ");
        int n = scanner.nextInt();

        if (n < 0 && n > 20) {
            System.out.println("El número que acabas de ingresar está fuera del rango permitido. Prueba de nuevo con otro diferente: ");
            return;

        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i);
                
            }

            System.out.println();

        }
    }
}