class Satelites extends Astros {

    private double distanciaAlPlaneta;
    private boolean orbitaPlanetaria;
    private Planetas planetaPertenece;

    public Satelites(String nombre, double masa, double diametroMedio, double periodoRotacion,
                     double periodoTraslacion, double distanciaMedia, double distanciaAlPlaneta,
                     boolean orbitaPlanetaria, Planetas planetaPertenece) {

        super(nombre, masa, diametroMedio, periodoRotacion, periodoTraslacion, distanciaMedia);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planetaPertenece = planetaPertenece;

    }

    @Override
    public void muestra() {

        super.muestra();

        System.out.println("La distancia al planeta de este satélite es " + distanciaAlPlaneta);
        System.out.println("La órbita planetaria de este satélite es " + orbitaPlanetaria);
        System.out.println("Este satélite pertenece al planeta " + planetaPertenece.getNombre());

    }
}
