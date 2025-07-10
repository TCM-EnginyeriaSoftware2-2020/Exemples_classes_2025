package exercici4;

public class RamaderiaMiura extends RamaderiaAbstractFactory {
    // patró singleton
    private final static RamaderiaMiura instance = new RamaderiaMiura();
    private RamaderiaMiura(){}
    public static RamaderiaMiura getInstance() { return instance; }

    @Override
    protected Bou[] creaBousBraus() {
        Bou[] bous = new Bou[SIZE];
        for (int i = 0; i < SIZE; i++) {
            bous[i] = new BouBrausMiura("Miura " + (i + 1));
        }
        return bous;
    }
}
