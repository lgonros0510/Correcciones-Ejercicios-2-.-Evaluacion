/** @author Lucía González Rosas */

/* Este programa nos permite realizar cálculos relacionados con la geometría. Dicho programa
 * permite calcular la circunferencia, el área y el volumen de una esfera a partir del radio
 * proporcionado por el usuario.
 */

import java.util.Scanner;

public class Geometria_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double radio = 0;

        while (true) {
            int opcion = menu();

            switch (opcion) {
                case 0:
                    radio = pedirRadio();
                    break;

                case 1:
                    System.out.println("La circunferencia de la esfera es " + circunferencia(radio));
                    break;

                case 2:
                    System.out.println("El área de la esfera es " + area(radio));
                    break;

                case 3:
                    System.out.println("El volumen de la esfera es " + volumen(radio));
                    break;

                case 4:
                    System.out.println("La circunferencia de la esfera es " + circunferencia(radio));
                    System.out.println("El área de la esfera es " + area(radio));
                    System.out.println("El volumen de la esfera es " + volumen(radio));
                    break;

                case 5:
                    System.out.println("¡Hasta la próxima!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Dicha opción no es válida. Inténtalo de nuevo, por favor: ");
                    
            }
        }
    }

    /**
     * Muestra el menú y devuelve la opción elegida por el usuario.
     * 
     * @return Opción elegida por el usuario.
     */
    public static int menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--->>> MENÚ DE GEOMETRÍA <<<---");
        System.out.println("0) Introducir el radio de la esfera");
        System.out.println("1) Calcular la circunferencia de la esfera");
        System.out.println("2) Calcular el área de la esfera");
        System.out.println("3) Calcular el volumen de la esfera");
        System.out.println("4) Calcular todas las operaciones disponibles");
        System.out.println("5) Salir del menú");
        System.out.println("-------------------------------");
        System.out.print("\nSelecciona una opción (0-5): ");
        int opcion = scanner.nextInt();
        return opcion;

    }

    /* Esta función pide al usuario por pantalla el radio de la esfera para que,
     * posteriormente, la introduzcamos por teclado.
     */

    /** @return Devuelve el radio introducido por teclado */

    public static double pedirRadio() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el radio de la esfera: ");
        double radio = Double.parseDouble(scanner.nextLine());
        return radio;

    }

    /* Esta función permite calcular la circunferencia de la esfera.
     */

    /** @return Devuelve el resultado de calcular la circunferencia de la esfera.
     *  @param r Es el radio de la esfera.
     */

    public static double circunferencia(double r) {
        return 2 * Math.PI * r;

    }

    /* Esta función permite calcular el área de la esfera.
     */

    /** @return Devuelve el resultado de calcular el área de la esfera.
     *  @param r Es el radio de la esfera.
     */

    public static double area(double r) {
        return Math.PI * r * r;

    }

    /* Esta función permite calcular el volumen de la esfera.
     */

    /** @return Devuelve el resultado de calcular el volumen de la esfera.
     *  @param r Es el radio de la esfera.
     */

    public static double volumen(double r) {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);

    }
}