package ejercici2.DefenseStrategy;

public final class Dodge implements IDefenseStrategy {
    private static IDefenseStrategy instance = new Dodge();
    private Dodge() { }
    public static IDefenseStrategy getInstance() { return instance; }
    @Override
    public String defend(){
        return "is dodging to avoid attack!";
    }
}