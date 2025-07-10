package exercici4;

public class RamaderiaXXXX extends RamaderiaAbstractFactory {
    // patró singleton
    private final static RamaderiaXXXX instance = new RamaderiaXXXX();
    private RamaderiaXXXX(){}
    public static RamaderiaXXXX getInstance() { return instance; }
    
    @Override
    protected Bou[] creaBousBraus() {
        Bou[] bous = new Bou[SIZE];
        for (int i = 0; i < SIZE; i++) {
            bous[i] = new BouBrausXXXX("Ramaderia XXXX " + (i + 1));
        }
        return bous;
    }
}
