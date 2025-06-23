package ejercici2.AttackStrategy;

public final class SwingSword implements IAttackStrategy {
    private static IAttackStrategy instance = new SwingSword();
    private SwingSword() { }
    public static IAttackStrategy getInstance() { return instance; }
    @Override
    public String attack(){
        return "attacks with a sword!";
    }
}
