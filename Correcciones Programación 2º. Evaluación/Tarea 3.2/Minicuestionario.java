/** @author Lucía González Rosas */

/* 1º.) Realiza un minicuestionario con 5 preguntas tipo test sobre conceptos del módulo. Cada pregunta
acertada sumará un punto. El programa mostrará al final la calificación obtenida = */

import java.util.Scanner;

public class Minicuestionario {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int puntuacion = 0;

        System.out.println("1º.) ¿Cuál es la estructura básica de una instrucción 'if' en Java?");
        System.out.println("a) if (condición) { //código }");
        System.out.println("b) if { //código } (condición)");
        System.out.println("c) (condición) { //código } if");
        System.out.print("Tu respuesta es ");
        String respuesta1 = scanner.nextLine();

        if (respuesta1.equalsIgnoreCase("a")) {
            puntuacion++;

        }

        System.out.println("\n2º.) ¿Qué operador se utiliza para comparar dos valores en una instrucción 'if'?");
        System.out.println("a) =");
        System.out.println("b) ==");
        System.out.println("c) >");
        System.out.print("Tu respuesta es ");
        String respuesta2 = scanner.nextLine();

        if (respuesta2.equalsIgnoreCase("b")) {
            puntuacion++;

        }

        System.out.println("\n3º.) ¿Qué palabra clave se utiliza para agregar una alternativa en una instrucción 'if'?");
        System.out.println("a) else");
        System.out.println("b) then");
        System.out.println("c) or");
        System.out.print("Tu respuesta es ");
        String respuesta3 = scanner.nextLine();

        if (respuesta3.equalsIgnoreCase("a")) {
            puntuacion++;
        }

        System.out.println("\n4º.) ¿Qué hace una instrucción 'if-else?'");
        System.out.println("a) Ejecuta un bloque de código si la condición es falsa, sino ejecuta otro bloque de código");
        System.out.println("b) No realiza ninguna acción");
        System.out.println("c) Ejecuta un bloque de código si la condición es verdadera, sino ejecuta otro bloque de código");
        System.out.print("Tu respuesta es ");
        String respuesta4 = scanner.nextLine();

        if (respuesta4.equalsIgnoreCase("c")) {
            puntuacion++;
        }

        System.out.println("\n5º.) ¿Cuál es la diferencia entre una instrucción 'if' simple y una instrucción 'if-else'?");
        System.out.println("a) No hay diferencia, son lo mismo");
        System.out.println("b) if-else tiene un bloque de código adicional para ejecutar si la condición es falsa");
        System.out.println("c) if-else tiene un bloque de código adicional para ejecutar si la condición es verdadera");
        System.out.print("Respuesta: ");
        String respuesta5 = scanner.nextLine();

        if (respuesta5.equalsIgnoreCase("b")) {
            puntuacion++;
        }

        System.out.println("\nT u untuación obtenida en el minicuestionario es de un " + puntuacion + "/5");

    }
}