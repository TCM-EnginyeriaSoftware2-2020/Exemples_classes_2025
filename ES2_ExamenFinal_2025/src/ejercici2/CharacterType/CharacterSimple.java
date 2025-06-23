package ejercici2.CharacterType;

import ejercici2.AttackStrategy.IAttackStrategy;
import ejercici2.DefenseStrategy.IDefenseStrategy;

public class CharacterSimple {
    private final String name;
    protected IAttackStrategy attack;
    protected IDefenseStrategy defense;

    public CharacterSimple(String name, IAttackStrategy attack, IDefenseStrategy defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public String attacking()
    {
        return this.name +" "+ this.attack.attack();
    }
    public String defending()
    {
        return this.name +" "+ this.defense.defend();
    }
}
