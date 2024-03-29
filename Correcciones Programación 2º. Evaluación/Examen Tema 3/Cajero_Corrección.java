import java.util.Scanner;

/** @author Lucía González Rosas */

/* En este examen se pide crear un programa que funcione como un cajero bancario, el cual proporcionará
 * 6 opciones para el usuario: "depositar()", el cual permitirá depositar una cantidad de saldo
 */

public class Cajero_Corrección {

    static boolean continuarEjecucion = true;

    static String operacion5;
    static String operacion4;
    static String operacion3;
    static String operacion2;
    static String operacion1;

    public static void main (String[] args) {
    
        int saldo = 1000;
        int nuevoSaldo = 1000;
        String idioma = "es";
        String operacion = "";
        int opcion;
    
        do {
    
            imprimirMenu(idioma);
            opcion = leerOpcion(idioma);
    
            switch (opcion) {
                case 1:
                operacion = (idioma == "es" ? "Depósito" : "Deposit");
                nuevoSaldo = depositar(saldo, idioma);
                break;
    
                case 2:
                operacion = (idioma == "es" ? "Retiro" : "Withdraw");
                nuevoSaldo = retirar(saldo, idioma);
                break;
    
                case 3:
                imprimirSaldo(saldo, idioma);
                break;
    
                case 4:
                operacion = "Bizum";
                nuevoSaldo = enviarBizum(saldo, idioma);
                break;
    
                case 5:
                ultimasOperaciones(idioma);
                break;
    
                case 6:
                idioma = (idioma == "es" ? "en" : "es");
    
            }
    
            saldo = nuevoSaldo;
    
        } while (opcion != 7);

        if (opcion == 7) {
            salir();

        }
    }
    
    /**
     * @param operacion Es la operación que se realiza en ese momento.
     * @param cantidad Es la cantidad de saldo que se deposita, se retira, etc...
     */
    public static void grabarOperacion(String operacion, int cantidad) {
    
        operacion5 = operacion4;
        operacion4 = operacion3;
        operacion3 = operacion2;
        operacion2 = operacion1;
        operacion1 = String.format("%-20s%20.2f", operacion, (double) cantidad);
    
    }

    /**
     * @param idioma Es el idioma del cajero actual.
     */
    public static void imprimirMenu(String idioma) {

        System.out.println(idioma == "es" ? "--->>> MENÚ DEL CAJERO <<<---" : "--->>> ATM'S MENU <<<---");
        System.out.println("1) " + (idioma == "es" ? "Depositar" : "Deposit"));
        System.out.println("2) " + (idioma == "es" ? "Retirar" : "Withdraw"));
        System.out.println("3) " + (idioma == "es" ? "Consultar saldo" : "Check balance"));
        System.out.println("4) " + (idioma == "es" ? "Enviar Bizum" : "Send Bizum"));
        System.out.println("5) " + (idioma == "es" ? "Últimas operaciones" : "Last operations"));
        System.out.println("6) " + (idioma == "es" ? "Cambiar idioma" : "Change language"));
        System.out.println("7) " + (idioma == "es" ? "Salir" : "Exit"));
        System.out.println("-----------------------------");

    }

    /**
     * @param idioma Es el idioma del cajero actual.
     */
    public static int leerOpcion(String idioma) {

        System.out.println((idioma.equals("es") ? "Introduzca una opción a elegir: " : "Enter an option to choose: "));
        int opcion = Integer.parseInt(System.console().readLine());
        return opcion;

    }

    /**
     * @param saldo Es el saldo que se manipula en ese momento.
     * @param idioma Es el idioma del cajero actual.
     */
    private static int depositar(int saldo, String idioma) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(idioma == "es" ? "Introduzca la cantidad de saldo a depositar: " : "Enter the balance amount to deposit: ");
        int cantidad = scanner.nextInt();

        if (cantidad <= 0) {
            System.out.println(idioma == "es" ? "La cantidad debe ser mayor que 0." : "The quantity must be more than 0.");
            return saldo;

        }

        if (saldo + cantidad > 10000) {
            System.out.println(idioma == "es" ? "Acaba de exceder el límite de saldo." : "You have just exceeded your balance limit.");
            return saldo;

        }

        System.out.println(idioma == "es" ? "El depósito ha sido realizado correctamente." : "The deposit has been made correctly.");
        return saldo + cantidad;

    }

    /**
     * @param saldo Es el saldo que se manipula en ese momento.
     * @param idioma Es el idioma del cajero actual.
     */
    private static int retirar(int saldo, String idioma) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(idioma == "es" ? "Introduzca la cantidad de saldo a retirar: " : "Enter the balance amount to withdraw: ");
        int cantidad = scanner.nextInt();

        if (cantidad <= 0) {
            System.out.println(idioma == "es" ? "La cantidad debe ser mayor que 0." : "The quantity must be more than 0.");
            return saldo;

        }

        if (saldo - cantidad < 0) {
            System.out.println(idioma == "es" ? "Tu saldo es insuficiente." : "Your balance is insufficient.");
            return saldo;

        }

        System.out.println(idioma == "es" ? "El retiro ha sido realizado correctamente." : "The withdrawal has been carried out correctly.");
        return saldo - cantidad;

    }

    /**
     * @param saldo Es el saldo que se manipula en ese momento.
     * @param idioma Es el idioma del cajero actual.
     */
    private static void imprimirSaldo(int saldo, String idioma) {

        System.out.println((idioma == "es" ? "Tu saldo actual es " : "Your current balance is ") + saldo);

    }

    /**
     * @param saldo Es el saldo que se manipula en ese momento.
     * @param idioma Es el idioma del cajero actual.
     */
    private static int enviarBizum(int saldo, String idioma) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(idioma == "es" ? "Introduzca su número de teléfono: " : "Enter your phone number: ");
        long telefono = scanner.nextLong();

        System.out.println(idioma == "es" ? "Introduzca la cantidad de saldo a enviar: " : "Enter the balance amount to send: ");
        int cantidad = scanner.nextInt();

        if (cantidad <= 0) {
            System.out.println(idioma == "es" ? "La cantidad debe ser mayor que 0." : "The quantity must be more than 0.");
            return saldo;

        }

        if (saldo - cantidad < 0) {
            System.out.println(idioma == "es" ? "Tu saldo es insuficiente." : "Your balance is insufficient.");
            return saldo;

        }

        System.out.println(idioma == "es" ? "El envío de Bizum ha sido realizado correctamente." : "The Bizum shipment has been completed correctly.");
        return saldo - cantidad;

    }

    /**
     * @param idioma Es el idioma del cajero actual.
     */
    private static void ultimasOperaciones(String idioma) {

        System.out.println(operacion1);
        System.out.println(operacion2);
        System.out.println(operacion3);
        System.out.println(operacion4);
        System.out.println(operacion5);
        System.out.println(idioma == "es" ? "Pulsa 'Enter' para volver al menú" : "Press 'Enter' to return to the menu");

        esperarEnter();

    }

    private static void esperarEnter() {

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

    private static void salir() {

        continuarEjecucion = false;

    }
}