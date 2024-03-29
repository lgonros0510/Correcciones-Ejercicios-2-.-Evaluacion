/** @author Lucía González Rosas */

/* 2º.) Realiza un programa que, dado un día de la semana (de lunes a viernes) y una hora (horas y minutos),
calcule cuántos minutos faltan para el fin de semana. Se considerará que el fin de semana comienza el viernes
a las 15:00h = */

import java.util.Scanner;

public class MinutosFinDeSemana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el día de la semana (de lunes a viernes): ");
        String diaSemana = scanner.nextLine().toLowerCase();

        System.out.print("Introduzca la hora (0-23): ");
        int hora = scanner.nextInt();

        System.out.print("Introduzca los minutos (0-59): ");
        int minutos = scanner.nextInt();

        int minutosFaltantes = 0;

        if (diaSemana.equals("lunes")) {
            if (hora < 15) {
                minutosFaltantes = (15 - hora) * 60 - minutos;

            } else {
                minutosFaltantes = (4 * 24 + 15 - hora) * 60 - minutos;

            }

        } else if (diaSemana.equals("martes")) {
            if (hora < 15) {
                minutosFaltantes = (3 * 24 + 15 - hora) * 60 - minutos;

            } else {
                minutosFaltantes = (3 * 24 + 15 - hora) * 60 - minutos;

            }

        } else if (diaSemana.equals("miercoles")) {
            if (hora < 15) {
                minutosFaltantes = (2 * 24 + 15 - hora) * 60 - minutos;

            } else {
                minutosFaltantes = (2 * 24 + 15 - hora) * 60 - minutos;

            }

        } else if (diaSemana.equals("jueves")) {
            if (hora < 15) {
                minutosFaltantes = (1 * 24 + 15 - hora) * 60 - minutos;

            } else {
                minutosFaltantes = (1 * 24 + 15 - hora) * 60 - minutos;

            }

        } else if (diaSemana.equals("viernes")) {
            if (hora < 15) {
                minutosFaltantes = (15 - hora) * 60 - minutos;

            } else {
                minutosFaltantes = 0;

            }

        } else {
            System.out.println("Dicho día de la semana no es válido. Por favor, ingrese un día que sea de lunes a viernes.");
            return;

        }


        System.out.println("Los minutos faltantes para que sea fin de semana son " + minutosFaltantes + " minutos.");

    }
}