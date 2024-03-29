/** @author Lucía González Rosas */

/* 3º.) Escribe un programa que pida el nombre de 3 productos, con su cantidad, precio y descuento.
Haz una factura simple con las 3 líneas y subtotales, y otras 3 líneas más con el total sin IVA,
IVA (21%) y total con IVA (1 punto) = */

import java.util.Scanner;

public class Ejercicio3_Corregido {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int IVA = 21;

        System.out.println("-----------------------------FACTURA DE LA COMPRA REALIZADA---------------------------------");

        System.out.println("Introduzca el nombre del primer producto:");
        String nombre1 = scanner.nextLine();

        System.out.println("Introduzca la cantidad del primer producto:");
        int cantidad1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduzca el precio del primer producto:");
        float precio1 = Float.parseFloat(scanner.nextLine());

        double totalSinIva1 = cantidad1 * precio1;
        double totalConIva1 = totalSinIva1 + (totalSinIva1 * (IVA / 100.0));

        System.out.println("Introduzca el nombre del segundo producto:");
        String nombre2 = scanner.nextLine();

        System.out.println("Introduzca la cantidad del segundo producto:");
        int cantidad2 = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduzca el precio del segundo producto:");
        float precio2 = Float.parseFloat(scanner.nextLine());

        double totalSinIva2 = cantidad2 * precio2;
        double totalConIva2 = totalSinIva2 + (totalSinIva2 * (IVA / 100.0));

        System.out.println("Introduzca el nombre del tercer producto:");
        String nombre3 = scanner.nextLine();

        System.out.println("Introduzca la cantidad del tercer producto:");
        int cantidad3 = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduzca el precio del tercer producto:");
        float precio3 = Float.parseFloat(scanner.nextLine());

        double totalSinIva3 = cantidad3 * precio3;
        double totalConIva3 = totalSinIva3 + (totalSinIva3 * (IVA / 100.0));

        System.out.println("\n---------------------------------------------------------FACTURA-------------------------------------------------------------");
        System.out.println("Producto \t\t Cantidad \t\t Precio \t\t Total (sin IVA) \t\t Total (con IVA)");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(nombre1 + "\t\t " + cantidad1 + "\t\t " + precio1 + "\t\t " + totalSinIva1 + "\t\t " + totalConIva1);
        System.out.println(nombre2 + "\t\t " + cantidad2 + "\t\t " + precio2 + "\t\t " + totalSinIva2 + "\t\t " + totalConIva2);
        System.out.println(nombre3 + "\t\t " + cantidad3 + "\t\t " + precio3 + "\t\t " + totalSinIva3 + "\t\t " + totalConIva3);

        double subtotal = totalSinIva1 + totalSinIva2 + totalSinIva3;
        double ivaTotal = subtotal * (IVA / 100.0);
        double totalConIva = subtotal + ivaTotal;

        System.out.println("\nSubtotal: " + subtotal + " euros");
        System.out.println("IVA (" + IVA + "%): " + ivaTotal + " euros");
        System.out.println("Total con IVA: " + totalConIva + " euros");

    }
}