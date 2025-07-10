package exercici4;

public abstract class RamaderiaAbstractFactory {

    public enum Ramaderies{Miura, JoseEscolar, FuenteYmbro, NúñezDelCuvillo, VictorianoDelRío, CebadaGago, Jandilla};
    public static final int SIZE = 6;

    public static Bou[] creaBous( Ramaderies dia){
        Bou[] bous = new Bou[SIZE * 2];
        System.arraycopy( creaBousMansos(), 0, bous, 0, SIZE);
        switch (dia){
            case Miura: System.arraycopy( RamaderiaMiura.getInstance().creaBousBraus(), 0, bous, SIZE, SIZE); break;
            // un case per cada factoria concreta = ramaderies
            default: return null;
        }
        return bous;
    }

    // Mètode comú a totes les factories concretes
    protected static BouMans[] creaBousMansos() {
        BouMans[] mansos = new BouMans[SIZE];
        for (int i = 0; i < SIZE; i++) {
            mansos[i] = new BouMans("Manso " + (i + 1));
        }
        return mansos;
    }

    // Mètode abstracte que cada fàbrica concreta ha d'implementar
    protected abstract Bou[] creaBousBraus();

}
