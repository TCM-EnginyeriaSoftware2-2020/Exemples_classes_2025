package ejercici2.DefenseStrategy;

public class Shield implements IDefenseStrategy {
    private static IDefenseStrategy instance = new Shield();
    private Shield() { }
    public static IDefenseStrategy getInstance() { return instance; }
    @Override
    public String defend(){
        return "is using a shield to defend!";
    }
}