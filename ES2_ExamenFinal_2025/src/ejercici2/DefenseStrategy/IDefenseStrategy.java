package ejercici2.DefenseStrategy;

public interface IDefenseStrategy {
    public static final int SHIELD = 0;
    public static final int DODGE = 1;
    public static final int MAGICBARRIER = 2;
    public static IDefenseStrategy selectDefense(int typeDefense){
        switch (typeDefense){
            case SHIELD: return Shield.getInstance();
            case DODGE: return Dodge.getInstance();
            case MAGICBARRIER: return CreateMagic.getInstance();
            default: throw new IllegalArgumentException("Tipus de defensa incorrecte");
        }
    }
    public abstract String defend();
}