package vehiculos_poo;

class Coche extends VehiculoTerrestre {

    private boolean aireAcondicionado;

    public Coche(String matricula, String modelo, int numRuedas, boolean aireAcondicionado) {

        super(matricula, modelo, numRuedas);
        this.aireAcondicionado = aireAcondicionado;

    }

    @Override
    public void imprimir() {

        super.imprimir();
        System.out.println("Aire acondicionado: " + (aireAcondicionado ? "Sí" : "No"));

    }
}