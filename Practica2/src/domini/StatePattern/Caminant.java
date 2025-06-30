package domini.StatePattern;

public class Caminant extends AbstractEstat {
    // Patró singleton perquè no calen diferents instàncies d'aquesta classe per diferents zombis.
    private static final Caminant instance = new Caminant();
    private Caminant(){}
    public static Caminant getInstance() {
        return instance;
    }

    @Override
    public boolean isMoving() {
        return true;
    }
}
