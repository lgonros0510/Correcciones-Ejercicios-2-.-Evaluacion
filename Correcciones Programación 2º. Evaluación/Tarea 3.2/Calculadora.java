/** @author Lucía González Rosas */

/* 4º.) Implementa una calculadora, que a través de un menú de a elegir una de las 6 opciones (Suma, resta,
multiplicación, división, resto, exponente), luego pedirá los 2 números y devolverá el resultado = */

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--->>> MENÚ DE LA CALCULARORA <<<---");
        System.out.println("1) Suma");
        System.out.println("2) Resta");
        System.out.println("3) Multiplicación");
        System.out.println("4) División");
        System.out.println("5) Resto");
        System.out.println("6) Exponente");
        System.out.println("------------------------------------");

        System.out.print("Introduzca el número correspondiente a la operación que desea realizar (1-6): ");
        int opcion = scanner.nextInt();

        double resultado = 0;

        switch (opcion) {
            case 1:
                System.out.print("Introduzca el primer número: ");
                double numero1_Suma = scanner.nextDouble();

                System.out.print("Introduzca el segundo número: ");
                double numero2_Suma = scanner.nextDouble();

                resultado = numero1_Suma + numero2_Suma;
                break;

            case 2:
                System.out.print("Introduzca el primer número: ");
                double numero1_Resta = scanner.nextDouble();

                System.out.print("Introduzca el segundo número: ");
                double numero2_Resta = scanner.nextDouble();

                resultado = numero1_Resta - numero2_Resta;
                break;

            case 3:
                System.out.print("Introduzca el primer número: ");
                double numero1_Multiplicacion = scanner.nextDouble();

                System.out.print("Introduzca el segundo número: ");
                double numero2_Multiplicacion = scanner.nextDouble();

                resultado = numero1_Multiplicacion * numero2_Multiplicacion;
                break;

            case 4:
                System.out.print("Introduzca el dividendo: ");
                double dividendo = scanner.nextDouble();

                System.out.print("Introduzca el divisor: ");
                double divisor = scanner.nextDouble();

                if (divisor == 0) {
                    System.out.println("No se debe dividir por cero. Rompería la calculadora.");
                    return;

                }

                resultado = dividendo / divisor;
                break;

            case 5:
                System.out.print("Introduzca el dividendo: ");
                double dividendoResto = scanner.nextDouble();

                System.out.print("Introduzca el divisor: ");
                double divisorResto = scanner.nextDouble();

                if (divisorResto == 0) {
                    System.out.println("No se puede calcular el resto si el divisor es igual a cero.");
                    return;

                }

                resultado = dividendoResto % divisorResto;
                break;

            case 6:
                System.out.print("Introduzca la base: ");
                double base = scanner.nextDouble();

                System.out.print("Introduzca el exponente: ");
                double exponente = scanner.nextDouble();

                resultado = Math.pow(base, exponente);
                break;

            default:
                System.out.println("Dicha opción no es válida. Por favor, ingrese un número del 1 al 6: ");
                return;

        }

        System.out.println("El resultado de la operación es " + resultado);

    }
}