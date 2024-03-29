/** @author Lucía González Rosas */

/* 8º.) Implementa un programa que implemente el cifrado César para una palabra de 6 letras (6 caracteres).
Pedirá 6 caracteres uno a uno, y luego el desplazamiento (número entero). Los 6 caracteres deberán ser las
26 letras mayúsculas (ASCII del 65 al 90), no es necesario comprobarlo. Entonces escribirá en una sola línea
el texto cifrado, desplazando cada letra el número de posiciones indicadas en desplazamiento. Ten en cuenta
que Z+1 es A, hay que hacer el alfabeto circular, así que hay que usar el módulo para que después de la Z pase
a la A. Pista: juega con el orden de la letra dentro de este alfabeto, por ejemplo la A es el 0, y la B el 1. Si
a este orden añades 65, tienes su código ASCII. Un desplazamiento negativo descifrará el texto cifrado con el mismo
número en positivo. Ten en cuenta que no se puede hacer cualquier operación aritmética con una variable char, así que
necesitarás hacer casting de la expresión aritmética, para convertirla de int a char. Para leer un único carácter de
una cadena, se puede usar el método charAt(), de la clase String . Por ejemplo: char letra = System.console().readLine()
.charAt(0); (3 puntos) = */

import java.util.Scanner;

public class Ejercicio8_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca los 6 caracteres uno a uno, por favor: ");
        char letra1 = scanner.nextLine().charAt(0);
        char letra2 = scanner.nextLine().charAt(0);
        char letra3 = scanner.nextLine().charAt(0);
        char letra4 = scanner.nextLine().charAt(0);
        char letra5 = scanner.nextLine().charAt(0);
        char letra6 = scanner.nextLine().charAt(0);

        System.out.print("Introduzca el desplazamiento de las letras (debe de ser un número entero): ");
        int desplazamiento = scanner.nextInt();

        char letraCifrada1 = (char) ((letra1 - 'A' + desplazamiento) % 26 + 'A');
        char letraCifrada2 = (char) ((letra2 - 'A' + desplazamiento) % 26 + 'A');
        char letraCifrada3 = (char) ((letra3 - 'A' + desplazamiento) % 26 + 'A');
        char letraCifrada4 = (char) ((letra4 - 'A' + desplazamiento) % 26 + 'A');
        char letraCifrada5 = (char) ((letra5 - 'A' + desplazamiento) % 26 + 'A');
        char letraCifrada6 = (char) ((letra6 - 'A' + desplazamiento) % 26 + 'A');

        System.out.println("El texto que se ha cifrado es " + letraCifrada1 + letraCifrada2 + letraCifrada3 +
                           letraCifrada4 + letraCifrada5 + letraCifrada6);

    }
}