package domini.StatePattern;

public class Inactiu extends AbstractEstat {
    // Patró singleton perquè no calen diferents instàncies d'aquesta classe per diferents zombis.
    private static final Inactiu instance = new Inactiu();
    private Inactiu(){}
    public static Inactiu getInstance(){ return instance;}

}
