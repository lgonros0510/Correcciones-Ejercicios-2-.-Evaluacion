import java.util.Scanner;

public class SistemaSolar {
    public static void main(String[] args) {

        Planetas[] planetas = new Planetas[8];

        planetas[0] = new Planetas("Mercurio", 3.301e23, 4879, 1407.6, 88, 57.9e6, 0, false, 0);
        planetas[1] = new Planetas("Venus", 4.867e24, 12104, -5832.5, 224.7, 108.2e6, 0, false, 0);
        planetas[2] = new Planetas("Tierra", 5.972e24, 12756, 23.9, 365.2, 149.6e6, 0, true, 1);
        planetas[3] = new Planetas("Marte", 6.417e23, 6792, 24.6, 687, 227.9e6, 0, true, 2);
        planetas[4] = new Planetas("Júpiter", 1.899e27, 142984, 9.9, 4331, 778.6e6, 0, true, 79);
        planetas[5] = new Planetas("Saturno", 5.685e26, 120536, 10.7, 10747, 1433.5e6, 0, true, 82);
        planetas[6] = new Planetas("Urano", 8.682e25, 51118, -17.2, 30589, 2872.5e6, 0, true, 27);
        planetas[7] = new Planetas("Neptuno", 1.024e26, 49528, 16.1, 59800, 4495.1e6, 0, true, 14);

        planetas[2].agregarSatelite(new Satelites("Luna", 7.349e22, 3475, 27.3, 27.3, 384400, 384400, true, planetas[2]));
        planetas[3].agregarSatelite(new Satelites("Phobos", 1.0659e16, 22.2, 7.7, 0.32, 9376, 9376, true, planetas[3]));
        planetas[3].agregarSatelite(new Satelites("Deimos", 1.4762e15, 12.4, 30.3, 1.26, 23460, 23460, true, planetas[3]));
        planetas[4].agregarSatelite(new Satelites("Ío", 8.93e22, 1821.6, 42.5, 1.8, 421700, 421700, true, planetas[4]));
        planetas[4].agregarSatelite(new Satelites("Europa", 4.8e22, 1560.8, 85.2, 3.5, 671100, 671100, true, planetas[4]));
        planetas[4].agregarSatelite(new Satelites("Ganimedes", 1.48e23, 2634.1, 171.7, 7.2, 1070400, 1070400, true, planetas[4]));
        planetas[4].agregarSatelite(new Satelites("Calisto", 1.08e23, 2408.4, 16.7, 16.7, 1882700, 1882700, true, planetas[4]));
        planetas[5].agregarSatelite(new Satelites("Mimas", 3.7e19, 396.4, 0.9, 0.9, 185520, 185520, true, planetas[5]));
        planetas[5].agregarSatelite(new Satelites("Encélado", 1.08e20, 504.2, 1.4, 1.4, 237948, 237948, true, planetas[5]));
        planetas[5].agregarSatelite(new Satelites("Tetis", 6.18e20, 1066.8, 1.9, 1.9, 294619, 294619, true, planetas[5]));
        planetas[5].agregarSatelite(new Satelites("Dione", 1.1e21, 1123, 2.7, 2.7, 377415, 377415, true, planetas[5]));
        planetas[5].agregarSatelite(new Satelites("Rea", 2.31e21, 1527.6, 4.5, 4.5, 527108, 527108, true, planetas[5]));
        planetas[5].agregarSatelite(new Satelites("Titán", 1.35e23, 2575, 15.9, 15.9, 1221870, 1221870, true, planetas[5]));
        planetas[5].agregarSatelite(new Satelites("Íapetus", 1.81e21, 1436, 79.3, 79.3, 3561300, 3561300, true, planetas[5]));
        planetas[6].agregarSatelite(new Satelites("Miranda", 6.59e19, 235.8, 1.4, 1.4, 129390, 129390, true, planetas[6]));
        planetas[6].agregarSatelite(new Satelites("Ariel", 1.35e21, 578.9, 2.5, 2.5, 191020, 191020, true, planetas[6]));
        planetas[6].agregarSatelite(new Satelites("Umbriel", 1.27e21, 584.7, 4.1, 4.1, 266300, 266300, true, planetas[6]));
        planetas[6].agregarSatelite(new Satelites("Titania", 3.53e21, 788.9, 8.7, 8.7, 435910, 435910, true, planetas[6]));
        planetas[6].agregarSatelite(new Satelites("Oberón", 3.01e21, 761.4, 13.5, 13.5, 583520, 583520, true, planetas[6]));
        planetas[7].agregarSatelite(new Satelites("Tritón", 2.14e22, 1353.4, -5.9, -5.9, 354800, 354800, true, planetas[7]));
        
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n--->>> MENÚ DEL SISTEMA SOLAR <<<---");
            System.out.println("====================================");
            System.out.println("1) La lista de los planetas (sólo sus nombres)");
            System.out.println("2) La lista de los satélites (sólo sus nombres)");
            System.out.println("3) La lista de los satélites de un planeta (sólo sus nombres)");
            System.out.println("4) Buscar un astro en concreto (Toda su información, ya sea un planeta o un satélite)");
            System.out.println("5) Salir del menú");
            System.out.println("====================================");
            System.out.print("Introduzca la opción a elegir (1-5): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nEl listado de los planetas es el siguiente: ");

                    for (Planetas planeta : planetas) {
                        System.out.println(planeta.getNombre());

                    }

                    break;

                case 2:
                    System.out.println("\nEl listado de los satélites es el siguiente: ");
                    
                    for (Planetas planeta : planetas) {
                        if (planeta != null && planeta.getSatelites() != null) {
                            for (Satelites satelite : planeta.getSatelites()) {
                                if (satelite != null) {
                                    System.out.println(satelite.getNombre());

                                }
                            }
                        }
                    }

                    break;

                case 3:
                    System.out.print("\nIntroduzca el nombre del planeta: ");
                    String nombrePlaneta = scanner.next();
                    boolean encontrado = false;

                    for (Planetas planeta : planetas) {
                        if (planeta != null && planeta.getNombre().equalsIgnoreCase(nombrePlaneta) && planeta.getSatelites() != null) {
                            encontrado = true;

                            System.out.println("\nLos satélites de " + nombrePlaneta + " son los siguientes: ");
                            for (Satelites satelite : planeta.getSatelites()) {
                                if (satelite != null) {
                                    System.out.println(satelite.getNombre());

                                }
                            }

                            break;

                        }
                    }

                    if (!encontrado) {
                        System.out.println("El planeta no ha sido encontrado o no posee ningún satélite.");

                    }

                    break;

                case 4:
                    System.out.print("\nIntroduzca el nombre del astro a buscar ( ya sea un planeta o un satélite): ");
                    String nombreAstro = scanner.next();
                    boolean encontradoAstro = false;

                    for (Planetas planeta : planetas) {
                        if (planeta != null && planeta.getNombre().equalsIgnoreCase(nombreAstro)) {
                            encontradoAstro = true;

                            System.out.println("\nLa información del planeta " + nombreAstro + " es la siguiente: ");
                            planeta.muestra();

                            System.out.println("\nSus satélites son: ");

                            if (planeta.getSatelites() != null) {
                                for (Satelites satelite : planeta.getSatelites()) {
                                    if (satelite != null) {
                                        satelite.muestra();

                                        System.out.println();

                                    }
                                }
                            }

                            break;

                        }
                    }

                    if (!encontradoAstro) {
                        for (Planetas planeta : planetas) {
                            if (planeta != null && planeta.getSatelites() != null) {
                                for (Satelites satelite : planeta.getSatelites()) {
                                    if (satelite != null && satelite.getNombre().equalsIgnoreCase(nombreAstro)) {
                                        encontradoAstro = true;

                                        System.out.println("\nLa información del satélite " + nombreAstro + " es la siguiente: ");
                                        satelite.muestra();

                                        break;
                                    }
                                }
                            }

                            if (encontradoAstro) {
                                break;

                            }
                        }
                    }

                    if (!encontradoAstro) {
                        System.out.println("Dicho astro no se ha encontrado.");
                    }
                    
                    break;

                case 5:
                    System.out.println("Saliendo del menú. ¡Hasta la próxima!");
                    break;

                default:
                    System.out.println("Dicha opción no es válida. Inténtalo de nuevo, por favor: ");

            }

        } while (opcion != 5);

    }
}