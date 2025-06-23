package ejercici2.AttackStrategy;

public final class CastSpell implements IAttackStrategy {

    private static IAttackStrategy instance = new CastSpell();
    private CastSpell() { }
    public static IAttackStrategy getInstance() { return instance; }

    @Override
    public String attack(){
       return "casts a spell!";
    }
}