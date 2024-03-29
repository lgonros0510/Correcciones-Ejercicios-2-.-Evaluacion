/** @author Lucía González Rosas */

/* En esta parte del programa, se implementará la clase "Empleado()", la cual introducirá la
 * información necesaria para cada empleado y sus funciones.
 * 
 * Para ello, se definirá sus atributos privados (siendo estos el nombre, el DNI, el teléfono y el
 * ordenador asignado de cada empleado) y las funciones "getNombre()" (para devolver el nombre de
 * los empleados), "getDni()" (para devolver el DNI de los empleados), "getTelefono()" (para devolver
 * el número de teléfono de los empleados), "getOrdenador()" (para devolver el ordenador asignado de
 * cada empleado), "setOrdenador()" (para asignar los ordenadores a sus respectivos empleados) y
 * "toString()" (para devolver los datos privados de los empleados por pantalla).
 */

package dawcontrol;

public class Empleado {

    private String nombre;
    private String dni;
    private int telefono;
    private Ordenador ordenador;

    public Empleado(String nombre, String dni, int telefono) {

        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.ordenador = null;

    }

    /** @return Devuelve el nombre de los empleados. */
    public String getNombre() {

        return nombre;

    }

    /** @return Devuelve el DNi de los empleados. */
    public String getDni() {

        return dni;

    }

    /** @return Devuelve el número de teléfono de los empleados. */
    public int getTelefono() {

        return telefono;

    }

    /** @return Devuelve el ordenador asignado de cada empleado. */
    public Ordenador getOrdenador() {

        return ordenador;

    }

    public void setOrdenador(Ordenador ordenador) {

        this.ordenador = ordenador;

    }

    /** @return Devuelve lso datos privados de los empleados por pantalla. */
    @Override
    public String toString() {

        return "Nombre del empleado: " + nombre + " || Su DNI: " + dni + " || Su número de teléfono: " + telefono +
        " || Su ordenador asignado: " + (ordenador != null ? ordenador.getHost() : "No tiene ningún ordenador asignado.");

    }
}