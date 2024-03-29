/** @author Lucía González Rosas */

/* 3º.) Escribe un programa que lea una calificación numérica entre 0 y 10 y la transforma en calificación
alfabética, escribiendo el resultado = */

import java.util.Scanner;

public class CalificacionesExamen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca la calificación numérica (debe ser entre 0 y 10): ");
        int calificacion = scanner.nextInt();

        String calificacionAlfabetica;

        if (calificacion >= 0 && calificacion < 3) {
            calificacionAlfabetica = "Muy Deficiente";

        } else if (calificacion >= 3 && calificacion < 5) {
            calificacionAlfabetica = "Insuficiente";

        } else if (calificacion >= 5 && calificacion < 6) {
            calificacionAlfabetica = "Bien";

        } else if (calificacion >= 6 && calificacion < 9) {
            calificacionAlfabetica = "Notable";

        } else if (calificacion >= 9 && calificacion <= 10) {
            calificacionAlfabetica = "Sobresaliente";

        } else {
            calificacionAlfabetica = "Calificación no válida";

        }

        System.out.println("La calificación que has introducido, en forma alfabética, sería un " + calificacionAlfabetica);

    }
}