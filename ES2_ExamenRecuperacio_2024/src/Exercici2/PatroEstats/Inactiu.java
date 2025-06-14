package Exercici2.PatroEstats;

public final class Inactiu implements IEstats {
    // patró singleton
    private static Inactiu estatUnic = new Inactiu();
    private Inactiu(){}
    public static Inactiu getEstatUnic() {
        return estatUnic;
    }

    @Override
    public IEstats botoON() {
        return new ActiuAmbVentilador();
    }

    @Override
    public IEstats botoVentilador() {
        return this;
    } // no fem res

    @Override
    public IEstats sensor(boolean activar) {
        return this;
    } // no fem res
}
