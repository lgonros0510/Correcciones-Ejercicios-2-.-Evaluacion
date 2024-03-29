abstract class Astros {

    private String nombre;
    private double masa;
    private double diametroMedio;
    private double periodoRotacion;
    private double periodoTraslacion;
    private double distanciaMedia;

    public Astros(String nombre, double masa, double diametroMedio, double periodoRotacion, double periodoTraslacion, double distanciaMedia) {

        this.nombre = nombre;
        this.masa = masa;
        this.diametroMedio = diametroMedio;
        this.periodoRotacion = periodoRotacion;
        this.periodoTraslacion = periodoTraslacion;
        this.distanciaMedia = distanciaMedia;

    }

    public void muestra() {

        System.out.println("El nombre del astro es " + nombre);
        System.out.println("La masa del astro es " + masa);
        System.out.println("El diámetro medio del astro es " + diametroMedio);
        System.out.println("El período de rotación del astro es " + periodoRotacion);
        System.out.println("El período de traslación del astro es " + periodoTraslacion);
        System.out.println("La distancia media del astro es " + distanciaMedia);

    }

    public String getNombre() {

        return nombre;

    }
}