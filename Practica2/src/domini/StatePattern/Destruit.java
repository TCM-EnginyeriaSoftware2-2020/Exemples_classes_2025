package domini.StatePattern;

public class Destruit extends AbstractEstat {
    // Patró singleton perquè no calen diferents instàncies d'aquesta classe per diferents zombis.
    private static final Destruit instance = new Destruit();
    private Destruit(){}
    public static Destruit getInstance(){
        return instance;
    }

    @Override
    public IEstatZombi update(int distancia) {
        throw new RuntimeException("El zombi ha mort");
    }

    @Override
    public IEstatZombi rebreDany(int vida) { throw new RuntimeException("El zombi ha mort"); }
}
