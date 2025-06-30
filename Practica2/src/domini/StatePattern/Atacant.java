package domini.StatePattern;

public class Atacant extends AbstractEstat {
    // Patró singleton perquè no calen diferents instàncies d'aquesta classe per diferents zombis.
    private static final Atacant instance = new Atacant();
    private Atacant(){}
    public static Atacant getInstance() {
        return instance;
    }

    @Override
    public boolean isAttacking() {
        return true;
    }
}
