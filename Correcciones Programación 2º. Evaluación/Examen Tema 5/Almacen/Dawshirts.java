/** @author Lucía González Rosas */

/* En esta parte del programa, se creará la clase "Dawshirts" donde se implementará tanto las 5
 * camisetas de prueba como los métodos para manejar los artículos, siendo estos "listado()" (para
 * ver las camisetas que hay en el almacén), "alta()" (para dar de alta un artículo), "baja()" (para
 * dar de baja un artículo), "busquedaPorDescripcion()" (permite buscar una camiseta por su descripción)
 * y "modificacion()" (permite modificar un artículo).
 * 
 * Esta tarea se ha corregido al completo el 27 de marzo del 2024.
 */

package Almacen;

import java.util.Scanner;

public class Dawshirts {

    private static final int MAX_CAMISETAS = 100;
    private static Camiseta[] almacen = new Camiseta[MAX_CAMISETAS];
    private static int totalCamisetas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        inicializarAlmacen();
        menu();

    }

    public static void menu() {
        int opcion;

        do {
            System.out.println("\n----> ALMACÉN DE LAS CAMISETAS <----\n");
            System.out.println("1. Listado de artículos");
            System.out.println("2. Alta de artículo");
            System.out.println("3. Baja de artículo");
            System.out.println("4. Búsqueda de un artículo por descripción");
            System.out.println("5. Modificación de un artículo");
            System.out.println("6. Salir\n");

            System.out.print("Selecciona una opción (1-6): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listado();
                    break;

                case 2:
                    alta();
                    break;

                case 3:
                    baja();
                    break;

                case 4:
                    busquedaPorDescripcion();
                    break;

                case 5:
                    modificacion();
                    break;

                case 6:
                    System.out.println("Estás saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Dicha opción no es válida. Inténtalo de nuevo: ");

            }

        } while (opcion != 6);

    }

    private static void inicializarAlmacen() {

        almacen[0] = new Camiseta(0, "Camiseta 1", 10, 20, 30);
        almacen[1] = new Camiseta(1, "Camiseta 2", 15, 25, 35);
        almacen[2] = new Camiseta(2, "Camiseta 3", 20, 30, 40);
        almacen[3] = new Camiseta(3, "Camiseta 4", 25, 35, 45);
        almacen[4] = new Camiseta(4, "Camiseta 5", 30, 40, 50);

        totalCamisetas = 5;

    }

    private static void listado() {

        System.out.println("\n----> Listado de los artículos <----\n");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s\n", "Código", "Descripción", "Stock (S)", "Stock (M)", "Stock (L)", "Total");

        for (int i = 0; i < totalCamisetas; i++) {
            System.out.println(almacen[i]);

        }

        System.out.println("Total de camisetas en el almacén: " + totalCamisetas);

    }

    private static void alta() {

        if (totalCamisetas < MAX_CAMISETAS) {
            System.out.print("Introduzca el código del artículo: ");
            int codigo = scanner.nextInt();

            for (int i = 0; i < totalCamisetas; i++) {
                if (almacen[i].getCodigo() == codigo) {
                    System.out.println("El código ingresado ya existe en el inventario. Inténtalo de nuevo.");
                    return;

                }
            }

            scanner.nextLine();

            System.out.print("Introduzca la descripción del artículo: ");
            String descripcion = scanner.nextLine();

            System.out.print("Introduzca el stock de la talla S: ");
            int stockS = scanner.nextInt();

            System.out.print("Introduzca el stock de la talla M: ");
            int stockM = scanner.nextInt();

            System.out.print("Introduzca el stock de la talla L: ");
            int stockL = scanner.nextInt();

            almacen[totalCamisetas] = new Camiseta(codigo, descripcion, stockS, stockM, stockL);
            totalCamisetas++;

            System.out.println("La camiseta ha sido añadida correctamente.");

        } else {
            System.out.println("El almacén está lleno. No se pueden añadir más camisetas.");

        }
    }

    private static void baja() {

        System.out.print("Introduzca el código del artículo a eliminar: ");
        int codigo = scanner.nextInt();

        int indiceAEliminar = -1;

        for (int i = 0; i < totalCamisetas; i++) {
            if (almacen[i].getCodigo() == codigo) {
                indiceAEliminar = i;
                break;

            }
        }

        if (indiceAEliminar != -1) {
            for (int i = indiceAEliminar; i < totalCamisetas - 1; i++) {
                almacen[i] = almacen[i + 1];

            }

            totalCamisetas--;
            System.out.println("La camiseta ha sido eliminada correctamente.");

        } else {
            System.out.println("No se ha encontrado ninguna camiseta con ese código.");

        }
    }

    private static void busquedaPorDescripcion() {

        scanner.nextLine();

        System.out.print("Introduzca la descripción a buscar: ");
        String descripcion = scanner.nextLine();

        boolean encontrada = false;

        System.out.println("\nResultados de la búsqueda:");

        System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s\n", "Código", "Descripción", "Stock (S)", "Stock (M)", "Stock (L)", "Total");

        for (int i = 0; i < totalCamisetas; i++) {
            if (almacen[i].getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                System.out.println(almacen[i]);
                encontrada = true;
                break;

            }
        }

        if (!encontrada) {
            System.out.println("No se encontraron camisetas con esa descripción.");

        }
    }

    private static void modificacion() {
    
        System.out.print("Introduzca el código del artículo a modificar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
    
        for (int i = 0; i < totalCamisetas; i++) {
            if (almacen[i].getCodigo() == codigo) {
                System.out.print("Introduzca la nueva descripción del artículo (deje en blanco para mantener la original): ");
                String nuevaDescripcion = scanner.nextLine();

                if (!nuevaDescripcion.isEmpty()) {
                    almacen[i].setDescripcion(nuevaDescripcion);
                }
    
                System.out.print("Introduzca el nuevo stock de la talla S (-1 para mantener el original): ");
                int nuevoStockS = scanner.nextInt();
    
                if (nuevoStockS != -1) {
                    almacen[i].setStockS(nuevoStockS);
                }
    
                System.out.print("Introduzca el nuevo stock de la talla M (-1 para mantener el original): ");
                int nuevoStockM = scanner.nextInt();
    
                if (nuevoStockM != -1) {
                    almacen[i].setStockM(nuevoStockM);
                }
    
                System.out.print("Introduzca el nuevo stock de la talla L (-1 para mantener el original): ");
                int nuevoStockL = scanner.nextInt();
    
                if (nuevoStockL != -1) {
                    almacen[i].setStockL(nuevoStockL);
                }
    
                System.out.println("La camiseta ha sido modificada correctamente.");
                return;
            }
        }
    
        System.out.println("No se ha encontrado ninguna camiseta con ese código.");
    }
}