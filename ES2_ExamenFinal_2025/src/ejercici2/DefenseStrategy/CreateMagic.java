package ejercici2.DefenseStrategy;

import ejercici2.AttackStrategy.CastSpell;
import ejercici2.AttackStrategy.IAttackStrategy;

public final class CreateMagic implements IDefenseStrategy {
    private static IDefenseStrategy instance = new CreateMagic();

    private CreateMagic() {
    }

    public static IDefenseStrategy getInstance() {
        return instance;
    }

    @Override
    public String defend() {
        return "is creating a magic barrier for defense!";
    }
}