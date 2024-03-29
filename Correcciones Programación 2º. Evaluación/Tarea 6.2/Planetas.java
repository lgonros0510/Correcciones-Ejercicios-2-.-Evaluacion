class Planetas extends Astros {

    private double distanciaAlSol;
    private boolean orbitaAlSol;
    private Satelites[] satelites;
    private int cantidadSatelites;

    public Planetas(String nombre, double masa, double diametroMedio, double periodoRotacion,
                    double periodoTraslacion, double distanciaMedia, double distanciaAlSol,
                    boolean orbitaAlSol, int maxSatelites) {

        super(nombre, masa, diametroMedio, periodoRotacion, periodoTraslacion, distanciaMedia);

        this.distanciaAlSol = distanciaAlSol;
        this.orbitaAlSol = orbitaAlSol;
        this.satelites = new Satelites[maxSatelites];
        this.cantidadSatelites = 0;

    }

    public void agregarSatelite(Satelites satelite) {

        if (cantidadSatelites < satelites.length) {
            satelites[cantidadSatelites++] = satelite;

        } else {
            System.out.println("No se pueden agregar más satélites a este planeta.");

        }
    }

    public Satelites[] getSatelites() {

        return satelites;

    }

    @Override
    public void muestra() {

        super.muestra();

        System.out.println("La distancia al sol del planeta es " + distanciaAlSol);
        System.out.println("La órbita al sol del planeta es " + orbitaAlSol);
        System.out.println("Este planeta tiene, de satélites, ");
        for (int i = 0; i < cantidadSatelites; i++) {
            satelites[i].muestra();

        }
    }
}
