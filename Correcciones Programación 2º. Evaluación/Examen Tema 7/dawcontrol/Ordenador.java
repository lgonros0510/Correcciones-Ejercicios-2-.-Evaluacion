/** @author Lucía González Rosas */

/* En esta parte del programa, se implementará la clase "Ordenador()", la cual introducirá la
 * información necesaria para cada ordenador y sus funciones.
 * 
 * Para ello, se definirá sus atributos privados (siendo estos el "host", el sistema operativo, la
 * ram en GB, el disco duro en TB y el estado en el que ocupa el ordenador) y las funciones "getHost()"
 * (para devolver el "host" de los ordenadores), "getSistemaOperativo()" (para devolver el sistema
 * operativo de los ordenadores), "getRam()" (para devolver el tamaño de la RAM en GB de los ordenadores),
 * "getDisco()" (para devolver el tamaño del disco duro en TB de los ordenadores ), "getEstado()" (para
 * devolver el estado en el que se encuentra cada ordenador), "setEstado()" (para asignar un estado a cada
 * ordenador) y "toString()" (para devolver los datos privados de los ordenadores por pantalla).
 */

package dawcontrol;

public class Ordenador {

    private String host;
    private String sistemaOperativo;
    private int ram;
    private int disco;
    private Estado estado;

    public Ordenador(String host, String sistemaOperativo, int ram, int disco) {

        this.host = host;
        this.sistemaOperativo = sistemaOperativo;
        this.ram = ram;
        this.disco = disco;
        this.estado = Estado.LIBRE;

    }

    /** @return Devuelve el "host" de los ordenadores. */
    public String getHost() {

        return host;

    }

    /** @return Devuelve el sistema operativo de los ordenadores. */
    public String getSistemaOperativo() {

        return sistemaOperativo;

    }

    /** @return Devuelve el tamaño de la RAM en GB de los ordenadores. */
    public int getRam() {

        return ram;

    }

    /** @return Devuelve el tamaño del disco duro en TB de los ordenadores. */
    public int getDisco() {

        return disco;

    }

    /** @return Devuelve el estado en el que se encuentra cada ordenador. */
    public Estado getEstado() {

        return estado;

    }

    public void setEstado(Estado estado) {

        this.estado = estado;

    }

    /** @return Devuelve los datos privados de los ordenadores por pantalla. */
    @Override
    public String toString() {

        return "El 'host' del ordenador: " + host + " || Su sistema operativo: " + sistemaOperativo + " || Su tamaño de RAM: " + ram +
        "GB || Su tamaño de disco duro: " + disco + "TB || Su estado actual: " + estado;

    }
}