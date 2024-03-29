/** @author Lucía González Rosas */

/* En esta parte del programa se implementará la clase "Departamento()", la cual permitirá manipular tanto
 * a los empleados como a los ordenadores dependiendo de lo que necesite el usuario.
 * 
 * Para ello, se definirá sus atributos privados (siendo 2 de ellos ArrayList para los empleados y para los
 * ordenadores) y las distintas funciones para manipular la información de los empleados y los ordenadores,
 * siendo estas "getNombre()" (para devolver el nombre de los departamentos), "añadirEmpleado(Empleado empleado)"
 * (para añadir los empleados nuevos a la lista), "añadirOrdenador(Ordenador ordenador)" (para añadir los
 * ordenadores nuevos a la lista), "totalEmpleados()", (para mostrar el total de empleados en la lista),
 * "totalOrdenadores()" (para mostrar el total de ordenadores en la lista), "eliminarEmpleado(int numEmpleado)"
 * (para eliminar un empleado de la lista), "bajaOrdenador(int numOrdenador)" (para dar de baja a un ordenador),
 * "eliminarOrdenadoresBaja()" (para eliminar los ordenadores que hayan sido dados de baja), "asignarOrdenador(
 * int numEmpleado, int numOrdenador)" (para asignarle a un empleado un ordenador nuevo), "imprimirListaEmpleados()"
 * (para mostrar por pantalla a los empleados que hay actualmente en la lista), "imprimirListaOrdenadores()" (para
 * mostrar por pantalla los ordenadores que hay actualmente en la lista) y "toString()" (para devolver el nombre del
 * departamento).
 */

package dawcontrol;

import java.util.ArrayList;

public class Departamento {

    private String nombre;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Ordenador> listaOrdenadores;

    public Departamento(String nombre) {

        this.nombre = nombre;

        this.listaEmpleados = new ArrayList<>();
        this.listaOrdenadores = new ArrayList<>();

    }

    /** @return Devuelve el nombre del departamento. */
    public String getNombre() {

        return nombre;

    }

    public void añadirEmpleado(Empleado empleado) {

        listaEmpleados.add(empleado);

    }

    public void añadirOrdenador(Ordenador ordenador) {

        listaOrdenadores.add(ordenador);

    }

    /** @return Devuelve el total de empleados que hay en la lista. */
    public int totalEmpleados() {

        return listaEmpleados.size();

    }

    /** @return Devuelve el total de ordenadores que hay en la lista. */
    public int totalOrdenadores() {

        return listaOrdenadores.size();

    }

    public void eliminarEmpleado(int numEmpleado) {

        if (numEmpleado > 0 && numEmpleado <= listaEmpleados.size()) {
            listaEmpleados.remove(numEmpleado - 1);

        }
    }

    public void bajaOrdenador(int numOrdenador) {

        if (numOrdenador > 0 && numOrdenador <= listaOrdenadores.size()) {
            Ordenador ordenador = listaOrdenadores.get(numOrdenador - 1);

            ordenador.setEstado(Estado.BAJA);

        }
    }

    public void eliminarOrdenadoresBaja() {

        listaOrdenadores.removeIf(ordenador -> ordenador.getEstado() == Estado.BAJA);
        
    }

    public void asignarOrdenador(int numEmpleado, int numOrdenador) {

        if (numEmpleado > 0 && numEmpleado <= listaEmpleados.size() && numOrdenador > 0 && numOrdenador <= listaOrdenadores.size()) {
            Empleado empleado = listaEmpleados.get(numEmpleado - 1);
            Ordenador ordenador = listaOrdenadores.get(numOrdenador - 1);

            if (ordenador.getEstado() == Estado.LIBRE) {
                if (empleado.getOrdenador() != null) {
                    empleado.getOrdenador().setEstado(Estado.TALLER);

                }

                ordenador.setEstado(Estado.ASIGNADO);
                empleado.setOrdenador(ordenador);

            } else {
                System.out.println("El ordenador seleccionado no está disponible.");

            }

        } else {
            System.out.println("Dicha opción no es válida. Introduzca otra, por favor.");

        }
    }

    public void imprimirListaEmpleados() {

        System.out.println("La lista actual de los empleados: ");

        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println((i + 1) + ". " + listaEmpleados.get(i));

        }
    }

    public void imprimirListaOrdenadores() {

        System.out.println("La lista actual de los ordenadores: ");

        for (int i = 0; i < listaOrdenadores.size(); i++) {
            System.out.println((i + 1) + ". " + listaOrdenadores.get(i));

        }
    }

    /** @return Devuelve el nombre del departamento. */
    @Override
    public String toString() {

        return nombre;

    }
}