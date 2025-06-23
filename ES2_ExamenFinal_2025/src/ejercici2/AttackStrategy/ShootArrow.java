package ejercici2.AttackStrategy;

public final class ShootArrow implements IAttackStrategy {
    private static IAttackStrategy instance = new ShootArrow();
    private ShootArrow() { }
    public static IAttackStrategy getInstance() { return instance; }
    @Override
    public String attack(){
        return "shoots an arrow!";
    }
}